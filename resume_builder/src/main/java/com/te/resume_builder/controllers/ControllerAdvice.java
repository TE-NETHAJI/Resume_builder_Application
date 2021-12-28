package com.te.resume_builder.controllers;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.resume_builder.dto.UserResponce;
import com.te.resume_builder.exception.UserException;

@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<UserResponce> noSuchElement(UserException exp) {
		UserResponce res = new UserResponce(true, exp.getMessage());
		return new ResponseEntity<UserResponce>(res, HttpStatus.OK);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<UserResponce> MANV(MethodArgumentNotValidException exp) {
		UserResponce res = new UserResponce(true, exp.getFieldError().getDefaultMessage());
		return new ResponseEntity<UserResponce>(res, HttpStatus.OK);
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public ResponseEntity<UserResponce> UserAlredyExist(DuplicateKeyException exp) {
		UserResponce res = new UserResponce(true, exp.getMessage());
		return new ResponseEntity<UserResponce>(res, HttpStatus.OK);
	}

	@ExceptionHandler(NoSuchBeanDefinitionException.class)
	public ResponseEntity<UserResponce> noSuchBean(NoSuchBeanDefinitionException exp) {
		UserResponce res = new UserResponce(true, exp.getMessage());
		return new ResponseEntity<UserResponce>(res, HttpStatus.OK);
	}
	
}
