package com.iktpreobuka.elektronski_dnevnik.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.elektronski_dnevnik.entities.ParentEntity;

public interface ParentRepository extends CrudRepository<ParentEntity, Integer>{

	//List<ParentEntity> findByEmail(String email);
}
