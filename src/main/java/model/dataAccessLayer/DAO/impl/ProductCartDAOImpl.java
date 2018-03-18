/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAccessLayer.DAO.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.dataAccessLayer.entity.Database;
import model.dataAccessLayer.entity.ItiStoreYProductcart;
import model.dataAccessLayer.DAO.ProductCartDAOInt;

/**
 *
 * @author Eman-PC
 */
public class ProductCartDAOImpl implements ProductCartDAOInt {

    ItiStoreYProductcart productCart = new ItiStoreYProductcart();

    /**
     * **************** product Exist *****************
     */
    @Override
    public boolean isProductExist(Long cartID, Long productID) {
        boolean isExist = false;
        PreparedStatement ps = Database.getInstance().getPreparedStatement("SELECT recid FROM ITI_STORE_Y_PRODUCTCART WHERE cartID=? AND productID=?");
        try {
            ps.setLong(1, cartID);
            ps.setLong(2, productID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                isExist = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Database.getInstance().release();
        }
        return isExist;
    }
    @Override
    public boolean addOrder(Long cartID, Long productID, Long numOfItem) {
        boolean isAdded = false;
        PreparedStatement ps = Database.getInstance().getPreparedStatement("INSERT INTO ITI_STORE_Y_PRODUCTCART (CARTID, PRODUCTID, NUMOFITEMS) VALUES (?,?,?)");
        try {
            ps.setLong(1, cartID);
            ps.setLong(2, productID);
            ps.setLong(3, numOfItem);

            int rowsEffected = ps.executeUpdate();
            if (rowsEffected == 1) {
                isAdded= true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Database.getInstance().release();
        }
        return isAdded;
    }
}
