package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.TipoTelefoneDAO;
import br.edu.facear.crm.entity.TipoTelefone;

public class TipoTelefoneBO implements InterfaceBO<TipoTelefone>{
	TipoTelefoneDAO tdao = new TipoTelefoneDAO();
	
	@Override
	public void Cadastrar(TipoTelefone tipotelefone) throws Exception {
		
		if(tipotelefone.getNome() == null){
			throw new Exception("Nome do tipo de telefone � inv�lido");
		}
		tdao.Cadastrar(tipotelefone);		
	}

	@Override
	public List<TipoTelefone> Listar() throws Exception {
		List<TipoTelefone> tipostelefone= tdao.Listar();
		if(tipostelefone == null){
			throw new Exception("Nenhumma Tipo de Telefone cadastrado");
		}
		return tipostelefone;
	}

	@Override
	public void Alterar(TipoTelefone tipotelefone) throws Exception {
		if(tipotelefone.getNome() == null) {
			throw new Exception("Nome de Tipo de Telefone � Invalido");
		}
		tdao.Alterar(tipotelefone);			
	}

	@Override
	public TipoTelefone BuscarID(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Tipo de Telefone Pesquisado � Inv�lido");
		}
		else if(id <= 0) {
			throw new Exception("Tipo de Telefone Pesquisado � Inv�lido");
		}
		
		return tdao.BuscarID(id);
	}

	@Override
	public void Excluir(TipoTelefone tipotelefone) throws Exception {
		if(tipotelefone.getNome() == null) {
			throw new Exception("Tipo de telefone selecionado � invalido");
		}		
		tdao.Excluir(tipotelefone);	
	}

}
