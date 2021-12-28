package com.te.resume_builder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.resume_builder.dto.ProjectDetails;

@Repository
public interface ProjectDetailsDoa extends JpaRepository<ProjectDetails, String> {
	
	

}
