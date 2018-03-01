/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAccessLayer.DAO.impl;

import model.dataAccessLayer.DAO.UserDAOInt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.dataAccessLayer.entity.Database;
import model.dataAccessLayer.entity.User;

/**
 *
 * @author Eman-PC
 */
public class UserDAOImpl implements UserDAOInt {

    User user = new User();

    /**
     * ******************* add new User *****************
     */
    @Override
    public boolean addUser(User user) {
        boolean isStored = false;
        PreparedStatement ps = Database.getInstance().getPreparedStatement("INSERT INTO ITI_STORE_Y_USER (NAME,PASSWORD,EMAIL,ADDRESS,JOB,BIRTHDATE,CREDITLIMIT) VALUES (?,?,?,?,?,?,?)");
        try {
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getAddress());
            ps.setString(5, user.getJob());
            ps.setDate(6, new java.sql.Date(user.getBirthdate().getTime()));
            ps.setFloat(7, user.getCreditLimit());

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
     * ******************* update product *****************
     */
    @Override
    public boolean editProfile(User user) {
        boolean isUpdated = false;
        PreparedStatement ps = Database.getInstance().getPreparedStatement("update ITI_STORE_Y_USER  set NAME=?, PASSWORD=?,EMAIL=?,ADDRESS=?,JOB=?,BIRTHDATE=?, CREDITLIMIT=? where Recid=?");

        try {
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getAddress());
            ps.setString(5, user.getJob());
            ps.setDate(6, new java.sql.Date(user.getBirthdate().getTime()));
            ps.setFloat(7, user.getCreditLimit());
            ps.setLong(8, user.getRecID());

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
     * **************** User Exist *****************
     */
    @Override
    public boolean isEmailExist(String email) {
        boolean isExist = false;
        PreparedStatement ps = Database.getInstance().getPreparedStatement("SELECT recid FROM ITI_STORE_Y_USER WHERE email=?");
        try {
            ps.setString(1, email);
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
     * ***************** get user by id ***************
     */
    @Override
    public User getUserById(Long id) throws SQLException {
        User user = new User();
        PreparedStatement ps = Database.getInstance().getPreparedStatement("SELECT * FROM ITI_STORE_Y_USER WHERE recid=?");
        try {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setRecID(rs.getLong("recId"));
                user.setName(rs.getString("Name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setJob(rs.getString("JOB"));
                user.setBirthdate(rs.getDate("BIRTHDATE"));
                user.setCreditLimit(rs.getFloat("creditlimit"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Database.getInstance().release();
        }
        return user;
    }

    /**
     * **************** Login method ******************
     */
    @Override
    public User checkLogin(String email, String password) {
        User existUser = null;
        if (isEmailExist(email)) {
            PreparedStatement ps = Database.getInstance().getPreparedStatement("SELECT * FROM ITI_STORE_Y_USER WHERE email=? AND password=?");
            try {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    existUser = getUserById(rs.getLong("recID"));
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            } finally {
                Database.getInstance().release();
            }
        }
        return existUser;
    }

    /**
     * **************** list all users ******************
     */
    @Override
    public ArrayList<User> getUserList() {
        ArrayList<User> list = new ArrayList<User>();
        PreparedStatement ps = Database.getInstance().getPreparedStatement("SELECT * FROM ITI_STORE_Y_USER");
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setRecID(rs.getLong("recid"));
                user.setName(rs.getString("Name"));
                user.setPassword(rs.getString("Password"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("Address"));
                user.setJob(rs.getString("job"));
                user.setBirthdate(rs.getDate("BIRTHDATE"));
                user.setCreditLimit(rs.getFloat("CreditLimit"));
                list.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Database.getInstance().release();
        }
        return list;
    }
}
