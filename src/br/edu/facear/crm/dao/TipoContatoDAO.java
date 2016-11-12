package br.edu.facear.crm.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.TipoContato;

public class TipoContatoDAO implements InterfaceDAO<TipoContato> {

	// CONECTA AO BANCO
	EntityManager em = Connection.getEntityManager();

	// CADASTRAR
	@Override
	public void Cadastrar(TipoContato o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}

	// ALTERAR
	@Override
	public void Alterar(TipoContato o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
	}

	// EXCLUIR
	@Override
	public void Excluir(TipoContato o) {
		em.getTransaction().begin();
		TipoContato tipocontato = em.merge(o);
		em.remove(tipocontato);
		em.getTransaction().commit();
	}

	// LISTAR
	@Override
	public ArrayList<TipoContato> Listar() {
		Query q = em.createQuery("from TipoContato a order by id");
		return (ArrayList<TipoContato>) q.getResultList();
	}

	// BUSCAR ID
	@Override
	public TipoContato BuscarID(Long id) {
		return em.find(TipoContato.class, id);
	}
}