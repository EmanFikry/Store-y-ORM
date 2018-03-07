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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dataAccessLayer.entity.Cart;
import model.dataAccessLayer.entity.Product;
import model.dataAccessLayer.entity.User;

/**
 *
 * @author Eman-PC
 */
public class BuyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = "";
        if (br != null) {
            json = br.readLine();
        }

        DAOService daoService = new DAOService();
        //get total sum from hesham
        float totalSum = 500;
        //create cart object
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("userObject");
        //update user credit limit after buying
      //  user.setCreditLimit(user.getCreditLimit() - totalSum);

        //add new cart
        Cart cart = new Cart();
        cart.setUserID(user.getRecID());
        cart.setTotalSum(totalSum);
        daoService.addCart(cart);
        Long cartID = daoService.getLastCartID();

        String result = json.replaceAll("[\\[\\]]", "");
        String[] products = result.split(",");
        for (int count = 0; count < products.length; count++) {
            String[] productInfo = products[count].split(":");
            String productID = productInfo[0];
            String productQuantity = productInfo[1];

            //update product amount
            Product product = daoService.getProductByID(Long.parseLong(productID));
            product.setAmount(product.getAmount() - Integer.parseInt(productQuantity));
            daoService.updateProduct(product);

            //add product to cart
            daoService.addOrder(cartID, Long.parseLong(productID), Long.parseLong(productQuantity));
        }

        System.out.println(json);
    }

}
