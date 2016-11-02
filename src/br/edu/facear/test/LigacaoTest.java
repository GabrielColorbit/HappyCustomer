package br.edu.facear.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
	@SuppressWarnings("deprecation")

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

		// ATRIBUTOS
		//Calendar data = new GregorianCalendar(31, 10, 2016);
		//Ligacao.setData(data.getTime());
		//Ligacao.setData(sdf.format(new Date(("31/10/2016")));
		Ligacao.setDuracao("02:10s");
		Ligacao.setTipoligacao(TipoLigacao.efetuada);
		Ligacao.setResumo("Liguei pra informar que a m�quina foi consertada.");

		// USU�RIO RESPONS�VEL PELA LIGA��O
		Usuario.setId(1l);
		Ligacao.setUsuarioresponsavel(Usuario);

		// CONTATO RESPONS�VEL PELA LIGA��O
		Contato.setId(1l);
		Ligacao.setContato(Contato);

		// EMPRESA DO CONTATO RESPONS�VEL PELA LIGA��O
		Empresa.setId(1l);
		Ligacao.setEmpresa(Empresa);

		// ATIVIDADE RELACIONADA COM A LIGA��O
		Atividade.setId(1l);
		Ligacao.setAtividade(Atividade);

		// CADASTRAR
		facade.CadastrarLigacao(Ligacao);
		Assert.assertEquals(true, Ligacao.getId() != null);
	}

	// ALTERAR
	// @Test
	public void testAterarLigacao() throws Exception {

		Empresa Empresa = facade.BuscarEmpresaPorId(3l);

		// ATRIBUTOS
		Calendar data = new GregorianCalendar(01, 11, 2016);
		Ligacao.setData(data.getTime());
		Ligacao.setDuracao("10:57s");
		Ligacao.setTipoligacao(TipoLigacao.recebida);
		Ligacao.setResumo("Ligou agradecendo pelo conserto da m�quina.");

		// USU�RIO RESPONS�VEL PELA LIGA��O
		Usuario.setId(1l);
		Ligacao.setUsuarioresponsavel(Usuario);

		// CONTATO RESPONS�VEL PELA LIGA��O
		Contato.setId(1l);
		Ligacao.setContato(Contato);

		// EMPRESA DO CONTATO RESPONS�VEL PELA LIGA��O
		Empresa.setId(1l);
		Ligacao.setEmpresa(Empresa);

		// ATIVIDADE RELACIONADA COM A LIGA��O
		// Atividade.setId(1l);
		// Ligacao.setAtividade(Atividade);

		// ALTERAR
		facade.AlterarLigacao(Ligacao);
		Assert.assertEquals(true, Ligacao.getDuracao().equals("10:57s"));
	}

	// EXCLUIR
	//@Test
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
		System.out.println("LIGA��O(�ES) CADASTRADA(S)");
		for (Ligacao Ligacao2 : Ligacao) {
			System.out.println(
					"Id: " + Ligacao2.getId() + "  Data: " + Ligacao2.getData() + "Dura��o: " + Ligacao2.getDuracao()
							+ "Tipo Liga��o: " + Ligacao2.getTipoligacao() + "Resumo: " + Ligacao2.getResumo());
		}
	}
}