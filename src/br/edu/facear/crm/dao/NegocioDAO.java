package br.edu.facear.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Negocio;
import br.edu.facear.crm.entity.TipoComunicador;

public class NegocioDAO implements InterfaceDAO<Negocio> {

	// CONECTA AO BANCO
	EntityManager em = Connection.getEntityManager();

	// CADASTRAR
	@Override
	public void Cadastrar(Negocio o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}

	// ALTERAR
	@Override
	public void Alterar(Negocio o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
	}

	// EXCLUIR
	@Override
	public void Excluir(Negocio o) {
		em.getTransaction().begin();
		Negocio negocio = em.merge(o);
		em.remove(negocio);
		em.getTransaction().commit();
	}

	// LISTAR
	@Override
	public List<Negocio> Listar() {
		Query q = em.createQuery("from Negocio a order by id");
		return q.getResultList();
	}

	// BUSCAR ID
	@Override
	public Negocio BuscarID(Long id) {
		return em.find(Negocio.class, id);
	}
}