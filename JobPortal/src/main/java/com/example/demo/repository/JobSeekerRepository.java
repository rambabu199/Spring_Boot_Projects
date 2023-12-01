package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.entity.JobSeeker;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long>{
	
	@Query(
	        nativeQuery = true,
	        value = "SELECT * FROM job_seeker_boot js " +
	                "JOIN Job_Class_boot jc ON js.jsid = jc.jsid " +
	                "JOIN recruter_boots r ON r.rid = jc.rid " +
	                "WHERE r.rid = :rid AND jc.job_id = :job_id AND js.jsid = :jsid"
	    )
	    List<JobSeeker> findApplicants(
	        @Param("rid") long rid,
	        @Param("job_id") long job_id,
	        @Param("jsid") long jsid
	    );

}
