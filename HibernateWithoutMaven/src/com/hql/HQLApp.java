package com.hql;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.hiber.Student;

public class HQLApp {
    public static void main(String[] args) {
        // Configure Hibernate
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        // Build SessionFactory and open a session
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        // Query to fetch data based on city and name
        String query = "from Student";
        Query<Student> q = session.createQuery(query, Student.class); // Type-safe query
        
        System.out.println("Executing Query: " + query);

        // Fetch and print the results before deletion
        List<Student> list = q.list();
        System.out.println("Before performing perticular operation simply Display all data :");
        for (Student ss : list) {
            System.out.println(ss.getSid() + " " + ss.getCity() + " " + ss.getSname());
        }
        
        System.out.println("-----------------------------------------------------------");

        
        // Delete data based on city
        Transaction tx = session.beginTransaction();
//        Query<?> q2 = session.createQuery("delete from Student s where s.city=:c");
//        q2.setParameter("c", "Mumbaii");
//
//        int r = q2.executeUpdate(); // Execute the delete query
//        System.out.println("Deleted Rows: " + r);

        // Fetch and print the updated results after deletion
        Query<Student> q3 = session.createQuery("from Student", Student.class);
        List<Student> updatedList = q3.list();
        System.out.println("After Deletion:");
        for (Student ss : updatedList) {
            System.out.println(ss.getSid() + " " + ss.getCity() + " " + ss.getSname());
        }
        
        System.out.println("--------------------------------------------------------------------------------");
        
     // Update data
//        Query q2 = session.createQuery("update Student s set s.city =:c where s.sname =:n");
//        q2.setParameter("c", "Aapll Latur..");
//        q2.setParameter("n", "Narayan");
//
//        int r = q2.executeUpdate();
//        System.out.println("Updated: " + r);

        // Fetch updated data after commit
        List<Student> updatedList1 = q3.list();
        System.out.println("After Updation:");
        for (Student ss : updatedList1) {
            System.out.println(ss.getSid() + " " + ss.getCity() + " " + ss.getSname());
        }
        tx.commit();
        
        Query q4 = session.createQuery("select q.question, q.questionId, a.answer from Question as q inner join q.answer as a");
        List<Object[]> list3 = q4.getResultList();
        for (Object[] aa : list3) {
            System.out.println(Arrays.toString(aa));
        }
        // Close session and factory
        session.close();
        factory.close();
    }
}
