package br.edu.facear.crm.dao;

import java.util.List;

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
		em.remove(o);
		em.getTransaction().commit();
	}

	// LISTAR
	@Override
	public List<TipoAtividade> Listar() {
		Query q = em.createQuery("from TipoAtividade a order by id");
		return q.getResultList();
	}

	// BUSCAR ID
	@Override
	public TipoAtividade BuscarID(Long id) {
		return em.find(TipoAtividade.class, id);
	}
}