/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAccessLayer.DAO;

import java.util.ArrayList;
import model.dataAccessLayer.entity.ItiStoreYProduct;

/**
 *
 * @author Eman-PC
 */
public interface ProductDAOInt {

    public boolean addProduct(ItiStoreYProduct product);

    public boolean deleteProduct(Long id);

    public boolean updateProduct(ItiStoreYProduct product);

    public ItiStoreYProduct getProductByID(Long id);

    public ArrayList<ItiStoreYProduct> getProductList();

    public int productAmount(Long id);
}
