package com.hiber;

import javax.persistence.Embeddable;

@Embeddable 
public class Certificate {
	private String course_name;
	private String cert_dur;
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCert_dur() {
		return cert_dur;
	}
	public void setCert_dur(String cert_dur) {
		this.cert_dur = cert_dur;
	}
	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Certificate(String course_name, String cert_dur) {
		super();
		this.course_name = course_name;
		this.cert_dur = cert_dur;
	}
	
	
}
