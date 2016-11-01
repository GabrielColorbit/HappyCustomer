package br.edu.facear.crm.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Usuario;

public class UsuarioDAO implements InterfaceDAO<Usuario> {

	// CONECTA AO BANCO
	EntityManager em = Connection.getEntityManager();

	// CADASTRAR
	@Override
	public void Cadastrar(Usuario ususario) throws CrmException {
		em.getTransaction().begin();
		em.persist(ususario);
		em.getTransaction().commit();
	}

	// ALTERAR
	@Override
	public void Alterar(Usuario usuario) {
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
	}

	// EXCLUIR
	@Override
	public void Excluir(Usuario usuario) {
		em.getTransaction().begin();
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