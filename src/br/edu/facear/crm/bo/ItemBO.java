package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.ItemDAO;
import br.edu.facear.crm.entity.Item;

public class ItemBO  implements InterfaceBO<Item>{
	ItemDAO idao = new ItemDAO();
	@Override
	public void Cadastrar(Item o) throws Exception {
		if(o.getProduto() == null ||
		   o.getNegocio() == null||
		   o.getQuantidade() == null){

			throw new Exception("Preencher todos os campos do item");
		}
		idao.Cadastrar(o);		
	}

	@Override
	public List<Item> Listar() throws Exception {
		List<Item> i = idao.Listar();
		if(i == null){
			throw new Exception("Nenhuma item cadastrado");
		}
		return i;
	}

	@Override
	public void Alterar(Item o) throws Exception {
		if(o.getProduto() == null ||
		   o.getNegocio() == null||
		   o.getQuantidade() == null){

			throw new Exception("Preencher todos os campos do item");
		}
		idao.Alterar(o);				
	}

	@Override
	public Item BuscarID(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Item pesquisado é Inválido");
		}
		else if(id <= 0) {
			throw new Exception("Item Pesquisado é Inválido");
		}
		return idao.BuscarID(id);
	}

	@Override
	public void Excluir(Item o) throws Exception {
		if(o.getId() == null) {
			throw new Exception("Item Selecionada é inválido.");
		}		
		idao.Excluir(o);		
	}

}
