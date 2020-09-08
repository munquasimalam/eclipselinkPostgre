package com.mm.muka.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Employee implements Serializable {
	@Id
//	@SequenceGenerator(name="employee_eId_generator",sequenceName="employee_seq",allocationSize=1,initialValue=20)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="employee_eId_generator")
//	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long eId;
	private String name;
	private double salary;
	
	// bi directiona many to many  association to address
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="employeeAddress",joinColumns={
	@JoinColumn(name="eId")		
	},
	inverseJoinColumns={
			@JoinColumn(name="aId")
	}
			)
	private List<Address> addressList;
	
	
	public Employee() {
		super();
	}


	public Employee(String name, double salary, List<Address> addressList) {
		super();
		this.name = name;
		this.salary = salary;
		this.addressList = addressList;
	}

	

	public long geteId() {
		return eId;
	}


	public void seteId(long eId) {
		this.eId = eId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public List<Address> getAddressList() {
		return addressList;
	}


	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	

}
