package br.edu.facear.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Atividade;
import br.edu.facear.crm.entity.Empresa;

public class AtividadeDAO implements InterfaceDAO<Atividade>{
	EntityManager em = Connection.getEntityManager();
	@Override
	public void salvar(Atividade o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();	
		
	}

	@Override
	public List<Atividade> listar() {
		Query q = em.createQuery("select a from Atividade a");
		
		return q.getResultList();
	}

	@Override
	public void editar(Atividade o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();			
	}

	@Override
	public Atividade getObjectById(Long id) {
		return em.find(Atividade.class, id);	
	}

	@Override
	public void excluir(Atividade o) {
		em.getTransaction().begin();
		em.remove(o);
		em.getTransaction().commit();			
	}

}
