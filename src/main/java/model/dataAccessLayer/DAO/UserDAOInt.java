/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAccessLayer.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import model.dataAccessLayer.entity.User;

/**
 *
 * @author Eman-PC
 */
public interface UserDAOInt {

    public boolean addUser(User user);
    
    public boolean addAllUserInterest(User user);

    public boolean editProfile(User user);

    public boolean isEmailExist(String email);
    
    public Long getUserIdByEmail(String email);

    public User getUserById(Long id) throws SQLException;

    public User checkLogin(String email, String password);

    public ArrayList<User> getUserList();
}
