package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hiber.Employee;

public class Pagination
{
    public static void main(String[] args)
    {
        Session s = new Configuration().configure().buildSessionFactory().openSession();
        Transaction tx = s.beginTransaction();

        Query query = s.createQuery("from Employee");

        query.setFirstResult(3);	//start limit
        query.setMaxResults(6);	//end limit to print table data in console

        List<Employee> e1 = query.list();
        //System.out.println(e1);
        for(Employee e:e1) {
        	System.out.println(e);
        }
        
        s.close();
    }
}

