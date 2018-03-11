/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAccessLayer.DAO.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.dataAccessLayer.DAO.WishListDAOInt;
import model.dataAccessLayer.entity.Database;
import model.dataAccessLayer.entity.WishList;

/**
 *
 * @author Ghada
 */
public class WishListDAOImpl implements WishListDAOInt {

    WishList wishList = new WishList();

    /**
     * **************** add wish list *****************
     */
    @Override
    public boolean addWishList(Long userID, Long productID, Long numOfItem) {
        boolean isAdded = false;
        PreparedStatement ps = Database.getInstance().getPreparedStatement("INSERT INTO ITI_STORE_Y_WISHLIST (USERID, PRODUCTID, NUMOFITEM) VALUES (?,?,?)");
        try {
            ps.setLong(1, userID);
            ps.setLong(2, productID);
            ps.setLong(3, numOfItem);

            int rowsEffected = ps.executeUpdate();
            if (rowsEffected == 1) {
                isAdded = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Database.getInstance().release();
        }
        return isAdded;
    }

    /**
     * **************** delete Product Of WishList *****************
     */
    @Override
    public boolean deleteProductOfWishList(Long productID, Long userID) {
        boolean isDeleted = false;
        PreparedStatement ps = Database.getInstance().getPreparedStatement("DELETE FROM ITI_STORE_Y_WISHLIST WHERE PRODUCTID=? AND USERID=? ");
        try {
            ps.setLong(1, productID);
            ps.setLong(2, userID);
            if (ps.executeUpdate() > 0) {
                isDeleted = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Database.getInstance().release();
        }
        return isDeleted;
    }

    /**
     * **************** product Exist *****************
     */
    @Override
    public boolean isProductExist(Long userID, Long productID) {
        boolean isExist = false;
        PreparedStatement ps = Database.getInstance().getPreparedStatement("SELECT recid FROM ITI_STORE_Y_WISHLIST WHERE userID=? AND productID=?");
        try {
            ps.setLong(1, userID);
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

    /**
     * **************** edit wishlist *****************
     */
    @Override
    public boolean updateMyWishList(WishList wishlist) {
        boolean isUpdated = false;
        PreparedStatement ps = Database.getInstance().getPreparedStatement("update ITI_STORE_Y_WISHLIST  set numofitem=? where  "
                + "userid=? and productid=?");

        try {
            ps.setLong(2, wishlist.getUserID());
            ps.setLong(3, wishlist.getProductID());
            ps.setLong(1, wishlist.getNumOfItem());

            if (ps.executeUpdate() > 0) {
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
     * ******************* delete product of user *****************
     */
    public boolean deleteProductOfUser(WishList wishList) {
        boolean isDeleted = false;
        PreparedStatement ps = Database.getInstance().getPreparedStatement("DELETE FROM ITI_STORE_Y_WISHLIST WHERE USERID=? AND PRODUCTID=?");
        try {
            ps.setLong(1, wishList.getUserID());
            ps.setLong(2, wishList.getProductID());
            if (ps.executeUpdate() > 0) {
                isDeleted = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Database.getInstance().release();
        }

        return isDeleted;
    }
}
