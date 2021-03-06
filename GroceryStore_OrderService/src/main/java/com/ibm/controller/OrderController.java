package com.ibm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.dao.OrderRepository;
import com.ibm.exception.AuthorizationDeniedException;
import com.ibm.model.Order;
import com.ibm.util.JwtUtil;

@RestController
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;
	/*
	 * @Autowired private JwtUtil jwtUtil;
	 */

	@PostMapping("/api/orders")
	public Order createOrder(@RequestBody Order order) throws Exception {
		/*
		 * String token = order.getUserToken().substring(7); String
		 * userName=order.getUserName(); String tokenUserName =
		 * jwtUtil.extractUsername(token); if (!jwtUtil.isTokenExpired(token) &&
		 * tokenUserName.equalsIgnoreCase(userName)) { return
		 * orderRepository.save(order);
		 * 
		 * } else { throw new AuthorizationDeniedException(); }
		 */
		return orderRepository.save(order);
	}

	@GetMapping("/api/orders/{id}")
	public Optional<Order> findOrderById(@PathVariable Long id) {
		return orderRepository.findById(id);
	}

}
