package com.wp.emp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Emp {

		@Id
		private int eno;
		private String ename;
		private int sal;
		
		@OneToOne//(fetch=FetchType.LAZY)
		private Laptop laptop;
		
		@OneToMany(mappedBy = "emp",fetch=FetchType.LAZY)
		private List<Vehicle> vehicles=new ArrayList<Vehicle>();
		
		@ManyToMany
		private List<Project> projects=new ArrayList<Project>();
		
		
		
	
		public List<Vehicle> getVehicles() {
			return vehicles;
		}
		public void setVehicles(List<Vehicle> vehicles) {
			this.vehicles = vehicles;
		}
		public Emp(int eno) {
			super();
			this.eno = eno;
		}
		public List<Project> getProjects() {
			return projects;
		}
		public void setProjects(List<Project> projects) {
			this.projects = projects;
		}
	
		public Laptop getLaptop() {
			return laptop;
		}
		public void setLaptop(Laptop laptop) {
			this.laptop = laptop;
		}
		public int getEno() {
			return eno;
		}
		public void setEno(int eno) {
			this.eno = eno;
		}
		public String getEname() {
			return ename;
		}
		public void setEname(String ename) {
			this.ename = ename;
		}
		public int getSal() {
			return sal;
		}
		public void setSal(int sal) {
			this.sal = sal;
		}
		public Emp(int eno, String ename, int sal) {
			super();
			this.eno = eno;
			this.ename = ename;
			this.sal = sal;
		}
		public Emp() {
			super();
		}
		
		public Emp(int eno, String ename, int sal, Laptop laptop) {
			super();
			this.eno = eno;
			this.ename = ename;
			this.sal = sal;
			this.laptop = laptop;
		}
		public Emp(int eno, String ename, int sal, Laptop laptop, List<Vehicle> vehicles, List<Project> projects) {
			super();
			this.eno = eno;
			this.ename = ename;
			this.sal = sal;
			this.laptop = laptop;
			this.vehicles = vehicles;
			this.projects = projects;
		}
		@Override
		public String toString() {
			return "Emp [eno=" + eno + ", ename=" + ename + ", sal=" + sal + ", laptop=" + laptop + ", vehicles="
					+ vehicles + ", projects=" + projects + "]";
		}
		
		
		

	}


