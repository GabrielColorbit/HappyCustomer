package br.edu.facear.crm.bo;

import java.util.ArrayList;

import br.edu.facear.crm.dao.TipoUsuarioDAO;
import br.edu.facear.crm.entity.TipoUsuario;

public class TipoUsuarioBO implements InterfaceBO<TipoUsuario>{
	TipoUsuarioDAO tudao = new TipoUsuarioDAO();
	@Override
	public void Cadastrar(TipoUsuario o) throws Exception {
		if(o.getNome() == null){
			throw new Exception("Nome do tipo de usu�rio � inv�lido");
		}
		tudao.Cadastrar(o);
	}

	@Override
	public ArrayList<TipoUsuario> Listar() throws Exception {
		ArrayList<TipoUsuario> tu= tudao.Listar();
		if(tu == null){
			throw new Exception("Nenhuma tipo de usu�rio cadastrado");
		}
		return tu;
	}

	@Override
	public void Alterar(TipoUsuario o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Nome do tipo de usu�rio � inv�lido");
		}
		tudao.Alterar(o);			
	}

	@Override
	public TipoUsuario BuscarID(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Tipo de usu�rio pesquisado � Inv�lido");
		}
		else if(id <= 0) {
			throw new Exception("Tipo de usu�rio Pesquisado � Inv�lido");
		}
		
		return tudao.BuscarID(id);
	}

	@Override
	public void Excluir(TipoUsuario o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Tipo de usuario selecionado � inv�lido.");
		}		
		tudao.Excluir(o);				
	}

}
