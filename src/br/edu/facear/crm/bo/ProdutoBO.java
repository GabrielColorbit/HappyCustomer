package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.ProdutoDAO;
import br.edu.facear.crm.entity.Produto;
import br.edu.facear.crm.entity.TipoEmpresa;

public class ProdutoBO implements InterfaceBO<Produto>{
	ProdutoDAO produtodao = new ProdutoDAO();
	@Override
	public void salvar(Produto produto) throws Exception {
		if(produto.getNome() == null){
			throw new Exception("Nome do produto é inválido");
		}else if(produto.getPreco() == null){
			throw new Exception("Preço do produto é inválido");
		}
		produtodao.salvar(produto);
	}

	@Override
	public List<Produto> listar() throws Exception {
		List<Produto> listaproduto= produtodao.listar();
		if(listaproduto == null){
			throw new Exception("Nenhumm produto cadastrado");
		}
		return listaproduto;
	}

	@Override
	public void editar(Produto produto) throws Exception {
		if(produto.getNome() == null) {
			throw new Exception("Nome do produto é Invalido");
		}else if(produto.getPreco() == null) {
			throw new Exception("Preço do produto é Invalido");
		}
		produtodao.editar(produto);	
	}

	@Override
	public Produto getObjectById(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Produto pesquisado é inválido");
		}
		else if(id <= 0) {
			throw new Exception("Produto pesquisado é inválido");
		}
		
		return produtodao.getObjectById(id);
	}

	@Override
	public void excluir(Produto produto) throws Exception {
		if(produto.getNome() == null) {
			throw new Exception("produto selecionado é inválido.");
		}
		produtodao.excluir(produto);			
	}
	
}
