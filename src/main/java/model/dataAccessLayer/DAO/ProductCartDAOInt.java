/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAccessLayer.DAO;

/**
 *
 * @author Eman-PC
 */
public interface ProductCartDAOInt {

    public boolean isProductExist(Long cartID, Long productID);

    public void addOrder(Long cartID, Long productID, Long numOfItem);
}
