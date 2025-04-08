package com.mapping.hiber;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	private int pid;
	@Column(name="project_name")
	private String pname;
	
	@ManyToMany
	private List<Employee1>employee;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public List<Employee1> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee1> employee) {
		this.employee = employee;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int pid, String pname, List<Employee1> employee) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Project [pid=" + pid + ", pname=" + pname + ", employee=" + employee + "]";
	}
	
}
