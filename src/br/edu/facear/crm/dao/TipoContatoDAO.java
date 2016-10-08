package br.edu.facear.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Estado;
import br.edu.facear.crm.entity.TipoContato;

public class TipoContatoDAO implements InterfaceDAO<TipoContato>{
	EntityManager em = Connection.getEntityManager();
	@Override
	public void Cadastrar(TipoContato tipocontato) throws CrmException {
		em.getTransaction().begin();
		em.persist(tipocontato);
		em.getTransaction().commit();		
	}

	@Override
	public List<TipoContato> Listar() {
		Query q = em.createQuery("select a from TipoContato a");
		
		return q.getResultList();
	}

	@Override
	public void Alterar(TipoContato tipocontato) {
		em.getTransaction().begin();
		em.merge(tipocontato);
		em.getTransaction().commit();		
	}

	@Override
	public TipoContato BuscarID(Long id) {
		return em.find(TipoContato.class, id);	

	}

	@Override
	public void Excluir(TipoContato tipocontato) {
		em.getTransaction().begin();
		em.remove(tipocontato);
		em.getTransaction().commit();			
	}

}
