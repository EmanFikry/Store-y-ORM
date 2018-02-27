/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataBaseDAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.dataBaseClasses.Database;
import model.dataBaseClasses.Product;

/**
 *
 * @author Ahmed
 */
public class ProductDao {

    Product product = new Product();

    /**
     * ******************* add new product *****************
     */
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
    public Product getProductByID(Long id) {
        PreparedStatement ps = Database.getInstance().getPreparedStatement("SELECT * FROM ITI_STORE_Y_PRODUCT WHERE recid=?");
        try {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                product.setId(rs.getLong("recId"));
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

}
