package com.hql;
//cascade defines how operations (like save, update, delete) on a parent entity are automatically applied to its associated child entities. 
//It simplifies managing relationships and ensures consistency across related entities.

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mapping.hiber.Answer1;
import com.mapping.hiber.Question1;

public class CascadeApp
{
    public static void main(String[] args)
    {
        Session s = new Configuration().configure().buildSessionFactory().openSession();
        Transaction tx =s.beginTransaction();

        Question1 q1 = new Question1();
        q1.setQuestion_id(11);
        q1.setQuestion("What Is Features Of Java?");

        Answer1 a1 = new Answer1(111, "Java Is Simple Language", q1);
        Answer1 a2 = new Answer1(112, "Java Is OOPs Language", q1);
        Answer1 a3 = new Answer1(113, "Java Is Independent Language", q1);
        
        List<Answer1> list = new ArrayList<Answer1>();
        list.add(a1);
        list.add(a2);
        list.add(a3);
        q1.setList(list);
        
        s.save(q1);
//        s.save(a1);
//        s.save(a2);
//        s.save(a3);
        //we have comment to all s.save(ans) because we use Cascade type in Question1.java file at 19 line (@OneToMany(cascade = CascadeType.ALL))
        
        tx.commit();
        s.close();
    }
}
