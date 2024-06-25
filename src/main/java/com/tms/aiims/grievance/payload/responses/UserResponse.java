package com.tms.aiims.grievance.payload.responses;


import java.util.HashSet;
import java.util.Set;

import com.tms.aiims.grievance.models.Department;
import com.tms.aiims.grievance.payloads.RoleDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {

	private int id;
	private String fullName;
	private String employeeId;
	private String contactNo;
	private String email;
	private String status;
	private String password;
//	private String registeredOn;
//	private String otpSentOn;
	private Department department;
	
	
	private Set<RoleDto> roles = new HashSet<>();


//	public UserResponse(int id, String fullName, String employeeId, String contactNo, String email, String status,
//			String regOn, String otpSentOn, Department department, Set<RoleDto> roles) {
//		super();
//		this.id = id;
//		this.fullName = fullName;
//		this.employeeId = employeeId;
//		this.contactNo = contactNo;
//		this.email = email;
//		this.status = status;
//		this.registeredOn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(regOn);
//		this.otpSentOn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(otpSentOn);
//		this.department = department;
//		this.roles = roles;
//	}
	
	
	
	
	
}