package br.edu.facear.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.edu.facear.crm.entity.OrigemContato;
import br.edu.facear.facade.FacadeHappyCustomer;

public class OrigemContatoTest {

	FacadeHappyCustomer facade = new FacadeHappyCustomer();

	@SuppressWarnings("deprecation")

	// CADASTRAR
	@Test
	public void testCadastroOrigemContato() throws Exception {
		for (int i = 0; i < 1; i++) {
			OrigemContato OrigemContato = new OrigemContato();
			OrigemContato.setNome("E-mail");
			facade.CadastrarOrigemContato(OrigemContato);
			Assert.assertEquals(true, OrigemContato.getId() != null);
		}
	}

	// ALTERAR
	// @Test
	public void testAterarOrigemContato() throws Exception {
		OrigemContato OrigemContato = facade.BuscarOrigemContatoPorId(1l);
		OrigemContato.setNome("Skype");
		facade.AlterarOrigemContato(OrigemContato);
		Assert.assertEquals(true, OrigemContato.getNome().equals("Skype"));
	}

	// EXCLUIR
	// @Test
	public void testExcluirOrigemContato() throws Exception {
		OrigemContato OrigemContato = facade.BuscarOrigemContatoPorId(3l);
		facade.ExcluirOrigemContato(OrigemContato);
		// OrigemContato = facade.BuscarOrigemContatoPorId(1l);
		// Assert.assertEquals(true, OrigemContato.getId() == null);
	}

	// LISTAR
	// @Test
	public void testListarOrigemContato() throws Exception {
		List<OrigemContato> OrigemContato = new ArrayList<OrigemContato>();
		OrigemContato = facade.ListarOrigemContato();
		Assert.assertEquals(true, OrigemContato.size() > 0);
		System.out.println("ORIGENS DE CONTATO(S) CADASTRADO(S)");
		for (OrigemContato OrigemContato2 : OrigemContato) {
			System.out.println("Id: " + OrigemContato2.getId() + "  Nome: " + OrigemContato2.getNome());
		}
	}
}