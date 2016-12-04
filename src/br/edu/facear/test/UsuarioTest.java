package br.edu.facear.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.edu.facear.crm.entity.Cidade;
import br.edu.facear.crm.entity.Comunicador;
import br.edu.facear.crm.entity.Genero;
import br.edu.facear.crm.entity.Status;
import br.edu.facear.crm.entity.Telefone;
import br.edu.facear.crm.entity.TipoComunicador;
import br.edu.facear.crm.entity.TipoTelefone;
import br.edu.facear.crm.entity.TipoUsuario;
import br.edu.facear.crm.entity.Usuario;
import br.edu.facear.facade.FacadeHappyCustomer;

public class UsuarioTest {

	FacadeHappyCustomer facade = new FacadeHappyCustomer();

	Usuario Usuario = new Usuario();
	TipoUsuario TipoUsuario = new TipoUsuario();
	Cidade Cidade = new Cidade();
	Telefone Telefone = new Telefone();
	TipoTelefone TipoTelefone = new TipoTelefone();
	Comunicador Comunicador = new Comunicador();
	TipoComunicador TipoComunicador = new TipoComunicador();

	// CADASTRAR
	@Test
	public void testCadastrarUsuario() throws Exception {

		// ATRIBUTOS
		Usuario.setNome("Luiz Correia");
		Usuario.setCpf("09788163904");
		Usuario.setDatanascimento("09/05/1997");
		Usuario.setEndereco("Rua João Halinski");
		Usuario.setNumero(44l);
		Usuario.setComplemento("Próximo a Cocelpa");
		Usuario.setCep("83707350");
		Usuario.setBairro("Jardim Alvorada");
		Usuario.setGenero(Genero.Masculino);
		Usuario.setCargo("Programador");
		Usuario.setLogin("luiz");
		Usuario.setSenha("1234");
		Usuario.setDatacadastro("19/11/2016");
		Usuario.setStatus(Status.Ativo);

		// CIDADE
		Cidade.setId(1l);
		Usuario.setCidade(Cidade);

		// TIPO
		TipoUsuario.setId(1l);
		Usuario.setTipousuario(TipoUsuario);

		// TELEFONE
		Telefone.setNumero("(41) 9613-5114");
		TipoTelefone.setId(1l);
		Telefone.setTipotelefone(TipoTelefone);
		facade.CadastrarTelefone(Telefone);

		List<Telefone> telefones_usuario = new ArrayList<Telefone>();
		telefones_usuario.add(Telefone);
		Usuario.setTelefones_usuario(telefones_usuario);

		// COMUNICADOR
		Comunicador.setNome("luizhenrique@gmail.com");
		TipoComunicador.setId(1l);
		Comunicador.setTipocomunicador(TipoComunicador);
		facade.CadastrarComunicador(Comunicador);

		List<Comunicador> comunicadores_usuario = new ArrayList<Comunicador>();
		comunicadores_usuario.add(Comunicador);
		Usuario.setComunicadores_usuario(comunicadores_usuario);

		// CADASTRAR
		facade.CadastrarUsuario(Usuario);
		Assert.assertEquals(true, Usuario.getId() != null);
	}

	// ALTERAR
	//@Test
	public void testAterarUsuario() throws Exception {

		Usuario Usuario = facade.BuscarUsuarioPorId(2l);

		// ATRIBUTOS
		Usuario.setNome("Gabriel Umbelino");
		Usuario.setCpf("09788163904");
		Usuario.setDatanascimento("09/05/1997");
		Usuario.setEndereco("Rua Antonio");
		Usuario.setNumero(156l);
		Usuario.setComplemento("Próximo ao Terminal CIC");
		Usuario.setCep("83707000");
		Usuario.setBairro("CIC");
		Usuario.setGenero(Genero.Feminino);
		Usuario.setCargo("Programador");
		Usuario.setLogin("gabriel");
		Usuario.setSenha("4321");
		Usuario.setDatacadastro("20/11/2016");
		Usuario.setStatus(Status.Inativo);

		// CIDADE
		Cidade.setId(1l);
		Usuario.setCidade(Cidade);

		// TIPO DE USUÁRIO
		TipoUsuario.setId(1l);
		Usuario.setTipousuario(TipoUsuario);

		// ALTERANDO TELEFONE
		Telefone Telefone = facade.BuscarTelefonePorId(2l);
		Telefone.setNumero("(41) 8554-7070");
		TipoTelefone.setId(1l);
		Telefone.setTipotelefone(TipoTelefone);
		facade.AlterarTelefone(Telefone);

		List<Telefone> telefones_usuario = new ArrayList<Telefone>();
		telefones_usuario.add(Telefone);
		Usuario.setTelefones_usuario(telefones_usuario);

		// ALTERANDO COMUNICADOR
		Comunicador Comunicador = facade.BuscarComunicadorPorId(1l);
		Comunicador.setNome("gabrielumbelino@gmail.com");
		TipoComunicador.setId(1l);
		Comunicador.setTipocomunicador(TipoComunicador);
		facade.AlterarComunicador(Comunicador);

		// ALTERAR
		facade.AlterarUsuario(Usuario);
		Assert.assertEquals(true, Usuario.getNome().equals("Gabriel Umbelino"));
	}

	// EXCLUIR
	// @Test
	public void testExcluirUsuario() throws Exception {
		Usuario Usuario = facade.BuscarUsuarioPorId(2l);
		facade.ExcluirUsuario(Usuario);
		// Usuario = facade.BuscarUsuarioPorId(1l);
		// Assert.assertEquals(true, Usuario.getId() == null);
	}

	// LISTAR
	// @Test
	public void testListarUsuario() throws Exception {
		List<Usuario> Usuario = new ArrayList<Usuario>();
		Usuario = facade.ListarUsuario();
		Assert.assertEquals(true, Usuario.size() > 0);
		System.out.println("USUÁRIOS(S) CADASTRADO(S)");
		for (Usuario Usuario2 : Usuario) {
			System.out.println("Id: " + Usuario2.getId() + "  Nome: " + Usuario2.getNome() + "Tipo Usuario: "
					+ Usuario2.getTipousuario().getNome());
		}
	}
}