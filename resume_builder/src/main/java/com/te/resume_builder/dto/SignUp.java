package com.te.resume_builder.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

import lombok.Data;


@Data
@Entity(name = "signup")
public class SignUp  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name ="first_Name")
	private String firstName;

	@Column(name ="last_Name")
	private String lastName;

	@Id
	@Email
	private String email;

	@Column
	@Min(value = 6)
	private String password;

}
