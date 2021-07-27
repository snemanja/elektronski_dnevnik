package com.iktpreobuka.elektronski_dnevnik.services;

import java.util.Optional;

import com.iktpreobuka.elektronski_dnevnik.entities.ERole;

public interface UserService {
	
	public boolean isAuthorizedAs(ERole role);
	public Optional<String> getLoggedInUsername();

}
