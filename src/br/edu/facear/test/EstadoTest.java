package br.edu.facear.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.edu.facear.crm.entity.Estado;
import br.edu.facear.facade.FacadeHappyCustomer;

public class EstadoTest {

	FacadeHappyCustomer facade = new FacadeHappyCustomer();

	// CADASTRAR
	@Test
	public void testCadastrarEstado() throws Exception {

		Estado Estado = new Estado();
		Estado.setNome("São Paulo");
		Estado.setPais("Brasil");
		facade.CadastrarEstado(Estado);
		Assert.assertEquals(true, Estado.getId() != null);
	}

	// ALTERAR
	// @Test
	public void testAterarEstado() throws Exception {
		Estado Estado = facade.BuscarEstadoPorId(2l);
		Estado.setNome("Santa Catarina");
		Estado.setPais("Brasil");
		facade.AlterarEstado(Estado);
		Assert.assertEquals(true, Estado.getNome().equals("Santa Catarina"));
	}

	// EXCLUIR
	// @Test
	public void testExcluirEstado() throws Exception {
		Estado Estado = facade.BuscarEstadoPorId(1l);
		facade.ExcluirEstado(Estado);
		// Estado = facade.BuscarEstadoPorId(1l);
		// Assert.assertEquals(true, Estado.getId() == null);
	}

	// LISTAR
	// @Test
	public void testListarEstado() throws Exception {
		List<Estado> Estado = new ArrayList<Estado>();
		Estado = facade.ListarEstado();
		Assert.assertEquals(true, Estado.size() > 0);
		System.out.println("ESTADO(S) CADASTRADO(S)");
		for (Estado Estado2 : Estado) {
			System.out
					.println("Id: " + Estado2.getId() + "  Nome: " + Estado2.getNome() + "País: " + Estado2.getPais());
		}
	}
}