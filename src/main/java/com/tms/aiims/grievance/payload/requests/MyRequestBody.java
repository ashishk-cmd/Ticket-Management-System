package com.tms.aiims.grievance.payload.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyRequestBody {

	private String client_id;
    private String client_secret;
    private String client_serID;

}
