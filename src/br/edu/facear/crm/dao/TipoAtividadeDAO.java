package br.edu.facear.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.TipoAtividade;
import br.edu.facear.crm.entity.TipoComunicador;

public class TipoAtividadeDAO implements InterfaceDAO<TipoAtividade>{
	EntityManager em = Connection.getEntityManager();

	@Override
	public void Cadastrar(TipoAtividade o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();				
	}

	@Override
	public List<TipoAtividade> Listar() {
		Query q = em.createQuery("select a from TipoAtividade a");
		
		return q.getResultList();
	}

	@Override
	public void Alterar(TipoAtividade o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();			
	}

	@Override
	public TipoAtividade BuscarID(Long id) {
		return em.find(TipoAtividade.class, id);	

	}

	@Override
	public void Excluir(TipoAtividade o) {
		em.getTransaction().begin();
		em.remove(o);
		em.getTransaction().commit();			
	}

}
