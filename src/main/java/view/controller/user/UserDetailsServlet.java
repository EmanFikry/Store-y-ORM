/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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
import model.dataAccessLayer.entity.ItiStoreYUser;

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
            ItiStoreYUser user = daoService.getUserById(Long.parseLong(userID));
            out.print(buildJSONFromVector(user));
        } catch (SQLException ex) {
            Logger.getLogger(UserDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String buildJSONFromVector(ItiStoreYUser user) {
        ObjectMapper objectMapper = new ObjectMapper();

        ItiStoreYUser newUser = new ItiStoreYUser();
        newUser.setAddress(user.getAddress());
        newUser.setBirthdate(user.getBirthdate());
        newUser.setCreditlimit(user.getCreditlimit());
        newUser.setEmail(user.getEmail());
        newUser.setJob(user.getJob());
        newUser.setName(user.getName());
        newUser.setPassword(user.getPassword());

        //Set pretty printing of json
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String arrayToJson = "";
        try {
            arrayToJson = objectMapper.writeValueAsString(newUser);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(UserDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayToJson;
    }
}
