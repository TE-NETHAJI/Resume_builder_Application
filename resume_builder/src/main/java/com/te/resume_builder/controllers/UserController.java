package com.te.resume_builder.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.te.resume_builder.dto.ExtraInterest;
import com.te.resume_builder.dto.ExtraSkills;
import com.te.resume_builder.dto.GraduateEducationDetails;
import com.te.resume_builder.dto.Login;
import com.te.resume_builder.dto.PersonalDetails;
import com.te.resume_builder.dto.ProjectDetails;
import com.te.resume_builder.dto.Schooling;
import com.te.resume_builder.dto.SignUp;
import com.te.resume_builder.dto.UserResponce;
import com.te.resume_builder.service.UserServiceLayer;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserServiceLayer userService;

	@GetMapping(path = "/hello")
	public String welcome() {
		return "welcome to resume builder";

	}

	@GetMapping(path = "/user")
	public ResponseEntity<UserResponce> getUserData(@RequestParam Integer id) {
		PersonalDetails details = userService.findById(id);
		UserResponce response = new UserResponce(false, details);
		return new ResponseEntity<UserResponce>(response, HttpStatus.OK);
	}

	@PostMapping(path = "/personelreg")
	public ResponseEntity<UserResponce> registerNewUser(@RequestBody PersonalDetails reg) {
		PersonalDetails register = userService.register(reg);
		UserResponce response = new UserResponce(false, register);
		return new ResponseEntity<UserResponce>(response, HttpStatus.OK);

	}

	@PostMapping(path = "/gradreg")
	public ResponseEntity<UserResponce> registerNewUser(@RequestBody List<GraduateEducationDetails> grad) {
		List<GraduateEducationDetails> register = userService.registerGrad(grad);
		UserResponce response = new UserResponce(false, register);
		return new ResponseEntity<UserResponce>(response, HttpStatus.OK);

	}

	@PostMapping(path = "/schoolreg")
	public ResponseEntity<UserResponce> register(@RequestBody List<Schooling> sch) {
		List<Schooling> register = userService.registerSchooling(sch);
		UserResponce response = new UserResponce(false, register);
		return new ResponseEntity<UserResponce>(response, HttpStatus.OK);

	}

	@PostMapping(path = "/projectreg")
	public ResponseEntity<UserResponce> registerProject(@RequestBody List<ProjectDetails> project) {
		List<ProjectDetails> register = userService.registerProject(project);
		UserResponce response = new UserResponce(false, register);
		return new ResponseEntity<UserResponce>(response, HttpStatus.OK);

	}

	@PostMapping(path = "/interestreg")
	public ResponseEntity<UserResponce> interestRegister(@RequestBody List<ExtraInterest> interest) {
		List<ExtraInterest> register = userService.registerInterest(interest);
		UserResponce response = new UserResponce(false, register);
		return new ResponseEntity<UserResponce>(response, HttpStatus.OK);

	}

	@PostMapping(path = "/skillreg")
	public ResponseEntity<UserResponce> skillReg(@RequestBody List<ExtraSkills> skill) {
		List<ExtraSkills> register = userService.registerSkill(skill);
		UserResponce response = new UserResponce(false, register);
		return new ResponseEntity<UserResponce>(response, HttpStatus.OK);

	}

	@PostMapping(path = "/signup")
	public ResponseEntity<UserResponce> signup(@RequestBody SignUp signup) {
		SignUp register = userService.registerSignup(signup);
		UserResponce response = new UserResponce(false, register);
		return new ResponseEntity<UserResponce>(response, HttpStatus.OK);

	}

	@PostMapping(path = "/login")
	public ResponseEntity<UserResponce> login(@Valid @RequestBody Login login) {
		UserResponce response = new UserResponce(false, userService.crendentials(login));
		return new ResponseEntity<UserResponce>(response, HttpStatus.OK);

	}

}
