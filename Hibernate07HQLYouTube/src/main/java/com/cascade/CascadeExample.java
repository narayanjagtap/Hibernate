package com.cascade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.HQL.Question;
import com.HQL.Answer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

public class CascadeExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session s = factory.openSession();

        Question q1 = new Question();

        q1.setQuestionId(567);
        q1.setQuestion("What is Cascading...");

        Answer a1 = new Answer(23423, "In hibernate it is important concept");
        Answer a2 = new Answer(255, "Second answer");
        Answer a3 = new Answer(35, "third answer");
        List<Answer> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);

        q1.setAnswer(list);
        
        Transaction tx = s.beginTransaction();
        
        s.save(q1);
        
        //NOW we don't have need to save the each answer sepratellu due to we have use the 'cascade = CascadeType.ALL' at private List answer in the question class.
//        s.save(a1);
//        s.save(a2);
//        s.save(a3);
        
        tx.commit();

        s.close();
        factory.close();
    }
}
