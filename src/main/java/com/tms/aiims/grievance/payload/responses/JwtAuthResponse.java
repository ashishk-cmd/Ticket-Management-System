package com.tms.aiims.grievance.payload.responses;

import java.util.Set;

import com.tms.aiims.grievance.models.Role;

import lombok.Data;

@Data
public class JwtAuthResponse {
	private String empId;
	private String username;
	private String token;
	private Set<Role> role;
}
