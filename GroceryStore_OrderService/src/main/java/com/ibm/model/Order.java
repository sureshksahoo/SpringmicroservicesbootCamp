package com.ibm.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")

public class Order {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String transactionToken;
    private String userToken;
    private String serviceToken;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items;
    public Order() {}
	public Order(Long id, List<OrderItem> items) {
		
		this.id = id;
		this.items = items;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTransactionToken() {
		return transactionToken;
	}
	public void setTransactionToken(String transactionToken) {
		this.transactionToken = transactionToken;
	}
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	public String getServiceToken() {
		return serviceToken;
	}
	public void setServiceToken(String serviceToken) {
		this.serviceToken = serviceToken;
	}
    

}