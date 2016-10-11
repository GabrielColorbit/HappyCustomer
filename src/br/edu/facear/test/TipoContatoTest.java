package br.edu.facear.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.edu.facear.crm.entity.Empresa;
import br.edu.facear.crm.entity.TipoContato;
import br.edu.facear.facade.FacadeHappyCustomer;
import junit.framework.Assert;

public class TipoContatoTest {
	
	@SuppressWarnings("deprecation")
	@Test
	public void testCadastroTipoContato() throws Exception{
		TipoContato a = new TipoContato();
		a.setNome("Prospect");
		FacadeHappyCustomer f = new FacadeHappyCustomer();
		f.CadastrarTipoContato(a);
		Assert.assertEquals(true, a.getId() != null);
	}
	@Test
	public void testAterarTipoCOntato() throws Exception{
		FacadeHappyCustomer f = new FacadeHappyCustomer();
		TipoContato t = f.BuscarTipoContatoPorId(1l);
		t.setNome("Administrador");
		f.AlterarTipoContato(t);
		t = f.BuscarTipoContatoPorId(1l);
		
		Assert.assertEquals(true, t.getNome().equals("Administrador"));
	}
	
	@Test
	public void testListarTipoContato() throws Exception {
		List<TipoContato> ts = new ArrayList<TipoContato>();
		FacadeHappyCustomer f = new FacadeHappyCustomer();
		
		ts = f.ListarTipoContato();
		
		Assert.assertEquals(true,ts.size() > 0);
		
	}}
