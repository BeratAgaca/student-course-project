package com.project.student_course_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.project.student_course_project.entity.Course;

public interface ICourseRepository extends JpaRepository<Course, Long>{
	  
	@Transactional
	@Modifying
	@Query(value = "delete from students_courses s_c where s_c.course_id=:id" , nativeQuery=true)
	void deleteCourse(@Param("id") long id);
}
