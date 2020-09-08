package com.mm.muka;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.mm.muka.config.JpaConfig;
import com.mm.muka.model.Employee;

public class CriteriaQueryMain {
	//static EntityManagerFactory factory = Persistence.createEntityManagerFactory("eclipselinkDemo");
    //static EntityManager  entityManager = factory.createEntityManager();
	 static EntityManager  entityManager = JpaConfig.getInstance();

	public static void main(String[] args) {
		//selectSomeField();
		filterRecords();
	}
	
	private static void selectSomeField(){
		CriteriaBuilder criteriaBuilder =entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Double> criteriaQuery = criteriaBuilder.createQuery(Double.class);
		Root<Employee> root = criteriaQuery.from(Employee.class);
		criteriaQuery.select(root.get("salary"));
		TypedQuery<Double>  typedQuery = entityManager.createQuery(criteriaQuery);
		List<Double> employees = typedQuery.getResultList();
		for(Double emp:employees)
			System.out.println(emp);
	}
	
	private static void filterRecords(){
		CriteriaBuilder criteriaBuilder =entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> root = criteriaQuery.from(Employee.class);
		criteriaQuery.where(criteriaBuilder.greaterThan(root.get("salary"), 25000));
		TypedQuery<Employee>  typedQuery = entityManager.createQuery(criteriaQuery);
		List<Employee> employees = typedQuery.getResultList();
		for(Employee emp:employees)
			System.out.println(emp);
	}

}
