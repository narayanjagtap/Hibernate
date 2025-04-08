package com.tut;

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

		// Creating answer first
		Answer answer = new Answer();
		answer.setAnswerId(343);
		answer.setAnswer("Java is a programming language");
		session.save(answer); // Save Answer first

		Answer answer1 = new Answer();
		answer1.setAnswerId(344);
		answer1.setAnswer("API is used to work with objects in Java");
		session.save(answer1); // Save second Answer

		
		// Creating questions after saving answers
		Question q1 = new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What is Java?");
		q1.setAnswer(answer); // Associate question with saved answer
		session.save(q1);

		Question q2 = new Question();
		q2.setQuestionId(242);
		q2.setQuestion("What is the Collection Framework?");
		q2.setAnswer(answer1); // Associate question with saved answer
		session.save(q2);

		tx.commit();
		session.close();
		factory.close();

		System.out.println("Done...");
	}
}
