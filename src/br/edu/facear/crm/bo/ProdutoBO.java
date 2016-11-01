package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.ProdutoDAO;
import br.edu.facear.crm.entity.Produto;

public class ProdutoBO implements InterfaceBO<Produto> {

	ProdutoDAO produtoDAO = new ProdutoDAO();

	// CADASTRAR
	@Override
	public void Cadastrar(Produto produto) throws Exception {
		if (produto.getNome() == null) {
			throw new Exception("Nome do produto é inválido!");
		} else if (produto.getPreco() == null) {
			throw new Exception("Preço do produto é inválido!");
		}
		produtoDAO.Cadastrar(produto);
	}

	// ALTERAR
	@Override
	public void Alterar(Produto produto) throws Exception {
		if (produto.getNome() == null) {
			throw new Exception("Nome do produto é inválido!");
		} else if (produto.getPreco() == null) {
			throw new Exception("Preço do produto é inválido!");
		}
		produtoDAO.Alterar(produto);
	}

	// EXCLUIR
	@Override
	public void Excluir(Produto produto) throws Exception {
		if (produto.getNome() == null) {
			throw new Exception("Produto selecionado é inválido!");
		}
		produtoDAO.Excluir(produto);
	}

	// LISTAR
	@Override
	public List<Produto> Listar() throws Exception {
		List<Produto> produtos = produtoDAO.Listar();
		if (produtos == null) {
			throw new Exception("Nenhumm produto cadastrado!");
		}
		return produtos;
	}

	// BUSCAR ID
	@Override
	public Produto BuscarID(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Produto pesquisado é inválido!");
		} else if (id <= 0) {
			throw new Exception("Produto pesquisado é inválido!");
		}
		return produtoDAO.BuscarID(id);
	}
}