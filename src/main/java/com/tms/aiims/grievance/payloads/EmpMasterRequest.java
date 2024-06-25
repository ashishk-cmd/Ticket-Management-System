package com.tms.aiims.grievance.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmpMasterRequest {

	@NotEmpty(message="Please provide a Employee Id.")
	@Pattern(regexp = "^[a-zA-Z]{1}[0-9]{7}$",message = "Employee Id must be of 8 length with no special characters and first letter must be alphabet.")
	private String employeeId;
	private String fullName;
	@NotEmpty(message="Please provide a Contact Number.")
	private String contactNo;
	private String email;
	private String status;
	private String password;
	private int otp;
	
}
