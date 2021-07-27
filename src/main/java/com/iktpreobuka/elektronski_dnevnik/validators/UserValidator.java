package com.iktpreobuka.elektronski_dnevnik.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.iktpreobuka.elektronski_dnevnik.dto.AdminDTO;
import com.iktpreobuka.elektronski_dnevnik.dto.ParentDTO;
import com.iktpreobuka.elektronski_dnevnik.dto.StudentDTO;
import com.iktpreobuka.elektronski_dnevnik.dto.TeacherDTO;
import com.iktpreobuka.elektronski_dnevnik.dto.UserDTO;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return UserDTO.class.equals(clazz)
				|| AdminDTO.class.equals(clazz)
				|| TeacherDTO.class.equals(clazz)
				|| ParentDTO.class.equals(clazz)
				|| StudentDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserDTO user = (UserDTO) target;
		
		if(user.getPassword() != null && !user.getPassword().equals(user.getConfirmPassword())) {
			errors.reject("400", "Passwordi moraju biti isti.");
		}
		
	}
	
	

}
