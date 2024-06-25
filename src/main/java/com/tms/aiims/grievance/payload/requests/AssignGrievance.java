package com.tms.aiims.grievance.payload.requests;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssignGrievance {

	@NotNull(message="Please provide Grievance Refrence Number.")
	private String grievanceRefNo;
	@NotNull(message="Please provide Employee Id.")
	private String empId;
}
