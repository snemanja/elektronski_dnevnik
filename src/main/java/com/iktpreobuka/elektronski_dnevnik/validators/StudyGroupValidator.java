package com.iktpreobuka.elektronski_dnevnik.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.iktpreobuka.elektronski_dnevnik.dto.StudyGroupDTO;
import com.iktpreobuka.elektronski_dnevnik.repositories.StudyGroupRepository;

@Component
public class StudyGroupValidator implements Validator{
	
	@Autowired
	StudyGroupRepository studyGroupRepo;
	
	@Override
	public boolean supports(Class<?> studyGroup) {
		return StudyGroupDTO.class.equals(studyGroup);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		StudyGroupDTO studyGroupDto = (StudyGroupDTO) target;
		if(studyGroupRepo.existsByStudentGroupNumber(studyGroupDto.getStudyGroupNumber())) {
			errors.reject("400", "Razred već postoji.");
		}
	}

}
