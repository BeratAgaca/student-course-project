package com.project.student_course_project.services;

import java.util.List;

import com.project.student_course_project.entity.Course;
import com.project.student_course_project.entity.Student;

public interface ICourseService {
	List<Course> getAll();
	Course getById(long id);
	List<Student> getCourseStudents(Course co);
	void addCourse(Course co);
	void updateCourse(Course co);
	void deleteCourse(long id);
}
