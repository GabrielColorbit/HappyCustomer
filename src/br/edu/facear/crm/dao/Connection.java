package br.edu.facear.crm.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
	static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("CRM_Feliz");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
