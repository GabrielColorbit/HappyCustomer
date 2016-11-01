package br.edu.facear.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.OrigemContato;

public class OrigemContatoDAO implements InterfaceDAO<OrigemContato> {

	// CONECTA AO BANCO
	EntityManager em = Connection.getEntityManager();

	// CADASTRAR
	@Override
	public void Cadastrar(OrigemContato o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}

	// ALTERAR
	@Override
	public void Alterar(OrigemContato o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
	}

	// EXCLUIR
	@Override
	public void Excluir(OrigemContato o) {
		em.getTransaction().begin();
		em.remove(o);
		em.getTransaction().commit();
	}

	// LISTAR
	@Override
	public List<OrigemContato> Listar() {
		Query q = em.createQuery("from OrigemContato a order by id");
		return q.getResultList();
	}

	// BUSCAR ID
	@Override
	public OrigemContato BuscarID(Long id) {
		return em.find(OrigemContato.class, id);
	}
}