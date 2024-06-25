package com.tms.aiims.grievance.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tms.aiims.grievance.models.Department;
import com.tms.aiims.grievance.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

	Optional<User> findByEmployeeId(String employeeid);

	Optional<User> findByContactNo(String contactNo);

	Optional<User> findByEmployeeIdAndContactNo(String employeeId, String contactNo);
	
	Optional<User> findByDepartment(Department department);
	
	@Query("SELECT u FROM User u JOIN u.roles r WHERE r.name = :role")
	Optional<User> findUsersWithRoles(String role);

	@Query("SELECT u FROM User u JOIN u.roles r WHERE r.name <> :normalUser ")
	List<User> findUsersWithRolesOtherThanUser(String normalUser);

}
