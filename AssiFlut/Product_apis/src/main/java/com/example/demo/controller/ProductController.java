package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ProductException;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService ps;
	
	@PostMapping("/create")
	public ResponseEntity<Product> createproduct( @Valid @RequestBody Product product) throws ProductException
	{
//		System.out.println(product.getBrandName());
	Product pp = ps.createProduct(product);
		
		return new ResponseEntity<Product>(pp,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}/{quantity}")
	public ResponseEntity<Product> IncreaseProductQuantity(@PathVariable("id") Integer Id, @PathVariable("quantity") Integer qty) throws ProductException{
		Product pInc = ps.IncreaseProductQuantity(Id, qty);
		
		return new ResponseEntity<>(pInc, HttpStatus.ACCEPTED);
	}
	@PutMapping("/decrease/{id}/{decquantity}")
	public ResponseEntity<Product> decreaseProductQuantity(@PathVariable("id") Integer Id, @PathVariable("decquantity") Integer qty) throws ProductException{
		Product pDec= ps.DecreseProductQuantity(Id, qty);
		
		return new ResponseEntity<>(pDec, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProducts() throws ProductException{
		List<Product> listofproduct = ps.getAllProduct();
		return new ResponseEntity<List<Product>>(listofproduct, HttpStatus.OK);
	}
	

}
