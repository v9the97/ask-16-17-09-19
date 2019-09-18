package com.wp.emp;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ProjectCRUD {

	public static void main(String ar[]) {
	SessionFactory sf=Util.getSF();
	Session session=sf.openSession();
	
	Scanner sc = new Scanner(System.in);
	
	
	System.	out.println("=============================");
	System.out.println("OPTION - 1.READ ");
	System.out.println("OPTION - 2.INSERTION ");
	System.out.println("OPTION - 3.UPDATION ");
	System.out.println("OPTION - 4.DELETION");
	System.out.println("=============================");
	int choice = sc.nextInt();

	switch(choice) {
		case 1:
		
		@SuppressWarnings("deprecation") Criteria cr = session.createCriteria(Project.class);
		@SuppressWarnings("unchecked") List<Project> list = cr.list();
		for(Project project : list)
		{
			
			System.out.println("Project code : "+project.getPcode());
			System.out.println("Project Title : "+project.getPtitle());
			System.out.println("Project Cost : "+project.getCost());
			
			List<Emp> emp=project.getEmployees();
			for(Emp employee:emp){
				System.out.println(employee.getEno()+","+employee.getEname()+","+employee.getSal());
			
			}
			System.out.println("..........................");
			
			
		}
		break;
	case 2:
		System.out.println("INSERTION");
		System.out.println("-----------------------------");
		System.out.println("enter pcode");
		String pcode = sc.next();
		System.out.println("enter ptitle");
		String ptitle = sc.next();
		System.out.println("enter cost");
		int price = sc.nextInt();

		Transaction tr = session.beginTransaction();
		Project project=new Project(pcode,ptitle,price);
		session.save(project);
		tr.commit();
		break;
	case 3:
		System.out.println("UPDATION");
		System.out.println("-----------------------------");
		System.out.println("enter pcode");
		String pcode1 = sc.next();
		System.out.println("enter ptitle");
		String ptitle1 = sc.next();
		System.out.println("enter cost");
		int price1 = sc.nextInt();
		
		
		Project project1=session.get(Project.class,pcode1);
		project1.setPcode(pcode1);
		project1.setPtitle(ptitle1);
		project1.setCost(price1);
		
		Transaction tr1 = session.beginTransaction();
		session.update(project1);
		tr1.commit();
		System.out.println("\nRecord Updated");
		break;
	case 4:
		System.out.println("DELETION");
		System.out.println("-----------------------------");
		System.out.println("enter pcode");
		String pcode2 = sc.next();
		Project project2=session.get(Project.class,pcode2);
		Transaction tr2 = session.beginTransaction();
		session.delete(project2);
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
