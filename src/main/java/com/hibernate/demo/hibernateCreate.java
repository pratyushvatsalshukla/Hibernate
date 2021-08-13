package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class hibernateCreate {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory() ;
		// Create Session
		Session session = factory.getCurrentSession() ;
		System.out.println("Session Object Created !!");
		
		try {
			// Begin Transaction
			session.beginTransaction() ;
			
			//Save Object
			Student student = new Student("Pratyush", "Vatsal", "prstech@gmail.com") ;
			session.save(student) ;
			System.out.println("Object Saved Into Database !!");
			
			// get Transaction and Commit
			session.getTransaction().commit();
			System.out.println("Transaction Completed and Comitted !!");
			
			
		}
		finally {
			session.close();
		}
		
		
		

	}

}
