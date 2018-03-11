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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dataAccessLayer.entity.Product;

/**
 *
 * @author Eman-PC
 */
public class DisplayProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        DAOService daoService = new DAOService();
        ArrayList<Product> products = daoService.getProductList();
        out.print(buildJSONFromVector(products));
        

    }

    private String buildJSONFromVector(ArrayList<Product> products) {

        Gson json = new Gson();
        return json.toJson(products);
    }

}
