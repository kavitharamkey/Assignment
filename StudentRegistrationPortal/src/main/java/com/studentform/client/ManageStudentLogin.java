package com.studentform.client;

import java.util.List;

import com.studentform.pojo.StudentLogin;
import com.studentform.util.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class ManageStudentLogin { 
	
			
		/* Add few Student records in database */ 
        // Integer student1 = manageStudent.addStudent(1,"kavitha", "kavitha","HibernateProgram",new Date()); 
		//Integer student2 = manageStudent.addStudent(2,"ramkey", "ramkey","HibernateProgram",new Date());
		//Integer student3 = manageStudent.addStudent(3,"raghav", "raghav","HibernateProgram",new Date()); 
		//System.out.println("Successfully Inserted " +student1 +", "+student2+", "+student3 );
		/* List down all the Students */
        //  manageStudent.listStudent(); 
	

	/* Method to INSERT a student record in the database */ 
	/*public Integer addStudent(int studentId, String username, String password, String createdBy,Date createdDate){ 
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null; 
		Integer studentRecord = null; 
		try{ 
			tx = session.beginTransaction(); 
			StudentLogin student = new StudentLogin(studentId, username,password, createdBy,createdDate); 
			studentRecord = (Integer) session.save(student); 
			tx.commit(); 
		}catch (HibernateException e) { 
			if (tx!=null) tx.rollback(); 
			e.printStackTrace(); 
		}finally { 
			session.close(); 
		} 
		return studentRecord; 
	} */
	
	/* Method to READ all the Student Information */ 
	@SuppressWarnings("rawtypes")
	public int listStudent(String login ,String password){ 
		int id = 0;
		Session session = HibernateUtil.getSessionFactory().openSession();  
		try{ 
			Criteria cr = session.createCriteria(StudentLogin.class); // Select * from STudent_Login
			cr.add(Restrictions.eq("username",login));
			cr.add(Restrictions.eq("password",password));
			cr.setProjection(Projections.property("student.studentId"));
			List sid = cr.list(); 
			//System.out.print("returned from DB sid.get(0)  " + sid.get(0).toString());
			System.out.print("size: "+sid.size());
			id =(Integer) sid.get(0);
			System.out.println("Studeny ID: " + id);
		}catch (HibernateException e) {
			e.printStackTrace(); 
		}
		finally { 
			session.close(); 
		} 
	    return id;
	} 
	
}