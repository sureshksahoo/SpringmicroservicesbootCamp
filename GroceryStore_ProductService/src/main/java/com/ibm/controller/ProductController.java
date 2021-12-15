package com.ibm.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.model.Product;
import com.ibm.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	ProductService productService;

	@GetMapping(value = { "", "/" })
	public @NotNull Iterable<Product> getProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> productByCode(@PathVariable Long id) {
		return ResponseEntity.ok(productService.findProductById(id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProductsByCode(@PathVariable Long id) {
		if (productService.deleteProductsById(id))
			return ResponseEntity.noContent().build();
		else
			return ResponseEntity.notFound().build();
	}
}
