package com.te.resume_builder.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;



@Data
@Entity(name = "login")
public class Login  implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@NotBlank(message = "Email cannot be blank")
	@NotNull(message = "Email cannot be null")
	private String email;
	
	
	@Column
	private String password;

}
