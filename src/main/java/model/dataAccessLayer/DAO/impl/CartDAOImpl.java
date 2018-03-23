/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAccessLayer.DAO.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.dataAccessLayer.entity.ItiStoreYCart;
import model.dataAccessLayer.DAO.CartDAOInt;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Eman-PC
 */
public class CartDAOImpl implements CartDAOInt {

    static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    static Session session = sessionFactory.openSession();

    /**
     * ******************* add new Cart *****************
     */
    @Override
    public boolean addCart(ItiStoreYCart cart) {
        boolean isStored = false;

        session.beginTransaction();
        session.save(cart);
        session.getTransaction().commit();
        isStored = true;
        return isStored;
    }

    @Override
    public void updateCart(ItiStoreYCart cart) {
        session.beginTransaction();
        session.update(cart);
        session.getTransaction().commit();
    }

    @Override
    public ItiStoreYCart getCartById(Long id) {
        ItiStoreYCart cart = (ItiStoreYCart) session.load(ItiStoreYCart.class, id);
        return cart;
    }

    @Override
    public Long getLastCartID() {
        Long cartID = -1L;
        Query query = session.createQuery("from ItiStoreYCart c where c.recid = ( select max(c1.recid) from  ItiStoreYCart c1 ) ");

        List<ItiStoreYCart> list = query.list();
        if (!list.isEmpty()) {
            cartID = list.get(0).getRecid();
        }
        return cartID;
    }
}
