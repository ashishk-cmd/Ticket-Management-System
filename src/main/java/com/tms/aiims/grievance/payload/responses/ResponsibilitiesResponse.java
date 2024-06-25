package com.tms.aiims.grievance.payload.responses;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.tms.aiims.grievance.models.Category;
import com.tms.aiims.grievance.models.Department;
import com.tms.aiims.grievance.models.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponsibilitiesResponse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	private UserResponse user;
	private Department department;
	private Category category;
	
}
