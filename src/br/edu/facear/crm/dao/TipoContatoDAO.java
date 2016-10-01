package br.edu.facear.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Estado;
import br.edu.facear.crm.entity.TipoContato;

public class TipoContatoDAO implements InterfaceDAO<TipoContato>{
	EntityManager em = Connection.getEntityManager();
	@Override
	public void salvar(TipoContato tipocontato) throws CrmException {
		em.getTransaction().begin();
		em.persist(tipocontato);
		em.getTransaction().commit();		
	}

	@Override
	public List<TipoContato> listar() {
		Query q = em.createQuery("select a from TipoContato a");
		
		return q.getResultList();
	}

	@Override
	public void editar(TipoContato tipocontato) {
		em.getTransaction().begin();
		em.merge(tipocontato);
		em.getTransaction().commit();		
	}

	@Override
	public TipoContato getObjectById(Long id) {
		return em.find(TipoContato.class, id);	

	}

	@Override
	public void excluir(TipoContato tipocontato) {
		em.getTransaction().begin();
		em.remove(tipocontato);
		em.getTransaction().commit();			
	}

}
