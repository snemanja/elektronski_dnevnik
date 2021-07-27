package com.iktpreobuka.elektronski_dnevnik.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name = "teaches_to_group")
@JsonIgnoreProperties({"hybernateLazyInitializer","handler"})
public class TeacherSubjectGroupEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "teacher_subject")
	private TeacherSubjectEntity teacherSubject;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "study_group")
	private StudyGroupEntity studyGroup;
	@OneToMany(mappedBy = "teacherSubjectGroup", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<StudentEntity> students;

}
