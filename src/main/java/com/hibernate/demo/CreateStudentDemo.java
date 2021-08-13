package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class CreateStudentDemo {
	public static void main(String ...args) {
		// create Session Factory
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Student.class)
								.buildSessionFactory() ;
		// Create a Sessioon
		Session session = factory.getCurrentSession() ;
		try {
			// Create a Student Object
			System.out.println("Creating new Student Object....");
			Student tempStudent = new Student("paul", "walker", "paul@walker.com") ;
			session.beginTransaction() ; 	// Start begin TRansaction
				
			System.out.println("Saving Student Object.....");
			session.save(tempStudent) ; // Save Student Object

			session.getTransaction().commit();// Commit Transaction
			System.out.println("Done Saving The Object To Database !!");
		}
		finally {
			factory.close() ;
		}
	}
}
