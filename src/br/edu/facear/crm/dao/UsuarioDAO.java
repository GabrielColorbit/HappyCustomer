package br.edu.facear.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Estado;
import br.edu.facear.crm.entity.Usuario;

public class UsuarioDAO implements InterfaceDAO<Usuario>{
	EntityManager em = Connection.getEntityManager();
	@Override
	public void salvar(Usuario ususario) throws CrmException {
		em.getTransaction().begin();
		em.persist(ususario);
		em.getTransaction().commit();		
	}

	@Override
	public List<Usuario> listar() {
		Query q = em.createQuery("select a from Usuario a");
		
		return q.getResultList();
	}

	@Override
	public void editar(Usuario usuario) {
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
	}

	@Override
	public Usuario getObjectById(Long id) {
		return em.find(Usuario.class, id);
	}

	@Override
	public void excluir(Usuario usuario) {
		em.getTransaction().begin();
		em.remove(usuario);
		em.getTransaction().commit();			}

}
