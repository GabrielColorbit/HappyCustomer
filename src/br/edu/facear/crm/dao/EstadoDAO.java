package br.edu.facear.crm.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Estado;

public class EstadoDAO implements InterfaceDAO<Estado> {

	// CONECTA AO BANCO
	EntityManager em = Connection.getEntityManager();

	// CADASTRAR
	@Override
	public void Cadastrar(Estado o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}

	// ALTERAR
	@Override
	public void Alterar(Estado o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
	}

	// EXCLUIR
	@Override
	public void Excluir(Estado o) {
		em.getTransaction().begin();
		Estado estado = em.merge(o);
		em.remove(estado);
		em.getTransaction().commit();
	}

	// LISTAR
	@Override
	public ArrayList<Estado> Listar() {
		Query q = em.createQuery("from Estado a order by id");
		return (ArrayList<Estado>) q.getResultList();
	}

	// BUSCAR ID
	@Override
	public Estado BuscarID(Long id) {
		return em.find(Estado.class, id);
	}
}