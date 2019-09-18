package com.wp.emp;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LaptopCRUD {

public static void main(String args[]) {
		
		SessionFactory sf=Util.getSF();
		Session session=sf.openSession();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("CRUD OPERATIONS");
		System.out.println("=============================");
		System.out.println("OPTION - 1.READ ");
		System.out.println("OPTION - 2.INSERTION ");
		System.out.println("OPTION - 3.UPDATION ");
		System.out.println("OPTION - 4.DELETION");
		System.out.println("=============================");
		int choice = sc.nextInt();

		switch(choice) {
		case 1:
			
			@SuppressWarnings("deprecation") Criteria cr = session.createCriteria(Laptop.class);
			@SuppressWarnings("unchecked") List<Laptop> list = cr.list();
			for(Laptop laptop : list)
			{
				
				System.out.println("Laptop Code : "+laptop.getCode());
				System.out.println("Laptop Brand : "+laptop.getBrand());
				System.out.println("Laptop Price : "+laptop.getPrice());
				System.out.println("Employee No : "+laptop.getEmp().getEno());
				System.out.println("Employee Name : "+laptop.getEmp().getEname());
				System.out.println("Employee Salary : "+laptop.getEmp().getSal());
				System.out.println("..........................");
				
				
			}
			break;
		case 2:
			System.out.println("INSERTION");
			System.out.println("-----------------------------");
			System.out.println("enter code");
			String code = sc.next();
			System.out.println("enter brand");
			String brand = sc.next();
			System.out.println("enter price");
			int price = sc.nextInt();

			Transaction tr = session.beginTransaction();
			Laptop laptop=new Laptop(code,brand,price);
			session.save(laptop);
			tr.commit();
			break;
		case 3:
			System.out.println("UPDATION");
			System.out.println("-----------------------------");
			
			System.out.println("enter code");
			String code1 = sc.next();
			System.out.println("enter brand");
			String brand1 = sc.next();
			System.out.println("enter price");
			int price1 = sc.nextInt();
			
			Laptop laptop1=session.get(Laptop.class,code1);
			laptop1.setCode(code1);
			laptop1.setBrand(brand1);
			laptop1.setPrice(price1);
			
			Transaction tr1 = session.beginTransaction();
			session.update(laptop1);
			tr1.commit();
			System.out.println("\nRecord Updated");
			break;
		case 4:
			System.out.println("DELETION");
			System.out.println("-----------------------------");
			System.out.println("enter code");
			String code2 = sc.next();
			Laptop laptop2=session.get(Laptop.class,code2);
			Transaction tr2 = session.beginTransaction();
			session.delete(laptop2);
			tr2.commit();
			System.out.println("\nRecord Deleted");
			break;
		default:
			System.out.println("CHOOSE CORRECT OPTION");
		}
		sc.close();
		session.close();
	}
}
