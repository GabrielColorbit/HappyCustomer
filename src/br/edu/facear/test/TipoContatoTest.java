package br.edu.facear.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.edu.facear.crm.entity.TipoContato;
import br.edu.facear.facade.FacadeHappyCustomer;
import junit.framework.Assert;

public class TipoContatoTest {
	
	FacadeHappyCustomer facade = new FacadeHappyCustomer();
	@SuppressWarnings("deprecation")
	
	// CADASTRAR
	@Test
	public void testCadastroTipoContato() throws Exception {
		TipoContato tipocontato = new TipoContato();
		tipocontato.setNome("FUCK New");
		facade.CadastrarTipoContato(tipocontato);
		Assert.assertEquals(true, tipocontato.getId() != null);
	}
	/*
	// ALTERAR
	@Test
	public void testAterarTipoContato() throws Exception {
		TipoContato tipocontato = facade.BuscarTipoContatoPorId(6l);
		tipocontato.setNome("MOTHERFUCKER");
		facade.AlterarTipoContato(tipocontato);
		tipocontato = facade.BuscarTipoContatoPorId(6l);
		Assert.assertEquals(true, tipocontato.getNome().equals("MOTHERFUCKER"));
	}
	
	//EXCLUIR
	@Test
	public void testExcluirTipoContato() throws Exception {
		TipoContato tipocontato = facade.BuscarTipoContatoPorId(5l);
		facade.ExcluirTipoContato(tipocontato);
		//tipocontato = facade.BuscarTipoContatoPorId(2l);
		//Assert.assertEquals(true, tipocontato.getId() == null);
	}
	*/
	// LISTAR
	@Test
	public void testListarTipoContato() throws Exception {
		List<TipoContato> tipocontato = new ArrayList<TipoContato>();
		tipocontato = facade.ListarTipoContato();
		Assert.assertEquals(true, tipocontato.size() > 0);
		for(int i=0; i<tipocontato.size();i++){
			System.out.println("Id: "+tipocontato.get(i).getId()+" Nome: "+tipocontato.get(i).getNome());
		}
	}	
}