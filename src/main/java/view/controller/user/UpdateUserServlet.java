/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.user;

import controller.DAODelegate.DAOService;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dataAccessLayer.entity.ItiStoreYInterest;
import model.dataAccessLayer.entity.ItiStoreYUser;

/**
 *
 * @author Eman-PC
 */
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        DAOService userDAOService = new DAOService();

        ItiStoreYUser updatedUser = (ItiStoreYUser) session.getAttribute("userObject");

        String birthDay = request.getParameter("birthdate");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String address = request.getParameter("address");
        String job = request.getParameter("job");
        String interest = request.getParameter("interests");
        String interestsArray[] = interest.split(";");
        String credit = request.getParameter("credit");

        long creditLimit = (long) (Double.parseDouble(credit));
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
        updatedUser.setCreditlimit(creditLimit);
        updatedUser.setPassword(password);
        updatedUser.setJob(job);
        updatedUser.setEmail(email);
        updatedUser.setName(name);

        ArrayList<ItiStoreYInterest> interests = new ArrayList<>();
        for (String temp : interestsArray) {
            if (!temp.isEmpty()) {
                ItiStoreYInterest newInterest = new ItiStoreYInterest();
                newInterest.setItiStoreYUser(updatedUser);
                newInterest.setName(temp);
                interests.add(newInterest);
            }
        }
        Set<ItiStoreYUser> interestesSet = new HashSet(interests);
        updatedUser.setItiStoreYInterests(interestesSet);
        userDAOService.editProfile(updatedUser);

        response.sendRedirect(request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + request.getContextPath() + "/home.jsp");
    }

}
