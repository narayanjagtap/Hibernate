package com.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddableMain {
	public static void main(String[] args) {
		//Configure hibernate
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Student s1 = new Student();
        s1.setSid(101);
        s1.setSname("Arya");
        s1.setCity("Mumbaii");
        
        Student s2 = new Student();
        s2.setSid(102);
        s2.setSname("Sagar");
        s2.setCity("Laturr");
        
        Certificate c1 = new Certificate();
        c1.setCourse_name("Hibernate");
        c1.setCert_dur("1.2 month");
        s1.setCert(c1);
        
        Certificate c2 = new Certificate();
        c2.setCourse_name("Spring");
        c2.setCert_dur("2 month");
        s2.setCert(c2);
        
        //Save objects to the database
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        
        session.save(s1);
        session.save(s2);
        
        tx.commit();

        //Close the session and factory
        session.close();
        factory.close();

        System.out.println("Done.....");
	}
}
