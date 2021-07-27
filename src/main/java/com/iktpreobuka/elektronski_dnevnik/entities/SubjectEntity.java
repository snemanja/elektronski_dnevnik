package com.iktpreobuka.elektronski_dnevnik.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@NoArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
@Table(name = "subjects")
@JsonIgnoreProperties({"hybernateLazyInitializer","handler"})
public class SubjectEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	
	@Column(name = "subject_name", nullable = false)
	@NotBlank(message = "Morate uneti naziv predmeta")
	@Size(min = 3, max = 15, message = "Naziv predmeta mora biti između {min} i {max} karaktera dugačak.")
	private String name;
	
	@Column(name = "weekly_fund_of_classes", nullable = false)
	@NotBlank(message = "Morate uneti nedeljni fond časova za predmet.")
	@Min(value = 0, message = "Nedeljni fond časova mora biti veći od {value}.")
	@Max(value = 40, message = "Nedeljni fond časova mora biti manji ili jednak {value}")
	private Integer weeklyFund;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "teacher")
	private TeacherEntity teacher;
	
	
	
	
}
