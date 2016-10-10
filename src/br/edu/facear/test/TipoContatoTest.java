package br.edu.facear.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.edu.facear.crm.entity.Empresa;
import br.edu.facear.crm.entity.TipoContato;
import br.edu.facear.facade.Facade;
import junit.framework.Assert;

public class TipoContatoTest {
	
	@SuppressWarnings("deprecation")
	@Test
	public void testCadastroTipoContato() throws Exception{
		TipoContato a = new TipoContato();
		a.setNome("Prospect");
		Facade f = new Facade();
		f.cadastrarTipoContato(a);
		Assert.assertEquals(true, a.getId() != null);
	}
	@Test
	public void testAterarTipoCOntato() throws Exception{
		Facade f = new Facade();
		TipoContato t = f.buscarTipoContatoPorId(1l);
		t.setNome("Administrador");
		f.alterarTipoContato(t);
		t = f.buscarTipoContatoPorId(1l);
		
		Assert.assertEquals(true, t.getNome().equals("Administrador"));
	}
	
	@Test
	public void testListarTipoContato() throws Exception {
		List<TipoContato> ts = new ArrayList<TipoContato>();
		Facade f = new Facade();
		
		ts = f.listarTipoContato();
		
		Assert.assertEquals(true,ts.size() > 0);
		
	}
}
