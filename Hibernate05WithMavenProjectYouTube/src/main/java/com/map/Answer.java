package com.map;

import javax.persistence.*;

@Entity
public class Answer {
	
	@Id
	@Column(name = "answer_id")
	private int answerId;
	
	private String answer;

	@ManyToOne
	@JoinColumn(name = "question_id")  // This ensures a proper foreign key mapping
	private Question question;

	// Getters and Setters
	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	// Constructors
	public Answer() {
		super();
	}

	public Answer(int answerId, String answer, Question question) {
		super();
		this.answerId = answerId;
		this.answer = answer;
		this.question = question;
	}
}
