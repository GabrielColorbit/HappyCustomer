package br.edu.facear.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.TipoComunicador;
import br.edu.facear.crm.entity.TipoContato;

public class TipoComunicadorDAO implements InterfaceDAO<TipoComunicador>{
	EntityManager em = Connection.getEntityManager();
	@Override
	public void salvar(TipoComunicador o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();			
	}

	@Override
	public List<TipoComunicador> listar() {
		Query q = em.createQuery("select a from TipoComunicador a");
		
		return q.getResultList();
	}

	@Override
	public void editar(TipoComunicador o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();			
	}

	@Override
	public TipoComunicador getObjectById(Long id) {
		return em.find(TipoComunicador.class, id);	
	}

	@Override
	public void excluir(TipoComunicador o) {
		em.getTransaction().begin();
		em.remove(o);
		em.getTransaction().commit();	
		
	}

}
