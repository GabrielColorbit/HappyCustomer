package br.edu.facear.crm.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Comunicador;

public class ComunicadorDAO implements InterfaceDAO<Comunicador> {

	// CONECTA AO BANCO
	EntityManager em = Connection.getEntityManager();

	// CADASTRAR
	@Override
	public void Cadastrar(Comunicador o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}

	// ALTERAR
	@Override
	public void Alterar(Comunicador o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
	}

	// EXCLUIR
	@Override
	public void Excluir(Comunicador o) {
		em.getTransaction().begin();
		Comunicador comunicador = em.merge(o);
		em.remove(comunicador);
		em.getTransaction().commit();

	}

	// LISTAR
	@Override
	public ArrayList<Comunicador> Listar() {
		Query q = em.createQuery("from Comunicador a order by id");
		return (ArrayList<Comunicador>) q.getResultList();
	}

	// BUSCAR ID
	@Override
	public Comunicador BuscarID(Long id) {
		return em.find(Comunicador.class, id);
	}
}