package com.te.resume_builder.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.validation.constraints.Past;

import org.hibernate.annotations.GenericGenerator;

//import org.hibernate.annotations.Type;
//import org.springframework.web.bind.annotation.InitBinder;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString.Exclude;


@Data
@Entity(name = "educational_details")
public class Schooling  implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column
	private String schoolName;
	
	@Column
	private String qualification;
	
	@Column
	//@Past
	//@Type(type="date")
	private Date from;
	
	@Column
	//@Type(type="date")
	private Date to;
	
	@Column
	private String description;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@GenericGenerator(name = "native",strategy = "native")
	private Integer id;
	
	@Column
	private Integer user;
	
	@Exclude
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user",insertable = false,updatable = false)
	private PersonalDetails details6;

}
