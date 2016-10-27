package br.edu.facear.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.edu.facear.crm.entity.TipoContato;
import br.edu.facear.facade.FacadeHappyCustomer;

public class TipoContatoTest {
	
	FacadeHappyCustomer facade = new FacadeHappyCustomer();
	@SuppressWarnings("deprecation")
	
<<<<<<< HEAD
	// CADASTRAR
	//@Test
	public void testCadastroTipoContato() throws Exception {
		TipoContato TipoContato = new TipoContato();
		TipoContato.setNome("Prospect");
		facade.CadastrarTipoContato(TipoContato);
		Assert.assertEquals(true, TipoContato.getId() != null);
	}

=======
	// CADASTRANDO CORRETAMENTO AGORA
	@Test
	public void testCadastroTipoContato() throws Exception {
		TipoContato tipocontato = new TipoContato();
		tipocontato.setNome("Operador");
		facade.CadastrarTipoContato(tipocontato);
		Assert.assertEquals(true, tipocontato.getId() != null);
	}//aqui consegui arrumar
	/*
>>>>>>> origin/master
	// ALTERAR
	@Test
	public void testAterarTipoContato() throws Exception {
		TipoContato TipoContato = facade.BuscarTipoContatoPorId(5l);
		TipoContato.setNome("Cliente");
		facade.AlterarTipoContato(TipoContato);
		Assert.assertEquals(true, TipoContato.getNome().equals("Cliente"));
	}
	
	//EXCLUIR
	//@Test
	public void testExcluirTipoContato() throws Exception {
		TipoContato TipoContato = facade.BuscarTipoContatoPorId(1l);
		facade.ExcluirTipoContato(TipoContato);
		//TipoContato = facade.BuscarTipoContatoPorId(1l);
		//Assert.assertEquals(true, TipoContato.getId() == null);
	}
	
	// LISTAR
	//@Test
	public void testListarTipoContato() throws Exception {
		List<TipoContato> TipoContato = new ArrayList<TipoContato>();
		TipoContato = facade.ListarTipoContato();
		Assert.assertEquals(true, TipoContato.size() > 0);
		System.out.println("TIPOS DE CONTATO(S) CADASTRADO(S)");
		for (TipoContato TipoContato2 : TipoContato) {
			System.out.println("Id: "+TipoContato2.getId()+"  Nome: "+TipoContato2.getNome());
		}
	}
}