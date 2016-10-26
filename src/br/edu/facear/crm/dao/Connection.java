package br.edu.facear.crm.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
	static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("CRM_Feliz");
	//consegui arrumar aqui, agora está funcionando 100 por cento.
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
