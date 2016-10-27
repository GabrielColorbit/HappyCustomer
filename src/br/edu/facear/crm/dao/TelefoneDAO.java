package br.edu.facear.crm.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.Telefone;

public class TelefoneDAO implements InterfaceDAO<Telefone>{
	EntityManager em = Connection.getEntityManager();

	@Override
	public void Cadastrar(Telefone telefone) throws CrmException {
		em.getTransaction().begin();
		try {
			em.persist(telefone);
		} catch (Exception ex) {
			if (ex.getCause().toString().contains("Unique key")) {
				throw new CrmException("O campo nome n�o pode ser �nico!!");
			}else{
				throw new CrmException(ex.getCause().toString());
			}
		}
		em.getTransaction().commit();

		
	}

	@Override
	public ArrayList<Telefone> Listar() {
		Query q = em.createQuery("select a from Telefone a");
		
		return (ArrayList<Telefone>) q.getResultList();

	}

	@Override
	public void Alterar(Telefone telefone) {
		em.getTransaction().begin();
		em.merge(telefone);
		em.getTransaction().commit();		
	}

	@Override
	public Telefone BuscarID(Long id) {
		return em.find(Telefone.class, id);	
	}

	@Override
	public void Excluir(Telefone telefone) {
		em.getTransaction().begin();
		em.remove(telefone);
		em.getTransaction().commit();
		
	}

}
