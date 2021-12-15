package com.ibm.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
@Entity
public class Product {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @NotNull(message = "Product name is required.")
	    @Basic(optional = false)
	    private String name;
	    private Double price;
	    private String pictureUrl;
	    private String code;
	    private int quantity;
	    
		public Product() {}

		public Product(@NotNull(message = "Product name is required.") String name, Double price,
				String pictureUrl,String code,int quantity) {
	
			this.name = name;
			this.price = price;
			this.pictureUrl = pictureUrl;
			this.code = code;
			this.quantity = quantity;
		}
		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public String getPictureUrl() {
			return pictureUrl;
		}

		public void setPictureUrl(String pictureUrl) {
			this.pictureUrl = pictureUrl;
		}

	   
}
