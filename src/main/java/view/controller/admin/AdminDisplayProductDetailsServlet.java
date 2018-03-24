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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dataAccessLayer.DAO.impl.ProductDAOImpl;
import model.dataAccessLayer.entity.ItiStoreYProduct;

/**
 *
 * @author Eman-PC
 */
public class AdminDisplayProductDetailsServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String productID = request.getParameter("id");
        DAOService daoService = new DAOService();
        ItiStoreYProduct product = daoService.getProductByID(Long.parseLong(productID));
        out.print(buildJSONFromVector(product));
        
    }
    
    private String buildJSONFromVector(ItiStoreYProduct product) {
        ObjectMapper objectMapper = new ObjectMapper();
        
        ItiStoreYProduct newProduct = new ItiStoreYProduct();
        newProduct.setAmount(product.getAmount());
        newProduct.setName(product.getName());
        newProduct.setImgurl(product.getImgurl());
        newProduct.setRecid(product.getRecid());
        newProduct.setPrice(product.getPrice());
        newProduct.setDescription(product.getDescription());
        newProduct.setCategory(product.getCategory());

        //Set pretty printing of json
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String arrayToJson = "";
        try {
            arrayToJson = objectMapper.writeValueAsString(newProduct);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(AdminDisplayProductDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayToJson;
    }
    
}
