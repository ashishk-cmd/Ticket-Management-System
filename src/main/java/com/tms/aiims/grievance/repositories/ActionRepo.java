package com.tms.aiims.grievance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tms.aiims.grievance.models.Action;

public interface ActionRepo extends JpaRepository<Action, Long> {

	
}
