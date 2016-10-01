package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.TipoTelefoneDAO;
import br.edu.facear.crm.entity.Cidade;
import br.edu.facear.crm.entity.TipoTelefone;

public class TipoTelefoneBO implements InterfaceBO<TipoTelefone>{
	TipoTelefoneDAO tdao = new TipoTelefoneDAO();
	
	@Override
	public void salvar(TipoTelefone tipotelefone) throws Exception {
		
		if(tipotelefone.getNome() == null){
			throw new Exception("Nome do tipo de telefone é inválido");
		}
		tdao.salvar(tipotelefone);		
	}

	@Override
	public List<TipoTelefone> listar() throws Exception {
		List<TipoTelefone> tipostelefone= tdao.listar();
		if(tipostelefone == null){
			throw new Exception("Nenhumma Tipo de Telefone cadastrado");
		}
		return tipostelefone;
	}

	@Override
	public void editar(TipoTelefone tipotelefone) throws Exception {
		if(tipotelefone.getNome() == null) {
			throw new Exception("Nome de Tipo de Telefone é Invalido");
		}
		tdao.editar(tipotelefone);			
	}

	@Override
	public TipoTelefone getObjectById(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Tipo de Telefone Pesquisado é Inválido");
		}
		else if(id <= 0) {
			throw new Exception("Tipo de Telefone Pesquisado é Inválido");
		}
		
		return tdao.getObjectById(id);
	}

	@Override
	public void excluir(TipoTelefone tipotelefone) throws Exception {
		if(tipotelefone.getNome() == null) {
			throw new Exception("Tipo de telefone selecionado é invalido");
		}		
		tdao.excluir(tipotelefone);	
	}

}
