package com.tms.aiims.grievance.payload.requests;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChangePassKey {

	@NotEmpty(message="Please provide a Old password.")
	private String oldPassword;

	@NotEmpty(message="Please provide a New Password.")
	private String newPassword;
}
