/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.DAODelegate;

import java.sql.SQLException;
import java.util.ArrayList;
import model.dataAccessLayer.DAO.*;
import model.dataAccessLayer.entity.Cart;
import model.dataAccessLayer.entity.Product;
import model.dataAccessLayer.entity.User;
import model.databasedao.factory.DAOsFactory;

/**
 *
 * @author Eman-PC
 */
public class DAOService {

    CartDAOInt cartDAORef = DAOsFactory.getCartDAOImpl();
    ProductCartDAOInt productCartDAORef = DAOsFactory.getProductCartDAOImpl();
    UserDAOInt userDAORef = DAOsFactory.getUserDAOImpl();
    ProductDAOInt productDAORef = DAOsFactory.getProductDAOImpl();

    public boolean addProduct(Product product) {
        boolean isStored = productDAORef.addProduct(product);
        return isStored;
    }

    public boolean deleteProduct(Long id) {
        boolean isDeleted = productDAORef.deleteProduct(id);
        return isDeleted;
    }

    public boolean updateProduct(Product product) {
        boolean isUpdated = productDAORef.updateProduct(product);
        return isUpdated;
    }

    public Product getProductByID(Long id) {
        Product product = productDAORef.getProductByID(id);
        return product;
    }

    public ArrayList<Product> getProductList() {
        ArrayList<Product> products = productDAORef.getProductList();
        return products;
    }

    public boolean isProductExist(Long cartID, Long productID) {
        boolean productExist = productCartDAORef.isProductExist(cartID, productID);
        return productExist;
    }

    public boolean addUser(User user) {
        boolean isAdded = false;
        if (userDAORef.addUser(user) && userDAORef.getUserIdByEmail(user.getEmail()) > 0) {
            user.setRecID(userDAORef.getUserIdByEmail(user.getEmail()));
            if (userDAORef.addAllUserInterest(user)) {
                isAdded = true;
            }
        }
        return isAdded;
    }

    public boolean isEmailExist(String email) {
        boolean isExisted = userDAORef.isEmailExist(email);
        return isExisted;
    }

    public boolean editProfile(User user) {
        boolean isUpdated = false;
        if (userDAORef.editProfile(user)) {
            if (userDAORef.hasInterests(user)) {
                if (userDAORef.deleteUserInterests(user)) {
                    isUpdated = userDAORef.addAllUserInterest(user);
                }
            } else {
                isUpdated = userDAORef.addAllUserInterest(user);
            }
        }
        return isUpdated;
    }

    public User getUserById(Long id) throws SQLException {
        User user = userDAORef.getUserById(id);
        return user;
    }

    public User checkLogin(String email, String password) {
        User user = userDAORef.checkLogin(email, password);
        return user;
    }

    public ArrayList<User> getUserList() {
        ArrayList<User> users = userDAORef.getUserList();
        return users;
    }

    public boolean addCart(Cart cart) {
        boolean isAdded = cartDAORef.addCart(cart);
        return isAdded;
    }

    public Long getLastCartID() {
        Long cartID = cartDAORef.getLastCartID();
        return cartID;
    }

    public boolean addOrder(Long cartID, Long productID, Long numOfItem) {
        boolean isAdded = productCartDAORef.addOrder(cartID, productID, numOfItem);
        return isAdded;
    }
}
