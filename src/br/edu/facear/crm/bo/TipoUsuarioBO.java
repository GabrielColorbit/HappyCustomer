package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.TipoUsuarioDAO;
import br.edu.facear.crm.entity.TipoUsuario;

public class TipoUsuarioBO implements InterfaceBO<TipoUsuario>{
	TipoUsuarioDAO tudao = new TipoUsuarioDAO();
	@Override
	public void Cadastrar(TipoUsuario o) throws Exception {
		if(o.getNome() == null){
			throw new Exception("Nome do tipo de usuário é inválido");
		}
		tudao.Cadastrar(o);
	}

	@Override
	public List<TipoUsuario> Listar() throws Exception {
		List<TipoUsuario> tu= tudao.Listar();
		if(tu == null){
			throw new Exception("Nenhuma tipo de usuário cadastrado");
		}
		return tu;
	}

	@Override
	public void Alterar(TipoUsuario o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Nome do tipo de usuário é inválido");
		}
		tudao.Alterar(o);			
	}

	@Override
	public TipoUsuario BuscarID(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Tipo de usuário pesquisado é Inválido");
		}
		else if(id <= 0) {
			throw new Exception("Tipo de usuário Pesquisado é Inválido");
		}
		
		return tudao.BuscarID(id);
	}

	@Override
	public void Excluir(TipoUsuario o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Tipo de usuario selecionado é inválido.");
		}		
		tudao.Excluir(o);				
	}

}
