/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAccessLayer.DAO;

import model.dataAccessLayer.entity.WishList;

/**
 *
 * @author Ghada
 */
public interface WishListDAOInt {

    public boolean addWishList(Long userID, Long productID, Long numOfItem);

    public boolean deleteProductOfWishList(Long productID, Long userID);
    
    public boolean isProductExist(Long cartID, Long productID);
    
    public boolean updateMyWishList(WishList wishlist);
}
