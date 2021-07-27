package com.iktpreobuka.elektronski_dnevnik.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Accessors(fluent = true, chain = true)
@Table(name = "class")
@JsonIgnoreProperties({"hybernateLazyInitializer","handler"})
public class StudyGroupEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	
	@Column(name = "class_number", nullable = false)
	@NotBlank(message = "Morate uneti broj odeljenja.")
	@Min(value = 1, message = "Broj odeljenja ne može biti manji od {value}.")
	@Max(value = 8, message = "Broj odeljenje ne može biti veći od {value}.")
	private String studyGroupNumber;
	
	@Column
	@Enumerated(EnumType.STRING)
	@NotBlank(message = "Morate uneti razred odeljenja.")
	private EYear year;
	
	@Column
	@Enumerated(EnumType.STRING)
	@NotBlank(message = "Morate uneti polugodište razreda.")
	private EPolugodiste polugodiste;
	
	@Version
	private Integer version;
	
	@OneToMany(mappedBy = "teacher", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<TeacherSubjectEntity> teacher;

}
