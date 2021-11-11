package com.example5.demo5.service;

import java.util.List;

import com.example5.demo5.Entity.Product;



public interface ProductService {
	//public Employee addProduct(Employee emp);

	public Product addProduct(Product prod);
	public List<Product> getProductDtls();
	public List<Product> findByNameAndCategory(String name, String category);
	 public Product update(Product product);
}
