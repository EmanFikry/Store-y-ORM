/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.databasedao.factory;

import model.dataAccessLayer.DAO.impl.*;

/**
 *
 * @author Eman-PC
 */
public class DAOsFactory {

    private static CartDAOImpl cartDAOImplInstance = null;
    private static ProductCartDAOImpl productCartDAOImplInstance = null;
    private static UserDAOImpl userDAOImplInstance = null;
    private static ProductDAOImpl productDAOImplInstance = null;
    private static WishListDAOImpl wishListDAOImplInstance = null;

    public static CartDAOImpl getCartDAOImpl() {

        if (cartDAOImplInstance == null) {
            cartDAOImplInstance = new CartDAOImpl();
        }
        return cartDAOImplInstance;
    }

    public static ProductCartDAOImpl getProductCartDAOImpl() {

        if (productCartDAOImplInstance == null) {
            productCartDAOImplInstance = new ProductCartDAOImpl();
        }
        return productCartDAOImplInstance;
    }

    public static UserDAOImpl getUserDAOImpl() {

        if (userDAOImplInstance == null) {
            userDAOImplInstance = new UserDAOImpl();
        }
        return userDAOImplInstance;
    }

    public static ProductDAOImpl getProductDAOImpl() {

        if (productDAOImplInstance == null) {
            productDAOImplInstance = new ProductDAOImpl();
        }
        return productDAOImplInstance;
    }

    public static WishListDAOImpl getWishListDAOImpl() {

        if (wishListDAOImplInstance == null) {
            wishListDAOImplInstance = new WishListDAOImpl();
        }
        return wishListDAOImplInstance;
    }
}
