package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.JobSeeker;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long>{

}
