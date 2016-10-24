package br.edu.facear.crm.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Usuario;

public class UsuarioDAO implements InterfaceDAO<Usuario>{
	EntityManager em = Connection.getEntityManager();
	@Override
	public void Cadastrar(Usuario ususario) throws CrmException {
		em.getTransaction().begin();
		em.persist(ususario);
		em.getTransaction().commit();		
	}

	@Override
	public ArrayList<Usuario> Listar() {
		Query q = em.createQuery("select a from Usuario a");
		
		return (ArrayList<Usuario>) q.getResultList();
	}

	@Override
	public void Alterar(Usuario usuario) {
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
	}

	@Override
	public Usuario BuscarID(Long id) {
		return em.find(Usuario.class, id);
	}

	@Override
	public void Excluir(Usuario usuario) {
		em.getTransaction().begin();
		em.remove(usuario);
		em.getTransaction().commit();			}

}
