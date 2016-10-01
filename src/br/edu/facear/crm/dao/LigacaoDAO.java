package br.edu.facear.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Atividade;
import br.edu.facear.crm.entity.Ligacao;

public class LigacaoDAO implements InterfaceDAO<Ligacao>{
	EntityManager em =  Connection.getEntityManager();
	@Override
	public void salvar(Ligacao o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();			
	}

	@Override
	public List<Ligacao> listar() {
		Query q = em.createQuery("select a from Ligacao a");
		
		return q.getResultList();
	}

	@Override
	public void editar(Ligacao o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();			
	}

	@Override
	public Ligacao getObjectById(Long id) {
		return em.find(Ligacao.class, id);	

	}

	@Override
	public void excluir(Ligacao o) {
		em.getTransaction().begin();
		em.remove(o);
		em.getTransaction().commit();				
	}

}
