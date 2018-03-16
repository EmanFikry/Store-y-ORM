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

        Product product = new DAOService().getProductByID(Long.parseLong(request.getParameter("id")));
        request.getSession().setAttribute("id", product.getRecID());
        request.getSession().setAttribute("name", product.getName());
        request.getSession().setAttribute("price", product.getPrice());
        request.getSession().setAttribute("category", product.getCategory());
        request.getSession().setAttribute("amount", product.getAmount());
        request.getSession().setAttribute("imgURL", product.getImgURL());
        request.getSession().setAttribute("description", product.getDescription());
        response.sendRedirect("UpdateProduct.jsp");
    }

    private String buildJSONFromVector(ArrayList<Product> products) {

        Gson json = new Gson();
        return json.toJson(products);
    }
}
