/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
        
        User updatedUser = (User) session.getAttribute("userObject");
        
        
        Date birthDay;
        birthDay = (Date) request.getAttribute("birthdate");
        String email = request.getParameter(("email"));
        String password = request.getParameter(("password"));
        long creditLimit = Long.parseLong(request.getParameter(("credit")));
        String address = request.getParameter(("address"));
        String job = request.getParameter(("job"));

        UserDAOImpl user = new UserDAOImpl();

        updatedUser.setAddress(address);
        updatedUser.setBirthdate((java.sql.Date) birthDay);
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
