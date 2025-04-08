package com.hiber;

//Explain Hibernate lifecycle states.

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppStateCls {
	public static void main(String[] args) {
		//Configure hibernate
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Student s1 = new Student();
        s1.setSid(103);
        s1.setSname("Narayan");
        s1.setCity("Pune");
        s1.setCert(new Certificate("DSA","6 months"));
        //Transient state : when we create new object .
        
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(s1);
        //persistant state : Database, session
        s1.setSname("Sumit");
        
        //detached state : remove data from session but dosn't from database.
        tx.commit();
        session.close();
        s1.setSname("Rama");
        System.out.println(s1);
        
        factory.close();
        s1.setSname("Shayam");
        System.out.println(s1);
        System.out.println("Done...");
	}
}
