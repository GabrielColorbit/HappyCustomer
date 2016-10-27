package br.edu.facear.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.edu.facear.crm.entity.TipoComunicador;
import br.edu.facear.facade.FacadeHappyCustomer;

public class TipoComunicadorTest {
	
	FacadeHappyCustomer facade = new FacadeHappyCustomer();
	@SuppressWarnings("deprecation")
	
	// CADASTRAR
	@Test
	public void testCadastroTipoComunicador() throws Exception {
		TipoComunicador TipoComunicador = new TipoComunicador();
		TipoComunicador.setNome("Whatsapp");
		facade.CadastrarTipoComunicador(TipoComunicador);
		Assert.assertEquals(true, TipoComunicador.getId() != null);
	}

	// ALTERAR
	//@Test
	public void testAterarTipoComunicador() throws Exception {
		TipoComunicador TipoComunicador = facade.BuscarTipoComunicadorPorId(1l);
		TipoComunicador.setNome("Whatsapp");
		facade.AlterarTipoComunicador(TipoComunicador);
		Assert.assertEquals(true, TipoComunicador.getNome().equals("Whatsapp"));
	}
	
	//EXCLUIR
	//@Test
	public void testExcluirTipoComunicador() throws Exception {
		TipoComunicador TipoComunicador = facade.BuscarTipoComunicadorPorId(2l);
		facade.ExcluirTipoComunicador(TipoComunicador);
		//TipoComunicador = facade.BuscarTipoComunicadorPorId(2l);
		//Assert.assertEquals(true, TipoComunicador.getTipoComunicadorID() == null);
	}
	
	// LISTAR
	//@Test
	public void testListarTipoComunicador() throws Exception {
		List<TipoComunicador> TipoComunicador = new ArrayList<TipoComunicador>();
		TipoComunicador = facade.ListarTipoComunicador();
		Assert.assertEquals(true, TipoComunicador.size() > 0);
		System.out.println("TIPOS DE COMUNICADOR(ES) CADASTRADO(S)");
		for (TipoComunicador TipoComunicador2 : TipoComunicador) {
			System.out.println("Id: "+TipoComunicador2.getId()+"  Nome: "+TipoComunicador2.getNome());
		}
	}
}