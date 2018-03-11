/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAccessLayer.DAO;

import model.dataAccessLayer.entity.Cart;

/**
 *
 * @author Eman-PC
 */
public interface CartDAOInt {
    public boolean addCart(Cart cart);
    public Long getLastCartID ();
     public boolean updateCart(Cart cart);
}
