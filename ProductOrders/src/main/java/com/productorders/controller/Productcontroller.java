package com.productorders.controller;

import org.springframework.stereotype.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.productorders.model.Order;
import com.productorders.model.Product;
import com.productorders.service.ProductService;

import jakarta.persistence.criteria.CriteriaBuilder.In;

@Controller
public class Productcontroller {
	@Autowired
	private ProductService productservice;
	
	@RequestMapping("/form")
	public String form(Model model) {
		Product product = new Product();
	    model.addAttribute("product", product);
	    return "Productform";
	}

	@PostMapping("/save")
	public String saveproduct(@ModelAttribute Product product) {
		List<Order> orders = product.getOrders();
		for (Order order : orders) {
	        order.setProduct(product);
	    }
		product.setOrders(orders);
		productservice.saveproducts(product);
		return "redirect:/";
	}
	@RequestMapping("/")
	public String getAllproducts(Model model) {
		model.addAttribute("products", productservice.getallproducts());
		return "display";
	}
    
	@RequestMapping("/delete")
    public String deleteProduct(@RequestParam Integer id) {
		Product product = productservice.getbyid(id);
		productservice.delete(product);
        return "redirect:/";
    }
	@GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Product product = productservice.getbyid(id);
        model.addAttribute("product", product);
        return "Productform";
    }

    @PostMapping("/edit/update")
    public String update(@ModelAttribute Product updatedProduct) {
    	for (Order order : updatedProduct.getOrders()) {
            order.setProduct(updatedProduct);
        }
        productservice.updateProduct(updatedProduct);
        return "redirect:/";
    }
	
	 @GetMapping("/search") 
	 public String search(@RequestParam(required=false) Integer id,@RequestParam String productname,@RequestParam(required=false) Integer price, Model model) {
		 System.out.println("ID: " + id + ", Product Name: " + productname +",Price: " + price); 
		 List<Product> searchResults = productservice.search(id, productname, price); 
		 System.out.println("Search Results: " + searchResults);
		 model.addAttribute("searchresults", searchResults); 
		 return "display";
	 }
		
	 @GetMapping("/checkProductname")
	 @ResponseBody
	 public String checkProductnameAvailability(@RequestParam String productname) {
	     System.out.println("Received Product Name: " + productname);
		 boolean exist = productservice.isProductnameAvailable(productname);
	     return exist ? "true" : "false";
	 }
		 
	
}
