/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.DAODelegate;

import java.sql.SQLException;
import java.util.List;
import model.dataAccessLayer.DAO.*;
import model.dataAccessLayer.entity.ItiStoreYCart;
import model.dataAccessLayer.entity.ItiStoreYProduct;
import model.dataAccessLayer.entity.ItiStoreYUser;
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

    /**
     * ******************** product methods **********************
     */
    public void addProduct(ItiStoreYProduct product) {
        productDAORef.addProduct(product);
    }

    public void deleteProduct(Long id) {
        productDAORef.deleteProduct(id);
    }

    public void updateProduct(ItiStoreYProduct product) {
        productDAORef.updateProduct(product);
    }

    public ItiStoreYProduct getProductByID(Long id) {
        ItiStoreYProduct product = productDAORef.getProductByID(id);
        return product;
    }

    public List<ItiStoreYProduct> getProductList() {
        List<ItiStoreYProduct> products = productDAORef.getProductList();
        return products;
    }

    public boolean isProductExist(Long cartID, Long productID) {
        boolean productExist = productCartDAORef.isProductExist(cartID, productID);
        return productExist;
    }

    /**
     * ******************** User methods **********************
     */
    public void addUser(ItiStoreYUser user) {
        userDAORef.addUser(user);
        userDAORef.deleteUserInterests(user);
        user.getItiStoreYInterests().clear();
        userDAORef.addAllUserInterest(user);
    }

    public boolean isEmailExist(String email) {
        boolean isExisted = userDAORef.isEmailExist(email);
        return isExisted;
    }

    public void editProfile(ItiStoreYUser user) {
        userDAORef.editProfile(user);
        userDAORef.deleteUserInterests(user);
        user.getItiStoreYInterests().clear();
        userDAORef.addAllUserInterest(user);
    }

    public void updateUser(ItiStoreYUser user) {
        userDAORef.editProfile(user);
    }

    public ItiStoreYUser getUserById(Long id) throws SQLException {
        ItiStoreYUser user = userDAORef.getUserById(id);
        return user;
    }

    public ItiStoreYUser checkLogin(String email, String password) {
        ItiStoreYUser user = userDAORef.checkLogin(email, password);
        return user;
    }

    public List<ItiStoreYUser> getUserList() {
        List<ItiStoreYUser> users = userDAORef.getUserList();
        return users;
    }

    /**
     * ******************** Cart methods **********************
     */
    public ItiStoreYCart getCartById(Long id) {
        ItiStoreYCart cart = cartDAORef.getCartById(id);
        return cart;
    }

    public boolean addCart(ItiStoreYCart cart) {
        boolean isAdded = cartDAORef.addCart(cart);
        return isAdded;
    }

    public Long getLastCartID() {
        Long cartID = cartDAORef.getLastCartID();
        return cartID;
    }

    public void addOrder(Long cartID, Long productID, Long numOfItem) {
        productCartDAORef.addOrder(cartID, productID, numOfItem);

    }

    public void updateCart(ItiStoreYCart cart) {
        cartDAORef.updateCart(cart);
    }
}
