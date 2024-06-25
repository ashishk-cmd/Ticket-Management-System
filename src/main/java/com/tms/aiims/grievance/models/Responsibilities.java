package com.tms.aiims.grievance.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@NoArgsConstructor
public class Responsibilities {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;

	private String status;
	
	@OneToOne
	private User user;

	@ManyToOne
	private Department department;
	
	@ManyToOne
	private Category category;

	
}
