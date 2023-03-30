package com.project.student_course_project.services;

import java.util.List;

import com.project.student_course_project.dtos.StudentDto;
import com.project.student_course_project.entity.Course;
import com.project.student_course_project.entity.Student;

public interface IStudentService{
	List<Student> getAll();
	Student getById(long id);
	List<Course> getStudentsCourses(Student st);
	void addStudent(Student st);
	List<Student> getPassedStudents(List<Long> ids);
	List<Student> getMalePersons(List<Long> ids);
	List<Student> getFemalePersons(List<Long> ids);
	List<Student> getDeneme(long id);
	void updateStudent(Student st);
	void deleteStudent( long id);
}