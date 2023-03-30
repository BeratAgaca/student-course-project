package com.project.student_course_project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.project.student_course_project.dtos.StudentDto;
import com.project.student_course_project.entity.Student;


public interface IStudentRepository extends JpaRepository<Student, Long>{
	
	@Query("SELECT s FROM Student s where s.grade>=60 and s.id in :ids")
	List<Student> getPassedStudentsByDto(@Param("ids") List<Long> ids);

	@Query("SELECT s FROM Student s where s.gender=0 and s.id in :ids")
	List<Student> getMalePersons(@Param("ids") List<Long> ids);
	
	@Query("SELECT s FROM Student s where s.gender=1 and s.id in :ids")
	List<Student> getFemalePersons(@Param("ids") List<Long> ids);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Student s where s.id=:id")
	void deleteStudent(@Param("id") long id);
	
	@Query("SELECT s FROM Student s where s.id = :id")
	List<Student> getDeneme(@Param("id") long id);
}
