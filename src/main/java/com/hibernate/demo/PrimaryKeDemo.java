package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class PrimaryKeDemo {

	public static void main(String[] args) {
		// create Session Factory
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Student.class)
								.buildSessionFactory() ;
		// Create a Sessioon
		Session session = factory.getCurrentSession() ;
		try {
			// Create 3 Student Object
			System.out.println("Creating 3 new Student Object....");
			Student tempStudent1 = new Student("John", "Doe", "john@doe.com") ;
			Student tempStudent2 = new Student("Mary", "Public", "mary@public.com") ;
			Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@applebum.com") ;
			session.beginTransaction() ; 	// Start begin TRansaction
				
			System.out.println("Saving Student Object.....");
			session.save(tempStudent1) ; // Save Student Object
			session.save(tempStudent2) ; // Save Student Object
			session.save(tempStudent3) ; // Save Student Object

			session.getTransaction().commit();// Commit Transaction
			System.out.println("Done Saving The Object To Database !!");
		}
		finally {
			factory.close() ;
		}
	}

}
