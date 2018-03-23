/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAccessLayer.DAO;

import java.util.List;
import model.dataAccessLayer.entity.ItiStoreYProduct;

/**
 *
 * @author Eman-PC
 */
public interface ProductDAOInt {

    public void addProduct(ItiStoreYProduct product);

    public void deleteProduct(Long id);

    public void updateProduct(ItiStoreYProduct product);

    public ItiStoreYProduct getProductByID(Long id);

    public List<ItiStoreYProduct> getProductList();

    public int productAmount(Long id);
}
