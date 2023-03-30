package com.project.student_course_project.impl;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.project.student_course_project.entity.Course;
import com.project.student_course_project.entity.Student;
import com.project.student_course_project.repositories.IStudentRepository;
import com.project.student_course_project.services.IStudentService;

@Service
public class StudentService implements IStudentService{

	@Autowired
	private IStudentRepository studentRepository; 
	 

	@Override
	public List<Student> getAll() { 
		return this.studentRepository.findAll();
	}

	@Override
	public Student getById(long id) { 
		return this.studentRepository.findById(id).get();
	}
	
	

	@Override
	public List<Course> getStudentsCourses(Student st) { 
		
		return st.getCourses();
	}

	@Override
	public void addStudent(Student st) { 
		this.studentRepository.save(st);
		
	}

	@Override
	public List<Student> getPassedStudents(List<Long> ids) {
		return this.studentRepository.getPassedStudentsByDto(ids);
		
	}

	@Override
	public List<Student> getMalePersons(List<Long> ids) {
		return this.studentRepository.getMalePersons(ids);
	}

	@Override
	public List<Student> getFemalePersons(List<Long> ids) {
		return this.studentRepository.getFemalePersons(ids);
	}

	@Override
	public List<Student> getDeneme(long id) {
		 
		return this.studentRepository.getDeneme(id);
	}

	@Override
	public void updateStudent(Student st) {
		 Student student = this.getById(st.getId());
		 student.setName(st.getName());
		 student.setGrade(st.getGrade());
		 student.setGender(st.getGender());
		 student.setCourses(st.getCourses());
		this.studentRepository.save(st);
	}

	@Override
	public void deleteStudent(long id) {  
		
		this.studentRepository.deleteStudent(id);
	}
 
/*
	@Override
	public List<Student> getPassedStudents(List<StudentDto> studentDtos) {
		int passLimit=60; 
		List<Student> myStudentList = new ArrayList<Student>();
		
		for(StudentDto student : studentDtos) {
			 Student st = this.studentRepository.findById(student.getId()).get();
			 if(st.getGrade()>=passLimit) {
				 myStudentList.add(st);
				 System.out.println("Not " +st.getGrade() );
			 }
			
				
		}
		
		return myStudentList;
	}
*/
	
}
