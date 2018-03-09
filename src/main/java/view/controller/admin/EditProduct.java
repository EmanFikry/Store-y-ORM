/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.admin;

import controller.DAODelegate.DAOService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dataAccessLayer.entity.Product;
import view.util.user.ProductValidation;

/**
 *
 * @author Eman-PC
 */
public class EditProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductValidation validation = new ProductValidation();

        String name = request.getParameter("name");
        String value = request.getParameter("value");

        switch (name) {
            case "productName":
                if (!validation.validateName(value)) {
                    response.getWriter().write("invalid name");
                }
                break;
            case "price":
                if (!validation.validatePrice(value)) {
                    response.getWriter().write("invalid price");
                }
                break;
            case "category":
                if (!validation.validateCategory(value)) {
                    response.getWriter().write("invalid category");
                }
                break;
            case "amount":
                if (!validation.validateAmount(value)) {
                    response.getWriter().write("invalid amount");
                }
                break;
            case "imgURL":
                if (!validation.validateImgURL(value)) {
                    response.getWriter().write("invalid imgURL");
                }
                break;
            case "description":
                if (!validation.validateDescription(value)) {
                    response.getWriter().write("invalid description");
                }
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOService daoService = new DAOService();
        Product product = new Product();

        String id = request.getParameter("id");
        String name = request.getParameter("productName");
        String price = request.getParameter("price");
        String category = request.getParameter("category");
        String amount = request.getParameter("amount");
        String imgURL = request.getParameter("imgURL");
        String description = request.getParameter("description");

        product.setRecID(Long.parseLong(id));
        product.setName(name);
        product.setPrice(Float.parseFloat(price));
        product.setCategory(category);
        product.setAmount(Integer.parseInt(amount));
        product.setImgURL(imgURL);
        product.setDescription(description);

        if (daoService.updateProduct(product)) {
            response.sendRedirect("ViewProduct");
        }
    }

}
