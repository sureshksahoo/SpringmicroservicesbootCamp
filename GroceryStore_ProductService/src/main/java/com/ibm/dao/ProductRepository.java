package com.ibm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.model.Product;

public interface ProductRepository  extends JpaRepository<Product, Long>{

    Product findProductById(Long id);

	void delete(Product result);

}
