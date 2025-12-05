package com.example.product_service.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product_service.entity.Product;
import com.example.product_service.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRespository;
	
	// create Product
	
	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return productRespository.save(product);
		
	}
	
	//get product
	
	@GetMapping
	public List<Product> getAllProducts(){
		return productRespository.findAll();
	}
	
	//get product by ID
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable Long productId){
		Product product=productRespository.findById(productId)
				.orElseThrow(()->new RuntimeException("product notfound"+productId));
		return ResponseEntity.ok(product);
	}
	
	
	
}
