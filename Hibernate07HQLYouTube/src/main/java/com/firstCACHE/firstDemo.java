package com.firstCACHE;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.HQL.Student;

public class firstDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();	//Loads Hibernate configuration from hibernate.cfg.xml.
        Session session = factory.openSession();
        
        // by default enabled

        Student student = session.get(Student.class, 3);	//Fetching an Entity from the Database
        System.out.println(student);

        System.out.println("working something..");

        Student student1 = session.get(Student.class, 3);	//Fetching the Same Entity Again
        System.out.println(student1);
        /*	Again fetches Student with ID = 3.
			But this time, Hibernate will not hit the database!
			Instead, it retrieves the student from the session cache (first-level cache).
			This improves performance by avoiding unnecessary database queries
		*/
        
        System.out.println("----------------------");

        System.out.println(session.contains(student1));	//Checks whether student1 is present in the Hibernate session cache.


        session.close();
    }
}
