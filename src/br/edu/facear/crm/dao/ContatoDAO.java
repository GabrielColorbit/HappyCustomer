package br.edu.facear.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Contato;
import br.edu.facear.crm.entity.Estado;

public class ContatoDAO implements InterfaceDAO<Contato> {
	EntityManager em = Connection.getEntityManager();
	@Override
	public void salvar(Contato contato) throws CrmException {
		em.getTransaction().begin();
		em.persist(contato);
		em.getTransaction().commit();
	}

	@Override
	public List<Contato> listar() {
		Query q = em.createQuery("select a from Contato a");
	
		return q.getResultList();
	}

	@Override
	public void editar(Contato contato) {
		em.getTransaction().begin();
		em.merge(contato);
		em.getTransaction().commit();		
	}

	@Override
	public Contato getObjectById(Long id) {
		return em.find(Contato.class, id);	
	}

	@Override
	public void excluir(Contato contato) {
		em.getTransaction().begin();
		em.remove(contato);
		em.getTransaction().commit();		
	}
	
}
