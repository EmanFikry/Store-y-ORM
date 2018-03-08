/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.admin;

import controller.DAODelegate.DAOService;
import java.io.IOException;
import java.util.ArrayList;
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
public class DisplayUsers extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<User> users;
        //call userdao from database
        DAOService daoService = new DAOService();
        users = daoService.getUserList();
        //create session to add all user list
        HttpSession session = request.getSession();
        //session.setAttribute("users", users);
        System.out.println(users.size()+"tesst");
        request.setAttribute("users", users);
        request.getRequestDispatcher("adminPages/customerProfile.jsp").forward(request, response);

    }

}
