package com.iktpreobuka.elektronski_dnevnik.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.iktpreobuka.elektronski_dnevnik.entities.ERole;
import com.iktpreobuka.elektronski_dnevnik.entities.UserEntity;
import com.iktpreobuka.elektronski_dnevnik.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public boolean isAuthorizedAs(ERole role) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(!(authentication instanceof AnonymousAuthenticationToken)) {
			
			UserEntity currentUser = userRepo.findByUsername(authentication.getName()).get();
			return currentUser.getRole() == role;
		}
		return false;
	}

	@Override
	public Optional<String> getLoggedInUsername() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUsername = null;
		
		if(!(authentication instanceof AnonymousAuthenticationToken)) {
			loggedInUsername = authentication.getName();
		}
		return Optional.ofNullable(loggedInUsername);
	}
	
	

}
