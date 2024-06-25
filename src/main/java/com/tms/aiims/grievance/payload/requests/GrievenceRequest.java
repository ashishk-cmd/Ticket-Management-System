package com.tms.aiims.grievance.payload.requests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GrievenceRequest  
{
// Grievance Details
	private String refNo;
	@Min(value = 1, message = "Please select a Department.")
	private Long departmentId;
	@Min(value = 1, message = "Please provide a Category.")
	private Long categoryId;
	@NotEmpty(message="Please provide a Concern.")
	private String concern;
	private String grievanceStatus;
	private String image1;
	private String image2;
	
// User Details
	@NotEmpty(message="Please provide a Name.")
	private String fullName;
	@NotEmpty(message="Please provide a Employee Id.")
	private String employeeId;
	
	private String email;
	@NotEmpty(message="Please provide a Contact Number.")
	private String contactNo;
	@NotNull(message = "Please provide sent Otp.")
	private int otp;
	
}
