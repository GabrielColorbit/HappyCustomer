package br.edu.facear.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;
import org.junit.Assert;
import org.junit.Test;

import br.edu.facear.crm.entity.Atividade;
import br.edu.facear.crm.entity.Contato;
import br.edu.facear.crm.entity.Empresa;
import br.edu.facear.crm.entity.Situacao;
import br.edu.facear.crm.entity.TipoAtividade;
import br.edu.facear.crm.entity.TipoComunicador;
import br.edu.facear.crm.entity.Usuario;
import br.edu.facear.facade.FacadeHappyCustomer;

public class AtividadeTest {
	
	FacadeHappyCustomer facade = new FacadeHappyCustomer();
	@SuppressWarnings("deprecation")
	
	// CADASTRAR
	@Test
	/*public void testCadastroAtividade() throws Exception {
		Atividade Atividade = new Atividade();
		
		
		
		Atividade.setNome("E-mail");
		Atividade.setDataRegistro("");
		Atividade.setDataInicio("");
		Atividade.setDataFim("");
		Atividade.setDescricao("");
		
		private Contato contato;
		Atividade.setSitu
		
		private String nome;
		private Date datainicio;
		private Date datafim;
		private String descricao;
		
		@ForeignKey(name="fk_usuario")
		private Usuario usuario;
		@ManyToOne
		@ForeignKey(name="fk_empresa")
		private Empresa empresa;
		@ManyToOne
		@ForeignKey(name="fk_tipoatividade")	
		private TipoAtividade tipoatividade;
		@ManyToOne
		@ForeignKey(name="fk_tipocomunicador")
		private TipoComunicador tipocomunicador;
		@ManyToOne
		@ForeignKey(name="fk_contato")

		
		facade.CadastrarAtividade(Atividade);
		Assert.assertEquals(true, Atividade.getId() != null);
	}*/

	// ALTERAR
	//@Test
	public void testAterarAtividade() throws Exception {
		Atividade Atividade = facade.BuscarAtividadePorId(1l);
		Atividade.setNome("Skype");
		facade.AlterarAtividade(Atividade);
		Atividade = facade.BuscarAtividadePorId(1l);
		Assert.assertEquals(true, Atividade.getNome().equals("Skype"));
	}
	
	//EXCLUIR
	//@Test
	public void testExcluirAtividade() throws Exception {
		Atividade Atividade = facade.BuscarAtividadePorId(1l);
		facade.ExcluirAtividade(Atividade);
		//Atividade = facade.BuscarAtividadePorId(1l);
		//Assert.assertEquals(true, Atividade.getId() == null);
	}
	
	// LISTAR
	//@Test
	public void testListarAtividade() throws Exception {
		List<Atividade> Atividade = new ArrayList<Atividade>();
		Atividade = facade.ListarAtividade();
		Assert.assertEquals(true, Atividade.size() > 0);
		System.out.println("ORIGENS DE CONTATO(S) CADASTRADO(S)");
		for (Atividade Atividade2 : Atividade) {
			System.out.println("Id: "+Atividade2.getId()+"  Nome: "+Atividade2.getNome());
		}
	}
}