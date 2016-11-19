package br.edu.facear.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.edu.facear.crm.entity.TipoUsuario;
import br.edu.facear.facade.FacadeHappyCustomer;

public class TipoUsuarioTest {

	FacadeHappyCustomer facade = new FacadeHappyCustomer();

	// CADASTRAR
	@Test
	public void testCadastrarTipoUsuario() throws Exception {

		TipoUsuario TipoUsuario = new TipoUsuario();
		TipoUsuario.setNome("Administrador");
		facade.CadastrarTipoUsuario(TipoUsuario);
		Assert.assertEquals(true, TipoUsuario.getId() != null);

	}

	// ALTERAR
	// @Test
	public void testAterarTipoUsuario() throws Exception {
		TipoUsuario TipoUsuario = facade.BuscarTipoUsuarioPorId(2l);
		TipoUsuario.setNome("Operador");
		facade.AlterarTipoUsuario(TipoUsuario);
		Assert.assertEquals(true, TipoUsuario.getNome().equals("Operador"));
	}

	// EXCLUIR
	// @Test
	public void testExcluirTipoUsuario() throws Exception {
		TipoUsuario TipoUsuario = facade.BuscarTipoUsuarioPorId(1l);
		facade.ExcluirTipoUsuario(TipoUsuario);
		// TipoUsuario = facade.BuscarTipoUsuarioPorId(1l);
		// Assert.assertEquals(true, TipoUsuario.getTipoUsuarioID() == null);
	}

	// LISTAR
	// @Test
	public void testListarTipoUsuario() throws Exception {
		List<TipoUsuario> TipoUsuario = new ArrayList<TipoUsuario>();
		TipoUsuario = facade.ListarTipoUsuario();
		Assert.assertEquals(true, TipoUsuario.size() > 0);
		System.out.println("TIPOS DE USUÁRIO(S) CADASTRADO(S)");
		for (TipoUsuario TipoUsuario2 : TipoUsuario) {
			System.out.println("Id: " + TipoUsuario2.getId() + "  Nome: " + TipoUsuario2.getNome());
		}
	}
}