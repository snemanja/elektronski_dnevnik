package com.iktpreobuka.elektronski_dnevnik.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.iktpreobuka.elektronski_dnevnik.dto.TeacherDTO;

public class TeacherValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return TeacherDTO.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		TeacherDTO teacher = (TeacherDTO) target;
		
		if(!teacher.getPassword().equals(teacher.getConfirmPassword())) {
			errors.reject("400", "Passwordi moraju biti isti.");
		}
	}

}
