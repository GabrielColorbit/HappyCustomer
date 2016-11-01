package br.edu.facear.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.edu.facear.crm.entity.TipoTelefone;

public class TipoTelefoneDAO implements InterfaceDAO<TipoTelefone> {

	// CONECTA AO BANCO
	EntityManager em = Connection.getEntityManager();

	// CADASTRAR
	@Override
	public void Cadastrar(TipoTelefone o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}

	// ALTERAR
	@Override
	public void Alterar(TipoTelefone o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
	}

	// EXCLUIR
	@Override
	public void Excluir(TipoTelefone o) {
		em.getTransaction().begin();
		em.remove(o);
		em.getTransaction().commit();
	}

	// LISTAR
	@Override
	public List<TipoTelefone> Listar() {
		Query q = em.createQuery("from TipoTelefone a order by id");
		return q.getResultList();
	}

	// BUSCAR ID
	@Override
	public TipoTelefone BuscarID(Long id) {
		return em.find(TipoTelefone.class, id);
	}
}