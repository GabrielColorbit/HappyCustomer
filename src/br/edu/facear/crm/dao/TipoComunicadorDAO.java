package br.edu.facear.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.TipoComunicador;
import br.edu.facear.crm.entity.TipoContato;

public class TipoComunicadorDAO implements InterfaceDAO<TipoComunicador>{
	EntityManager em = Connection.getEntityManager();
	@Override
	public void Cadastrar(TipoComunicador o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();			
	}

	@Override
	public List<TipoComunicador> Listar() {
		Query q = em.createQuery("select a from TipoComunicador a");
		
		return q.getResultList();
	}

	@Override
	public void Alterar(TipoComunicador o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();			
	}

	@Override
	public TipoComunicador BuscarID(Long id) {
		return em.find(TipoComunicador.class, id);	
	}

	@Override
	public void Excluir(TipoComunicador o) {
		em.getTransaction().begin();
		em.remove(o);
		em.getTransaction().commit();	
		
	}

}
