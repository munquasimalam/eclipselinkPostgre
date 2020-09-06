package com.mm.muka;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

	public static void main(String[] args) {
		
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("eclipselinkDemo");
     EntityManager  entityManager = factory.createEntityManager();
     entityManager.getTransaction().begin();
     entityManager.persist(new Collage(2,"aiet2"));
     entityManager.getTransaction().commit();
     entityManager.close();
     factory.close();
    
	}

}
