package in.sp.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.sp.entities.User;

public class App 
{
    public static void main( String[] args )
    {
//    	User user1 = new User();
//    	user1.setName("Narayana");
//    	user1.setEmail("narayana@gmail.com");
//    	user1.setPassword("narayana123");
//    	user1.setGender("male");
//    	user1.setCity("Maharashtra");
    	
//    	User user2 = new User();
//    	user2.setName("SAGAR");
//    	user2.setEmail("sagar@gmail.com");
//    	user2.setPassword("sagar123");
//    	user2.setGender("male");
//    	user2.setCity("Latur");
    	
    	Configuration cfg = new Configuration();
    	cfg.configure("/in/sp/config/hibernate.cfg.xml");
    	
    	SessionFactory sessionFactory = cfg.buildSessionFactory();
    	Session session = sessionFactory.openSession();
    	Transaction transaction = session.beginTransaction();
    	
    	
    	//------------Insert Operation---------------
//    	try {
//			session.save(user2);
//			transaction.commit();
//			
//			System.out.println("USER DETAILS ADDED SUCCESSFULLY");
//		} catch (Exception e) {
//			transaction.rollback();
//			e.printStackTrace();
//			
//			System.out.println("USER DETAILS ARE NOT ADDED DUE TO SOME ERRORS");
//		}
    	
    	
    	//-----------Select Operation----------
//    	try {
//    		User user = session.get(User.class, 2L);	//2 here is second id details and L is for long datatype of id
//    		
//    		if (user != null) {
//    			System.out.println(user.getId());
//        		System.out.println(user.getName());
//        		System.out.println(user.getEmail());
//        		System.out.println(user.getPassword());
//        		System.out.println(user.getGender());
//        		System.out.println(user.getCity());
//			}
//    		else {
//    			System.out.println("USER NOT FOUND, PLEASE ENTER VALID USER ID");
//    		}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
    	
    	
//    	//------------Update Operation---------------
//    	
//    	try {
//    		User user = session.get(User.class, 1L);
//    		user.setCity("Pune");
//    		
//    		session.saveOrUpdate(user);
//			transaction.commit();
//			
//			System.out.println("USER DETAILS UPDATED SUCCESSFULLY");
//		} catch (Exception e) {
//			transaction.rollback();
//			e.printStackTrace();
//			
//			System.out.println("USER DETAILS ARE NOT UPDATED DUE TO SOME ERRORS");
//		}
    	
    	
    	
    	//------------Delete Operation---------------
    	
    	try {
    		User user = new User();
    		user.setId(3L);
    		
    		session.delete(user);
    		session.saveOrUpdate(user);
			transaction.commit();
			
			System.out.println("USER DETAILS DELETED SUCCESSFULLY");
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			
			System.out.println("USER DETAILS ARE NOT DELETED DUE TO SOME ERRORS");
		}
    }
}
