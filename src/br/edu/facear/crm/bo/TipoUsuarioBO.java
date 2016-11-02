package br.edu.facear.crm.bo;

import java.util.ArrayList;

import br.edu.facear.crm.dao.TipoUsuarioDAO;
import br.edu.facear.crm.entity.TipoUsuario;

public class TipoUsuarioBO implements InterfaceBO<TipoUsuario> {

	TipoUsuarioDAO tipousuarioDAO = new TipoUsuarioDAO();

	// CADASTRAR
	@Override
	public void Cadastrar(TipoUsuario o) throws Exception {
		if (o.getNome() == null) {
			throw new Exception("Nome do tipo de usuário é inválido");
		}
		else if (o.getNome().isEmpty()) {
			throw new Exception("Preencha o campo nome!");
		}
		tipousuarioDAO.Cadastrar(o);
	}

	// ALTERAR
	@Override
	public void Alterar(TipoUsuario o) throws Exception {
		if (o.getNome() == null) {
			throw new Exception("Nome do tipo de usuário é inválido!");
		}
		else if (o.getNome().isEmpty()) {
			throw new Exception("Preencha o campo nome!");
		}
		tipousuarioDAO.Alterar(o);
	}

	// EXCLUIR
	@Override
	public void Excluir(TipoUsuario o) throws Exception {
		if (o.getNome() == null) {
			throw new Exception("Tipo de usuário selecionado é inválido!");
		}
		tipousuarioDAO.Excluir(o);
	}

	// LISTAR
	@Override
	public ArrayList<TipoUsuario> Listar() throws Exception {
		ArrayList<TipoUsuario> tu = tipousuarioDAO.Listar();
		if (tu == null) {
			throw new Exception("Nenhum tipo de usuário cadastrado!");
		}
		return tu;
	}

	// BUSCAR ID
	@Override
	public TipoUsuario BuscarID(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Tipo de usuário pesquisado é Inválido!");
		} else if (id <= 0) {
			throw new Exception("Tipo de usuário Pesquisado é Inválido!");
		}
		return tipousuarioDAO.BuscarID(id);
	}
}