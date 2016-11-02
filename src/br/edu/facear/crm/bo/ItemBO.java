package br.edu.facear.crm.bo;

import java.util.ArrayList;

import br.edu.facear.crm.dao.ItemDAO;
import br.edu.facear.crm.entity.Item;

public class ItemBO implements InterfaceBO<Item> {

	ItemDAO idao = new ItemDAO();

	// CADASTRAR
	@Override
	public void Cadastrar(Item item) throws Exception {
		if (item.getProduto() == null) {
			throw new Exception("Selecione um Produto!");
		} else if (item.getNegocio() == null) {
			throw new Exception("Selecione um Negócio!");
		} else if (item.getQuantidade() == null) {
			throw new Exception("Quantidade Fornecida Invalido.");
		}

		idao.Cadastrar(item);
	}

	// ALTERAR
	@Override
	public void Alterar(Item item) throws Exception {

		if (item.getProduto() == null) {
			throw new Exception("Selecione um Produto");
		} else if (item.getNegocio() == null) {
			throw new Exception("Selecione um Negócio.");
		} else if (item.getQuantidade() == null) {
			throw new Exception("Quantidade Fornecida Invalido.");
		}

		idao.Alterar(item);
	}

	// EXCLUIR
	@Override
	public void Excluir(Item o) throws Exception {
		if (o.getId() == null) {
			throw new Exception("Item Selecionada é inválido.");
		}
		idao.Excluir(o);
	}

	// BUSCAR ID
	@Override
	public Item BuscarID(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Item pesquisado é Inválido");
		} else if (id <= 0) {
			throw new Exception("Item Pesquisado é Inválido");
		}
		return idao.BuscarID(id);
	}

	// LISTAR
	@Override
	public ArrayList<Item> Listar() throws Exception {
		ArrayList<Item> i = idao.Listar();
		if (i == null) {
			throw new Exception("Nenhuma item cadastrado");
		}
		return i;
	}
}