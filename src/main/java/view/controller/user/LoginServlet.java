/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Eman-PC
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("loginemail");
        String password = request.getParameter("loginpas");

        //check if user exists
        boolean userExist = false;
        boolean passRight = false;

        //check if user exists in db or not
        //if exist check his password
        //if password is true create session for him
        //if password is false send error message
        //if not exist send error message
        //this method will call the UserDAOCaller and it will call the UserDAO to deal with DB
        HttpSession session = request.getSession(true);
        session.setAttribute("userEmail", email);

        if (!passRight) {
            request.getServletContext().setAttribute("loginMsg", "Wrong Password");
            request.getServletContext().setAttribute("loginEmail", email);
            response.sendRedirect("generalPages/login.jsp");
        }

    }
}
