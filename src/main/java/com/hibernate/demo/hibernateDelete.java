package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class hibernateDelete {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory() ;
		// Create Session
		Session session = factory.getCurrentSession() ;
		System.out.println("Session Object Created !!");
		
		try {
			//Beign Transaction 
			session.beginTransaction();
			
			// Run Operations 
			session.createQuery("delete from Student s where s.lastName = 'Vatsal'").executeUpdate() ;
			
			// Get Transaction and Commit !!
			session.getTransaction().commit();
			
		}
		finally {
			session.close(); 
		}

	}

}
