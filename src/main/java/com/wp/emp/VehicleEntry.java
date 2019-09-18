package com.wp.emp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class VehicleEntry {

	public static void main(String[] args) {
		
		SessionFactory sf = Util.getSF();
		Session session = sf.openSession();
		
		Vehicle v1=new Vehicle("V111","Hyundai","Santro",400000,new Emp(111));
		Vehicle v2=new Vehicle("V112","Maruti","Baleno",700000,new Emp(112));
		Vehicle v3=new Vehicle("V113","Tata","Tiago",600000,new Emp(113));
		Vehicle v4=new Vehicle("V114","Ford","Figo",500000,new Emp(111));
		
		
		
		Transaction tr = session.beginTransaction();
		session.save(v1); session.save(v2); session.save(v3); session.save(v4);
		tr.commit();
		session.close();
		System.out.println("RECORD ADDED");

	}

}
