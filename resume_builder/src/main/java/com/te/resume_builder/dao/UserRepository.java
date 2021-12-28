package com.te.resume_builder.dao;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.resume_builder.dto.PersonalDetails;
//import com.te.resume_builder.dto.ProjectDetails;

@Repository
public interface UserRepository extends JpaRepository<PersonalDetails, Integer> {
	
	
	/*
	 * public List<GraduateEducationDetails> saveAll(List<GraduateEducationDetails>
	 * grad);
	 * 
	 * public List<ProjectDetails> saveAll(List<ProjectDetails> project);
	 */
	
	//public Login save(Login login);

}
