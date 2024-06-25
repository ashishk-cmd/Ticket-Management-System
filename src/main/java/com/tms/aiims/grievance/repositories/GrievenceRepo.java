package com.tms.aiims.grievance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tms.aiims.grievance.models.Department;
import com.tms.aiims.grievance.models.Grievence;
import com.tms.aiims.grievance.models.User;

public interface GrievenceRepo extends JpaRepository<Grievence, Long>
{

	Grievence findByRefNo(String grievanceRef);

	List<Grievence>findByUserRaisedBy(User user);

	Grievence findByUserRaisedByAndRefNo(User user, String grievanceRef);

//	List<Grievence> findByCurrentUserAndDepartmentAndCategory(User user, Department department, Category category);

	List<Grievence> findByCurrentUserAndDepartment(User user, Department department);

	List<Grievence> findByDepartment(Department department);

}
