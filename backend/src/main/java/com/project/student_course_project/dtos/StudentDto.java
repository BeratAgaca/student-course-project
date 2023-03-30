package com.project.student_course_project.dtos;

public class StudentDto {
	private long id;  
	public StudentDto( ) { }
	public StudentDto(long id ) {
		super();
		this.id = id;  
	}
	 
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	} 
}
