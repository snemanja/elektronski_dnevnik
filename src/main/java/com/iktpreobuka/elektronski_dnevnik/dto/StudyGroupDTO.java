package com.iktpreobuka.elektronski_dnevnik.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.iktpreobuka.elektronski_dnevnik.entities.EPolugodiste;
import com.iktpreobuka.elektronski_dnevnik.entities.EYear;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class StudyGroupDTO {

	@NotBlank(message = "Morate uneti broj odeljenja.")
	@Min(value = 1, message = "Broj odeljenja ne može biti manji od {value}.")
	@Max(value = 8, message = "Broj odeljenje ne može biti veći od {value}.")
	private String studyGroupNumber;

	private EYear year;

	private EPolugodiste polugodiste;
}
