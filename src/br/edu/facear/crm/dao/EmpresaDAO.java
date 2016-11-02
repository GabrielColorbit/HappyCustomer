package br.edu.facear.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Empresa;
import br.edu.facear.crm.entity.TipoComunicador;

public class EmpresaDAO implements InterfaceDAO<Empresa> {

	// CONECTA AO BANCO
	EntityManager em = Connection.getEntityManager();

	// CADASTRAR
	@Override
	public void Cadastrar(Empresa o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}

	// ALTERAR
	@Override
	public void Alterar(Empresa o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
	}

	// EXCLUIR
	@Override
	public void Excluir(Empresa o) {
		em.getTransaction().begin();
		Empresa empresa = em.merge(o);
		em.remove(empresa);
		em.getTransaction().commit();
	}

	// LISTAR
	@Override
	public List<Empresa> Listar() {
		Query q = em.createQuery("from Empresa a order by id");
		return q.getResultList();
	}

	// BUSCAR ID
	@Override
	public Empresa BuscarID(Long id) {
		return em.find(Empresa.class, id);
	}
}