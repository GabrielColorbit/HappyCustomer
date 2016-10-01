package br.edu.facear.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Negocio;

public class NegocioDAO implements InterfaceDAO<Negocio>{
	EntityManager em = Connection.getEntityManager();

	@Override
	public void salvar(Negocio o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();			
	}

	@Override
	public List<Negocio> listar() {
		Query q = em.createQuery("select a from Negocio a");
		
		return q.getResultList();	
	}

	@Override
	public void editar(Negocio o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();			
	}

	@Override
	public Negocio getObjectById(Long id) {
		return em.find(Negocio.class, id);	

	}

	@Override
	public void excluir(Negocio o) {
		em.getTransaction().begin();
		em.remove(o);
		em.getTransaction().commit();			
	}

}
