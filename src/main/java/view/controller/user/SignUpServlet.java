/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
        List<String> interests = new ArrayList<>();
        for (String temp : interestsArray) {
            if (!temp.isEmpty()) {
                interests.add(temp);
            }
        }

        boolean validName = validate.validateName(name);
        boolean validEmail = validate.validateEmail(email);
        boolean validPassword = validate.validatePassword(password, confirmPassword);
        boolean validDate = validate.validateDate(birthday);
        boolean validAddress = validate.validateAddress(address);
        boolean validCreditLimit = validate.validateCreditLimit(creditLimit);

        if (!validName) {
            request.getServletContext().setAttribute("invalidName", "Wrong Format");
        }
        if (!validAddress) {
            request.getServletContext().setAttribute("invalidAddress", "Wrong Format");
        }
        if (!validEmail) {
            request.getServletContext().setAttribute("invalidEmail", "Wrong Format");
        }
        if (!validDate) {
            request.getServletContext().setAttribute("invalidDate", "Enter date before '2000-02-28'");
        }
        if (!validPassword) {
            request.getServletContext().setAttribute("invalidPassword", "Passwords do not match");
        }
        if (!validCreditLimit) {
            request.getServletContext().setAttribute("invalidCreditLimit", "Wrong Format");
        }

        if (validAddress && validDate && validEmail && validName && validPassword && validCreditLimit) {
            User user = new User();
            //fill the data in user object
            //call DAOsCaller
            response.sendRedirect("generalPages/login.jsp");
        } else {
            response.sendRedirect("generalPages/registeration.jsp");
        }

    }
}
