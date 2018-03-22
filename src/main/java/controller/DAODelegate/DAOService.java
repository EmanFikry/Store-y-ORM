/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.DAODelegate;

import java.sql.SQLException;
import java.util.List;
import model.dataAccessLayer.DAO.*;
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
    public boolean addProduct(ItiStoreYProduct product) {
        boolean isStored = productDAORef.addProduct(product);
        return isStored;
    }

    public boolean deleteProduct(Long id) {
        boolean isDeleted = productDAORef.deleteProduct(id);
        return isDeleted;
    }

    public boolean updateProduct(ItiStoreYProduct product) {
        boolean isUpdated = productDAORef.updateProduct(product);
        return isUpdated;
    }

    public ItiStoreYProduct getProductByID(Long id) {
        ItiStoreYProduct product = productDAORef.getProductByID(id);
        return product;
    }

    public ArrayList<ItiStoreYProduct> getProductList() {
        ArrayList<ItiStoreYProduct> products = productDAORef.getProductList();
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
    public boolean addCart(ItiStoreYCart cart) {
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

    public boolean updateCart(ItiStoreYCart cart) {
        boolean isUpdated = cartDAORef.updateCart(cart);
        return isUpdated;
    }
}
