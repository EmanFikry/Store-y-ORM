/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.admin;

import controller.DAODelegate.DAOService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dataAccessLayer.entity.Product;

/**
 *
 * @author Eman-PC
 */
public class AddProduct extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DAOService daoService = new DAOService();
        Product product = new Product();
        String imgURL = request.getParameter("imgURL");
        String name = request.getParameter("productName");
        String category = request.getParameter("productCategory");
        float price = Float.parseFloat(request.getParameter("productPrice"));
        int amount = Integer.parseInt(request.getParameter("productAmount"));
        String description = request.getParameter("productDescription");

        //add product in db
        if (daoService.addProduct(product)) {
            request.setAttribute("success", "Product added successfully");
            // request.getRequestDispatcher("admin").forward(request, response);

        } else {
            request.setAttribute("errormsg", "Product is not inserted successfully");
            //  request.getRequestDispatcher("/admin/add_product.jsp").forward(request, response);
        }

    }
}
