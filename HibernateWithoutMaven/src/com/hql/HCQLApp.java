package com.hql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.hiber.Student;

public class HCQLApp {
	public static void main(String[] args) {
		Session s = new Configuration().configure().buildSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        
        Query query = s.createQuery("from Student");
        
        Criteria c = s.createCriteria(Student.class);	//This is used for fetch preticular data from database
        /*//c.add(Restrictions.between("sid", 103, 106));
        //c.add(Restrictions.ge("sid",102));
        c.add(Restrictions.le("sid", 103));	//run one to one method like le, ge , between etc
        
        List<Student> stud =c.list();
        for(Student ss : stud) {
        	System.out.println(ss);
        }*/
        
        c.setProjection(Projections.property("city"));	//this projection are used to fetch perticular column from table.
        List<String> list2 = c.list(); // Fetches a list of 'sname' values
        for(String st:list2) {
        	System.out.println(st);
        }
        
        tx.commit();
	}
}
