package com.wp.emp;

import java.util.List;

import org.hibernate.Session;

public class EmpSearch {

	public static void main(String[] args) {
		
		Session session=Util.getSF().openSession();
		Emp emp=session.get(Emp.class, 111);
		System.out.println("Employee No : "+emp.getEno());
		System.out.println("Employee Name : "+emp.getEname());
		System.out.println("Employee Salary : "+emp.getSal());
		System.out.println("Employee Laptop Code : "+emp.getLaptop().getCode());
		System.out.println("Employee Laptop Brand : "+emp.getLaptop().getBrand());
		System.out.println("Employee Laptop Price : "+emp.getLaptop().getPrice());
		
		List<Project> projects=emp.getProjects();
		for(Project project:projects){
			System.out.println(project.getPcode()+","+project.getPtitle()+","+project.getCost());
		
		}
		
		List<Vehicle> vehicles=emp.getVehicles();
		for(Vehicle vehicle:vehicles)
			System.out.println(vehicle.getRegno()+","+vehicle.getBrand()+","+vehicle.getModel()+","+vehicle.getPrice());

		session.close();
	}
}
