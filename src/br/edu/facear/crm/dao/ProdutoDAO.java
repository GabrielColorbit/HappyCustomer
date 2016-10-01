package br.edu.facear.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Produto;

public class ProdutoDAO implements InterfaceDAO<Produto>{
	EntityManager em = Connection.getEntityManager();

	@Override
	public void salvar(Produto produto) throws CrmException {
		em.getTransaction().begin();
		try {
			em.persist(produto);
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
	public List<Produto> listar() {
		Query q = em.createQuery("select a from Produto a");
		
		return q.getResultList();
	}

	@Override
	public void editar(Produto produto) {
		em.getTransaction().begin();
		em.merge(produto);
		em.getTransaction().commit();			
	}

	@Override
	public Produto getObjectById(Long id) {
		return em.find(Produto.class, id);	
	}

	@Override
	public void excluir(Produto produto) {
		em.getTransaction().begin();
		em.remove(produto);
		em.getTransaction().commit();		
	}
	

}
