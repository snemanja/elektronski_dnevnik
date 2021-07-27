package com.iktpreobuka.elektronski_dnevnik.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.elektronski_dnevnik.entities.ParentEntity;
import com.iktpreobuka.elektronski_dnevnik.entities.StudentEntity;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer>{

	//StudentEntity findByUsername(String username);
	
	//List<StudentEntity> findByParent(ParentEntity parent);
	
}
