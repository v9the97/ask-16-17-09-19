package com.wp.emp;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class VehicleCRUD {

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
			
			@SuppressWarnings("deprecation") Criteria cr = session.createCriteria(Vehicle.class);
			@SuppressWarnings("unchecked") List<Vehicle> list = cr.list();
			for(Vehicle vehicle : list)
			{
				
				System.out.println("Vehicle RegNo : "+vehicle.getRegno());
				System.out.println("Vehicle Brand : "+vehicle.getBrand());
				System.out.println("Vehicle Model : "+vehicle.getModel());
				System.out.println("Vehicle Price : "+vehicle.getPrice());
				System.out.println("Employee No : "+vehicle.getEmp().getEno());
				System.out.println("Employee Name : "+vehicle.getEmp().getEname());
				System.out.println("Employee Salary : "+vehicle.getEmp().getSal());
				System.out.println("..........................");
				
				
			}
			break;
		case 2:
			System.out.println("INSERTION");
			System.out.println("-----------------------------");
			System.out.println("enter regNo");
			String regNo = sc.next();
			System.out.println("enter brand");
			String brand = sc.next();
			System.out.println("enter model");
			String model = sc.next();
			System.out.println("enter price");
			int price = sc.nextInt();
			System.out.println("enter eno");
			int eno = sc.nextInt();

			Transaction tr = session.beginTransaction();
			Vehicle vehicle=new Vehicle(regNo,brand,model,price,new Emp(eno));
			session.save(vehicle);
			tr.commit();
			break;
		case 3:
			System.out.println("UPDATION");
			System.out.println("-----------------------------");
			System.out.println("enter regNo");
			String regNo1 = sc.next();
			System.out.println("enter brand");
			String brand1 = sc.next();
			System.out.println("enter model");
			String model1 = sc.next();
			System.out.println("enter price");
			int price1 = sc.nextInt();
			System.out.println("enter eno");
			int eno1 = sc.nextInt();
			
			
			Vehicle vehicle1=session.get(Vehicle.class,regNo1);
			vehicle1.setRegno(regNo1);
			vehicle1.setBrand(brand1);
			vehicle1.setModel(model1);
			vehicle1.setPrice(price1);
			vehicle1.setEmp(new Emp(eno1));
			
			Transaction tr1 = session.beginTransaction();
			session.update(vehicle1);
			tr1.commit();
			System.out.println("\nRecord Updated");
			break;
		case 4:
			System.out.println("DELETION");
			System.out.println("-----------------------------");
			System.out.println("enter regNo");
			String regNo2 = sc.next();
			Vehicle vehicle2=session.get(Vehicle.class,regNo2);
			Transaction tr2 = session.beginTransaction();
			session.delete(vehicle2);
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
