package com.tms.aiims.grievance.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.aiims.grievance.models.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

	public Optional<Category> findByName(String name);

	public List<Category> findAllByStatus(String status);

}
