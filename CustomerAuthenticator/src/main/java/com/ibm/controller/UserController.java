package com.ibm.controller;

import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.dao.ResponseStatus;
import com.ibm.exception.UserNotFoundException;
import com.ibm.model.AuthRequest;
import com.ibm.util.JwtUtil;

@RestController
public class UserController {
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	private static final String STATUS_SUCCESS="Success";

	@PostMapping("/authenticate")
	public ResponseStatus generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (Exception ex) {
			throw new UserNotFoundException();
		}
		String token=jwtUtil.generateToken(authRequest.getUserName());
		String txnToken="Grocery"+UUID.randomUUID().toString();
		String srvcToken="Authentication"+new Date();
		ResponseStatus reponse=new ResponseStatus(STATUS_SUCCESS,token,txnToken,srvcToken);
     
		return reponse;
	}

}
