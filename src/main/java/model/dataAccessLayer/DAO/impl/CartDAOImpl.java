/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAccessLayer.DAO.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.dataAccessLayer.entity.Cart;
import model.dataAccessLayer.DAO.CartDAOInt;
import model.dataAccessLayer.entity.Database;

/**
 *
 * @author Eman-PC
 */
public class CartDAOImpl implements CartDAOInt {

    Cart cart = new Cart();

    /**
     * ******************* add new Cart *****************
     */
    @Override
    public boolean addCart(Cart cart) {
        boolean isStored = false;
        PreparedStatement ps = Database.getInstance().getPreparedStatement("INSERT INTO ITI_STORE_Y_CART (USERID,TOTALSUM) VALUES (?,?)");
        try {
            ps.setLong(1, cart.getUserID());
            ps.setDouble(2, cart.getTotalSum());

            int rowsEffected = ps.executeUpdate();
            if (rowsEffected == 1) {
                isStored = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Database.getInstance().release();
        }
        return isStored;
    }

    public boolean updateCart(Cart cart) {
        boolean isUpdated = false;
        PreparedStatement ps = Database.getInstance().getPreparedStatement("update ITI_STORE_Y_CART set totalsum = ? where recid=? ");
        try {
            ps.setLong(2, cart.getRecID());
            ps.setDouble(1, cart.getTotalSum());

            int rowsEffected = ps.executeUpdate();
            if (rowsEffected == 1) {
                isUpdated = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Database.getInstance().release();
        }
        return isUpdated;
    }

    /**
     * ******************* Get last cart id *****************
     */
    @Override
    public Long getLastCartID() {
        Long cartID = -1L;
        PreparedStatement ps = Database.getInstance().getPreparedStatement("select * from ITI_STORE_Y_CART where recid = ( select max(recid) from  ITI_STORE_Y_CART )");
        try {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cartID = rs.getLong("recid");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Database.getInstance().release();
        }
        return cartID;
    }
}
