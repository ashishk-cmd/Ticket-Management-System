package com.tms.aiims.grievance.payload.responses;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.tms.aiims.grievance.models.Category;
import com.tms.aiims.grievance.models.Department;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GrievenceResponse  
{

	private String refNo;

	private Department department = new Department();
	
	private Category category = new Category();
	
	private String concern;
	
	private UserResponse userRaisedBy = new UserResponse();
	private String grievanceStatus;
//	@JsonIgnore
	private String lastUpdate;
//	@JsonIgnore
	private String raisedOn;

	private UserResponse currentUser = new UserResponse();
	private String image1;
	private String image2;
	
	private List<RemarksResponse> remarksResponse = new ArrayList<RemarksResponse>();

	public GrievenceResponse(String refNo, Department department, Category category, String concern,
			UserResponse userRaisedBy, String grievanceStatus, String lu, String rOn, UserResponse currentUser,
			String image1, String image2, List<RemarksResponse> remarksResponse) {
		super();
		this.refNo = refNo;
		this.department = department;
		this.category = category;
		this.concern = concern;
		this.userRaisedBy = userRaisedBy;
		this.grievanceStatus = grievanceStatus;
		this.lastUpdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lu);
		this.raisedOn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rOn);
		this.currentUser = currentUser;
		this.image1 = image1;
		this.image2 = image2;
		this.remarksResponse = remarksResponse;
	}

	
	
}
