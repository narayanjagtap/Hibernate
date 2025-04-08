package com.hiber;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		System.out.println("Connect Succesfully...");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Employee e1 = new Employee();
		e1.setEid(1);
		e1.setEname("Narayana");
		e1.setEaddress("Laturr");
		e1.setEsal(100000);
		
		Address a1 = new Address();
		a1.setCity("Mumbaii");
		a1.setStreet("Marine drive");
		a1.setX(567.5678);
		a1.setOpen(true);
		a1.setAddedDate(new Date());
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(e1);
		session.save(a1);
		tx.commit();
		session.close();
		System.out.println("Done....");
	}
}
