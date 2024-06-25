package com.tms.aiims.grievance.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.tms.aiims.grievance.payloads.CategoryDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	private String name;
	private String status;
	
	public static Category getInstance(CategoryDto category) {
		Category data = new Category();
		data.setName(category.getName());
		return data;
	}


}
