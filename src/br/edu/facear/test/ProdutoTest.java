package br.edu.facear.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.edu.facear.crm.entity.Produto;
import br.edu.facear.facade.FacadeHappyCustomer;

public class ProdutoTest {
	
	FacadeHappyCustomer facade = new FacadeHappyCustomer();
	@SuppressWarnings("deprecation")
	
	// CADASTRAR
	@Test
	public void testCadastroProduto() throws Exception {
		Produto Produto = new Produto();
		Produto.setNome("Coxinha");
		Produto.setPreco(2.59f);

		facade.CadastrarProduto(Produto);
		
		Assert.assertEquals(true, Produto.getId() != null);
	}
	
	// ALTERAR
	//@Test
	public void testAterarProduto() throws Exception {
		Produto Produto = facade.BuscarProdutoPorId(3l);
		Produto.setNome("Coca-Cola");
		Produto.setPreco(5.78f);
		facade.AlterarProduto(Produto);
		Assert.assertEquals(true, Produto.getNome().equals("Coca-Cola"));
	}
	
	//EXCLUIR
	//@Test
	public void testExcluirProduto() throws Exception {
		Produto Produto = facade.BuscarProdutoPorId(2l);
		facade.ExcluirProduto(Produto);
		//Produto = facade.BuscarProdutoPorId(1l);
		//Assert.assertEquals(true, Produto.getProdutoID() == null);
	}
	
	// LISTAR
	//@Test
	public void testListarProduto() throws Exception {
		List<Produto> Produto = new ArrayList<Produto>();
		Produto = facade.ListarProduto();
		Assert.assertEquals(true, Produto.size() > 0);
		System.out.println("PRODUTO(S) CADASTRADO(S)");
		for (Produto Produto2 : Produto) {
			System.out.println("Id: "+Produto2.getId()+"  Nome: "+Produto2.getNome());
		}
	}
}