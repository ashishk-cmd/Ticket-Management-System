package com.tms.aiims.grievance.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GrievanceStatus {

	@NotEmpty(message="Please provide a Employee Id.")
	@Pattern(regexp = "^[a-zA-Z]{1}[0-9]{7}$",message = "Employee Id must be of 7 length with no special characters and first letter must be alphabet.")	
	private String employeeId;
	
	@NotEmpty(message="Please provide a Grievance Refrence Number.")
	private String grievanceRef;
	private String status;
	private int otp;
}
