package com.iktpreobuka.elektronski_dnevnik.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@NoArgsConstructor
@Accessors(fluent = true, chain = true)
@Getter
@Setter
@Table(name = "grades")
@JsonIgnoreProperties({"hybernateLazyInitializer","handler"})
public class GradeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	@Column(name = "grade", insertable = false, updatable = false)
	@Min(value = 1, message = "Ocena ne može biti manja od {value}.")
	@Max(value = 5, message = "Ocena ne može biti veća od {value}.")
	private Integer grade;
	@Column(name = "date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate date;
	@Enumerated(EnumType.STRING)
	@Column(name = "Class")
	@NotNull(message = "Morate uneti razred.")
	private EYear year;
	@Enumerated(EnumType.STRING)
	@Column(name = "Polugodiste")
	@NotNull(message = "Morate uneti polugodište.")
	private EPolugodiste polugodiste;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "grade")
	private TeacherSubjectGroupStudentEntity teacherStudent; 

}
