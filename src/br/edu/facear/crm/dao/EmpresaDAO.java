package br.edu.facear.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Empresa;

public class EmpresaDAO implements InterfaceDAO<Empresa> {
	EntityManager em = Connection.getEntityManager();
	@Override
	public void Cadastrar(Empresa o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();		
	}

	@Override
	public List<Empresa> Listar() {
		Query q = em.createQuery("select a from Empresa a");
		
		return q.getResultList();
	}

	@Override
	public void Alterar(Empresa o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();			
	}

	@Override
	public Empresa BuscarID(Long id) {
		return em.find(Empresa.class, id);	

	}

	@Override
	public void Excluir(Empresa o) {
		em.getTransaction().begin();
		em.remove(o);
		em.getTransaction().commit();			
	}

}
