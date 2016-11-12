package br.edu.facear.crm.bo;

import java.util.ArrayList;

import br.edu.facear.crm.dao.LigacaoDAO;
import br.edu.facear.crm.entity.Ligacao;

public class LigacaoBO implements InterfaceBO<Ligacao> {

	LigacaoDAO ligacaoDAO = new LigacaoDAO();

	// CADASTRAR
	@Override
	public void Cadastrar(Ligacao ligacao) throws Exception {

		if (ligacao.getContato() == null) {
			throw new Exception("Selecione um Contato");
		}
		// else if(ligacao.getAtividade() == null){
		// throw new Exception("Selecione uma Atividade.");
		// }
		else if (ligacao.getEmpresa() == null) {
			throw new Exception("Selecione uma Empresa.");
		} else if (ligacao.getDuracao() == null) {
			throw new Exception("Duracao Informada Invalida");
		} else if (ligacao.getData() == null) {
			throw new Exception("Data Informada Invalida");
		} 
//		else if (ligacao.getTipoligacao() == null) {
//			throw new Exception("Selecione um Tipo de Ligacao");
//		} 
		else if (ligacao.getResumo() == null) {
			throw new Exception("Resumo Informado Invalido");
		}
		ligacaoDAO.Cadastrar(ligacao);
	}

	// ALTERAR
	@Override
	public void Alterar(Ligacao ligacao) throws Exception {

		if (ligacao.getContato() == null) {
			throw new Exception("Selecione um Contato");
		} 
//		else if (ligacao.getAtividade() == null) {
//			throw new Exception("Selecione uma Atividade.");
//		} 
//		else if (ligacao.getUsuarioresponsavel() == null) {
//			throw new Exception("Selecione um Usuario.");
//		} 
		else if (ligacao.getEmpresa() == null) {
			throw new Exception("Selecione uma Empresa.");
		} else if (ligacao.getDuracao() == null) {
			throw new Exception("Duracao Informada Invalida");
		} else if (ligacao.getData() == null) {
			throw new Exception("Data Informada Invalida");
		} else if (ligacao.getTipoligacao() == null) {
			throw new Exception("Selecione um Tipo de Ligacao");
		} else if (ligacao.getResumo() == null) {
			throw new Exception("Resumo Informado Invalido");
		}

		ligacaoDAO.Alterar(ligacao);
	}

	// EXCLUIR
	@Override
	public void Excluir(Ligacao o) throws Exception {
		if (o == null) {
			throw new Exception("Ligacao Selecionada é inválida.");
		}
		ligacaoDAO.Excluir(o);
	}

	// LISTAR
	@Override
	public ArrayList<Ligacao> Listar() throws Exception {
		ArrayList<Ligacao> l = ligacaoDAO.Listar();
		if (l == null) {
			throw new Exception("Nenhuma ligacão cadastrada");
		}
		return l;
	}

	// BUSCAR ID
	@Override
	public Ligacao BuscarID(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Ligacao pesquisada é inválida");
		} else if (id <= 0) {
			throw new Exception("Ligacao pesquisado é inválida");
		}
		return ligacaoDAO.BuscarID(id);
	}
}