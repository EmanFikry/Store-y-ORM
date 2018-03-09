/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.user;

import controller.DAODelegate.DAOService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dataAccessLayer.entity.User;
import view.util.user.Validation;

/**
 *
 * @author Eman-PC
 */
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //System.out.println(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+"/generalPages/registeration.jsp");

        Validation validate = new Validation();
        String name = request.getParameter("uname");
        String birthday = request.getParameter("ubd");
        String email = request.getParameter("uemail");
        String password = request.getParameter("upassword");
        String confirmPassword = request.getParameter("uconfirmPassword");
        String creditLimit = request.getParameter("ucreditLimit");
        String address = request.getParameter("uaddress");
        String job = request.getParameter("userJob");
        String interest = request.getParameter("uCategory");

        String interestsArray[] = interest.split(";");
        ArrayList<String> interests = new ArrayList<>();
        for (String temp : interestsArray) {
            if (!temp.isEmpty()) {
                interests.add(temp);
            }
        }

        boolean validData = true;
        if (!validate.validateName(name)) {
            request.getServletContext().setAttribute("invalidName", "Wrong Format");
            validData = false;
        }
        if (!validate.validateAddress(address)) {
            request.getServletContext().setAttribute("invalidAddress", "Wrong Format");
            validData = false;
        }
        if (!validate.validateEmail(email)) {
            request.getServletContext().setAttribute("invalidEmail", "Wrong Format");
            validData = false;
        }
        if (!validate.validateDate(birthday)) {
            request.getServletContext().setAttribute("invalidDate", "Enter date before '2000-02-28'");
            validData = false;
        }
        if (!validate.validatePassword(password, confirmPassword)) {
            request.getServletContext().setAttribute("invalidPassword", "Passwords do not match");
            validData = false;
        }
        if (!validate.validateCreditLimit(creditLimit)) {
            request.getServletContext().setAttribute("invalidCreditLimit", "Enter number greater than 0");
            validData = false;
        }

        if (validData) {

            DAOService daoService = new DAOService();
            boolean isExisted = daoService.isEmailExist(email);
            if (isExisted) {
                //response.sendRedirect(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/generalPages/registeration.jsp");
                request.getServletContext().setAttribute("invalidEmail", "Email already exists");
                response.sendRedirect(request.getScheme() + "://"
                        + request.getServerName() + ":" + request.getServerPort()
                        + request.getContextPath() + "/MainPages/home.jsp");
            } else {
                //fill the data in user object
                User user = new User();
                user.setAddress(address);
                user.setCreditLimit(Float.parseFloat(creditLimit));
                user.setEmail(email);
                user.setUserInterest(interests);
                user.setJob(job);
                user.setName(name);
                user.setPassword(password);

                //convert birthday from String to sql date
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date date = null;
                try {
                    date = formatter.parse(birthday);
                } catch (ParseException ex) {
                    Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                user.setBirthdate(sqlDate);

                boolean isAdded = daoService.addUser(user);
                if (isAdded) {
                    //response.sendRedirect("generalPages/registeration.jsp");
                    response.sendRedirect(request.getScheme() + "://"
                            + request.getServerName() + ":" + request.getServerPort()
                            + request.getContextPath() + "/MainPages/home.jsp");
                }
            }
        } else {
            // response.sendRedirect("generalPages/registeration.jsp");
            response.sendRedirect(request.getScheme() + "://"
                    + request.getServerName() + ":" + request.getServerPort()
                    + request.getContextPath() + "/MainPages/home.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("temail");
        DAOService daoService = new DAOService();
        boolean isExisted = daoService.isEmailExist(email);
        if (isExisted) {
            System.out.println("exist");
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            out.write("Email already exists");
        }
    }
}
