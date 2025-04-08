package com.maven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        System.out.println("Connect Successfully...");

        Configuration cfg = new Configuration();	//creates a Configuration object to hold Hibernate settings.
        cfg.configure("hibernate.cfg.xml");	//loads the hibernate.cfg.xml file, which contains the database connection properties and mapping details.

        SessionFactory factory = cfg.buildSessionFactory();	//builds a SessionFactory from the configuration. It serves as a factory for Session objects.
        System.out.println(factory.isClosed());	//prints whether the SessionFactory is closed (should print false since it was just created).

        Student s1 = new Student();
        s1.setRollno(0);
        s1.setName("Aai");
        s1.setAddress("Jayphal");
        s1.setMarks(90);

        Session session = factory.openSession();	//A Session is used to interact with the database (e.g., for CRUD operations).
        Transaction tx = session.beginTransaction();
        session.save(s1);
        tx.commit();
    }
}
