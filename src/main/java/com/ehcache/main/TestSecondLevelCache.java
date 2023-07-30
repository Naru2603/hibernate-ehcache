package com.ehcache.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.basic.entity.Employee;

public class TestSecondLevelCache {

	public static void main(String[] args) {
		
		Employee emp = new Employee("Narendra", "Hupari", "QA");
		Employee emp2 = new Employee("Rahul", "Pune", "Testing");
		
		Configuration conf = new Configuration();
		conf.configure();
		
		SessionFactory sf = conf.buildSessionFactory();
		
		Session session1 = sf.openSession();
		
		Transaction txn = session1.beginTransaction();

//		session.save(emp);
//		session.save(emp2);
		
		Employee e1 = session1.get(Employee.class, 1);
		System.out.println("Data fecthed from session 1 for first time ===== :"+e1);
		
		Employee e2 = session1.get(Employee.class, 1);
		System.out.println("Data fecthed from session 2 for second time >>>>>>>>>>>>>>>>> :"+e2);
		
		txn.commit();
		session1.close();
		
		System.out.println("Starting session 2 >>>>>>>>>>>>>>>>>>>");
	
		Session session2 = sf.openSession();
		
		Transaction txn2 = session2.beginTransaction();
		
		Employee se1 = session2.get(Employee.class, 1);
		System.out.println("Data fecthed from session 2 for first time ===== :"+se1);
	
		System.out.println("Data saved to DB successfully..!!");
		
		
		txn2.commit();
		session2.close();
		

	}

}
