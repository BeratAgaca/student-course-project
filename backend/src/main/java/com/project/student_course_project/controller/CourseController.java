package com.project.student_course_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.student_course_project.entity.Course;
import com.project.student_course_project.entity.Student;
import com.project.student_course_project.services.ICourseService; 
 
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@RequestMapping("/api")
public class CourseController {
	@Autowired
	private ICourseService courseService;
	
	@GetMapping("/courses") 
	public List<Course> getAll() { 
		return this.courseService.getAll();
	}
 
	@GetMapping("/courses/{id}")
	public Course getById(@PathVariable long id) { 
		return this.courseService.getById(id);
	}
	@PostMapping("/addcourse")
	public String add(@RequestBody Course course) { 
		 this.courseService.addCourse(course);
		 return "redirect:/addCourse";
	}
	
	@PostMapping("/getCourseStudents")
	public List<Student> getCourseStudents(@RequestBody Course course) { 
		return this.courseService.getCourseStudents(course);
	}
	
	@PostMapping("/updatecourse")
	public void update(@RequestBody Course co) {
		this.courseService.updateCourse(co);
	}
	
	@DeleteMapping("/deletecourse")
	public void deleteCourse(@RequestParam(value = "id" , defaultValue="0", required=true) long id ) {
		this.courseService.deleteCourse(id);
	}
}
