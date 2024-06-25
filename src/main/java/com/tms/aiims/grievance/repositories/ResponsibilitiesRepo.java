package com.tms.aiims.grievance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tms.aiims.grievance.models.Category;
import com.tms.aiims.grievance.models.Department;
import com.tms.aiims.grievance.models.Responsibilities;
import com.tms.aiims.grievance.models.User;

public interface ResponsibilitiesRepo extends JpaRepository<Responsibilities, Long> {

//	Responsibilities findByDepartmentAndCategory(Department department, Category category);

	List<Responsibilities> findByUser(User user);

//	Responsibilities findByDepartment(Department department);
	
	List<Responsibilities> findByDepartment(Department department);
	

//	Responsibilities findByDepartmentAndUser(Department department, User user);
	
	List<Responsibilities> findByDepartmentAndUser(Department department, User user);

	List<Responsibilities> findByDepartmentAndCategoryAndUser(Department department, Category category, User user);

	List<Responsibilities> findByDepartmentAndCategory(Department department, Category category);


}
