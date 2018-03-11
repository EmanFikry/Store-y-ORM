/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.user;

import controller.DAODelegate.DAOService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dataAccessLayer.entity.User;
import model.dataAccessLayer.entity.WishList;

/**
 *
 * @author Eman-PC
 */
public class UpdateCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = "";
        if (br != null) {
            json = br.readLine();
        }

        String result = json.replaceAll("[\\{\\}\\[\\]]", "");

        String[] products = result.split(",");
        String[] amountArray = products[2].split(":");
        String amount = amountArray[1];
        String[] idArray = products[3].split(":");
        String id = idArray[1].replaceAll("\"", "");

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("userObject");

        WishList wishList = new WishList();
        wishList.setUserID(user.getRecID());
        wishList.setNumOfItem(Long.parseLong(amount));
        wishList.setProductID(Long.parseLong(id));

        DAOService daoService = new DAOService();
        boolean isAdded = daoService.addWishList(wishList);
        System.out.println(isAdded);
        response.getWriter().write("success");
        //add to db 
    }
}
