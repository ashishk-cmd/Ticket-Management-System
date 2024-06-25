package com.tms.aiims.grievance.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.tms.aiims.grievance.payloads.DepartmentDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	private String name;
	private String status;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST})
	@JoinTable(name="department_categories",
	joinColumns = @JoinColumn(name="department_id",referencedColumnName = "id",unique=false),
	inverseJoinColumns = @JoinColumn(name="categories_id",referencedColumnName = "id",unique=false)
		 )
	private List<Category> categories = new ArrayList<>();

	public static Department getInstance(DepartmentDto department) {
		Department data = new Department();
		data.setName(department.getName());
		data.setCategories(new ArrayList<>());
		return data;
	}
	
}
