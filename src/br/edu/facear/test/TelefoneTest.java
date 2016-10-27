package br.edu.facear.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.edu.facear.crm.entity.Telefone;
import br.edu.facear.crm.entity.TipoComunicador;
import br.edu.facear.crm.entity.TipoTelefone;
import br.edu.facear.facade.FacadeHappyCustomer;

public class TelefoneTest {
	
	FacadeHappyCustomer facade = new FacadeHappyCustomer();
	@SuppressWarnings("deprecation")
	
	Telefone Telefone = new Telefone();
	TipoTelefone TipoTelefone = new TipoTelefone();
	
	// CADASTRAR
	//@Test
	public void testCadastroTelefone() throws Exception {
		
		Telefone.setNumero("123456789");
		TipoTelefone.setId(1l);
		Telefone.setId_tipotelefone(TipoTelefone);
		facade.CadastrarTelefone(Telefone);
		Assert.assertEquals(true, Telefone.getId() != null && Telefone.getId_tipotelefone()!= null);
	}

	// ALTERAR
	@Test
	public void testAterarTelefone() throws Exception {
		
		Telefone Telefone = facade.BuscarTelefonePorId(2l);
		Telefone.setNumero("987654321");
		TipoTelefone.setId(3l);
		Telefone.setId_tipotelefone(TipoTelefone);
		facade.AlterarTelefone(Telefone);
		Assert.assertEquals(true, Telefone.getNumero().equals("987654321"));
	}
	
	//EXCLUIR
	//@Test
	public void testExcluirTelefone() throws Exception {
		
		Telefone Telefone = facade.BuscarTelefonePorId(3l);
		facade.ExcluirTelefone(Telefone);
		//Telefone = facade.BuscarTelefonePorId(1l);
		//Assert.assertEquals(true, Telefone.getId() == null);
	}
	
	// LISTAR
	@Test
	public void testListarTelefone() throws Exception {
		
		List<Telefone> Telefone = new ArrayList<Telefone>();
		Telefone = facade.ListarTelefone();
		Assert.assertEquals(true, Telefone.size() > 0);
		System.out.println("TELEFONE(S) CADASTRADO(S)");
		for (Telefone Telefone2 : Telefone) {
			System.out.println("Id: "+Telefone2.getId()+"  Número: "+Telefone2.getNumero()+"Tipo Telefone: "+Telefone2.getId_tipotelefone());
		}
	}
}