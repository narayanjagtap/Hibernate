package com.Pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.HQL.Student;

public class HQLPagination {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		
		Query<Student> query = s.createQuery("From Student", Student.class);
		
		//Implementing pagination using Hibernate.
		
		query.setFirstResult(0);	// Start from the first record (index 0)
		
		query.setMaxResults(8);		// Fetch only 5 records
		
		List<Student> list = query.list();
		
		for (Student st: list) {
			System.out.println(st.getId()+" : "+st.getName() + " : " + st.getCity());
		}
		
		s.close();
		factory.close();
	}
}
