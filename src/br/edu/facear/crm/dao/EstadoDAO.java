package br.edu.facear.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Estado;


public class EstadoDAO implements InterfaceDAO<Estado>{
	EntityManager em = Connection.getEntityManager();
	@Override
public void salvar(Estado estado) 	throws CrmException {
		em.getTransaction().begin();
		em.persist(estado);
		em.getTransaction().commit();
	}

	@Override
	public List<Estado> listar() {
		
		Query q = em.createQuery("select a from Estado a");
		
		return q.getResultList();
	}

	@Override
	public void editar(Estado estado) {
		em.getTransaction().begin();
		em.merge(estado);
		em.getTransaction().commit();
	}

	@Override
	public Estado getObjectById(Long id) {
		return em.find(Estado.class, id);	
	}

	@Override
	public void excluir(Estado estado) {
		em.getTransaction().begin();
		em.remove(estado);
		em.getTransaction().commit();		
	}

}
