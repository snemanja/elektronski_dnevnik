package com.iktpreobuka.elektronski_dnevnik.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.iktpreobuka.elektronski_dnevnik.dto.SubjectDTO;
import com.iktpreobuka.elektronski_dnevnik.repositories.SubjectRepository;

@Component
public class SubjectValidator implements Validator{
	
	@Autowired
	SubjectRepository subjectRepo;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return SubjectDTO.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		SubjectDTO subject = (SubjectDTO) target;
		if(subjectRepo.existsByName(subject.getName())){
			errors.reject("400", "Naziv predmeta već postoji.");
		}
	}

}
