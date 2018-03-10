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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dataAccessLayer.entity.Product;

/**
 *
 * @author Ghada
 */
public class ViewProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.print(buildJSONFromVector(new DAOService().getProductList()));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getSession().setAttribute("id", request.getParameter("id"));
        request.getSession().setAttribute("name", request.getParameter("name"));
        request.getSession().setAttribute("price", request.getParameter("price"));
        request.getSession().setAttribute("category", request.getParameter("category"));
        request.getSession().setAttribute("amount", request.getParameter("amount"));
        request.getSession().setAttribute("imgURL", request.getParameter("imgURL"));
        request.getSession().setAttribute("description", request.getParameter("description"));
        response.sendRedirect("updateProduct.jsp");
    }

    private String buildJSONFromVector(ArrayList<Product> products) {

        Gson json = new Gson();
        return json.toJson(products);
    }
}
