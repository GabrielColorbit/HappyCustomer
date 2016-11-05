package br.edu.facear.crm.bo;

import java.util.ArrayList;

import br.edu.facear.crm.dao.TipoComunicadorDAO;
import br.edu.facear.crm.entity.TipoComunicador;

public class TipoComunicadorBO implements InterfaceBO<TipoComunicador> {

	TipoComunicadorDAO tipocomunicadorDAO = new TipoComunicadorDAO();

	// CADASTRAR
	@Override
	public void Cadastrar(TipoComunicador o) throws Exception {
		if (o.getNome() == null) {
			throw new Exception("Nome do tipo de comunicador é inválido!");
		}
		else if (o.getNome().isEmpty()) {
			throw new Exception("Preencha o campo nome!");
		}
		tipocomunicadorDAO.Cadastrar(o);
	}

	// ALTERAR
	@Override
	public void Alterar(TipoComunicador o) throws Exception {
		if (o.getNome() == null) {
			throw new Exception("Nome do tipo de comunicador é inválido!");
		}
		else if (o.getNome().isEmpty()) {
			throw new Exception("Preencha o campo nome!");
		}
		tipocomunicadorDAO.Alterar(o);
	}

	// EXCLUIR
	@Override
	public void Excluir(TipoComunicador o) throws Exception {
		if (o.getNome() == null) {
			throw new Exception("Tipo de comunicador selecionado é inválido!");
		}
		tipocomunicadorDAO.Excluir(o);
	}

	// LISTAR
	@Override
	public ArrayList<TipoComunicador> Listar() throws Exception {
		ArrayList<TipoComunicador> tipocomunicador = tipocomunicadorDAO.Listar();
		if (tipocomunicador == null) {
			throw new Exception("Nenhuma tipo de comunicador cadastrado!");
		}
		return tipocomunicador;
	}

	// BUSCAR ID
	@Override
	public TipoComunicador BuscarID(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Tipo de comunicador pesquisado é inválido!");
		} else if (id <= 0) {
			throw new Exception("Tipo de comunicador pesquisado é inválido!");
		}

		return tipocomunicadorDAO.BuscarID(id);
	}
}