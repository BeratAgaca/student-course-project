package com.project.student_course_project.entity;
 
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table; 

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="courses")
public class Course implements Serializable{  
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name = "id")
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "price")
	private int price;
	
	@JsonIgnore
	@ManyToMany(mappedBy="courses", fetch=FetchType.LAZY)
	private List<Student> students;
 
	
	public Course(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Course() {}

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
