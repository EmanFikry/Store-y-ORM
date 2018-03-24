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
import model.dataAccessLayer.entity.ItiStoreYProduct;

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
        
        ItiStoreYProduct product = new DAOService().getProductByID(Long.parseLong(request.getParameter("id")));
        request.getSession().setAttribute("id", product.getRecid());
        request.getSession().setAttribute("name", product.getName());
        request.getSession().setAttribute("price", product.getPrice());
        request.getSession().setAttribute("category", product.getCategory());
        request.getSession().setAttribute("amount", product.getAmount());
        request.getSession().setAttribute("imgURL", product.getImgurl());
        request.getSession().setAttribute("description", product.getDescription());
        response.sendRedirect("UpdateProduct.jsp");
    }
    
    private String buildJSONFromVector(List<ItiStoreYProduct> products) {
        ObjectMapper objectMapper = new ObjectMapper();
        
        Iterator<ItiStoreYProduct> productsIterator = products.iterator();
        List<ItiStoreYProduct> newProductsList = new ArrayList<>();
        while (productsIterator.hasNext()) {
            ItiStoreYProduct nextProduct = productsIterator.next();
            ItiStoreYProduct newProduct = new ItiStoreYProduct();
            newProduct.setName(nextProduct.getName());
            newProduct.setCategory(nextProduct.getCategory());
            newProduct.setRecid(nextProduct.getRecid());
            newProduct.setPrice(nextProduct.getPrice());
            newProductsList.add(newProduct);
        }
        //Set pretty printing of json
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String arrayToJson = "";
        try {
            arrayToJson = objectMapper.writeValueAsString(newProductsList);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ViewProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayToJson;
    }
}
