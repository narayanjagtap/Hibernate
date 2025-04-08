package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) {
		//in this method we will understand the how ot use get() and load() method for Fetching the data from db.
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		//get-student : 101
		Student student = (Student)session.get(Student.class, 101);
		System.out.println(student);
		
		//load-student_address : 1
		Address ad=(Address) session.load(Address.class, 2);
		System.out.println(ad.getCity() + " : " + ad.getStreet());
		
		session.close();
		factory.close();
	}
}
