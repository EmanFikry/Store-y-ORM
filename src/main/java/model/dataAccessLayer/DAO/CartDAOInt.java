/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAccessLayer.DAO;

import model.dataAccessLayer.entity.ItiStoreYCart;

/**
 *
 * @author Eman-PC
 */
public interface CartDAOInt {

    public ItiStoreYCart getCartById(Long id);
            
    public boolean addCart(ItiStoreYCart cart);

    public Long getLastCartID();

    public void updateCart(ItiStoreYCart cart);
}
