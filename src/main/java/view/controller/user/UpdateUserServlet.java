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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dataAccessLayer.DAO.impl.UserDAOImpl;
import model.dataAccessLayer.entity.User;

/**
 *
 * @author Eman-PC
 */
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();

        String username = (String) session.getAttribute("username");
        


        UserDAOImpl user = new UserDAOImpl();



        User updatedUser = (User) session.getAttribute("userObject");

        String birthDay;
        birthDay = request.getParameter("birthdate");
        String email = request.getParameter(("email"));
        String password = request.getParameter(("password"));
        long creditLimit = Long.parseLong(request.getParameter(("credit")));
        String address = request.getParameter(("address"));
        String job = request.getParameter(("job"));
        //convert birthday from String to sql date
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        try {
            date = formatter.parse(birthDay);
        } catch (ParseException ex) {
            Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());



        updatedUser.setAddress(address);
        updatedUser.setBirthdate(sqlDate);
        updatedUser.setCreditLimit(creditLimit);
        updatedUser.setPassword(password);
        updatedUser.setJob(job);
        updatedUser.setEmail(email);

        boolean updated = user.editProfile(updatedUser);

        if (updated) {
            out.println("success");
        } else {
            out.println("fail");
        }
    }

}
