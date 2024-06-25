package com.tms.aiims.grievance.models;

import java.util.Date;

import javax.persistence.Column;
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
public class Grievence 
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	private String refNo;
	

	@ManyToOne
	private Department department;
	

	@ManyToOne
	private Category category;
	
	private String concern;
	

	@ManyToOne
	private User userRaisedBy;
	
	private String grievanceStatus;
	private Date lastUpdate;
	private Date raisedOn;
	

	@ManyToOne
	private User currentUser;
	
	@Column(nullable = true)
	private String image1;
	@Column(nullable = true)
	private String image2;
	
	private int otp;
	private Date otpsenton;
//	@OneToMany
//	private List<RemarksResponse> remarksResponse = new ArrayList<RemarksResponse>();
	
}
