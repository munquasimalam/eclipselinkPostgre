package com.mm.muka.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Address  implements Serializable{
	@Id
	//@SequenceGenerator(name="address_aId_generator",sequenceName="address_seq",allocationSize=1,initialValue=20)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="address_aId_generator")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer aId;
	private String houseNo;
	private String streetNo;
	private String location;
	private String state;
	
	@ManyToMany(mappedBy="addressList")
	List<Employee> employeeList;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String houseNo, String streetNo, String location,
			String state, List<Employee> employeeList) {
		super();
		this.houseNo = houseNo;
		this.streetNo = streetNo;
		this.location = location;
		this.state = state;
		this.employeeList = employeeList;
	}

	public Integer getaId() {
		return aId;
	}

	public void setaId(Integer aId) {
		this.aId = aId;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	

}
