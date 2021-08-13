package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class QueryStudentDemo {
	public static void main(String ...args){
		// create Session Factory
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Student.class)
								.buildSessionFactory() ;
		// Create a Sessioon
		try {
		
			// Start begin TRansaction
			factory.getCurrentSession().beginTransaction() ; 	
			
			// Query Students
			
			List<Student> theStudents = factory.getCurrentSession().createQuery("from Student").getResultList() ;
			
			// Display The Students
			for(Student tempStudent : theStudents)
			{
				System.out.println(tempStudent);
			}
		
			
			List<Student>theStudent = factory.getCurrentSession().createQuery("from Student s where s.lastName='Doe'").getResultList() ;
			
			System.out.println("Students With Last name : DOE");
			for(Student tempStudent : theStudent)
			{
				System.out.println(tempStudent);
			}
//			
			// Commit Transaction
			factory.getCurrentSession().getTransaction().commit();
		}	
		finally {
			factory.close() ;
		}

	}

}
