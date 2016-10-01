package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.ItemDAO;
import br.edu.facear.crm.entity.Item;

public class ItemBO  implements InterfaceBO<Item>{
	ItemDAO idao = new ItemDAO();
	@Override
	public void salvar(Item o) throws Exception {
		if(o.getProduto() == null ||
		   o.getNegocio() == null||
		   o.getQuantidade() == null){

			throw new Exception("Preencher todos os campos do item");
		}
		idao.salvar(o);		
	}

	@Override
	public List<Item> listar() throws Exception {
		List<Item> i = idao.listar();
		if(i == null){
			throw new Exception("Nenhuma item cadastrado");
		}
		return i;
	}

	@Override
	public void editar(Item o) throws Exception {
		if(o.getProduto() == null ||
		   o.getNegocio() == null||
		   o.getQuantidade() == null){

			throw new Exception("Preencher todos os campos do item");
		}
		idao.editar(o);				
	}

	@Override
	public Item getObjectById(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Item pesquisado é Inválido");
		}
		else if(id <= 0) {
			throw new Exception("Item Pesquisado é Inválido");
		}
		return idao.getObjectById(id);
	}

	@Override
	public void excluir(Item o) throws Exception {
		if(o.getId() == null) {
			throw new Exception("Item Selecionada é inválido.");
		}		
		idao.excluir(o);		
	}

}
