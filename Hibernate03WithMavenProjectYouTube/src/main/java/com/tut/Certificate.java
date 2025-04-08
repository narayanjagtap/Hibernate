package com.tut;

import javax.persistence.Embeddable;

/* @Embeddable → Marks Certificate as an embedded class, meaning its fields (course and duration) 
 * will be stored in the Student table instead of a separate table.
 */

@Embeddable	
public class Certificate {
	
	private String Course;
	private String duration;
	
	
	public String getCourse() {
		return Course;
	}
	public void setCourse(String course) {
		Course = course;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Certificate(String course, String duration) {
		super();
		Course = course;
		this.duration = duration;
	}
	
}
