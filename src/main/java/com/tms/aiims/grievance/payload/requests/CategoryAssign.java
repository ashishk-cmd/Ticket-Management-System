package com.tms.aiims.grievance.payload.requests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryAssign {


	@NotEmpty(message="Please provide a Employee Id.")
	@Pattern(regexp = "^[a-zA-Z]{1}[0-9]{7}$",message = "Employee Id must be of 8 length with no special characters and first letter must be alphabet.")
	private String employeeId;
	
	@Min(value = 1, message = "Please select a Department.")
	private Long departmentId;
}
