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
import model.dataBaseClasses.Product;
import model.dataBaseClasses.User;
import model.dataBaseDAOs.ProductDao;

/**
 *
 * @author shalaby
 */
public class EditProductServlet extends HttpServlet {

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
        User user = (User) session.getAttribute("admin_logged");
        System.out.println(user);
        if (user == null) {    //user not logged in 
            request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
            return;
            
        }
        //get product id from request
        Long pId = Long.parseLong(request.getParameter("pId"));
        if(pId == 0){
            response.sendRedirect("/admin/products.jsp");
        }
        //get whole product from db 
        ProductDao productdao = new ProductDao();
        Product p = productdao.getProductByID(pId);
        if(p != null){
            request.setAttribute("edit_product", p);
            request.getRequestDispatcher("/admin/edit_product.jsp").forward(request, response);
            return;
        }else{
            request.setAttribute("errorMsg", "No Such Product");
            request.getRequestDispatcher("admin").forward(request, response);
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
