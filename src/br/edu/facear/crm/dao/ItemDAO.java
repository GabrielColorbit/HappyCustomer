package br.edu.facear.crm.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Item;

public class ItemDAO implements InterfaceDAO<Item> {

	// CONECTA AO BANCO
	EntityManager em = Connection.getEntityManager();

	// CADASTRAR
	@Override
	public void Cadastrar(Item o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}

	// ALTERAR
	@Override
	public void Alterar(Item o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
	}

	// EXCLUIR
	@Override
	public void Excluir(Item o) {
		em.getTransaction().begin();
		Item item = em.merge(o);
		em.remove(item);
		em.getTransaction().commit();
	}

	// LISTAR
	@Override
	public ArrayList<Item> Listar() {
		Query q = em.createQuery("from Item a order by id");
		return (ArrayList<Item>) q.getResultList();
	}

	// BUSCAR ID
	@Override
	public Item BuscarID(Long id) {
		return em.find(Item.class, id);
	}
}