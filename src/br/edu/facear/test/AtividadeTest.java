package br.edu.facear.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
	public void testCadastroAtividade() throws Exception {
		
		for (int i = 0; i < 2; i++) {
			Atividade.setNome("Conserto Mackbook");
			Calendar datacadastro = new GregorianCalendar(31, 10, 2016);
			Atividade.setDatacadastro(datacadastro.getTime());
			Calendar datainicio = new GregorianCalendar(31, 10, 2016);
			Atividade.setDatainicio(datainicio.getTime());
			Calendar datafim = new GregorianCalendar(02, 11, 2016);
			Atividade.setDatafim(datafim.getTime());
			Atividade.setDescricao("Vamos estar consertando o mackbook.");
			Atividade.setSituacao(Situacao.Aberto);
			
			// USUÁRIO RESPONSÁVEL PELA ATIVIDADE
			Usuario.setId(5l);
			Atividade.setUsuarioresponsavel(Usuario);
	
			// CONTATO RESPONSÁVEL PELA ATIVIDADE
			Contato.setId(6l);
			Atividade.setContato(Contato);
	
			// EMPRESA DO CONTATO RESPONSÁVEL PELA ATIVIDADE
			Empresa.setId(7l);
			Atividade.setEmpresa(Empresa);
			
			// TIPO DE ATIVIDADE
			TipoAtividade.setId(1l);
			Atividade.setTipoatividade(TipoAtividade);
			
			// CADASTRANDO COMUNICADOR
			Comunicador.setNome("atividade1@atividade1.com");
			TipoComunicador.setId(1l);
			Comunicador.setTipocomunicador(TipoComunicador);
			facade.CadastrarComunicador(Comunicador);
	
			List<Comunicador> comunicadores_atividade = new ArrayList<Comunicador>();
			comunicadores_atividade.add(Comunicador);
			Atividade.setComunicadores_atividade(comunicadores_atividade);
			
			//CADASTRAR
			facade.CadastrarAtividade(Atividade);
			Assert.assertEquals(true, Atividade.getId() != null);
		}
	}

	// ALTERAR
	//@Test
	public void testAterarAtividade() throws Exception {
		Atividade Atividade = facade.BuscarAtividadePorId(1l);

		Atividade.setNome("Conserto Samsung AtiveBook");
		Calendar datacadastro = new GregorianCalendar(31, 10, 2016);
		Atividade.setDatacadastro(datacadastro.getTime());
		Calendar datainicio = new GregorianCalendar(31, 10, 2016);
		Atividade.setDatacadastro(datainicio.getTime());
		Calendar datafim = new GregorianCalendar(02, 11, 2016);
		Atividade.setDatafim(datafim.getTime());
		Atividade.setDescricao("Foi consertando o ativebook.");
		Atividade.setSituacao(Situacao.Finalizado);
		
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
		
		// ALTERANDO COMUNICADOR
		Comunicador Comunicador = facade.BuscarComunicadorPorId(1l);
		Comunicador.setNome("atividade2@atividade2.com");
		TipoComunicador.setId(1l);
		Comunicador.setTipocomunicador(TipoComunicador);
		facade.AlterarComunicador(Comunicador);

		List<Comunicador> comunicadores_atividade = new ArrayList<Comunicador>();
		comunicadores_atividade.add(Comunicador);
		Atividade.setComunicadores_atividade(comunicadores_atividade);
		
		facade.AlterarAtividade(Atividade);
		Assert.assertEquals(true, Atividade.getNome().equals("Conserto Samsung AtiveBook"));
	}
	
	//EXCLUIR
	//@Test
	public void testExcluirAtividade() throws Exception {
		Atividade Atividade = facade.BuscarAtividadePorId(1l);
		facade.ExcluirAtividade(Atividade);
	}
	
	// LISTAR
	//@Test
	public void testListarAtividade() throws Exception {
		List<Atividade> Atividade = new ArrayList<Atividade>();
		Atividade = facade.ListarAtividade();
		Assert.assertEquals(true, Atividade.size() > 0);
		System.out.println("ATIVIDADE(S) CADASTRADA(S)");
		for (Atividade Atividade2 : Atividade) {
			System.out.println("Id: "+Atividade2.getId()+"  Nome: "+Atividade2.getNome());
		}
	}
}