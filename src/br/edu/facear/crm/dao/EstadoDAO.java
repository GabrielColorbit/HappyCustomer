package br.edu.facear.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Estado;

public class EstadoDAO implements InterfaceDAO<Estado> {

	// CONECTA AO BANCO
	EntityManager em = Connection.getEntityManager();

	// CADASTRAR
	@Override
	public void Cadastrar(Estado estado) throws CrmException {
		em.getTransaction().begin();
		em.persist(estado);
		em.getTransaction().commit();
	}

	// ALTERAR
	@Override
	public void Alterar(Estado estado) {
		em.getTransaction().begin();
		em.merge(estado);
		em.getTransaction().commit();
	}

	// EXCLUIR
	@Override
	public void Excluir(Estado estado) {
		em.getTransaction().begin();
		em.remove(estado);
		em.getTransaction().commit();
	}

	// LISTAR
	@Override
	public List<Estado> Listar() {
		Query q = em.createQuery("from Estado a order by id");
		return q.getResultList();
	}

	// BUSCAR ID
	@Override
	public Estado BuscarID(Long id) {
		return em.find(Estado.class, id);
	}
}