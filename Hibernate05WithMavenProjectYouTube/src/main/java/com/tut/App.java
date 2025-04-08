package com.tut;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class App {
	public static void main(String[] args) {
		System.out.println("Project started..");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		// Creating questions
		Question q1 = new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What is Java?");

		// Creating answers
		Answer answer = new Answer();
		answer.setAnswerId(343);
		answer.setAnswer("Java is a programming language");
		answer.setQuestion(q1);  // Set the question

		Answer answer1 = new Answer();
		answer1.setAnswerId(344);
		answer1.setAnswer("With the help of Java we can create software");
		answer1.setQuestion(q1);  // Set the question

		Answer answer2 = new Answer();
		answer2.setAnswerId(345);
		answer2.setAnswer("Java has different types of frameworks");
		answer2.setQuestion(q1);  // Set the question

		List<Answer> list = new ArrayList<Answer>();
		list.add(answer);
		list.add(answer1);
		list.add(answer2);

		q1.setAnswers(list);

		session.save(q1);
		session.save(answer);
		session.save(answer1);
		session.save(answer2);

		tx.commit();
		session.close();
		factory.close();

		System.out.println("Done...");
	}
}
