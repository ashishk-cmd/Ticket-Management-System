package com.tms.aiims.grievance.payload.requests;

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
public class RemarksRequest {

	@NotNull(message="Please provide Grievance Refrence Number.")
	private String grievanceRefNo;
	@NotEmpty(message="Please provide remarks.")
	private String remarks;
	
}
