package com.ibm.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ibm.dao.ProductRepository;
import com.ibm.exception.ResourceNotFoundException;
import com.ibm.model.Product;

@Service
@Transactional
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public Iterable<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProduct(long id) throws ResourceNotFoundException {
		return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
	}

	public List<Product> save(List<Product> product) {
		return productRepository.saveAll(product);
	}

	public Product findProductById(Long id) {
		Product product = productRepository.findProductById(id);
		return product;

	}

	public boolean deleteProductsById(Long id) {
		Product result = findProductById(id);
		productRepository.delete(result);
		return true;
	}
}
