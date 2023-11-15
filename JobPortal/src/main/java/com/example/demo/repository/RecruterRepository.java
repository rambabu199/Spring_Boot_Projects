package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Recruter;

public interface RecruterRepository extends JpaRepository<Recruter, Long>{
	
	public Recruter findByName(String name);

}
