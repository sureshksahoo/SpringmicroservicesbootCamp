package com.ibm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.ibm.dao.UserRepository;
import com.ibm.model.User;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	UserRepository userRepo;
	public void saveUser(List<User> user) {
		userRepo.saveAll(user);
	}
	 
	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
	        User user = userRepo.findByUserName(username);
	        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
	    }

}
