package br.edu.facear.crm.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Cidade;

public class CidadeDAO implements InterfaceDAO<Cidade> {

	// CONECTA AO BANCO
	EntityManager em = Connection.getEntityManager();

	// CADASTRAR
	@Override
	public void Cadastrar(Cidade o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}

	// ALTERAR
	@Override
	public void Alterar(Cidade o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
	}

	// EXCLUIR
	@Override
	public void Excluir(Cidade o) {
		em.getTransaction().begin();
		Cidade cidade = em.merge(o);
		em.remove(cidade);
		em.getTransaction().commit();
	}

	// LISTAR
	@Override
	public ArrayList<Cidade> Listar() {
		Query q = em.createQuery("from Cidade a order by id");
		return (ArrayList<Cidade>) q.getResultList();
	}

	// BUSCAR ID
	@Override
	public Cidade BuscarID(Long id) {
		return em.find(Cidade.class, id);
	}
}