package br.edu.facear.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.edu.facear.crm.entity.TipoEmpresa;
import br.edu.facear.facade.FacadeHappyCustomer;
//import junit.framework.Assert;
import org.junit.Assert;

public class TipoEmpresaTest {
	
	FacadeHappyCustomer facade = new FacadeHappyCustomer();
	
	// CADASTRAR
	@Test
	public void testCadastroTipoEmpresa() throws Exception {
		for (int i = 0; i < 2; i++) {
			TipoEmpresa TipoEmpresa = new TipoEmpresa();
			TipoEmpresa.setNome(null);
			facade.CadastrarTipoEmpresa(TipoEmpresa);
			Assert.assertEquals(true, TipoEmpresa.getId() != null);
		}
	}
	
	// ALTERAR
	//@Test
	public void testAterarTipoEmpresa() throws Exception {
		TipoEmpresa TipoEmpresa = facade.BuscarTipoEmpresaPorId(1l);
		TipoEmpresa.setNome("Entregas");
		facade.AlterarTipoEmpresa(TipoEmpresa);
		Assert.assertEquals(true, TipoEmpresa.getNome().equals("Entregas"));
	}
	
	//EXCLUIR
	//@Test
	public void testExcluirTipoEmpresa() throws Exception {
		TipoEmpresa TipoEmpresa = facade.BuscarTipoEmpresaPorId(2l);
		facade.ExcluirTipoEmpresa(TipoEmpresa);
		//TipoEmpresa = facade.BuscarTipoEmpresaPorId(2l);
		//Assert.assertEquals(true, TipoEmpresa.getTipoEmpresaID() == null);
	}
	
	// LISTAR
	//@Test
	public void testListarTipoEmpresa() throws Exception {
		List<TipoEmpresa> TipoEmpresa = new ArrayList<TipoEmpresa>();
		TipoEmpresa = facade.ListarTipoEmpresa();
		Assert.assertEquals(true, TipoEmpresa.size() > 0);
		System.out.println("TIPOS DE EMPRESAS(S) CADASTRADA(S)");
		for (TipoEmpresa TipoEmpresa2 : TipoEmpresa) {
			System.out.println("Id: "+TipoEmpresa2.getId()+"  Nome: "+TipoEmpresa2.getNome());
		}
	}
}