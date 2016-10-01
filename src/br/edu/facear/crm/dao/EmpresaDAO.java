package br.edu.facear.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Empresa;

public class EmpresaDAO implements InterfaceDAO<Empresa> {
	EntityManager em = Connection.getEntityManager();
	@Override
	public void salvar(Empresa o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();		
	}

	@Override
	public List<Empresa> listar() {
		Query q = em.createQuery("select a from Empresa a");
		
		return q.getResultList();
	}

	@Override
	public void editar(Empresa o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();			
	}

	@Override
	public Empresa getObjectById(Long id) {
		return em.find(Empresa.class, id);	

	}

	@Override
	public void excluir(Empresa o) {
		em.getTransaction().begin();
		em.remove(o);
		em.getTransaction().commit();			
	}

}
