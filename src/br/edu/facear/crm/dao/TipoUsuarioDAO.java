package br.edu.facear.crm.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.TipoUsuario;

public class TipoUsuarioDAO implements InterfaceDAO<TipoUsuario> {

	// CONECTA AO BANCO
	EntityManager em = Connection.getEntityManager();

	// CADASTRAR
	@Override
	public void Cadastrar(TipoUsuario o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}

	// ALTERAR
	@Override
	public void Alterar(TipoUsuario o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
	}

	// EXCLUIR
	@Override
	public void Excluir(TipoUsuario o) {
		em.getTransaction().begin();
		TipoUsuario tipousuario = em.merge(o);
		em.remove(tipousuario);
		em.getTransaction().commit();
	}

	// LISTAR
	@Override
	public ArrayList<TipoUsuario> Listar() {
		Query q = em.createQuery("from TipoUsuario a order by id");
		return (ArrayList<TipoUsuario>) q.getResultList();
	}

	// BUSCAR ID
	@Override
	public TipoUsuario BuscarID(Long id) {
		return em.find(TipoUsuario.class, id);
	}
}