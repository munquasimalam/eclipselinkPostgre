package com.mm.muka;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mm.muka.config.JpaConfig;
import com.mm.muka.model.Collage;
import com.mm.muka.model.Employee;

public class CrudeMain {
	 //static EntityManagerFactory factory = Persistence.createEntityManagerFactory("eclipselinkDemo");
    // static EntityManager  entityManager1 = factory.createEntityManager();
     static EntityManager  entityManager = JpaConfig.getInstance();

	public static void main(String[] args) {
		getById(2);
		//insertRecords();
		//updateRecord(10);
		//DeleteRecord(10);
		
		//fetchRecords();
    
	}
	
	public  static void insertRecords(){
		
	     entityManager.getTransaction().begin();
	     //entityManager.persist(new Collage(4,"kite 4"));
	    // entityManager.persist(new Employee("munna3",26000.50));
	     System.out.println("Inserted record:id 3 name kite");
	     entityManager.getTransaction().commit();
	    // entityManager.close();
	     //factory.close();
	}
	
	public static void fetchRecords(){
		
		    try {
		    	 entityManager.getTransaction().begin();
		        List<Collage> collages = entityManager.createQuery("SELECT l FROM Collage l", Collage.class).getResultList(); 

		        for (Collage c : collages)
		            System.out.println(c.getCid() + " " + c.getCname());
		        entityManager.getTransaction().commit();

		    } catch (Exception e) {
		        System.out.println(e.getMessage()); 
		    }
	}

	private static void getById(Integer id) {
		Collage c = entityManager.find(Collage.class, id);
		if(c!= null){
			System.out.println(c.getCname());
		} else {
			System.out.println("Employee not available in DB");
		}
		
	}
	public static void updateRecord(Integer cId){
		String collageName="collageName123";
		try{
		entityManager.getTransaction().begin();
		 Query query = entityManager.createQuery("UPDATE Collage c SET c.cname ='"+collageName+ "' WHERE c.cid=:cidParam");
         query.setParameter("cidParam", cId);
         query.executeUpdate();
         entityManager.getTransaction().commit();
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}
	}
	private static void DeleteRecord(Integer id){
		Collage collage = entityManager.find(Collage.class, id);

		entityManager.getTransaction().begin();
		entityManager.remove(collage);
		entityManager.getTransaction().commit();
	}

}
