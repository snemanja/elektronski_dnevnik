package com.iktpreobuka.elektronski_dnevnik.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.elektronski_dnevnik.entities.EYear;
import com.iktpreobuka.elektronski_dnevnik.entities.StudentEntity;
import com.iktpreobuka.elektronski_dnevnik.entities.StudyGroupEntity;
import com.iktpreobuka.elektronski_dnevnik.entities.TeacherSubjectEntity;
import com.iktpreobuka.elektronski_dnevnik.entities.TeacherSubjectGroupStudentEntity;

public interface TeacherSubjectGroupStudentRepository extends CrudRepository<TeacherSubjectGroupStudentEntity,
	Integer>{
	
//	TeacherSubjectGroupStudentEntity findByTeacherSubjectAndStudent(TeacherSubjectEntity teacherSubject,
//			StudentEntity student);
//	List<TeacherSubjectGroupStudentEntity> findByStudent(StudentEntity student);
//	List<TeacherSubjectGroupStudentEntity> findByGroup(EYear year, StudyGroupEntity name);

}
