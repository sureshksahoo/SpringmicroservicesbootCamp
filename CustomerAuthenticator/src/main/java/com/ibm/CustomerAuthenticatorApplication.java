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

import com.ibm.model.User;
import com.ibm.service.UserService;

@SpringBootApplication
public class CustomerAuthenticatorApplication {
	    @Autowired
	    private UserService service;

	    @PostConstruct
	    public void initUsers() {
	        List<User> users = Stream.of(
	                new User(1, "suresh", "admin@1234", "admin"),
	                new User(2, "prakash", "password@1234", "user"),
	                new User(3, "aditya", "password@12345", "user"),
	                new User(4, "ramesh", "pwd3", "seller"),
	                new User(5, "manish", "pwd5678", "seller")
	        ).collect(Collectors.toList());
	        service.saveUser(users);
	    }
	    @Bean
	    public WebMvcConfigurer corsConfigurer() {
	    	return new WebMvcConfigurer() {
	    		@Override
	    		public void addCorsMappings(CorsRegistry registry) {
	    			registry.addMapping("/*").allowedHeaders("*").allowedOrigins("*").allowedMethods("*");
	    		
	    			
	    		}
	    	};
	    }

	public static void main(String[] args) {
		SpringApplication.run(CustomerAuthenticatorApplication.class, args);
	}

	
	

}
