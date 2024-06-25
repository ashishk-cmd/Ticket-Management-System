package com.tms.aiims.grievance.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.aiims.grievance.models.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

	 public Optional<Role> findByName(String name);

	public Optional<Role> findById(Long roleId);
	
	
}
