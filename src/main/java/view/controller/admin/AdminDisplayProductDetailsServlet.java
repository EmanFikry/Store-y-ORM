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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        Gson json = new Gson();
        return json.toJson(product);
    }

}
