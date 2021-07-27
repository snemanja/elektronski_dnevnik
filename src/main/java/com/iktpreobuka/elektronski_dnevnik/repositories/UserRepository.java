package com.iktpreobuka.elektronski_dnevnik.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.elektronski_dnevnik.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer>{

	Optional<UserEntity> findByUsername(String username);
	

}
