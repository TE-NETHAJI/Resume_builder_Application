package com.te.resume_builder.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity(name = "extra_details_interests")
public class ExtraInterest  implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "interest_One")
	private String interestOne;
	
	@Column(name ="interest_Two")
	private String interestTwo;
	
	@Column(name ="interest_Three")
	private String interestThree;
	
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
	private PersonalDetails details2;

}
