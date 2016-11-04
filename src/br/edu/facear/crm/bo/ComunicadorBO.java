package br.edu.facear.crm.bo;

import java.util.ArrayList;

import br.edu.facear.crm.dao.ComunicadorDAO;
import br.edu.facear.crm.entity.Comunicador;

public class ComunicadorBO implements InterfaceBO<Comunicador> {

	ComunicadorDAO comunicadorDAO = new ComunicadorDAO();

	// CADASTRAR
	@Override
	public void Cadastrar(Comunicador comunicador) throws Exception {
		if (comunicador.getNome() == null) {
			throw new Exception("Nome do comunicador é invalido!");
		}
		else if (comunicador.getTipocomunicador() == null) {
			throw new Exception("Selecione um Tipo de Comunicador!");
		}
		comunicadorDAO.Cadastrar(comunicador);
	}

	// ALTERAR
	@Override
	public void Alterar(Comunicador comunicador) throws Exception {
		if (comunicador.getNome() == null) {
			throw new Exception("Nome do comunicador é invalido!");
		}
		else if (comunicador.getTipocomunicador() == null) {
			throw new Exception("Selecione um Tipo de Comunicador!");
		}
		comunicadorDAO.Alterar(comunicador);
	}
	
	// EXCLUIR
	public void Excluir(Comunicador o) throws Exception {
		if (o.getNome() == null) {
			throw new Exception("Comunicador selecionado é inválido!");
		}
		comunicadorDAO.Excluir(o);
	}

	// LISTAR
	@Override
	public ArrayList<Comunicador> Listar() throws Exception {
		ArrayList<Comunicador> comunicadores = comunicadorDAO.Listar();
		if (comunicadores == null) {
			throw new Exception("Nenhum comunicador cadastrado!");
		}
		return comunicadores;
	}

	// BUSCAR ID
	@Override
	public Comunicador BuscarID(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Comunicador pesquisado é Inválido!");
		} else if (id <= 0) {
			throw new Exception("Comunicador Pesquisado é Inválido!");
		}
		return comunicadorDAO.BuscarID(id);
	}
}