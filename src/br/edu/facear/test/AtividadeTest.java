package br.edu.facear.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.edu.facear.crm.entity.Atividade;
import br.edu.facear.crm.entity.Comunicador;
import br.edu.facear.crm.entity.Contato;
import br.edu.facear.crm.entity.Empresa;
import br.edu.facear.crm.entity.Situacao;
import br.edu.facear.crm.entity.TipoAtividade;
import br.edu.facear.crm.entity.TipoComunicador;
import br.edu.facear.crm.entity.Usuario;
import br.edu.facear.facade.FacadeHappyCustomer;

public class AtividadeTest {

	FacadeHappyCustomer facade = new FacadeHappyCustomer();

	Atividade Atividade = new Atividade();
	Usuario Usuario = new Usuario();
	Contato Contato = new Contato();
	Empresa Empresa = new Empresa();
	TipoAtividade TipoAtividade = new TipoAtividade();
	Comunicador Comunicador = new Comunicador();
	TipoComunicador TipoComunicador = new TipoComunicador();

	// CADASTRAR
	@Test
	public void testCadastrarAtividade() throws Exception {

		Atividade.setNome("Celular travando");
		Atividade.setDatacadastro("20/12/2016");
		Atividade.setDatainicio("20/11/2016");
		//Atividade.setDatafim("22/11/2016");
		Atividade.setDescricao("Vamos verificar a causa do bug.");
		Atividade.setSituacao(Situacao.Aberto);
		
		// USUÁRIO RESPONSÁVEL PELA ATIVIDADE
		Usuario.setId(1l);
		Atividade.setUsuarioresponsavel(Usuario);

		// CONTATO RESPONSÁVEL PELA ATIVIDADE
		Contato.setId(1l);
		Atividade.setContato(Contato);

		// EMPRESA DO CONTATO RESPONSÁVEL PELA ATIVIDADE
		Empresa.setId(1l);
		Atividade.setEmpresa(Empresa);

		// TIPO DE ATIVIDADE
		TipoAtividade.setId(1l);
		Atividade.setTipoatividade(TipoAtividade);

		// CADASTRANDO COMUNICADOR
		Comunicador.setNome("atividade1@atividade1.com");
		Comunicador.setData("04/12/2016");
		Comunicador.setResumo("Foi comprado um cartão SD de 64GB.");
		TipoComunicador.setId(1l);
		Comunicador.setTipocomunicador(TipoComunicador);
		facade.CadastrarComunicador(Comunicador);

		List<Comunicador> comunicadores_atividade = new ArrayList<Comunicador>();
		comunicadores_atividade.add(Comunicador);
		Atividade.setComunicadores_atividade(comunicadores_atividade);

		// CADASTRAR
		facade.CadastrarAtividade(Atividade);
		Assert.assertEquals(true, Atividade.getId() != null);

	}

	// ALTERAR
	// @Test
	public void testAterarAtividade() throws Exception {

		Atividade Atividade = facade.BuscarAtividadePorId(2l);

		Atividade.setNome("Notebook com problema na tela");
		Comunicador.setResumo("Foi comprado uma tela nova com pelicula de vidro.");
		Atividade.setDatacadastro("19/11/2016");
		Atividade.setDatainicio("19/11/2016");
		Atividade.setDatafim("22/11/2016");
		Atividade.setDescricao("Vamos consertar no prazo de 2 dias.");
		Atividade.setSituacao(Situacao.Finalizado);

		// USUÁRIO RESPONSÁVEL PELA ATIVIDADE
		Usuario.setId(2l);
		Atividade.setUsuarioresponsavel(Usuario);

		// CONTATO RESPONSÁVEL PELA ATIVIDADE
		Contato.setId(2l);
		Atividade.setContato(Contato);

		// EMPRESA DO CONTATO RESPONSÁVEL PELA ATIVIDADE
		Empresa.setId(2l);
		Atividade.setEmpresa(Empresa);

		// TIPO DE ATIVIDADE
		TipoAtividade.setId(2l);
		Atividade.setTipoatividade(TipoAtividade);

		// ALTERANDO COMUNICADOR
		Comunicador Comunicador = facade.BuscarComunicadorPorId(1l);
		Comunicador.setNome("atividade2@atividade2.com");
		TipoComunicador.setId(2l);
		Comunicador.setTipocomunicador(TipoComunicador);
		facade.AlterarComunicador(Comunicador);

		List<Comunicador> comunicadores_atividade = new ArrayList<Comunicador>();
		comunicadores_atividade.add(Comunicador);
		Atividade.setComunicadores_atividade(comunicadores_atividade);

		facade.AlterarAtividade(Atividade);
		Assert.assertEquals(true, Atividade.getNome().equals("Notebook com problema na tela"));
	}

	// EXCLUIR
	// @Test
	public void testExcluirAtividade() throws Exception {
		Atividade Atividade = facade.BuscarAtividadePorId(1l);
		facade.ExcluirAtividade(Atividade);
	}

	// LISTAR
	// @Test
	public void testListarAtividade() throws Exception {
		List<Atividade> Atividade = new ArrayList<Atividade>();
		Atividade = facade.ListarAtividade();
		Assert.assertEquals(true, Atividade.size() > 0);
		System.out.println("ATIVIDADE(S) CADASTRADA(S)");
		for (Atividade Atividade2 : Atividade) {
			System.out.println("Id: " + Atividade2.getId() + "  Nome: " + Atividade2.getNome());
		}
	}
}