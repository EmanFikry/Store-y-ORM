/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAccessLayer.DAO;

import java.sql.SQLException;
import java.util.List;
import model.dataAccessLayer.entity.ItiStoreYUser;

/**
 *
 * @author Eman-PC
 */
public interface UserDAOInt {

    public void addUser(ItiStoreYUser user);
    
    public void addAllUserInterest(ItiStoreYUser user);
    
    public boolean hasInterests(ItiStoreYUser user);

    public void editProfile(ItiStoreYUser user);

    public boolean isEmailExist(String email);
    
    public Long getUserIdByEmail(String email);

    public ItiStoreYUser getUserById(Long id) throws SQLException;

    public ItiStoreYUser checkLogin(String email, String password);

    public List<ItiStoreYUser> getUserList();

    public boolean deleteUserInterests(ItiStoreYUser user);
}
