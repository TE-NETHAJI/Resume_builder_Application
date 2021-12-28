package com.te.resume_builder.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;


@Data
@Entity
@Table(name = "personal_details")
@JsonInclude(value = Include.NON_NULL)
public class PersonalDetails  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "first_Name")
	private String firstName;

	@Column(name = "last_Name")
	private String lastName;

	
	@Email
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Please Enter valid E-mail")
	@NotBlank(message = "mail cannot be null")
	@NotEmpty(message = "mail cannot be empty")
	@Column
	private String email;

	@Column(name = "mobile_No")
	@Min(value = 10)
	private Long mobile;

	@Column
	private String website;

	@Column(name = "git_Hub")
	private String gitHub;

	@Column
	private String linkedin;

	@Column
	private String twitter;

	@Column
	private String facebook;

	@Column
	private String instagram;

	@Column
	@Size(min = 5,message = "Password must be five characters")
	private String password;

	@Column
	@Id
	private Integer user;
	

	/**
	 * Relationship Mapping from one to many and many to one from respected entity
	 */
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "details1", fetch = FetchType.LAZY)
	private List<ExperienceDetails> expInfo;

	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "details2", fetch = FetchType.LAZY)
	private List<ExtraInterest> extraInterest;

	

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "details3", fetch = FetchType.LAZY)
	private List<ExtraSkills> extraSkills;

	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "details4", fetch = FetchType.LAZY)
	private List<GraduateEducationDetails> gradDetails;

	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "details5", fetch = FetchType.LAZY)
	private List<ProjectDetails> projectDetails;

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "details6", fetch = FetchType.LAZY)
	private List<Schooling> schooling;

}
