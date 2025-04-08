package com.mapping.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class mainApp {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Question q1 = new Question();
		q1.setQuestionId(3);
		q1.setQuestion("Is Java Platform Independent if then how?");
		
		Answer a1 = new Answer();
		a1.setAnswerId(103);
		a1.setAnswer("Yes, Java is a Platform Independent language. ");
		a1.setQuestion(q1);
		q1.setAnswer(a1);
		
		Question q2 = new Question();
		q2.setQuestionId(4);
		q2.setQuestion("What are the top Java Features?");


		Answer a2 = new Answer();
		a2.setAnswerId(104);
		a2.setAnswer("Java is one the most famous and most used language in the real world,");
		a2.setQuestion(q2);
		q2.setAnswer(a2);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(q1);
		session.save(a1);
		
		session.save(q2);
		session.save(a2);
		
		tx.commit();
		
		System.out.println("-------------Question 1 and his answer : -----------------");
		//The lines you provided are crucial for retrieving and displaying specific data from the database in terminal/Console.
		Question que = (Question)session.get(Question.class, 3);
		System.out.println(que.getQuestion());
		System.out.println(que.getAnswer().getAnswer());

		System.out.println("-------------Question 2 and his answer : -----------------");
		Question que1 = (Question)session.get(Question.class, 4);
		System.out.println(que1.getQuestion());
		System.out.println(que1.getAnswer().getAnswer());
		
		session.close();
	}
}
