package com.tms.aiims.grievance.payload.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RemarksResponse {

	private UserResponse toUser;
	private UserResponse fromUser;
	private String remarks;
}
