package br.edu.facear.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.edu.facear.crm.entity.Comunicador;
import br.edu.facear.crm.entity.TipoComunicador;
import br.edu.facear.facade.FacadeHappyCustomer;

public class ComunicadorTest {

	FacadeHappyCustomer facade = new FacadeHappyCustomer();

	Comunicador Comunicador = new Comunicador();
	TipoComunicador TipoComunicador = new TipoComunicador();

	// CADASTRAR
	@Test
	public void testCadastrarComunicador() throws Exception {

		Comunicador.setNome("comunicadorTest@facebook.com");
		TipoComunicador.setId(1l);
		Comunicador.setTipocomunicador(TipoComunicador);
		facade.CadastrarComunicador(Comunicador);
		Assert.assertEquals(true, Comunicador.getId() != null && Comunicador.getTipocomunicador() != null);
	}

	// ALTERAR
	// @Test
	public void testAterarComunicador() throws Exception {

		Comunicador Comunicador = facade.BuscarComunicadorPorId(2l);
		Comunicador.setNome("comunicadorTest@gmail.com");
		TipoComunicador.setId(2l);
		Comunicador.setTipocomunicador(TipoComunicador);
		facade.AlterarComunicador(Comunicador);
		Assert.assertEquals(true, Comunicador.getNome().equals("comunicadorTest@gmail.com"));
	}

	// EXCLUIR
	// @Test
	public void testExcluirComunicador() throws Exception {
		Comunicador Comunicador = facade.BuscarComunicadorPorId(3l);
		facade.ExcluirComunicador(Comunicador);
		// Comunicador = facade.BuscarComunicadorPorId(1l);
		// Assert.assertEquals(true, Comunicador.getId() == null);
	}

	// LISTAR
	// @Test
	public void testListarComunicador() throws Exception {
		List<Comunicador> Comunicador = new ArrayList<Comunicador>();
		Comunicador = facade.ListarComunicador();
		Assert.assertEquals(true, Comunicador.size() > 0);
		System.out.println("ORIGENS DE CONTATO(S) CADASTRADO(S)");
		for (Comunicador Comunicador2 : Comunicador) {
			System.out.println("Id: " + Comunicador2.getId() + "  Nome: " + Comunicador2.getNome()
					+ "Tipo Comunicador: " + Comunicador2.getTipocomunicador().getNome());
		}
	}
}