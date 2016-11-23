package br.edu.facear.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.edu.facear.crm.entity.Cidade;
import br.edu.facear.crm.entity.Comunicador;
import br.edu.facear.crm.entity.Contato;
import br.edu.facear.crm.entity.Empresa;
import br.edu.facear.crm.entity.Genero;
import br.edu.facear.crm.entity.OrigemContato;
import br.edu.facear.crm.entity.Status;
import br.edu.facear.crm.entity.Telefone;
import br.edu.facear.crm.entity.TipoComunicador;
import br.edu.facear.crm.entity.TipoContato;
import br.edu.facear.crm.entity.TipoTelefone;
import br.edu.facear.crm.entity.Usuario;
import br.edu.facear.facade.FacadeHappyCustomer;

public class ContatoTest {

	FacadeHappyCustomer facade = new FacadeHappyCustomer();

	Contato Contato = new Contato();
	Empresa Empresa = new Empresa();
	Usuario Usuario = new Usuario();
	TipoContato TipoContato = new TipoContato();
	OrigemContato OrigemContato = new OrigemContato();
	Cidade Cidade = new Cidade();
	Telefone Telefone = new Telefone();
	TipoTelefone TipoTelefone = new TipoTelefone();
	Comunicador Comunicador = new Comunicador();
	TipoComunicador TipoComunicador = new TipoComunicador();

	// SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy HH:mm:ss");

	// CADASTRAR
	@Test
	public void testCadastrarContato() throws Exception {

		// ATRIBUTOS
		Contato.setNome("Luiz");
		Contato.setCpf("09788163904");
		Contato.setDatanascimento("09/05/1997");
		Contato.setEndereco("Rua João Halinski");
		Contato.setNumero(44l);
		Contato.setComplemento("Próximo a Cocelpa");
		Contato.setCep("83707350");
		Contato.setBairro("Jardim Alvorada");
		Contato.setGenero(Genero.Masculino);
		Contato.setCargo("Programador");
		
		Contato.setDatacadastro("19/11/2016");
		Contato.setStatus(Status.Ativo);

		// CIDADE
		Cidade.setId(1l);
		Contato.setCidade(Cidade);

		// TIPO DE CONTATO
		TipoContato.setId(1l);
		Contato.setTipocontato(TipoContato);

		// USUÁRIO RESPONSÁVEL PELO CONTATO
		Usuario.setId(1l);
		Contato.setUsuarioresponsavel(Usuario);

		// ORIGEM DO CONTATO
		OrigemContato.setId(1l);
		Contato.setOrigemcontato(OrigemContato);

		// CADASTRANDO TELEFONE
		Telefone.setNumero("(41) 9613-5114");
		TipoTelefone.setId(1l);
		Telefone.setTipotelefone(TipoTelefone);
		facade.CadastrarTelefone(Telefone);

		List<Telefone> telefones_contato = new ArrayList<Telefone>();
		telefones_contato.add(Telefone);
		Contato.setTelefones_contato(telefones_contato);

		// CADASTRANDO COMUNICADOR
		Comunicador.setNome("gelopar@gelopar.com");
		TipoComunicador.setId(1l);
		Comunicador.setTipocomunicador(TipoComunicador);
		facade.CadastrarComunicador(Comunicador);

		List<Comunicador> comunicadores_contato = new ArrayList<Comunicador>();
		comunicadores_contato.add(Comunicador);
		Contato.setComunicadores_contato(comunicadores_contato);

		// CADASTRANDO EMPRESAS
		
//		Empresa.setId(1l);
//		List<Empresa> empresas_contato = new ArrayList<Empresa>(); 
//		empresas_contato.add(Empresa);
//		Contato.setEmpresas(empresas_contato);

		// CADASTRAR
		facade.CadastrarContato(Contato);
		Assert.assertEquals(true, Contato.getId() != null);
	}

	// ALTERAR
	// @Test
	public void testAterarContato() throws Exception {

		Contato Contato = facade.BuscarContatoPorId(2l);

		// ATRIBUTOS
		Contato.setNome("Gabriel");
		Contato.setCpf("19765478239");
		Contato.setDatanascimento("30/09/1994");
		Contato.setEndereco("Rua Carlos Gomes");
		Contato.setNumero(110l);
		Contato.setComplemento("Próximo ao Terminal do Cabral");
		Contato.setCep("83707567");
		Contato.setBairro("Centro");
		Contato.setGenero(Genero.Masculino);
		Contato.setCargo("Analista");
		Contato.setDatacadastro("20/11/2016");
		Contato.setStatus(Status.Inativo);

		// CIDADE
		Cidade.setId(1l);
		Contato.setCidade(Cidade);

		// TIPO DE CONTATO
		TipoContato.setId(1l);
		Contato.setTipocontato(TipoContato);

		// USUÁRIO RESPONSÁVEL PELO CONTATO
		Usuario.setId(1l);
		Contato.setUsuarioresponsavel(Usuario);

		// ORIGEM DO CONTATO
		OrigemContato.setId(1l);
		Contato.setOrigemcontato(OrigemContato);

		// ALTERANDO TELEFONE
		Telefone Telefone = facade.BuscarTelefonePorId(2l);
		Telefone.setNumero("(41) 8776-4532");
		TipoTelefone.setId(1l);
		Telefone.setTipotelefone(TipoTelefone);
		facade.AlterarTelefone(Telefone);

		List<Telefone> telefones_contato = new ArrayList<Telefone>();
		telefones_contato.add(Telefone);
		Contato.setTelefones_contato(telefones_contato);

		// ALTERANDO COMUNICADOR
		Comunicador Comunicador = facade.BuscarComunicadorPorId(1l);
		Comunicador.setNome("guilherme@gmail.com");
		TipoComunicador.setId(1l);
		Comunicador.setTipocomunicador(TipoComunicador);
		facade.AlterarComunicador(Comunicador);

		List<Comunicador> comunicadores_contato = new ArrayList<Comunicador>();
		comunicadores_contato.add(Comunicador);
		Contato.setComunicadores_contato(comunicadores_contato);

		// ALTERANDO EMPRESAS
		// Contato.setId(1l);
		// List<Contato> contatos_empresa = new ArrayList<Contato>();
		// contatos_empresa.add(Contato);
		// Empresa.setContatos_empresa(contatos_empresa);

		// ALTERAR
		facade.AlterarContato(Contato);
		Assert.assertEquals(true, Contato.getNome().equals("Gabriel"));
	}

	// EXCLUIR
	// @Test
	public void testExcluirContato() throws Exception {
		Contato Contato = facade.BuscarContatoPorId(3l);
		facade.ExcluirContato(Contato);
		// Usuario = facade.BuscarUsuarioPorId(1l);
		// Assert.assertEquals(true, Usuario.getId() == null);
	}

	// LISTAR
	// @Test
	public void testListarContato() throws Exception {
		List<Contato> Contato = new ArrayList<Contato>();
		Contato = facade.ListarContato();
		Assert.assertEquals(true, Contato.size() > 0);
		System.out.println("CONTATO(S) CADASTRADO(S)");
		for (Contato Contato2 : Contato) {
			System.out.println("Id: " + Contato2.getId() + "  Nome: " + Contato2.getNome() + "  Tipo Contato: "
					+ Contato2.getTipocontato().getNome());
		}
	}
}