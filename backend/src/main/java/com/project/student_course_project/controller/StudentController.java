package com.project.student_course_project.controller;
 
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.student_course_project.dtos.StudentDto;
import com.project.student_course_project.entity.Course;
import com.project.student_course_project.entity.Student;
import com.project.student_course_project.services.IStudentService; 

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@RequestMapping("/api") 
public class StudentController {
	
	@Autowired
	private IStudentService studentService;
	
	@GetMapping("/students") 
	public List<Student> getAll() { 
		return this.studentService.getAll();
	}
 
	@GetMapping("/students/{id}")
	public Student getById(@PathVariable long id) { 
		return this.studentService.getById(id);
	}
	@PostMapping("/addstudent")
	public void addStudent(@RequestBody Student st) { 
		 this.studentService.addStudent(st); 
	}
	
	@PostMapping("/getStudentCourses")
	public List<Course> getStudentsCourses(@RequestBody Student st) { 
		return this.studentService.getStudentsCourses(st);
	}
	
	@PostMapping("/getStudentsPassedByDtos")
	public List<Student> getPassedStudents(@RequestBody List<StudentDto> stDtos){ 
		List<Long> ids = new ArrayList<Long>();
		for(int i=0; i<stDtos.size();i++) {
			ids.add(stDtos.get(i).getId());
		}
		
		return this.studentService.getPassedStudents(ids);
	}
	
	 
	@PostMapping("/getMales")
	public List<Student> getMalePersons(@RequestBody List<StudentDto> stDtos){
		List<Long> ids = new ArrayList<Long>();
		for(int i=0; i<stDtos.size();i++) {
			ids.add(stDtos.get(i).getId());
		}
		return this.studentService.getMalePersons(ids);
	}
	
	@PostMapping("/getFemales")
	public List<Student> getFemalePersons(@RequestBody List<StudentDto> stDtos){
		List<Long> ids = new ArrayList<Long>();
		for(int i=0; i<stDtos.size();i++) {
			ids.add(stDtos.get(i).getId());
		}
		return this.studentService.getFemalePersons(ids);
	}
	@PostMapping("/deneme")
	public List<Student> getDeneme(@RequestBody StudentDto stDto){ 
		return this.studentService.getDeneme(stDto.getId());
	}
	
	@PostMapping("/updatestudent")
	public void updateStudent(@RequestBody Student st) { 
		 
		 this.studentService.updateStudent(st);
	} 
	
	
	@DeleteMapping("/deletestudent") 
	public void deleteStudent(@RequestParam(value = "id", defaultValue="0", required=true) int id) {
		this.studentService.deleteStudent(id);
	}
}
