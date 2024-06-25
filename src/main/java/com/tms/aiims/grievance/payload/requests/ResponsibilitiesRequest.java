package com.tms.aiims.grievance.payload.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponsibilitiesRequest {

	private String userId;
	private Long departmentId;
	private Long categoryId;
	

}
