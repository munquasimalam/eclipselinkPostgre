package com.mm.muka.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaConfig {
	
	private static EntityManager entitymanager;
	private JpaConfig(){
	}
	private static EntityManagerFactory createEntityManagerFactory(){
		return Persistence.createEntityManagerFactory("eclipselinkDemo");
	}
	public static EntityManager getInstance(){
		return createEntityManagerFactory().createEntityManager();	
	}
	
}
