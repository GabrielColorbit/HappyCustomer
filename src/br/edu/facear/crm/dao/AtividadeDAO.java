package br.edu.facear.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Atividade;
import br.edu.facear.crm.entity.Empresa;

public class AtividadeDAO implements InterfaceDAO<Atividade>{
	
	EntityManager em = Connection.getEntityManager();
	
	@Override
	public void Cadastrar(Atividade o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();	
	}

	@Override
	public List<Atividade> Listar() {
		Query q = em.createQuery("from Atividade a");		
		return q.getResultList();
	}

	@Override
	public void Alterar(Atividade o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();			
	}

	@Override
	public Atividade BuscarID(Long id) {
		return em.find(Atividade.class, id);	
	}

	@Override
	public void Excluir(Atividade o) {
		em.getTransaction().begin();
		em.remove(o);
		
		em.getTransaction().commit();			
	}
}