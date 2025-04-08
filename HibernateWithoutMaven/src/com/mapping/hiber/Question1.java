package com.mapping.hiber;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Question1 {
	@Id
	@Column(name="que_Id")
	private int question_id;
	private String question;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Answer1>list;	//here we have use list for one to many answere.

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Answer1> getList() {
		return list;
	}

	public void setList(List<Answer1> list) {
		this.list = list;
	}

	public Question1(int question_id, String question, List<Answer1> list) {
		super();
		this.question_id = question_id;
		this.question = question;
		this.list = list;
	}

	public Question1() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Question1 [question_id=" + question_id + ", question=" + question + ", list=" + list + "]";
	}
	
	
}
