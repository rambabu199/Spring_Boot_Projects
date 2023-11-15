package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.JobClass;

public interface JobClassRepository extends JpaRepository<JobClass, Long> {
	//public JobClass findByJob_title(String title);

}
