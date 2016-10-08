package br.edu.facear.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.edu.facear.crm.entity.TipoTelefone;

public class TipoTelefoneDAO implements InterfaceDAO<TipoTelefone> {
	
	EntityManager em = Connection.getEntityManager();
	
	@Override
	public void Cadastrar(TipoTelefone tipotelefone) throws CrmException {
		em.getTransaction().begin();
		try {
			em.persist(tipotelefone);
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
	public List<TipoTelefone> Listar() {
		
		EntityManager em = Connection.getEntityManager();
		Query q = em.createQuery("from TipoTelefone");
		
		return q.getResultList();
	}

	@Override
	public void Alterar(TipoTelefone tipotelefone) {
		em.getTransaction().begin();
		em.merge(tipotelefone);
		em.getTransaction().commit();
	}

	@Override
	public TipoTelefone BuscarID(Long id) {
		return em.find(TipoTelefone.class, id);	
	}

	@Override
	public void Excluir(TipoTelefone tipotelefone) {
		em.getTransaction().begin();
		em.remove(tipotelefone);
		em.getTransaction().commit();		
	}
}