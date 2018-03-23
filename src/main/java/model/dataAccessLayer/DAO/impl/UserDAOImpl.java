/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAccessLayer.DAO.impl;

import model.dataAccessLayer.DAO.UserDAOInt;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dataAccessLayer.entity.ItiStoreYInterest;
import model.dataAccessLayer.entity.ItiStoreYUser;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Eman-PC
 */
public class UserDAOImpl implements UserDAOInt {

    static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    static Session session = sessionFactory.openSession();

    /**
     * ******************* add new User *****************
     */
    //tested
    @Override
    public void addUser(ItiStoreYUser user) {
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    /**
     * ******************* add all User interest *****************
     */
    //tested
    @Override
    public void addAllUserInterest(ItiStoreYUser user) {
        Set<ItiStoreYInterest> interests = user.getItiStoreYInterests();

        Iterator<ItiStoreYInterest> it = interests.iterator();
        while (it.hasNext()) {
            addUserInterest(user, it.next().getName());
        }
    }

    /**
     * ******************* add single interest *****************
     */
    //tested
    private void addUserInterest(ItiStoreYUser user, String interest) {
        ItiStoreYInterest interest2 = new ItiStoreYInterest();
        interest2.setItiStoreYUser(user);
        interest2.setName(interest);
        session.beginTransaction();
        session.save(interest2);
        session.getTransaction().commit();
    }

    /**
     * ******************* delete user interests *****************
     */
    //tested
    @Override
    public void deleteUserInterests(ItiStoreYUser user) {
        Set<ItiStoreYInterest> interests = user.getItiStoreYInterests();
        for (ItiStoreYInterest interest : interests) {
            session.beginTransaction();
            session.delete(interest);
            session.getTransaction().commit();
        }

    }

    /**
     * ******************* check if user has interests *****************
     */
    //not tested because not needed
    @Override
    public boolean hasInterests(ItiStoreYUser user) {
        boolean hasInterest = false;
        Query query
                = session.createQuery("select recid FROM ITI_STORE_Y_INTEREST where userid=:userId");
        query.setParameter("userId", user.getRecid());

        List result = query.list();
        if (result.size() > 0) {
            hasInterest = true;
        }
        return hasInterest;
    }

    /**
     * ******************* update User *****************
     */
    //tested
    @Override
    public void editProfile(ItiStoreYUser user) {
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }

    /**
     * **************** User Exist *****************
     */
    //tested
    @Override
    public boolean isEmailExist(String email) {
        boolean isExist = false;
        Query query
                = session.createQuery("SELECT recid FROM ItiStoreYUser WHERE email=:userEmail");
        query.setParameter("userEmail", email);

        List result = query.list();
        if (result.size() > 0) {
            isExist = true;
        }
        return isExist;
    }

    /**
     * ***************** get user by id ***************
     */
    //tested
    @Override
    public ItiStoreYUser getUserById(Long id) throws SQLException {
        ItiStoreYUser user = (ItiStoreYUser) session.load(ItiStoreYUser.class, id);
        return user;
    }

    /**
     * ***************** get user by email ***************
     */
    //tested
    @Override
    public Long getUserIdByEmail(String email) {
        Long userID = -1L;
        Query query
                = session.createQuery("SELECT u.recid FROM ItiStoreYUser u WHERE u.email=:userEmail");
        query.setParameter("userEmail", email);

        List<Long> result = query.list();
        if (!result.isEmpty()) {
            userID = result.get(0);
        }
        return userID;
    }

    /**
     * **************** Login method ******************
     */
    //tested
    @Override
    public ItiStoreYUser checkLogin(String email, String password) {
        ItiStoreYUser existUser = null;
        if (isEmailExist(email)) {
            Query query
                    = session.createQuery("FROM ItiStoreYUser WHERE email=:userEmail AND password=:userPassword");
            query.setParameter("userEmail", email);
            query.setParameter("userPassword", password);

            List<ItiStoreYUser> result = query.list();
            try {
                if (!result.isEmpty()) {
                    existUser = getUserById(result.get(0).getRecid());
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Exception in checkLogin");
            }
        }
        return existUser;
    }

    /**
     * **************** list all users ******************
     */
    //tested
    @Override
    public List<ItiStoreYUser> getUserList() {
        Query query
                = session.createQuery("FROM ItiStoreYUser");
        List<ItiStoreYUser> result = query.list();
        return result;
    }

    @Override
    public Long getLastClientID() {
        Long userID = -1L;
        Query query = session.createQuery("from ItiStoreYUser c where c.recid = ( select max(c1.recid) from  ItiStoreYUser c1 ) ");

        List<ItiStoreYUser> list = query.list();
        if (!list.isEmpty()) {
            userID = list.get(0).getRecid();
        }
        return userID;
    }
}
