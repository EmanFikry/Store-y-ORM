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

/**
 *
 * @author Ghada
 */
public class ViewProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().setAttribute("products", new DAOService().getProductList());
        response.sendRedirect("viewProduct.jsp?id=0");
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

}
