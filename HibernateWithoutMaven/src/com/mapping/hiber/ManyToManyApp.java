package com.mapping.hiber;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;

public class ManyToManyApp {
    public static void main(String[] args) {
        // Step 1: Configure hibernate
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        // Step 2: Create Employee objects
        Employee1 e1 = new Employee1();
        e1.setEid(11);
        e1.setEname("Harshada");

        Employee1 e2 = new Employee1();
        e2.setEid(12);
        e2.setEname("Dipali");

        Employee1 e3 = new Employee1();
        e3.setEid(13);
        e3.setEname("Narayan");

        // Step 3: Create Project objects
        Project p1 = new Project();
        p1.setPid(1011);
        p1.setPname("Weather App Detection");

        Project p2 = new Project();
        p2.setPid(1012);
        p2.setPname("Hospital Management System");

        Project p3 = new Project();
        p3.setPid(1013);
        p3.setPname("Ecommerce Website");

        // Step 4: Map Employees to Projects
        List<Employee1> list1 = new ArrayList<>();
        list1.add(e1);
        list1.add(e2);
        list1.add(e3);

        List<Project> list2 = new ArrayList<>();
        list2.add(p1);
        list2.add(p2);
        list2.add(p3);

        e1.setProject(list2);  // Map projects to employee e1
        p1.setEmployee(list1); // Map employees to project p1

        // Step 5: Save objects to the database
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(e1);
        session.save(e2);
        session.save(e3);
        session.save(p1);
        session.save(p2);
        session.save(p3);

        tx.commit();

        // Step 6: Close the session and factory
        session.close();
        factory.close();

        System.out.println("Done.....");
    }
}

