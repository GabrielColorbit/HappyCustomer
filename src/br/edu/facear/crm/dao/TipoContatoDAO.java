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
	public void Cadastrar(TipoContato tipocontato) throws CrmException {
		em.getTransaction().begin();
		em.persist(tipocontato);
		em.getTransaction().commit();
	}

	// ALTERAR
	@Override
	public void Alterar(TipoContato tipocontato) {
		em.getTransaction().begin();
		em.merge(tipocontato);
		em.getTransaction().commit();
	}

	// EXCLUIR
	@Override
	public void Excluir(TipoContato tipocontato) {
		em.getTransaction().begin();
		em.remove(tipocontato);
		em.getTransaction().commit();
	}

	// LISTAR
	@Override
	public ArrayList<TipoContato> Listar() {
		Query tipocontato = em.createQuery("from TipoContato a order by id");

		return (ArrayList<TipoContato>) tipocontato.getResultList();
	}

	// BUSCAR ID
	@Override
	public TipoContato BuscarID(Long tipocontato) {
		return em.find(TipoContato.class, tipocontato );

	}

}