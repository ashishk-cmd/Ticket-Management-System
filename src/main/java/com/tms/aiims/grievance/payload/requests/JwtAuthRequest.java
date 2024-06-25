package com.tms.aiims.grievance.payload.requests;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class JwtAuthRequest {

	@NotEmpty(message="Please provide a User Name.")
	private String username;
	@NotEmpty(message="Please provide a Password.")
	private String password;
	
}
