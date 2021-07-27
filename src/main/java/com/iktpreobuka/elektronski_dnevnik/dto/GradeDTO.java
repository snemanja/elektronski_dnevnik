package com.iktpreobuka.elektronski_dnevnik.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.iktpreobuka.elektronski_dnevnik.entities.EPolugodiste;
import com.iktpreobuka.elektronski_dnevnik.entities.EYear;

import lombok.Data;

@Data
public class GradeDTO {
	
	@NotNull(message = "Morate uneti broj odeljenja.")
	@Min(value = 1, message = "Ocena ne može biti manja od {value}.")
	@Max(value = 5, message = "Ocena ne može biti veća od {value}.")
	private Integer grade;
	
	private EYear year;
	
	private EPolugodiste polugodiste;

}
