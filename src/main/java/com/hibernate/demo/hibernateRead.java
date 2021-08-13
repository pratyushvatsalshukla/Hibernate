package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class hibernateRead {
	public static void main(String ...prs)
	{
		
		// Create Session Factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory() ;
		// Create Session
		Session session = factory.getCurrentSession() ;
		System.out.println("Session Object Created !!");
		
		try {
			
			// Begin Transaction 
			session.beginTransaction() ;
			
			// Run read Query
			List<Student> studentDetails = session.createQuery("from Student s where s.lastName = 'Vatsal'").getResultList() ;
			for(Student details : studentDetails)
			{
				System.out.println(details);
			}
			
			// Run Transaction And Commit !!
			session.getTransaction().commit() ;
			
		}
		finally {
			session.close();
		}
		
		
	}
}
