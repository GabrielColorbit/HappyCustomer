package br.edu.facear.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Comunicador;

public class ComunicadorDAO implements InterfaceDAO<Comunicador>{
	EntityManager em = Connection.getEntityManager();
	@Override
	public void Cadastrar(Comunicador o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();	
	}

	@Override
	public List<Comunicador> Listar() {
		Query q = em.createQuery("select a from Comunicador a");
		
		return q.getResultList();
	}

	@Override
	public void Alterar(Comunicador o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();			
	}

	@Override
	public Comunicador BuscarID(Long id) {
		return em.find(Comunicador.class, id);	
	}

	@Override
	public void Excluir(Comunicador o) {
		em.getTransaction().begin();
		em.remove(o);
		em.getTransaction().commit();	
		
	}
}