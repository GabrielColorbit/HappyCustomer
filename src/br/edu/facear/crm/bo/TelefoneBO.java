package br.edu.facear.crm.bo;

import java.util.ArrayList;

import br.edu.facear.crm.dao.TelefoneDAO;
import br.edu.facear.crm.entity.Telefone;

public class TelefoneBO implements InterfaceBO<Telefone> {

	TelefoneDAO telefoneDAO = new TelefoneDAO();

	// CADASTRAR
	@Override
	public void Cadastrar(Telefone telefone) throws Exception {
		if (telefone.getNumero() == null) {
			throw new Exception("Preencha o campo número!");
		}
		else if (telefone.getTipotelefone() == null) {
			throw new Exception("Selecione um Tipo de Telefone!");
		}
		telefoneDAO.Cadastrar(telefone);
	}

	// ALTERAR
	@Override
	public void Alterar(Telefone telefone) throws Exception {
		if (telefone.getNumero() == null) {
			throw new Exception("Preencha o campo número!");
		}
		else if (telefone.getTipotelefone() == null) {
			throw new Exception("Selecione um Tipo de Telefone!");
		}
		telefoneDAO.Alterar(telefone);
	}

	// EXCLUIR
	@Override
	public void Excluir(Telefone telefone) throws Exception {
		if (telefone.getNumero() == null) {
			throw new Exception("Telefone selecionado é Inválido!");
		}
		telefoneDAO.Excluir(telefone);
	}

	// LISTAR
	@Override
	public ArrayList<Telefone> Listar() throws Exception {
		ArrayList<Telefone> telefones = telefoneDAO.Listar();
		if (telefones == null) {
			throw new Exception("Nenhum telefone cadastrado!");
		}
		return telefones;
	}

	// BUSCAR ID
	@Override
	public Telefone BuscarID(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Telefone Pesquisado é Inválido!");
		} else if (id <= 0) {
			throw new Exception("Telefone Pesquisado é Inválido!");
		}
		return telefoneDAO.BuscarID(id);
	}
}