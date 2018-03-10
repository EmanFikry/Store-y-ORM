/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.user;

import com.google.gson.Gson;
import controller.DAODelegate.DAOService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dataAccessLayer.entity.Product;
import model.dataAccessLayer.entity.User;

/**
 *
 * @author Eman-PC
 */
public class UserDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            String userID = request.getParameter("userid");
            DAOService daoService = new DAOService();
            User user = daoService.getUserById(Long.parseLong(userID));
            out.print(buildJSONFromVector(user));
        } catch (SQLException ex) {
            Logger.getLogger(UserDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String buildJSONFromVector(User user) {

        Gson json = new Gson();
        return json.toJson(user);
    }
}
