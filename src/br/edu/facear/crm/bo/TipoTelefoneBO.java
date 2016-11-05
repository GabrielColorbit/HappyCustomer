package br.edu.facear.crm.bo;

import java.util.ArrayList;

import br.edu.facear.crm.dao.TipoTelefoneDAO;
import br.edu.facear.crm.entity.TipoTelefone;

public class TipoTelefoneBO implements InterfaceBO<TipoTelefone> {

	TipoTelefoneDAO tipotelefoneDAO = new TipoTelefoneDAO();

	// CADASTRAR
	@Override
	public void Cadastrar(TipoTelefone tipotelefone) throws Exception {
		if (tipotelefone.getNome() == null) {
			throw new Exception("Nome do tipo de telefone é inválido!");
		}
		else if (tipotelefone.getNome().isEmpty()) {
			throw new Exception("Preencha o campo nome!");
		}
		tipotelefoneDAO.Cadastrar(tipotelefone);
	}

	// ALTERAR
	@Override
	public void Alterar(TipoTelefone tipotelefone) throws Exception {
		if (tipotelefone.getNome() == null) {
			throw new Exception("Nome de Tipo de Telefone é Invalido!");
		}
		else if (tipotelefone.getNome().isEmpty()) {
			throw new Exception("Preencha o campo nome!");
		}
		tipotelefoneDAO.Alterar(tipotelefone);
	}

	// EXCLUIR
	@Override
	public void Excluir(TipoTelefone tipotelefone) throws Exception {
		if (tipotelefone.getNome() == null) {
			throw new Exception("Tipo de telefone selecionado é invalido!");
		}
		tipotelefoneDAO.Excluir(tipotelefone);
	}

	// LISTAR
	@Override
	public ArrayList<TipoTelefone> Listar() throws Exception {
		ArrayList<TipoTelefone> tipotelefone = tipotelefoneDAO.Listar();
		if (tipotelefone == null) {
			throw new Exception("Nenhum Tipo de Telefone cadastrado!");
		}
		return tipotelefone;
	}

	// BUSCAR ID
	@Override
	public TipoTelefone BuscarID(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Tipo de Telefone Pesquisado é Inválido!");
		} else if (id <= 0) {
			throw new Exception("Tipo de Telefone Pesquisado é Inválido!");
		}
		return tipotelefoneDAO.BuscarID(id);
	}
}