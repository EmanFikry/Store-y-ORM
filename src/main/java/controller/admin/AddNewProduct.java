/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dataBaseClasses.Database;
import model.dataBaseClasses.Product;
import model.dataBaseClasses.User;
import model.dataBaseDAOs.ProductDao;

/**
 *
 * @author shalaby
 */
public class AddNewProduct extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
            HttpSession session = request.getSession(true);
        // get user
	User user = (User) session.getAttribute("admin_logged");
        System.out.println(user);
        if (user == null) {    
            // lesa user not login as admin
            request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
            return;
            
        }
        // data of product name,price,category,amount,imgURL,description
        // get data from jsp
          
        String imgURL = request.getParameter("imgURL").equals("")?"default_image.jpg":request.getParameter("imgURL");
        System.out.println(imgURL);
        String name = request.getParameter("productName");
        String category = request.getParameter("productCategory");
        float price = Float.parseFloat(request.getParameter("productPrice"));
        int amount = Integer.parseInt(request.getParameter("productAmount"));
        String description = request.getParameter("productDescription");
        if(description == null){
            description="No Description";
        }
        
        Product product=new Product(Long.MIN_VALUE, price, amount, name, description, category, imgURL);
       
        //Create DB handler object 
        ProductDao productdao = new ProductDao();
       
        //add product in db
        
        if(productdao.addProduct(product)){
            request.setAttribute("success", "Product added successfully");
            request.getRequestDispatcher("admin").forward(request, response);
            //response.sendRedirect("/OnlineShopping");
        }else{
            request.setAttribute("errormsg", "Product is not inserted successfully" );
            request.getRequestDispatcher("/admin/add_product.jsp").forward(request, response);
            return;
        }
    }
    
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
