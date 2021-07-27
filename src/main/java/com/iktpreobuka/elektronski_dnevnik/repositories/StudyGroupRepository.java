package com.iktpreobuka.elektronski_dnevnik.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.elektronski_dnevnik.entities.StudyGroupEntity;

public interface StudyGroupRepository extends CrudRepository<StudyGroupEntity, Integer>{
	
	Boolean existsByStudentGroupNumber(String studyGroupNumber);
}
