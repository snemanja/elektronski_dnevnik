package com.iktpreobuka.elektronski_dnevnik.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.iktpreobuka.elektronski_dnevnik.entities.ERole;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class UserDTO {

	@NotBlank(message = "Morate uneti ime.")
	@Size(min = 2, max = 20, message = "Ime mora imati od {min} do {max} slova.")
	private String name;
	
	@NotBlank(message = "Morate uneti prezime.")
	@Size(min = 2, max = 20, message = "Prezime mora imati od {min} do {max} slova.")
	private String lastName;
	
	@NotBlank(message = "Morate uneti korisničko ime.")
	@Size(min = 2, max = 20, message = "Korisničko ime mora imati od {min} do {max} slova.")
	private String username;
	
	@NotBlank(message = "Morate uneti password.")
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,30}$",
	message = "Password se mora sastojati od minimum 8 karaktera, od toga barem jedno veliko slovo, jedno "
			+ "malo slovo i jedan broj.")
	private String password;
	
	@NotBlank(message = "Morate ponovo uneti password.")
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,30}$",
	message = "Ponovljeni password mora biti isti kao password.")
	private String confirmPassword;
	
	private ERole role;
}
