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
import model.dataAccessLayer.entity.ItiStoreYCart;
import model.dataAccessLayer.entity.ItiStoreYProduct;
import model.dataAccessLayer.entity.ItiStoreYUser;

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

        float totalSum = 0F;
        //create cart object
        HttpSession session = request.getSession(false);
        ItiStoreYUser user = (ItiStoreYUser) session.getAttribute("userObject");

        //add new cart
        ItiStoreYCart cart = new ItiStoreYCart();
        cart.setItiStoreYUser(user);
        //cart.setTotalSum(totalSum);
        daoService.addCart(cart);
        Long cartID = daoService.getLastCartID();

        String result = json.replaceAll("[\\[\\] \\{\\}]", "");
        String[] products = result.split(",");
        for (int count = 0; count < products.length; count++) {
            String[] productInfo = products[count].split(":");
            String productID = productInfo[1].replaceAll("\"", "");
            String productQuantity = productInfo[0].replaceAll("\"", "");
            String productTotalSum = productInfo[2].replaceAll("\"", "");
            totalSum = Float.parseFloat(productTotalSum);

            //update product amount
            ItiStoreYProduct product = daoService.getProductByID(Long.parseLong(productID));
            product.setAmount(product.getAmount() - Integer.parseInt(productQuantity));
            daoService.updateProduct(product);

            //add product to cart
            daoService.addOrder(cartID, Long.parseLong(productID), Long.parseLong(productQuantity));
        }

        //update cart total sum
        ItiStoreYCart updatedCart = daoService.getCartById(cartID);
        updatedCart.setTotalsum(totalSum);
        daoService.updateCart(updatedCart);
        //update user credit limit after buying
        user.setCreditlimit(user.getCreditlimit() - totalSum);
        daoService.updateUser(user);
        session.setAttribute("userObject", user);
        response.sendRedirect(request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + request.getContextPath() + "/home.jsp");
    }

}
