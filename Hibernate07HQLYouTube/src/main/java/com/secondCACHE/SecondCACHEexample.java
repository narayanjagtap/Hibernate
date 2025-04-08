package com.secondCACHE;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.HQL.Student;

public class SecondCACHEexample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		
		// First session
        Session session1 = factory.openSession();
        Student student1 = session1.get(Student.class, 10);
        System.out.println(student1);

        session1.close();
        
        System.out.println(".............Working............");

        // Second session
        Session session2 = factory.openSession();
        Student student2 = session2.get(Student.class, 10);
        System.out.println(student2);

        session2.close();
        
        
	}
}
