package br.edu.facear.crm.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.controller.Configuration;

import br.edu.facear.crm.entity.Atividade;


public class AtividadeDAO implements InterfaceDAO<Atividade> {

	// CONECTA AO BANCO
	EntityManager em = Connection.getEntityManager();

	// CADASTRAR
	@Override
	public void Cadastrar(Atividade o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}

	// ALTERAR
	@Override
	public void Alterar(Atividade o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
	}

	// EXCLUIR
	@Override
	public void Excluir(Atividade o) {
		em.getTransaction().begin();
		Atividade atividade = em.merge(o);
		em.remove(atividade);
		em.getTransaction().commit();
	}

	// LISTAR
	@Override
	public ArrayList<Atividade> Listar() {
		Query q = em.createQuery("from Atividade a order by id");
		return (ArrayList<Atividade>) q.getResultList();
	}

	// BUSCAR ID
	@Override
	public Atividade BuscarID(Long id) {
		return em.find(Atividade.class, id);
	}
}