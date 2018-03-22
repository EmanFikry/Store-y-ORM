/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.user;

import controller.DAODelegate.DAOService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eman-PC
 */
public class DisplayProductDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productID = request.getParameter("productID");
        DAOService daoService = new DAOService();
        //Product product = daoService.getProductByID(Long.parseLong(productID));
        Product product = new Product();
        product.setAmount(100);
        product.setCategory("hsdjhsdjsd");
        product.setDescription("dshsjhhshsdhsj");
        product.setName("teeest");
        product.setPrice(100);
        product.setImgURL("images/34.jpg");
        request.getServletContext().setAttribute("productObject", product);
        response.sendRedirect("productDetails.jsp");

    }

}
