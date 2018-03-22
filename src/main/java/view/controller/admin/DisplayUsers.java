/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.admin;

import com.google.gson.Gson;
import controller.DAODelegate.DAOService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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

        for(int i=0;i<users.size();i++)
        {
            System.out.println(users.get(i).getName());
        }
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(buildJSONFromVector(users));
    }

    private String buildJSONFromVector(List<ItiStoreYUser> users) {

        Gson json = new Gson();
        return json.toJson(users);
    }
}
