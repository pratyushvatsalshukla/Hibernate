package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class ReadStudentDemo {
	public static void main(String ...args)	{
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
			Student tempStudent = new Student("daffu", "duck", "daffy@duck.com") ;
			session.beginTransaction() ; 	// Start begin TRansaction
				
			System.out.println("Saving Student Object.....");
			System.out.println(tempStudent);
			session.save(tempStudent) ; // Save Student Object

			session.getTransaction().commit();// Commit Transaction
			System.out.println("Done Saving The Object To Database !!");
		
			System.out.println("Saved Student. Generated Id : " + tempStudent.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession() ;
			session.beginTransaction() ;
			
			// retrieve student based on the id: primary key
			System.out.println("\n Getting Student With ID : "+ tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId()) ;
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("DONE FINISHED !!");
		
		}
		finally {
			factory.close() ;
		}

	}
}
