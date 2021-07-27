package com.iktpreobuka.elektronski_dnevnik.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class SubjectDTO {

	@NotNull(message = "Morate uneti naziv predmeta.")
	@Size(min = 5, max = 20, message = "Naziv predmeta mora biti najmanje {min} i najviše {max} slova dugačak.")
	@Pattern(regexp = "^[a-zA-Z0-9\\s,]*$", message = "Uneli ste neispravan naziv predmeta.")
	private String name;
	
	@Min(value = 0, message = "Nedeljni fond časova mora biti veći od {value}.")
	@Max(value = 40, message = "Nedeljni fond časova mora biti manji ili jednak {value}")
	private Integer weekylFund;
	
}
