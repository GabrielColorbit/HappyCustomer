package br.edu.facear.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.TipoEmpresa;

public class TipoEmpresaDAO implements InterfaceDAO<TipoEmpresa>{
	


	@Override
	public void salvar(TipoEmpresa tipoempresa) throws CrmException {
		EntityManager em = Connection.getEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(tipoempresa);

		} catch (Exception ex) {
			if (ex.getCause().toString().contains("Unique key")) {
				throw new CrmException("O campo nome não pode ser único!!");
			}else{
				throw new CrmException(ex.getCause().toString());
			}
		}
		em.getTransaction().commit();
		
	}

	@Override
	public List<TipoEmpresa> listar() {
		EntityManager em = Connection.getEntityManager();
		Query q = em.createQuery("select a from TipoEmpresa a");
		return q.getResultList();
	}

	@Override
	public void editar(TipoEmpresa tipoempresa) {
		EntityManager em = Connection.getEntityManager();
		em.getTransaction().begin();
		em.merge(tipoempresa);
		em.getTransaction().commit();
		
	}

	@Override
	public TipoEmpresa getObjectById(Long id) {
		EntityManager em = Connection.getEntityManager();
		return em.find(TipoEmpresa.class, id);
	}

	@Override
	public void excluir(TipoEmpresa tipoempresa) {
		EntityManager em = Connection.getEntityManager();
		em.getTransaction().begin();
		em.remove(tipoempresa);
		em.getTransaction().commit();		
	}

}
