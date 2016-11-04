package br.edu.facear.crm.bo;

import java.util.ArrayList;

import br.edu.facear.crm.dao.EstadoDAO;
import br.edu.facear.crm.entity.Estado;

public class EstadoBO implements InterfaceBO<Estado> {

	EstadoDAO estadoDAO = new EstadoDAO();

	// CADASTRAR
	@Override
	public void Cadastrar(Estado estado) throws Exception {
		if (estado.getNome() == null) {
			throw new Exception("Nome do estado é inválido!");
		}
		if (estado.getPais() == null) {
			throw new Exception("Selecione um páis!");
		}
		estadoDAO.Cadastrar(estado);
	}

	// ALTERAR
	@Override
	public void Alterar(Estado estado) throws Exception {
		if (estado.getNome() == null) {
			throw new Exception("Nome do estado é invalido!");
		}
		if (estado.getPais() == null) {
			throw new Exception("Selecione um país!");
		}
		estadoDAO.Alterar(estado);
	}

	// EXCLUIR
	@Override
	public void Excluir(Estado estado) throws Exception {
		if (estado.getNome() == null) {
			throw new Exception("Estado Selecionado é inválido!");
		}
		estadoDAO.Excluir(estado);
	}

	// LISTAR
	@Override
	public ArrayList<Estado> Listar() throws Exception {
		ArrayList<Estado> estados = estadoDAO.Listar();
		if (estados == null) {
			throw new Exception("Nenhumm estado cadastrado!");
		}
		return estados;
	}

	// BUSCAR ID
	@Override
	public Estado BuscarID(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Estado pesquisado é inválido!");
		} else if (id <= 0) {
			throw new Exception("Estado pesquisado é inválido!");
		}
		return estadoDAO.BuscarID(id);
	}
}