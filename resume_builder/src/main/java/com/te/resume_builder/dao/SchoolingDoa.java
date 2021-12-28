package com.te.resume_builder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.resume_builder.dto.Schooling;

@Repository
public interface SchoolingDoa extends JpaRepository<Schooling, String> {

}
