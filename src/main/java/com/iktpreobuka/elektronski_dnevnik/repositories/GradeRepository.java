package com.iktpreobuka.elektronski_dnevnik.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.elektronski_dnevnik.entities.GradeEntity;
import com.iktpreobuka.elektronski_dnevnik.entities.TeacherSubjectGroupStudentEntity;

public interface GradeRepository extends CrudRepository<GradeEntity, Integer>{

	//List<GradeEntity> findByTeacherSubjectGroupStudent(TeacherSubjectGroupStudentEntity tsgs);
	
}
