package com.te.resume_builder.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.te.resume_builder.dao.GraduateEducationDoa;
import com.te.resume_builder.dao.InterestDoa;
import com.te.resume_builder.dao.LoginDoa;
import com.te.resume_builder.dao.ProjectDetailsDoa;
import com.te.resume_builder.dao.SchoolingDoa;
import com.te.resume_builder.dao.SignupDoa;
import com.te.resume_builder.dao.SkillsDoa;
import com.te.resume_builder.dao.UserRepository;
import com.te.resume_builder.dto.ExtraInterest;
import com.te.resume_builder.dto.ExtraSkills;
import com.te.resume_builder.dto.GraduateEducationDetails;
import com.te.resume_builder.dto.Login;
import com.te.resume_builder.dto.PersonalDetails;
import com.te.resume_builder.dto.ProjectDetails;
import com.te.resume_builder.dto.Schooling;
import com.te.resume_builder.dto.SignUp;
import com.te.resume_builder.exception.UserException;

@Service
public class UserServiceImplementation implements UserServiceLayer {

	@Autowired
	private UserRepository dao;

	@Autowired
	private GraduateEducationDoa grads;

	@Autowired
	private SchoolingDoa sch;

	@Autowired
	private ProjectDetailsDoa prj;

	@Autowired
	private InterestDoa intr;

	@Autowired
	private SkillsDoa skills;

	@Autowired
	private SignupDoa sgn;

	@Autowired
	private LoginDoa cred;

	@Override
	public PersonalDetails findById(Integer id) {

		if (id != null) {

			Optional<PersonalDetails> details = dao.findById(id);
			return details.get();

		}

		throw new UserException("Email not found");
	}

	@Override
	public PersonalDetails register(PersonalDetails reg) {

		if (reg != null) {
			return dao.save(reg);
		}
		throw new UserException("Personal Details Not Registered");
	}

	@Override
	@Transactional
	public List<GraduateEducationDetails> registerGrad(List<GraduateEducationDetails> grad) {
		if (grad != null) {
			return grads.saveAll(grad);
		}
		throw new UserException("Graduate Details Not Registered");
	}

	@Override
	public List<Schooling> registerSchooling(List<Schooling> school) {
		if (school != null) {
			return sch.saveAll(school);
		}
		throw new UserException("Schooling Details Not Registered");
	}

	@Override
	public List<ProjectDetails> registerProject(List<ProjectDetails> project) {
		if (project != null) {
			return prj.saveAll(project);
		}
		throw new UserException("Projects Details Not Registered");
	}

	@Override
	public List<ExtraInterest> registerInterest(List<ExtraInterest> interest) {
		if (interest != null) {
			return intr.saveAll(interest);
		}
		throw new UserException("Interest Details Not Registered");
	}

	@Override
	public List<ExtraSkills> registerSkill(List<ExtraSkills> skill) {
		if (skill != null) {
			return skills.saveAll(skill);
		}
		throw new UserException("Skills Details Not Registered");
	}

	@Override
	public SignUp registerSignup(SignUp signup) {
		if (sgn.existsById(signup.getEmail())) {
			 throw new DuplicateKeyException("User Already Exist Plsease login with your credentials");
		}
		throw new UserException("Datas Details Not Registered");
	}

	@Override
	public Object crendentials(Login login) {
		if (cred.existsById(login.getEmail())) {
			if (cred.getById(login.getEmail()).getPassword().equals(login.getPassword())) {
				return "login Sucussfull";

			}
			throw new UserException("password mismatch");
		}
		throw new UserException("invalid Credentials");
	}

}
