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
        //ArrayList<Product> products = daoService.getProductList();
        //out.print(buildJSONFromVector(products));
        ArrayList<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setAmount(100);
        product.setRecID(1L);
        product.setCategory("c1");
        product.setDescription("test1");
        product.setName("p1");
        product.setPrice(100);
        product.setImgURL("images/34.jpg");
        products.add(product);
        Product product2 = new Product();
        product2.setAmount(200);
        product2.setRecID(2L);
        product2.setCategory("c2");
        product2.setDescription("test2");
        product2.setName("p2");
        product2.setPrice(100);
        product2.setImgURL("images/34.jpg");
        products.add(product2);
        out.print(buildJSONFromVector(products));

    }

    private String buildJSONFromVector(ArrayList<Product> products) {

        Gson json = new Gson();
        return json.toJson(products);
    }

}
