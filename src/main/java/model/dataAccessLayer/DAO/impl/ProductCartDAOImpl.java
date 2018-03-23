/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAccessLayer.DAO.impl;

import java.math.BigDecimal;
import java.util.List;
import model.dataAccessLayer.entity.ItiStoreYProductcart;
import model.dataAccessLayer.DAO.ProductCartDAOInt;
import model.dataAccessLayer.entity.ItiStoreYCart;
import model.dataAccessLayer.entity.ItiStoreYProduct;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Eman-PC
 */
public class ProductCartDAOImpl implements ProductCartDAOInt {

    static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    static Session session = sessionFactory.openSession();

    /**
     * **************** product Exist *****************
     */
    //tested
    @Override
    public boolean isProductExist(Long cartID, Long productID) {

        boolean isExist = false;
        ItiStoreYCart cart = (ItiStoreYCart) session.load(ItiStoreYCart.class, cartID);
        ItiStoreYProduct product = (ItiStoreYProduct) session.load(ItiStoreYProduct.class, productID);
        if (cart != null && product != null) {
            Query query
                    = session.createQuery("SELECT recid FROM ItiStoreYProductcart p WHERE "
                            + "p.itiStoreYCart=:cart AND p.itiStoreYProduct=:product");
            query.setParameter("cart", cart);
            query.setParameter("product", product);

            List result = query.list();
            if (result.size() > 0) {
                isExist = true;
            }
        }
        return isExist;
    }

    //tested
    @Override
    public void addOrder(Long cartID, Long productID, Long numOfItem) {
        ItiStoreYCart cart = (ItiStoreYCart) session.load(ItiStoreYCart.class, cartID);
        ItiStoreYProduct product = (ItiStoreYProduct) session.load(ItiStoreYProduct.class, productID);
        ItiStoreYProductcart productcart = new ItiStoreYProductcart();
        productcart.setItiStoreYCart(cart);
        productcart.setItiStoreYProduct(product);
        productcart.setNumofitems(new BigDecimal(numOfItem));

        session.beginTransaction();
        session.save(productcart);
        session.getTransaction().commit();
    }
}
