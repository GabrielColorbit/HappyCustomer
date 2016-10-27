package br.edu.facear.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.edu.facear.crm.entity.Cidade;
import br.edu.facear.crm.entity.Estado;
import br.edu.facear.crm.entity.TipoTelefone;
import br.edu.facear.facade.FacadeHappyCustomer;

public class CidadeTest {
	
	FacadeHappyCustomer facade = new FacadeHappyCustomer();
	@SuppressWarnings("deprecation")
	
	Cidade Cidade = new Cidade();
	Estado Estado = new Estado();
	
	// CADASTRAR
	//@Test
	public void testCadastroCidade() throws Exception {
		
		Cidade.setNome("Curitiba");
		Estado.setId(1l);
		Cidade.setId_estado(Estado);
		facade.CadastrarCidade(Cidade);
		Assert.assertEquals(true, Cidade.getId() != null && Cidade.getId_estado() != null);
	}

	// ALTERAR
	//@Test
	public void testAterarCidade() throws Exception {
		Cidade Cidade = facade.BuscarCidadePorId(1l);
		Cidade.setNome("Guarulhos");
		Estado.setId(2l);
		Cidade.setId_estado(Estado);
		facade.AlterarCidade(Cidade);
		Assert.assertEquals(true, Cidade.getNome().equals("Guarulhos"));
	}
	
	//EXCLUIR
	//@Test
	public void testExcluirCidade() throws Exception {
		Cidade Cidade = facade.BuscarCidadePorId(1l);
		facade.ExcluirCidade(Cidade);
		//Cidade = facade.BuscarCidadePorId(1l);
		//Assert.assertEquals(true, Cidade.getId() == null);
	}
	
	// LISTAR
	//@Test
	public void testListarCidade() throws Exception {
		List<Cidade> Cidade = new ArrayList<Cidade>();
		Cidade = facade.ListarCidade();
		Assert.assertEquals(true, Cidade.size() > 0);
		System.out.println("CIDADE(S) CADASTRADA(S)");
		for (Cidade Cidade2 : Cidade) {
			System.out.println("Id: "+Cidade2.getId()+"  Nome: "+Cidade2.getNome()+"  Tipo Estado:"+Cidade2.getId_estado());
		}
	}
}