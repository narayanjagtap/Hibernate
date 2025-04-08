package com.hiber;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	private int sid;
	private String sname;
	private String city;
	
	private Certificate cert;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Certificate getCert() {
		return cert;
	}

	public void setCert(Certificate cert) {
		this.cert = cert;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int sid, String sname, String city, Certificate cert) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.city = city;
		this.cert = cert;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", city=" + city + ", cert=" + cert + "]";
	}
	
	
}
