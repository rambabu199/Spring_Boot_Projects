package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.JobClass;

public interface JobClassRepository extends JpaRepository<JobClass, Long> {
	//public JobClass findByJob_title(String title);
	@Query(value = "select * from Job_Class_boot jcb where jcb.location=:location",nativeQuery = true)
	public List<JobClass>findbyLocation(@Param("location") String location);
	
	
	@Query(value = "select * from Job_Class_boot jcb where jcb.job_title=:job_title",nativeQuery = true)
	public List<JobClass>findbyTitle(@Param("job_title") String job_title);
	
	@Query(value = "SELECT *\r\n"
			+ "FROM jobclass j\r\n"
			+ "JOIN applyjob a ON a.job_id = j.job_id\r\n"
			+ "JOIN jobseeker js ON js.jsid = a.jsid;\r\n"
			+ "where j.job_id=:job_id AND js.jsid=:jsid",nativeQuery = true)
	public List<JobClass>appliedjobs(@Param("job_id")long job_id,@Param("jsid")long jsid);

}
