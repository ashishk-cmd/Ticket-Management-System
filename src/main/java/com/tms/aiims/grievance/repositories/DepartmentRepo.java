package com.tms.aiims.grievance.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.aiims.grievance.models.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
    
	public Optional<Department> findByName(String name);

	public List<Department> findAllByStatus(String status);
}
