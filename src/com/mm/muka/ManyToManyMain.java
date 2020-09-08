package com.mm.muka;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.mm.muka.config.JpaConfig;
import com.mm.muka.model.Address;
import com.mm.muka.model.Employee;

public class ManyToManyMain {
	  static EntityManager  entityManager = JpaConfig.getInstance();


	public static void main(String[] args) {
		Employee emp = new Employee();
		//emp.seteId(100);
		emp.setName("munna");
		emp.setSalary(30000);
		
		Address add = new Address();
		//add.setaId(10);
		add.setHouseNo("a2/82");
		add.setStreetNo("14");
		add.setLocation("Delhi");
		add.setState("new Delhi");
		
		List<Employee> empList = new ArrayList<>();
		empList.add(emp);
		
		List<Address> addressList = new ArrayList<>();
		addressList.add(add);
		
		add.setEmployeeList(empList);
		emp.setAddressList(addressList);
		
		entityManager.getTransaction().begin();
		entityManager.persist(emp);
		System.out.println("saved Employee successfully.");
		entityManager.getTransaction().commit();
		

	}

}
