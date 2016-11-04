package br.edu.facear.crm.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Telefone;
import br.edu.facear.crm.entity.TipoComunicador;

public class TelefoneDAO implements InterfaceDAO<Telefone> {

	// CONECTA AO BANCO
	EntityManager em = Connection.getEntityManager();

	// CADASTRAR
	@Override
	public void Cadastrar(Telefone o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}

	// ALTERAR
	@Override
	public void Alterar(Telefone o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
	}

	// EXCLUIR
	@Override
	public void Excluir(Telefone o) {
		em.getTransaction().begin();
		Telefone telefone = em.merge(o);
		em.remove(telefone);
		em.getTransaction().commit();
	}

	// LISTAR
	@Override
	public ArrayList<Telefone> Listar() {
		Query q = em.createQuery("from Telefone a order by id");
		return (ArrayList<Telefone>) q.getResultList();
	}

	// BUSCAR ID
	@Override
	public Telefone BuscarID(Long id) {
		return em.find(Telefone.class, id);
	}
}