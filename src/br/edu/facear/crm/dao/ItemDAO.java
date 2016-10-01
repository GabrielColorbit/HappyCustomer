package br.edu.facear.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Item;

public class ItemDAO implements InterfaceDAO<Item>{
	EntityManager em = Connection.getEntityManager();

	@Override
	public void salvar(Item o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();			
	}

	@Override
	public List<Item> listar() {
		Query q = em.createQuery("select a from Item a");
		
		return q.getResultList();
	}

	@Override
	public void editar(Item o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();			
	}

	@Override
	public Item getObjectById(Long id) {
		return em.find(Item.class, id);	

	}

	@Override
	public void excluir(Item o) {
		em.getTransaction().begin();
		em.remove(o);
		em.getTransaction().commit();			
	}

}
