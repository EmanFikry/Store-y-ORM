/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.user;

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
import model.dataAccessLayer.DAO.impl.ProductDAOImpl;
import model.dataAccessLayer.entity.ItiStoreYProduct;

/**
 *
 * @author Eman-PC
 */
public class DisplayProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("jere");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        DAOService daoService = new DAOService();
        List<ItiStoreYProduct> products = daoService.getProductList();
        out.print(buildJSONFromVector(products));

    }

    private String buildJSONFromVector(List<ItiStoreYProduct> products) {
        ObjectMapper objectMapper = new ObjectMapper();

        Iterator<ItiStoreYProduct> productsIterator = products.iterator();
        List<ItiStoreYProduct> newProductsList = new ArrayList<>();
        while (productsIterator.hasNext()) {
            ItiStoreYProduct nextProduct = productsIterator.next();
            ItiStoreYProduct newProduct = new ItiStoreYProduct();
            newProduct.setAmount(nextProduct.getAmount());
            newProduct.setName(nextProduct.getName());
            newProduct.setImgurl(nextProduct.getImgurl());
            newProduct.setRecid(nextProduct.getRecid());
            newProduct.setPrice(nextProduct.getPrice());
            newProductsList.add(newProduct);
        }
        //Set pretty printing of json
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String arrayToJson = "";
        try {
            arrayToJson = objectMapper.writeValueAsString(newProductsList);
            System.out.println(arrayToJson);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayToJson;
    }
}
