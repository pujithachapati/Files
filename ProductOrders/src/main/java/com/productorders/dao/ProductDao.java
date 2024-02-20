package com.productorders.dao;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.query.Query;
import com.productorders.model.Order;
import com.productorders.model.Product;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;



@Repository
public class ProductDao {
	@Autowired
	private SessionFactory sessionfactory;
	
	public void saveproduct(Product product) {
		Session session = sessionfactory.getCurrentSession();
		session.saveOrUpdate(product);
	}
	public Product getbyidproduct(Integer id) {
		Session session = sessionfactory.getCurrentSession();
		 return session.get(Product.class,id);
	}
	public List<Product> getallproducts() {
		Session session = sessionfactory.getCurrentSession();
		return session.createQuery("FROM Product",Product.class).list();
	}
	public void delete(Product product) {
		Session session = sessionfactory.getCurrentSession();
		session.delete(product);
	}

	public void updateProduct(Product updatedProduct) {
	    Session session = sessionfactory.getCurrentSession();
	    Product existingProduct = getbyidproduct(updatedProduct.getId());
	    session.clear();;
	    existingProduct.setProductname(updatedProduct.getProductname());
	    existingProduct.setProductusage(updatedProduct.getProductusage());
	    existingProduct.setPrice(updatedProduct.getPrice());
	    existingProduct.setManufacturingDate(updatedProduct.getManufacturingDate());
	    
	    List<Order> existingOrders = existingProduct.getOrders();
	    List<Order> newOrders = updatedProduct.getOrders();
	    List<Order> ordersToRemove = new ArrayList<>();

	    for (Order updatedOrder : newOrders) {
	        boolean orderFound = false;

	        if (updatedOrder.getId() != null) {
	            for (int i = 0; i < existingOrders.size(); i++) {
	                Order existingOrder = existingOrders.get(i);

	                if (updatedOrder.getId().equals(existingOrder.getId())) {
	                    existingOrders.set(i, updatedOrder);
	                    orderFound = true;
	                    break;
	                }
	            }
	        } else {

	            if (!orderFound && updatedOrder.getCustomername()!=null) {
	            	session.clear();
	                existingOrders.add(updatedOrder);
	            }
	        }
	    }    
	   System.out.println(existingOrders);
	   for (Order existingOrder : existingOrders) {
	            if (!newOrders.contains(existingOrder)) {
	            	session.clear();
	                ordersToRemove.add(existingOrder);
	            }
	   }
	    existingOrders.removeAll(ordersToRemove);
	    existingProduct.setOrders(existingOrders);
	    session.update(existingProduct);
	}

	 
	
	  public List<Product> searchProducts(Integer id, String productname, Integer price) { 
		  Session session = sessionfactory.getCurrentSession();
		  CriteriaBuilder builder = session.getCriteriaBuilder();
		  CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
		  Root<Product> root = criteriaQuery.from(Product.class);
		  Predicate predicate = builder.conjunction();

		  if (id != null) { 
			  predicate = builder.and(predicate,builder.equal(root.get("id"), id)); 
		  }
	  
		  if (productname != null && !productname.isEmpty()) { 
			  predicate = builder.and(predicate, builder.like(builder.lower(root.get("productname")),"%" + productname.toLowerCase() + "%")); 
		  }
	  
		  if (price != null) { 
			  predicate = builder.and(predicate,builder.like(root.get("price").as(String.class), "%" + price.toString() +"%"));
	  
		  }

		  criteriaQuery.where(predicate);
	  
		  return session.createQuery(criteriaQuery).getResultList(); 
	  }
	 
	
	  public boolean isProductnameAvailable(String productname) {
		    Session session = sessionfactory.getCurrentSession();
		    String hql = "SELECT COUNT(*) FROM Product WHERE productname = :productname";
		    Query<Long> query = session.createQuery(hql, Long.class);
		    query.setParameter("productname", productname);
		    long count = query.uniqueResult();
		    return count > 0;
		}

}