/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import controller.DAODelegate.DAOService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
public class DisplayUsers extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<ItiStoreYUser> users;
        //call userdao from database
        DAOService daoService = new DAOService();
        users = daoService.getUserList();

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(buildJSONFromVector(users));
    }

    private String buildJSONFromVector(List<ItiStoreYUser> users) {
        ObjectMapper objectMapper = new ObjectMapper();

        Iterator<ItiStoreYUser> usersIterator = users.iterator();
        List<ItiStoreYUser> usersList = new ArrayList<>();
        while (usersIterator.hasNext()) {
            ItiStoreYUser user = usersIterator.next();
            ItiStoreYUser newUser = new ItiStoreYUser();
            newUser.setAddress(user.getAddress());
            newUser.setEmail(user.getEmail());
            newUser.setName(user.getName());
            newUser.setRecid(user.getRecid());
            usersList.add(newUser);
        }
        //Set pretty printing of json
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String arrayToJson = "";
        try {
            arrayToJson = objectMapper.writeValueAsString(usersList);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(DisplayUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayToJson;
    }
}
