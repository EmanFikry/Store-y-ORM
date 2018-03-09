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
public class RemoveProduct extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
         Long pId = Long.parseLong(request.getParameter("pId"));
          DAOService daoService = new DAOService();
           boolean productdao = daoService.deleteProduct(pId);
       //   productdao.deleteProduct(pId);
          if(  productdao)
          {
              System.out.println("delete done successfly");
          }
          else
          {
              System.out.println("delete failed");
          }
        
        
    
        //redirect to specific page

    }


}