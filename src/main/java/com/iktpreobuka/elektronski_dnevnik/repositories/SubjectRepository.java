package com.iktpreobuka.elektronski_dnevnik.repositories;

import org.springframework.data.repository.CrudRepository;
import java.util.*;
import com.iktpreobuka.elektronski_dnevnik.entities.SubjectEntity;
import com.iktpreobuka.elektronski_dnevnik.entities.TeacherEntity;

public interface SubjectRepository extends CrudRepository<SubjectEntity, Integer>{
	
	Boolean existsByName(String name);
	
	
	List<SubjectEntity> findByTeacher(TeacherEntity teacher);
	

}
