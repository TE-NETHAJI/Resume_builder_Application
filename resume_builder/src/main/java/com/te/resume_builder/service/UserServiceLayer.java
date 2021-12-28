package com.te.resume_builder.service;

import java.util.List;

import com.te.resume_builder.dto.ExtraInterest;
import com.te.resume_builder.dto.ExtraSkills;
import com.te.resume_builder.dto.GraduateEducationDetails;
import com.te.resume_builder.dto.Login;
import com.te.resume_builder.dto.PersonalDetails;
import com.te.resume_builder.dto.ProjectDetails;
import com.te.resume_builder.dto.Schooling;
import com.te.resume_builder.dto.SignUp;

public interface UserServiceLayer {

	public PersonalDetails findById(Integer  id);

	public PersonalDetails register(PersonalDetails reg);
	
	public List<GraduateEducationDetails> registerGrad(List<GraduateEducationDetails> grad);
	
	public List<Schooling> registerSchooling(List<Schooling>  school);
	
	public List<ProjectDetails> registerProject(List<ProjectDetails>  project);
	
	public List<ExtraInterest> registerInterest(List<ExtraInterest> interest);
	
	public List<ExtraSkills> registerSkill(List<ExtraSkills> skill);
	
	public SignUp registerSignup(SignUp signup);
	
	public Object crendentials(Login login);

}
