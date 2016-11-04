package br.edu.facear.crm.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Produto;

public class ProdutoDAO implements InterfaceDAO<Produto> {

	// CONECTA AO BANCO
	EntityManager em = Connection.getEntityManager();

	// CADASTRAR
	@Override
	public void Cadastrar(Produto o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}

	// ALTERAR
	@Override
	public void Alterar(Produto o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
	}

	// EXCLUIR
	@Override
	public void Excluir(Produto o) {
		em.getTransaction().begin();
		Produto produto = em.merge(o);
		em.remove(produto);
		em.getTransaction().commit();
	}

	// LISTAR
	@Override
	public ArrayList<Produto> Listar() {
		Query q = em.createQuery("from Produto a order by id");
		return (ArrayList<Produto>) q.getResultList();
	}

	// BUSCAR ID
	@Override
	public Produto BuscarID(Long id) {
		return em.find(Produto.class, id);
	}
}