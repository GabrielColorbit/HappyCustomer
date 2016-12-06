package br.edu.facear.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.edu.facear.crm.entity.Atividade;
import br.edu.facear.crm.entity.Contato;
import br.edu.facear.crm.entity.Empresa;
import br.edu.facear.crm.entity.Ligacao;
import br.edu.facear.crm.entity.Telefone;
import br.edu.facear.crm.entity.TipoLigacao;
import br.edu.facear.crm.entity.TipoTelefone;
import br.edu.facear.crm.entity.Usuario;
import br.edu.facear.facade.FacadeHappyCustomer;

public class LigacaoTest {

	FacadeHappyCustomer facade = new FacadeHappyCustomer();

	Ligacao Ligacao = new Ligacao();
	Usuario Usuario = new Usuario();
	Contato Contato = new Contato();
	Empresa Empresa = new Empresa();
	Atividade Atividade = new Atividade();
	Telefone Telefone = new Telefone();
	TipoTelefone TipoTelefone = new TipoTelefone();

	SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy HH:mm:ss");

	// CADASTRAR
	@Test
	public void testCadastrarLigacao() throws Exception {

		for (int i = 0; i<30; i++){
			
			FacadeHappyCustomer facade = new FacadeHappyCustomer();

			Ligacao Ligacao = new Ligacao();
			Usuario Usuario = new Usuario();
			Contato Contato = new Contato();
			Empresa Empresa = new Empresa();
			Telefone Telefone = new Telefone();
			
			// ATRIBUTOS
			Ligacao.setData("19/11/2016");
			Telefone.setId(1l);
			Ligacao.setTelefone(Telefone);
			Ligacao.setDuracao("02:10s");
			Ligacao.setTipoligacao(TipoLigacao.Efetuada);
			Ligacao.setResumo("Liguei pra informar que a máquina foi consertada.");

			// USUÁRIO RESPONSÁVEL PELA LIGAÇÃO
			Usuario.setId(1l);
			Ligacao.setUsuarioresponsavel(Usuario);

			// CONTATO RESPONSÁVEL PELA LIGAÇÃO
			Contato.setId(1l);
			Ligacao.setContato(Contato);

			// EMPRESA DO CONTATO RESPONSÁVEL PELA LIGAÇÃO
			Empresa.setId(1l);
			Ligacao.setEmpresa(Empresa);

			// ATIVIDADE RELACIONADA COM A LIGAÇÃO
			// Atividade.setId(1l);
			// Ligacao.setAtividade(Atividade);

			// CADASTRAR
			facade.CadastrarLigacao(Ligacao);
			Assert.assertEquals(true, Ligacao.getId() != null);
		}
	}

	// ALTERAR
	// @Test
	public void testAterarLigacao() throws Exception {

		Ligacao Ligacao = facade.BuscarLigacaoPorId(2l);

		// ATRIBUTOS
		Ligacao.setData("20/11/2016");
		Ligacao.setDuracao("10:57s");
		Ligacao.setTipoligacao(TipoLigacao.Recebida);
		Ligacao.setResumo("Ligou agradecendo pelo conserto da máquina.");

		// USUÁRIO RESPONSÁVEL PELA LIGAÇÃO
		Usuario.setId(2l);
		Ligacao.setUsuarioresponsavel(Usuario);

		// CONTATO RESPONSÁVEL PELA LIGAÇÃO
		Contato.setId(2l);
		Ligacao.setContato(Contato);

		// EMPRESA DO CONTATO RESPONSÁVEL PELA LIGAÇÃO
		Empresa.setId(2l);
		Ligacao.setEmpresa(Empresa);

		// ATIVIDADE RELACIONADA COM A LIGAÇÃO
		// Atividade.setId(1l);
		// Ligacao.setAtividade(Atividade);

		// ALTERAR
		facade.AlterarLigacao(Ligacao);
		Assert.assertEquals(true, Ligacao.getDuracao().equals("10:57s"));
	}

	// EXCLUIR
	// @Test
	public void testExcluirLigacao() throws Exception {
		Ligacao Ligacao = facade.BuscarLigacaoPorId(1l);
		facade.ExcluirLigacao(Ligacao);
	}

	// LISTAR
	// @Test
	public void testListarLigacao() throws Exception {
		List<Ligacao> Ligacao = new ArrayList<Ligacao>();
		Ligacao = facade.ListarLigacao();
		Assert.assertEquals(true, Ligacao.size() > 0);
		System.out.println("LIGAÇÃO(ÕES) CADASTRADA(S)");
		for (Ligacao Ligacao2 : Ligacao) {
			System.out.println(
					"Id: " + Ligacao2.getId() + "  Data: " + Ligacao2.getData() + "Duração: " + Ligacao2.getDuracao()
							+ "Tipo Ligação: " + Ligacao2.getTipoligacao() + "Resumo: " + Ligacao2.getResumo());
		}
	}
}