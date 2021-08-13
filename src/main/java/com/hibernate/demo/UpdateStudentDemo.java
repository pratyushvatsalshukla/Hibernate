package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class UpdateStudentDemo {
	public static void main(String ...args){
		// create Session Factory
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Student.class)
								.buildSessionFactory() ;
		// Create a Sessioon
		Session session = factory.getCurrentSession() ;
		try {
			int studentId = 1 ;
			// Begin Transaction
			session.beginTransaction() ;
			
			//Retrieve Student based on The ID
			Student myStudent = session.get(Student.class, studentId) ;
			System.out.println("Updating  Student.......");
			myStudent.setFirstName("ScoobyDoobyDoooo");
			System.out.println("Updated !!");
			
			//Commit Session
			session.getTransaction().commit();
			
		}	
		finally {
			factory.close() ;
		}

	}

}
