package br.edu.facear.crm.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.TipoAtividade;

public class TipoAtividadeDAO implements InterfaceDAO<TipoAtividade> {

	// CONECTA AO BANCO
	EntityManager em = Connection.getEntityManager();

	// CADASTRAR
	@Override
	public void Cadastrar(TipoAtividade o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}

	// ALTERAR
	@Override
	public void Alterar(TipoAtividade o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
	}

	// EXCLUIR
	@Override
	public void Excluir(TipoAtividade o) {
		em.getTransaction().begin();
		TipoAtividade tipoatividade = em.merge(o);
		em.remove(tipoatividade);
		em.getTransaction().commit();
	}

	// LISTAR
	@Override
	public ArrayList<TipoAtividade> Listar() {
		Query q = em.createQuery("from TipoAtividade a order by id");
		return (ArrayList<TipoAtividade>) q.getResultList();
	}

	// BUSCAR ID
	@Override
	public TipoAtividade BuscarID(Long id) {
		return em.find(TipoAtividade.class, id);
	}
}