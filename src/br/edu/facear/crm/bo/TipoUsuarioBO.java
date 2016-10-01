package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.TipoUsuarioDAO;
import br.edu.facear.crm.entity.TipoUsuario;

public class TipoUsuarioBO implements InterfaceBO<TipoUsuario>{
	TipoUsuarioDAO tudao = new TipoUsuarioDAO();
	@Override
	public void salvar(TipoUsuario o) throws Exception {
		if(o.getNome() == null){
			throw new Exception("Nome do tipo de usuário é inválido");
		}
		tudao.salvar(o);
	}

	@Override
	public List<TipoUsuario> listar() throws Exception {
		List<TipoUsuario> tu= tudao.listar();
		if(tu == null){
			throw new Exception("Nenhuma tipo de usuário cadastrado");
		}
		return tu;
	}

	@Override
	public void editar(TipoUsuario o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Nome do tipo de usuário é inválido");
		}
		tudao.editar(o);			
	}

	@Override
	public TipoUsuario getObjectById(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Tipo de usuário pesquisado é Inválido");
		}
		else if(id <= 0) {
			throw new Exception("Tipo de usuário Pesquisado é Inválido");
		}
		
		return tudao.getObjectById(id);
	}

	@Override
	public void excluir(TipoUsuario o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Tipo de usuario selecionado é inválido.");
		}		
		tudao.excluir(o);				
	}

}
