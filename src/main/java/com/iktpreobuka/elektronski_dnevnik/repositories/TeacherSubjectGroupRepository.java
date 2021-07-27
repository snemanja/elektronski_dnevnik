package com.iktpreobuka.elektronski_dnevnik.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.elektronski_dnevnik.entities.StudyGroupEntity;
import com.iktpreobuka.elektronski_dnevnik.entities.TeacherSubjectEntity;
import com.iktpreobuka.elektronski_dnevnik.entities.TeacherSubjectGroupEntity;

public interface TeacherSubjectGroupRepository extends CrudRepository<TeacherSubjectGroupEntity, Integer>{

	//TeacherSubjectGroupEntity findByTeacherSubjectAndGroup(TeacherSubjectEntity teacherSubject,
	//		StudyGroupEntity studyGroup);
	
}
