package com.tms.aiims.grievance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.aiims.grievance.models.Grievence;
import com.tms.aiims.grievance.models.Remarks;

@Repository
public interface RemarksRepo extends JpaRepository<Remarks, Long> {

	List<Remarks> findByGrievence(Grievence grievence);


}
