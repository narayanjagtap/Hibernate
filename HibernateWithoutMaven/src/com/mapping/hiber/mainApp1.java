package com.mapping.hiber;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class mainApp1 {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Question1 que = new Question1();
		que.setQuestion_id(1111);
		que.setQuestion("What is hibernate?");
		
		Answer1 ans1 = new Answer1();
		ans1.setAns_id(1012);
		ans1.setAnswer("Hibernate is open sorce Framework");
		ans1.setQuestion(que);
		
		Answer1 ans2 = new Answer1();
		ans2.setAns_id(1024);
		ans2.setAnswer("Hibernate is Depend on orm tool...");
		ans2.setQuestion(que);
		
		Answer1 ans3 =new Answer1();
		ans3.setAns_id(1046);
		ans3.setAnswer("hibernate is Non invansive Framework...");
		ans3.setQuestion(que);
		
		Answer1 ans4 = new Answer1();
		ans4.setAns_id(1235);
		ans4.setAnswer("Using hibetnate we don't need towrite questy manually..");
		ans4.setQuestion(que);
		
		List<Answer1>list = new ArrayList<Answer1>();
		list.add(ans1);
		list.add(ans2);
		list.add(ans3);
		list.add(ans4);
		que.setList(list);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(que);
		session.save(ans1);
		session.save(ans2);
		session.save(ans3);
		session.save(ans4);
		
		tx.commit();

		session.close();
		factory.close();
		System.out.println("Done...");
	}
}
