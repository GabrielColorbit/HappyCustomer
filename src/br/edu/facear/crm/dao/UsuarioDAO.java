package br.edu.facear.crm.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.TipoComunicador;
import br.edu.facear.crm.entity.Usuario;

public class UsuarioDAO implements InterfaceDAO<Usuario> {

	// CONECTA AO BANCO
	EntityManager em = Connection.getEntityManager();

	// CADASTRAR
	@Override
	public void Cadastrar(Usuario o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}

	// ALTERAR
	@Override
	public void Alterar(Usuario o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
	}

	// EXCLUIR
	@Override
	public void Excluir(Usuario o) {
		em.getTransaction().begin();
		Usuario usuario = em.merge(o);
		em.remove(usuario);
		em.getTransaction().commit();
	}

	// LISTAR
	@Override
	public ArrayList<Usuario> Listar() {
		Query q = em.createQuery("from Usuario a order by id");
		return (ArrayList<Usuario>) q.getResultList();
	}

	// BUSCAR ID
	@Override
	public Usuario BuscarID(Long id) {
		return em.find(Usuario.class, id);
	}
}