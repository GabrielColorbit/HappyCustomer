package br.edu.facear.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.edu.facear.crm.entity.TipoAtividade;
import br.edu.facear.facade.FacadeHappyCustomer;

public class TipoAtividadeTest {

	FacadeHappyCustomer facade = new FacadeHappyCustomer();

	// CADASTRAR
	@Test
	public void testCadastroTipoAtividade() throws Exception {
		for (int i = 0; i < 1; i++) {
			TipoAtividade TipoAtividade = new TipoAtividade();
			TipoAtividade.setNome("Formatação");
			facade.CadastrarTipoAtividade(TipoAtividade);
			Assert.assertEquals(true, TipoAtividade.getId() != null);
		}
	}

	// ALTERAR
	//@Test
	public void testAterarTipoAtividade() throws Exception {
		TipoAtividade TipoAtividade = facade.BuscarTipoAtividadePorId(2l);
		TipoAtividade.setNome("Conserto");
		facade.AlterarTipoAtividade(TipoAtividade);
		Assert.assertEquals(true, TipoAtividade.getNome().equals("Conserto"));
	}

	// EXCLUIR
	//@Test
	public void testExcluirTipoAtividade() throws Exception {
		TipoAtividade TipoAtividade = facade.BuscarTipoAtividadePorId(1l);
		facade.ExcluirTipoAtividade(TipoAtividade);
		// TipoAtividade = facade.BuscarTipoAtividadePorId(2l);
		// Assert.assertEquals(true, TipoAtividade.getTipoAtividadeID() ==
		// null);
	}

	// LISTAR
	// @Test
	public void testListarTipoAtividade() throws Exception {
		List<TipoAtividade> TipoAtividade = new ArrayList<TipoAtividade>();
		TipoAtividade = facade.ListarTipoAtividade();
		Assert.assertEquals(true, TipoAtividade.size() > 0);
		System.out.println("TIPOS DE ATIVIDADE(S) CADASTRADA(S)");
		for (TipoAtividade TipoAtividade2 : TipoAtividade) {
			System.out.println("Id: " + TipoAtividade2.getId() + "  Nome: " + TipoAtividade2.getNome());
		}
	}
}