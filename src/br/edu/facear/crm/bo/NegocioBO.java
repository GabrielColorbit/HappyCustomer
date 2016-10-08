package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.NegocioDAO;
import br.edu.facear.crm.entity.Negocio;

public class NegocioBO implements InterfaceBO<Negocio> {
	NegocioDAO ndao =  new NegocioDAO();
	@Override
	public void Cadastrar(Negocio o) throws Exception {
		if(o.getEmpresa() == null ||
		   o.getData() == null){

			throw new Exception("Preencher todos os campos do negocio");
		}
		ndao.Cadastrar(o);				
	}

	@Override
	public List<Negocio> Listar() throws Exception {
		List<Negocio> n = ndao.Listar();
		if(n == null){
			throw new Exception("Nenhuma negocio cadastrado");
		}
		return n;
	}

	@Override
	public void Alterar(Negocio o) throws Exception {
		if(o.getEmpresa() == null ||
		   o.getData() == null){

			throw new Exception("Preencher todos os campos do negocio");
		}
		ndao.Alterar(o);				
	}

	@Override
	public Negocio BuscarID(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Item pesquisado é Inválido");
		}
		else if(id <= 0) {
			throw new Exception("Item Pesquisado é Inválido");
		}
		return ndao.BuscarID(id);
	}

	@Override
	public void Excluir(Negocio o) throws Exception {
		if(o.getId() == null) {
			throw new Exception("Negocio Selecionada é inválido.");
		}		
		ndao.Excluir(o);				
	}

}
