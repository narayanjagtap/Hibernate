package com.mapping.hiber;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee1 {
	@Id
	private int eid;
	@Column(name="Employee_name")
	private String ename;
	
	@ManyToMany
	@JoinTable
	private List<Project>Project;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public List<Project> getProject() {
		return Project;
	}

	public void setProject(List<Project> project) {
		Project = project;
	}

	public Employee1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee1(int eid, String ename, List<com.mapping.hiber.Project> project) {
		super();
		this.eid = eid;
		this.ename = ename;
		Project = project;
	}

	@Override
	public String toString() {
		return "Employee1 [eid=" + eid + ", ename=" + ename + ", Project=" + Project + "]";
	}
	
}
