package com.iktpreobuka.elektronski_dnevnik.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@NoArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	
	@Column(name = "Name", nullable = false)
	@NotBlank(message = "Morate uneti ime.")
	@Size(min = 3, max = 15, message = "Ime mora imati između {min} i {max} slova.")
	private String name;
	
	@Column(name = "LastName", nullable = false)
	@NotBlank(message = "Morate uneti prezime.")
	@Size(min = 3, max = 15, message = "Prezime mora imati između {min} i {max} slova.")
	private String lastName;
	
	@Column(name = "email", nullable = false)
	@NotBlank(message = "Morate uneti e-mail.")
	@Email(message = "E-mail mora biti validan.")
	private String email;
	
	@Column(name = "username", nullable = false)
	@NotBlank(message = "Morate uneti korisničko ime koje ćete koristiti.")
	@Size(min = 3, max = 15, message = "Korisničko ime mora imati između {min} i {max} slova.")
	private String username;
	
	@JsonIgnore
	@Column(name = "password", nullable = false)
	@NotBlank(message = "Morate uneti password.")
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,30}$",
	message = "Password se mora sastojati od minimum 8 karaktera, od toga barem jedno veliko slovo, jedno "
			+ "malo slovo i jedan broj.")
	private String password;
	
	@Column(name = "ERole")
	@Enumerated(EnumType.STRING)
	private ERole role;
	
	@Version
	private Integer version;
}
