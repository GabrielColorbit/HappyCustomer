package br.edu.facear.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Estado;
import br.edu.facear.crm.entity.TipoUsuario;

public class TipoUsuarioDAO implements InterfaceDAO<TipoUsuario>{
	EntityManager em = Connection.getEntityManager();
	@Override
	public void salvar(TipoUsuario tipousuario) throws CrmException {
		em.getTransaction().begin();
		em.persist(tipousuario);
		em.getTransaction().commit();
	}

	@Override
	public List<TipoUsuario> listar() {
		Query q = em.createQuery("select a from TipoUsuario a");
		
		return q.getResultList();
	}

	@Override
	public void editar(TipoUsuario tipousuario) {
		em.getTransaction().begin();
		em.merge(tipousuario);
		em.getTransaction().commit();
	}

	@Override
	public TipoUsuario getObjectById(Long id) {
		return em.find(TipoUsuario.class, id);
	}

	@Override
	public void excluir(TipoUsuario tipousuario) {
		em.getTransaction().begin();
		em.remove(tipousuario);
		em.getTransaction().commit();		
	}
	

}
