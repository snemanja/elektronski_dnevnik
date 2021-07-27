package com.iktpreobuka.elektronski_dnevnik.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.iktpreobuka.elektronski_dnevnik.dto.StudentDTO;

@Component
public class StudentValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return StudentDTO.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		StudentDTO student = (StudentDTO) target;
		
		if(!student.getPassword().equals(student.getConfirmPassword())) {
			errors.reject("400", "Passwordi moraju biti isti.");
		}
	}
	

}
