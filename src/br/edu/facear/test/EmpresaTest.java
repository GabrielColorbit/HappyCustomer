package br.edu.facear.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.edu.facear.crm.entity.Cidade;
import br.edu.facear.crm.entity.Comunicador;
import br.edu.facear.crm.entity.Contato;
import br.edu.facear.crm.entity.Empresa;
import br.edu.facear.crm.entity.Status;
import br.edu.facear.crm.entity.Telefone;
import br.edu.facear.crm.entity.TipoComunicador;
import br.edu.facear.crm.entity.TipoEmpresa;
import br.edu.facear.crm.entity.TipoTelefone;
import br.edu.facear.crm.entity.Usuario;
import br.edu.facear.facade.FacadeHappyCustomer;

public class EmpresaTest {

	FacadeHappyCustomer facade = new FacadeHappyCustomer();

	Empresa Empresa = new Empresa();
	Contato Contato = new Contato();
	Usuario Usuario = new Usuario();
	TipoEmpresa TipoEmpresa = new TipoEmpresa();
	Cidade Cidade = new Cidade();
	Telefone Telefone = new Telefone();
	TipoTelefone TipoTelefone = new TipoTelefone();
	Comunicador Comunicador = new Comunicador();
	TipoComunicador TipoComunicador = new TipoComunicador();

	// SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy HH:mm:ss");

	// CADASTRAR
	@Test
	public void testCadastrarEmpresa() throws Exception {

		for (int i = 0; i < 3; i++) {
			// ATRIBUTOS
			Empresa.setRazaosocial("Gelopar Refrigeração Paranaense Ltda");
			Empresa.setCnpj("75190074000160");
			Empresa.setInscricaoestadual("1352678934");
			Empresa.setEndereco("Rua Dr. Eli Volpato");
			Empresa.setNumero(250l);
			Empresa.setComplemento("Próximo a Petrobrás");
			Empresa.setCep("83707250");
			Empresa.setBairro("Chapada");
			Empresa.setSite("www.gelopar.com.br");
			Empresa.setRamo("Refrigeração");
			Empresa.setLogo("C:\\Downloads\\Gelopar.png");
			Calendar datacadastro = new GregorianCalendar(27, 10, 2016);
			Empresa.setDatacadastro(datacadastro.getTime());
			Empresa.setStatus(Status.Ativo);
	
			// CIDADE
			Cidade.setId(1l);
			Empresa.setCidade(Cidade);
	
			// TIPO DE EMPRESA
			TipoEmpresa.setId(1l);
			Empresa.setTipoempresa(TipoEmpresa);
	
			// USUÁRIO RESPONSÁVEL PELA EMPRESA
			Usuario.setId(1l);
			Empresa.setUsuarioresponsavel(Usuario);
	
			// CADASTRANDO TELEFONE
			Telefone.setNumero("(41) 3641-1361");
			TipoTelefone.setId(1l);
			Telefone.setTipotelefone(TipoTelefone);
			facade.CadastrarTelefone(Telefone);
	
			List<Telefone> telefones_empresa = new ArrayList<Telefone>();
			telefones_empresa.add(Telefone);
			Empresa.setTelefones_empresa(telefones_empresa);
	
			// CADASTRANDO COMUNICADOR
			Comunicador.setNome("gelopar@gelopar.com");
			TipoComunicador.setId(1l);
			Comunicador.setTipocomunicador(TipoComunicador);
			facade.CadastrarComunicador(Comunicador);
	
			List<Comunicador> comunicadores_empresa = new ArrayList<Comunicador>();
			comunicadores_empresa.add(Comunicador);
			Empresa.setComunicadores_empresa(comunicadores_empresa);
			
			// CADASTRANDO CONTATOS
			/*Contato.setId(1l);
			List<Contato> contatos_empresa = new ArrayList<Contato>();
			contatos_empresa.add(Contato);
			Empresa.setContatos_empresa(contatos_empresa);*/
	
			// CADASTRAR
			facade.CadastrarEmpresa(Empresa);
			Assert.assertEquals(true, Empresa.getId() != null);
		}
	}

	// ALTERAR
	//@Test
	public void testAterarEmpresa() throws Exception {

		Empresa Empresa = facade.BuscarEmpresaPorId(3l);

		// ATRIBUTOS
		Empresa.setRazaosocial("Facear");
		Empresa.setCnpj("34564234000167");
		Empresa.setInscricaoestadual("23341256");
		Empresa.setEndereco("Av. Das Araucárias");
		Empresa.setNumero(1456l);
		Empresa.setComplemento("Próximo ao Terminal Angélica");
		Empresa.setCep("83707220");
		Empresa.setBairro("Thomaz Coelho");
		Empresa.setSite("www.facear.com.br");
		Empresa.setRamo("Faculdade");
		Empresa.setLogo("C:\\Downloads\\Facear.png");
		Calendar datacadastro = new GregorianCalendar(28, 10, 2016);
		Empresa.setDatacadastro(datacadastro.getTime());
		Empresa.setStatus(Status.Inativo);

		// CIDADE
		Cidade.setId(1l);
		Empresa.setCidade(Cidade);

		// TIPO DE EMPRESA
		TipoEmpresa.setId(1l);
		Empresa.setTipoempresa(TipoEmpresa);

		// USUÁRIO RESPONSÁVEL PELA EMPRESA
		Usuario.setId(1l);
		Empresa.setUsuarioresponsavel(Usuario);

		// ALTERANDO TELEFONE
		Telefone.setNumero("(41) 3641-1551");
		TipoTelefone.setId(1l);
		Telefone.setTipotelefone(TipoTelefone);
		facade.CadastrarTelefone(Telefone);

		List<Telefone> telefones_empresa = new ArrayList<Telefone>();
		telefones_empresa.add(Telefone);
		Empresa.setTelefones_empresa(telefones_empresa);

		// ALTERANDO COMUNICADOR
		Comunicador.setNome("facear@facear.com");
		TipoComunicador.setId(1l);
		Comunicador.setTipocomunicador(TipoComunicador);
		facade.CadastrarComunicador(Comunicador);
		
		List<Comunicador> comunicadores_empresa = new ArrayList<Comunicador>();
		comunicadores_empresa.add(Comunicador);
		Empresa.setComunicadores_empresa(comunicadores_empresa);
		
		// ALTERANDO CONTATOS
		//Contato.setId(1l);
		//List<Contato> contatos_empresa = new ArrayList<Contato>();
		//contatos_empresa.add(Contato);
		//Empresa.setContatos_empresa(contatos_empresa);

		//ALTERAR
		facade.AlterarEmpresa(Empresa);
		Assert.assertEquals(true, Empresa.getRazaosocial().equals("Facear"));
	}

	// EXCLUIR
	//@Test
	public void testExcluirEmpresa() throws Exception {
		Empresa Empresa = facade.BuscarEmpresaPorId(7l);
		facade.ExcluirEmpresa(Empresa);
		// Usuario = facade.BuscarUsuarioPorId(1l);
		// Assert.assertEquals(true, Usuario.getId() == null);
	}

	// LISTAR
	@Test
	public void testListarEmpresa() throws Exception {
		List<Empresa> Empresa = new ArrayList<Empresa>();
		Empresa = facade.ListarEmpresa();
		Assert.assertEquals(true, Empresa.size() > 0);
		System.out.println("EMPRESA(S) CADASTRADO(S)");
		for (Empresa Empresa2 : Empresa) {
			System.out.println("Id: " + Empresa2.getId() + "  Razão Social: " + Empresa2.getRazaosocial() + "  Tipo Empresa: "
					+ Empresa2.getTipoempresa().getNome());
		}
	}
}