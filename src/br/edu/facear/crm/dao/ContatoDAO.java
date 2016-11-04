package br.edu.facear.crm.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Contato;

public class ContatoDAO implements InterfaceDAO<Contato> {

	// CONECTA AO BANCO
	EntityManager em = Connection.getEntityManager();

	// CADASTRAR
	@Override
	public void Cadastrar(Contato o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}

	// ALTERAR
	@Override
	public void Alterar(Contato o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
	}

	// EXCLUIR
	@Override
	public void Excluir(Contato o) {
		em.getTransaction().begin();
		Contato contato = em.merge(o);
		em.remove(contato);
		em.getTransaction().commit();
	}

	// LISTAR
	@Override
	public ArrayList<Contato> Listar() {
		Query q = em.createQuery("from Contato a order by id");
		return (ArrayList<Contato>) q.getResultList();
	}

	// BUSCAR ID
	@Override
	public Contato BuscarID(Long id) {
		return em.find(Contato.class, id);
	}
}