package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//You create a Student object in App.java.

public class App {
	public static void main(String[] args) {
		System.out.println("Project started..");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// Creating Student
		Student st = new Student();
		st.setId(103);
		st.setName("Didi");
		st.setCity("Shivali");

		System.out.println(st);

		Session session = factory.openSession();
		///

		Transaction tx = session.beginTransaction();

		session.save(st);
		tx.commit();
		session.close();
	}
}
