package com.tms.aiims.grievance.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Remarks {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	@ManyToOne
	private User toUser;
	@ManyToOne
	private User fromUser;
	@ManyToOne
	private Grievence grievence;
	private String remarks;
	
}
