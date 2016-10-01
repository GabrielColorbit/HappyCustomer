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
			throw new Exception("Nome do produto � inv�lido");
		}else if(produto.getPreco() == null){
			throw new Exception("Pre�o do produto � inv�lido");
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
			throw new Exception("Nome do produto � Invalido");
		}else if(produto.getPreco() == null) {
			throw new Exception("Pre�o do produto � Invalido");
		}
		produtodao.editar(produto);	
	}

	@Override
	public Produto getObjectById(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Produto pesquisado � inv�lido");
		}
		else if(id <= 0) {
			throw new Exception("Produto pesquisado � inv�lido");
		}
		
		return produtodao.getObjectById(id);
	}

	@Override
	public void excluir(Produto produto) throws Exception {
		if(produto.getNome() == null) {
			throw new Exception("produto selecionado � inv�lido.");
		}
		produtodao.excluir(produto);			
	}
	
}
