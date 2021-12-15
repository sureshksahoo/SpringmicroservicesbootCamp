package com.ibm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	

}
