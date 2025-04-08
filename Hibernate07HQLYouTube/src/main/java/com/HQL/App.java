package com.HQL;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session s = factory.openSession();
		
		String query = "from Student";
		String query1 = "from Student where city = 'Pune'";
		
		Query q = s.createQuery(query1);
		
		//single result (unique)
		//multiple result (list)
		
		List<Student> list = q.list();
		
		for(Student student:list) {
			System.out.println(student.getName() + " : " + student.getCerti().getCourse());	//here certificate is a class
		}
		
		
		System.out.println("---------------------------------------------------------------------------------");
		
		Transaction tx = s.beginTransaction(); // Start transaction
		
		//--------Delete Query--------
//		Query q2 = s.createQuery("delete from Student s where s.city=:c");
//		q2.setParameter("c", "Nashik");
//		
//		int r = q2.executeUpdate();
//		System.out.println("Deleted : ");
//		System.out.println(r);
		
		//------Update Query---------
		Query q2=s.createQuery("update Student set city=:c where name=:n");
		q2.setParameter("c", "Latur");
		q2.setParameter("n", "Amit Deshmukh");
		int r = q2.executeUpdate();
		System.out.println(r + "objects updated");
		
		System.out.println("-----------------------------------------------------------------------------------");
		//-------to execute Join Query----------
		Query q3 = s.createQuery("select q.question,q.questionId,a.answer from Question as q INNER JOIN q.answer as a");
		
		List<Object[]> list3 = q3.getResultList();
		for (Object[] arr : list3){
		System.out.println(Arrays.toString(arr));
		}
		
		tx.commit(); // Commit transaction
		
		s.close();
		
		factory.close();
    }
}
