package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//You create a Student object in App.java.

public class App {
	public static void main(String[] args) throws IOException	//we are add exception here due to image.p
	{
		System.out.println("Project started..");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// Creating Student
		Student st = new Student();
		st.setId(102);
		st.setName("NARAYANA");
		st.setCity("Pune");
		System.out.println(st);
		
		//creating object of address class
		Address ad=new Address();
		ad.setStreet("street2 ");
		ad.setCity("Latur");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(1234.234);
		
		//Reading image
		FileInputStream fis = new FileInputStream("src/main/java/Chhaava.png");
		byte[] data=new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);
		/*For view this image : 
		 * To open the BLOB image stored in MySQL Workbench
		 * Right-click the BLOB field   →   Select "Open Value in Editor"   →   Click "View as Image".
		 */
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(st);	//save the Student object
		session.save(ad);	//save the address object
		tx.commit();
		session.close();
		System.out.println("Done...");
	}
}
