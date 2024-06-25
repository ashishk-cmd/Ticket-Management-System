package com.tms.aiims.grievance.payloads;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DepartmentDto {

	private Long id;
	private String name;
	private String status;

	private List<CategoryDto> categories = new ArrayList<>();
	
}
