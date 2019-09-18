package com.wp.emp;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {


		@Id
		private String pcode;
		private String ptitle;
		private int cost;
		
		@ManyToMany(mappedBy="projects")
		List<Emp> employees=new ArrayList<Emp>();
		
		public String getPcode() {
			return pcode;
		}
		public void setPcode(String pcode) {
			this.pcode = pcode;
		}
		public String getPtitle() {
			return ptitle;
		}
		public void setPtitle(String ptitle) {
			this.ptitle = ptitle;
		}
		public int getCost() {
			return cost;
		}
		public void setCost(int cost) {
			this.cost = cost;
		}
		public Project(String pcode, String ptitle, int cost) {
			super();
			this.pcode = pcode;
			this.ptitle = ptitle;
			this.cost = cost;
		}
		public Project(String pcode) {
			super();
			this.pcode = pcode;
		}
		public Project() {
			super();
		}
		public List<Emp> getEmployees() {
			return employees;
		}
		public void setEmployees(List<Emp> employees) {
			this.employees = employees;
		}
		
		
}
