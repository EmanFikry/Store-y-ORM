/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAccessLayer.DAO.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.dataAccessLayer.entity.Database;
import model.dataAccessLayer.entity.Product;
import model.dataAccessLayer.DAO.ProductDAOInt;

/**
 *
 * @author Eman-PC
 */
public class ProductDAOImpl implements ProductDAOInt {

    Product product = new Product();

    /**
     * ******************* add new product *****************
     */
    @Override
    public boolean addProduct(Product product) {
        boolean isStored = false;
        PreparedStatement ps = Database.getInstance().getPreparedStatement("INSERT INTO ITI_STORE_Y_PRODUCT (name,price,category,amount,imgURL,description) VALUES (?,?,?,?,?,?)");
        try {
            ps.setString(1, product.getName());
            ps.setFloat(2, product.getPrice());
            ps.setString(3, product.getCategory());
            ps.setInt(4, product.getAmount());
            ps.setString(5, product.getImgURL());
            ps.setString(6, product.getDescription());

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

    /**
     * ******************* delete product *****************
     */
    @Override
    public boolean deleteProduct(Long id) {
        boolean isDeleted = false;
        PreparedStatement ps = Database.getInstance().getPreparedStatement("DELETE FROM ITI_STORE_Y_PRODUCT WHERE RECID=? ");
        try {
            ps.setLong(1, id);
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
     * ******************* update product *****************
     */
    @Override
    public boolean updateProduct(Product product) {
        boolean isUpdated = false;
        PreparedStatement ps = Database.getInstance().getPreparedStatement("update ITI_STORE_Y_PRODUCT  set name=?, price=?,category=?,amount=?,imgURL=?,description=? where Recid=?");

        try {
            ps.setString(1, product.getName());
            ps.setFloat(2, product.getPrice());
            ps.setString(3, product.getCategory());
            ps.setInt(4, product.getAmount());
            ps.setString(5, product.getImgURL());
            ps.setString(6, product.getDescription());
            ps.setLong(7, product.getRecID());

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
     * ******************* get product by ID *****************
     */
    @Override
    public Product getProductByID(Long id) {
        PreparedStatement ps = Database.getInstance().getPreparedStatement("SELECT * FROM ITI_STORE_Y_PRODUCT WHERE recid=?");
        try {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                product.setRecID(rs.getLong("recId"));
                product.setName(rs.getString("Name"));
                product.setPrice(rs.getFloat("price"));
                product.setCategory(rs.getString("Category"));
                product.setAmount(rs.getInt("Amount"));
                product.setImgURL(rs.getString("ImgURL"));
                product.setDescription(rs.getString("Description"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Database.getInstance().release();
        }
        return product;
    }

    /**
     * ******************* get all products *****************
     */
    @Override
    public ArrayList<Product> getProductList() {
        ArrayList<Product> list = new ArrayList<Product>();
        PreparedStatement ps = Database.getInstance().getPreparedStatement("SELECT * FROM ITI_STORE_Y_PRODUCT");
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setRecID(rs.getLong("recid"));
                product.setName(rs.getString("Name"));
                product.setPrice(rs.getFloat("PRICE"));
                product.setCategory(rs.getString("CATEGORY"));
                product.setAmount(rs.getInt("AMOUNT"));
                product.setImgURL(rs.getString("IMGURL"));
                product.setDescription(rs.getString("DESCRIPTION"));
                list.add(product);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Database.getInstance().release();
        }
        return list;
    }

    /**
     * ******************* get product Amount *****************
     */
    @Override
    public int productAmount(Long id) {
        int pAmount = -1;
        PreparedStatement ps = Database.getInstance().getPreparedStatement("SELECT amount FROM ITI_STORE_Y_PRODUCT WHERE productID=?");
        try {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pAmount = rs.getInt("amount");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Database.getInstance().release();
        }
        return pAmount;

    }
}
