package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.ProdutoDAO;
import br.edu.facear.crm.entity.Produto;
import br.edu.facear.crm.entity.TipoEmpresa;

public class ProdutoBO implements InterfaceBO<Produto>{
	ProdutoDAO produtodao = new ProdutoDAO();
	@Override
	public void Cadastrar(Produto produto) throws Exception {
		if(produto.getNome() == null){
			throw new Exception("Nome do produto é inválido");
		}else if(produto.getPreco() == null){
			throw new Exception("Preço do produto é inválido");
		}
		produtodao.Cadastrar(produto);
	}

	@Override
	public List<Produto> Listar() throws Exception {
		List<Produto> listaproduto= produtodao.Listar();
		if(listaproduto == null){
			throw new Exception("Nenhumm produto cadastrado");
		}
		return listaproduto;
	}

	@Override
	public void Alterar(Produto produto) throws Exception {
		if(produto.getNome() == null) {
			throw new Exception("Nome do produto é Invalido");
		}else if(produto.getPreco() == null) {
			throw new Exception("Preço do produto é Invalido");
		}
		produtodao.Alterar(produto);	
	}

	@Override
	public Produto BuscarID(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Produto pesquisado é inválido");
		}
		else if(id <= 0) {
			throw new Exception("Produto pesquisado é inválido");
		}
		
		return produtodao.BuscarID(id);
	}

	@Override
	public void Excluir(Produto produto) throws Exception {
		if(produto.getNome() == null) {
			throw new Exception("produto selecionado é inválido.");
		}
		produtodao.Excluir(produto);			
	}
	
}
