package com.wp.emp;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Entity;

@Entity
public class Laptop {
	
	@Id
	private String code;
	private String brand;
	private int price;
	
	@OneToOne(mappedBy = "laptop")
	private Emp emp;
	
	
	
	public Laptop(String code, String brand, int price) {
		super();
		this.code = code;
		this.brand = brand;
		this.price = price;
	}
	public Laptop() {
		super();
	}
	
	public Laptop(String code) {
		super();
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	@Override
	public String toString() {
		return "Laptop [code=" + code + ", brand=" + brand + ", price=" + price + ", emp=" + emp + "]";
	}
	
}
