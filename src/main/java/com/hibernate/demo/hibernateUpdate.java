package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class hibernateUpdate {
	public static void main(String ...args)
	{
		
		// Create Session Factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory() ;
		// Create Session
		Session session = factory.getCurrentSession() ;
		System.out.println("Session Object Created !!");
		
		try {
			 //Begin Transaction
			session.beginTransaction() ;
			
			//Write Query To Update
			session.createQuery("update Student s set email ='prslpu001@gmail.com' where  s.lastName= 'Vatsal' ").executeUpdate() ;
			
			// Get Transaction and Commit !! 
			session.getTransaction().commit();
			
			
		}
		finally{
			session.close(); 
		}
		
	}
}
