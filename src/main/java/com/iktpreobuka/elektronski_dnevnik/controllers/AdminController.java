package com.iktpreobuka.elektronski_dnevnik.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.elektronski_dnevnik.dto.UserDTO;
import com.iktpreobuka.elektronski_dnevnik.entities.UserEntity;
import com.iktpreobuka.elektronski_dnevnik.repositories.AdminRepository;
import com.iktpreobuka.elektronski_dnevnik.repositories.UserRepository;
import com.iktpreobuka.elektronski_dnevnik.services.UserServiceImpl;
import com.iktpreobuka.elektronski_dnevnik.validators.UserValidator;

@RestController
@RequestMapping(path = "/api/v1/admin")
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private UserValidator userValidator;
	
	public ResponseEntity<?> createUser(@RequestBody UserDTO newUser){
		UserEntity user = new UserEntity();
		
		
		return null;
		
	}

}
