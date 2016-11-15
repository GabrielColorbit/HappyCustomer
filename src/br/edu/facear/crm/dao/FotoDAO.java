package br.edu.facear.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.facear.crm.entity.Estado;
import br.edu.facear.crm.entity.Foto;

public class FotoDAO implements InterfaceDAO<Foto>{
	EntityManager em = Connection.getEntityManager();
	
	
	@Override
	public void Cadastrar(Foto crm) throws CrmException {

		em.getTransaction().begin();
		em.persist(crm);
		em.getTransaction().commit();
	}

	@Override
	public void Alterar(Foto crm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Excluir(Foto crm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Foto> Listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Foto BuscarID(Long id) {
		return em.find(Foto.class, id);
	}
	

}
