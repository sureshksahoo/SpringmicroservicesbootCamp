package com.ibm;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ibm.model.Product;
import com.ibm.service.ProductService;

@SpringBootApplication
public class GroceryStoreProductApplication {
	   @Autowired
	   private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(GroceryStoreProductApplication.class, args);
	}

	 @PostConstruct
	    public void initUsers() {
	        List<Product> products = Stream.of(
	                new Product( "rice", 50.00, "rice,jpg","A1-512",2),
	                new Product( "dal", 130.00, "dal.jpg","A1-5123",5),
	                new Product( "oil", 200.00, "refineoil.jpg","B1-512",8),
	                new Product("toothpaste", 100.00, "closeup","C1-512",9),
	                new Product("Biscuit", 50.00, "Britania","D1-123",10)
	        ).collect(Collectors.toList());
	        productService.save(products);
	

   }
	  @Bean
	    public WebMvcConfigurer corsConfigurer() {
	    	return new WebMvcConfigurer() {
	    		@Override
	    		public void addCorsMappings(CorsRegistry registry) {
	    			registry.addMapping("/**").allowedHeaders("*").allowedOrigins("*").allowedMethods("*");
	    		
	    			
	    		}
	    	};
	    }
}
