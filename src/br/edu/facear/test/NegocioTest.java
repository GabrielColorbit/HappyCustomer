package br.edu.facear.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.edu.facear.crm.entity.Empresa;
import br.edu.facear.crm.entity.Item;
import br.edu.facear.crm.entity.Negocio;
import br.edu.facear.crm.entity.Produto;
import br.edu.facear.facade.FacadeHappyCustomer;

public class NegocioTest {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	FacadeHappyCustomer facade = new FacadeHappyCustomer();

	Negocio Negocio = new Negocio();
	Produto Produto = new Produto();
	Empresa Empresa = new Empresa();

	Item Item = new Item();

	// CADASTRAR
	@Test
	public void testCadastrarNegocio() throws Exception {

		// ATRIBUTOS NEGÓCIO
		Negocio.setNome("Compra de Comida");
		Calendar data = new GregorianCalendar(29, 10, 2016);
		Negocio.setData(data.getTime());

		// EMPRESA RESPONSÁVEL PELO NEGÓCIO
		Empresa.setId(1l);
		Negocio.setEmpresa(Empresa);

		facade.CadastrarNegocio(Negocio);
		Assert.assertEquals(true, Negocio.getId() != null && Negocio.getId() != null);
		// TERMINA NEGÓCIO E JA INICIA O ITENS

		// ITENS DO NEGÓCIO
		Produto.setId(1l);
		Item.setProduto(Produto);
		Item.setNegocio(Negocio);
		Item.setQuantidade(2l);
		facade.CadastrarItem(Item);

	}

	// ALTERAR
	// @Test
	public void testAterarNegocio() throws Exception {

		Negocio Negocio = facade.BuscarNegocioPorId(1l);

		// ATRIBUTOS NEGÓCIO
		Negocio.setNome("Compra de Bebida");
		Calendar data = new GregorianCalendar(30, 10, 2016);
		Negocio.setData(data.getTime());

		// EMPRESA RESPONSÁVEL PELO NEGÓCIO
		Empresa.setId(2l);
		Negocio.setEmpresa(Empresa);

		facade.AlterarNegocio(Negocio);
		Assert.assertEquals(true, Negocio.getNome().equals("Compra de Bebida"));
		// TERMINA NEGÓCIO E JA INICIA O ITENS

		// ITENS DO NEGÓCIO
		Produto.setId(2l);
		Item.setProduto(Produto);
		Item.setNegocio(Negocio);
		Item.setQuantidade(7l);
		facade.CadastrarItem(Item);
	}

	// EXCLUIR
	// @Test
	public void testExcluirNegocio() throws Exception {

		// PRIMEIRO TEM QUE APAGAR TODOS OS ITENS RELACIONADOS AO NEGOCIO
		// ABAIXO,
		// SENÃO ELE NÃO DEIXA POR CAUSA DO RELACIONAMENTO.
		Item Item = facade.BuscarItemPorId(3l);
		facade.ExcluirItem(Item);

		Negocio Negocio = facade.BuscarNegocioPorId(2l);
		facade.ExcluirNegocio(Negocio);
	}

	// LISTAR
	// @Test
	public void testListarNegocio() throws Exception {
		List<Negocio> Negocio = new ArrayList<Negocio>();
		Negocio = facade.ListarNegocio();
		Assert.assertEquals(true, Negocio.size() > 0);
		System.out.println("NEGÓCIO(S) CADASTRADO(S)");
		for (Negocio Negocio2 : Negocio) {
			System.out.println("Id: " + Negocio2.getId() + "  Nome: " + Negocio2.getNome());
		}
	}
}