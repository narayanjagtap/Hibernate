package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		//student 1
		Student student1=new Student();
		student1.setId(1212);
		student1.setName("Sagar");
		student1.setCity("Delhi");
		
		Certificate certificate=new Certificate();
		certificate.setCourse("Andriod");
		certificate.setDuration("6 months");
		student1.setCerti (certificate);
		
		//student 2
		Student student2=new Student();
		student2.setId(1313);
		student2.setName("Pruthvi");
		student2.setCity("Mumbai");
		
		Certificate certificate1=new Certificate();
		certificate1.setCourse("Python");
		certificate1.setDuration("4 months");
		student2.setCerti (certificate1);
		
		
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		
		//objects save:
		s.save(student1);
		s.save(student2);
		
		tx.commit();
		s.close();
		factory.close();
	}
}
