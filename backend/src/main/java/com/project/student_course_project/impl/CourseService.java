package com.project.student_course_project.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.student_course_project.entity.Course;
import com.project.student_course_project.entity.Student;
import com.project.student_course_project.repositories.ICourseRepository;
import com.project.student_course_project.services.ICourseService; 

@Service
public class CourseService implements ICourseService{
	@Autowired
	private ICourseRepository courseRepository;
	 
	

	@Override
	public List<Course> getAll() { 
		return this.courseRepository.findAll();
	}

	@Override
	public Course getById(long id) { 
		return this.courseRepository.findById(id).get();
	}
	
	@Override
	public void addCourse(Course course) { 
		this.courseRepository.save(course);
	}
	
	
	@Override
	public List<Student> getCourseStudents(Course co) { 
		return co.getStudents();
	}

	@Override
	public void updateCourse(Course co) {
		Course c = this.getById(co.getId());
		c.setName(co.getName());
		c.setPrice(co.getPrice());
		c.setStudents(co.getStudents());
		this.addCourse(c);
	}

	@Override
	public void deleteCourse(long id) {        
		this.courseRepository.deleteCourse(id);                           
		this.courseRepository.delete(this.getById(id));                              
		
	}
	
}
                                         