package com.productorders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productorders.dao.ProductDao;
import com.productorders.model.Product;


@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductDao productdao;
	
	public void saveproducts(Product product) {
		if(!productdao.isProductnameAvailable(product.getProductname())) {
			productdao.saveproduct(product);
			System.out.println(product);
		}
	}
	public Product getbyid(Integer id) {
		return productdao.getbyidproduct(id);
	}
	public List<Product> getallproducts(){
		return productdao.getallproducts();
	}
	public void delete(Product product) {
		productdao.delete(product);
	}
	public void updateProduct(Product updatedProduct) {
        productdao.updateProduct(updatedProduct);
    }
	public List<Product> search(Integer id,String productname,Integer price){
		return productdao.searchProducts(id, productname, price);
	}
	
	public boolean isProductnameAvailable(String productname) { 
	  return productdao.isProductnameAvailable(productname);
	  
	}
	 
}
