package com.project.student_course_project.entity;
 
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull; 
 
enum Gender{
	E,
	K
}

@Entity
@Table(name="students")
public class Student implements Serializable {  
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name = "id") 
	private long id; 
	@Column(name = "name") 
	private String name;
	@Column(name = "grade")
	private int grade;  
	@Column(name = "gender")
	private Gender gender;
	
	//@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE )
	@JoinTable(name="students_courses", 
		joinColumns = {
			@JoinColumn(name="student_id", referencedColumnName="id",
				nullable=false, updatable=false)},
		inverseJoinColumns = {
			@JoinColumn(name="course_id", referencedColumnName="id",
					nullable=false, updatable=false)})
	private List<Course> courses;
 
	
	public Student(String name, int grade, Gender gender) {
		super();
		this.name = name;
		this.grade = grade; 
		this.gender = gender; 
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Student() {}  
	
	
	
}
