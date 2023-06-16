package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.ProductException;
import com.example.demo.model.Product;

public interface ProductService {
	
	public Product createProduct(Product product) throws ProductException;
	
	public Product findById(Integer id) throws  ProductException ;
	
    public Product IncreaseProductQuantity(Integer productId,Integer quantity) throws ProductException;
    
   public Product DecreseProductQuantity(Integer productId,Integer quantity) throws ProductException;
	
	public List<Product> getAllProduct();
	

}
