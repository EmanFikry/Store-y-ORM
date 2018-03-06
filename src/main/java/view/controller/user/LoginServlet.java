/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.user;

import controller.DAODelegate.DAOService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dataAccessLayer.entity.User;

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

        //check if user exists in db or not
        DAOService daoService = new DAOService();
        User user = daoService.checkLogin(email, password);
        if (user == null) {
            boolean isExisted = daoService.isEmailExist(email);
            if (isExisted) {
                request.getServletContext().setAttribute("invalidPassword", "wrong password");
            } else {
                request.getServletContext().setAttribute("invalidEmail", "Email does not exist");
            }
            //   response.sendRedirect("generalPages/login.jsp");
        } else {
            HttpSession session = request.getSession(true);
            session.setAttribute("userObject", user);
            //  response.sendRedirect("generalPages/login.jsp");
        }

    }
}
