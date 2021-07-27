package com.iktpreobuka.elektronski_dnevnik.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@NoArgsConstructor
@Accessors(fluent = true, chain = true)
@Getter
@Setter
@Table(name = "admin")
public class AdminEntity extends UserEntity {
	
}
