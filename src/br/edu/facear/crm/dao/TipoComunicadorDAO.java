package br.edu.facear.crm.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.TipoComunicador;

public class TipoComunicadorDAO implements InterfaceDAO<TipoComunicador> {

	// CONECTA AO BANCO
	EntityManager em = Connection.getEntityManager();

	// CADASTRAR
	@Override
	public void Cadastrar(TipoComunicador o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}

	// ALTERAR
	@Override
	public void Alterar(TipoComunicador o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
	}

	// EXCLUIR
	@Override
	public void Excluir(TipoComunicador o) {
		em.getTransaction().begin();
		TipoComunicador tipocomunicador = em.merge(o);
		em.remove(tipocomunicador);
		em.getTransaction().commit();
	}

	// LISTAR
	@Override
	public ArrayList<TipoComunicador> Listar() {
		Query q = em.createQuery("from TipoComunicador a order by id");
		return (ArrayList<TipoComunicador>) q.getResultList();
	}

	// BUSCAR ID
	@Override
	public TipoComunicador BuscarID(Long id) {
		return em.find(TipoComunicador.class, id);
	}
}