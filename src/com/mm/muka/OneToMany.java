package com.mm.muka;

import javax.persistence.EntityManager;

import com.mm.muka.config.JpaConfig;
import com.mm.muka.model.Book;
import com.mm.muka.model.Page;

public class OneToMany {
	  static EntityManager  entityManager = JpaConfig.getInstance();


	public static void main(String[] args) {
		
		entityManager.getTransaction().begin();
		// create a new book
        Book book = new Book("Java 101", "Alam", "123456");
        entityManager.persist(book);
        entityManager.persist( new Page(1, "Introduction contents", "Introduction", book));
        entityManager.persist( new Page(2, "Introduction contents2", "Introduction2", book));
        entityManager.persist( new Page(2, "Introduction contents3", "Introduction3", book));
        
        entityManager.getTransaction().commit();
        

	}

}
