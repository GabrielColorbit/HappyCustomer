package br.edu.facear.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Estado;
import br.edu.facear.crm.entity.OrigemContato;

public class OrigemContatoDAO implements InterfaceDAO<OrigemContato> {
	EntityManager em = Connection.getEntityManager();
	@Override
	public void Cadastrar(OrigemContato origemcontato) throws CrmException {
		em.getTransaction().begin();
		em.persist(origemcontato);
		em.getTransaction().commit();		
	}

	@Override
	public List<OrigemContato> Listar() {
		Query q = em.createQuery("select a from OrigemContato a");
		return q.getResultList();
	}

	@Override
	public void Alterar(OrigemContato origemcontato) {
		em.getTransaction().begin();
		em.merge(origemcontato);
		em.getTransaction().commit();		
	}

	@Override
	public OrigemContato BuscarID(Long id) {
		return em.find(OrigemContato.class, id);	
	}
	@Override
	public void Excluir(OrigemContato origemcontato) {
		em.getTransaction().begin();
		em.remove(origemcontato);
		em.getTransaction().commit();			
	}

}
