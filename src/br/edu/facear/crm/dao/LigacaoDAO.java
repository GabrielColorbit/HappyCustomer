package br.edu.facear.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Ligacao;

public class LigacaoDAO implements InterfaceDAO<Ligacao> {

	// CONECTA AO BANCO
	EntityManager em = Connection.getEntityManager();

	// CADASTRAR
	@Override
	public void Cadastrar(Ligacao o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}

	// ALTERAR
	@Override
	public void Alterar(Ligacao o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
	}

	// EXCLUIR
	@Override
	public void Excluir(Ligacao o) {
		em.getTransaction().begin();
		em.remove(o);
		em.getTransaction().commit();
	}

	// LISTAR
	@Override
	public List<Ligacao> Listar() {
		Query q = em.createQuery("from Ligacao a order by id");
		return q.getResultList();
	}

	// BUSCAR ID
	@Override
	public Ligacao BuscarID(Long id) {
		return em.find(Ligacao.class, id);
	}
}