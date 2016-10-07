package br.edu.facear.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.edu.facear.crm.bo.AtividadeBO;
import br.edu.facear.crm.bo.CidadeBO;
import br.edu.facear.crm.bo.ContatoBO;
import br.edu.facear.crm.bo.EmpresaBO;
import br.edu.facear.crm.bo.EstadoBO;
import br.edu.facear.crm.bo.ItemBO;
import br.edu.facear.crm.bo.LigacaoBO;
import br.edu.facear.crm.bo.NegocioBO;
import br.edu.facear.crm.bo.OrigemContatoBO;
import br.edu.facear.crm.bo.ProdutoBO;
import br.edu.facear.crm.bo.TelefoneBO;
import br.edu.facear.crm.bo.TipoAtividadeBO;
import br.edu.facear.crm.bo.TipoComunicadorBO;
import br.edu.facear.crm.bo.TipoContatoBO;
import br.edu.facear.crm.bo.TipoEmpresaBO;
import br.edu.facear.crm.bo.TipoTelefoneBO;
import br.edu.facear.crm.bo.TipoUsuarioBO;
import br.edu.facear.crm.bo.UsuarioBO;
import br.edu.facear.crm.dao.EmpresaDAO;
import br.edu.facear.crm.entity.Atividade;
import br.edu.facear.crm.entity.Cidade;
import br.edu.facear.crm.entity.Contato;
import br.edu.facear.crm.entity.Empresa;
import br.edu.facear.crm.entity.Estado;
import br.edu.facear.crm.entity.Genero;
import br.edu.facear.crm.entity.Item;
import br.edu.facear.crm.entity.Ligacao;
import br.edu.facear.crm.entity.Negocio;
import br.edu.facear.crm.entity.OrigemContato;
import br.edu.facear.crm.entity.Produto;
import br.edu.facear.crm.entity.Status;
import br.edu.facear.crm.entity.StatusAtividade;
import br.edu.facear.crm.entity.Telefone;
import br.edu.facear.crm.entity.TipoAtividade;
import br.edu.facear.crm.entity.TipoComunicador;
import br.edu.facear.crm.entity.TipoContato;
import br.edu.facear.crm.entity.TipoEmpresa;
import br.edu.facear.crm.entity.TipoLigacao;
import br.edu.facear.crm.entity.TipoTelefone;
import br.edu.facear.crm.entity.TipoUsuario;
import br.edu.facear.crm.entity.Usuario;

public class Main {
	public static void main(String[] args) throws Exception {
		gerenciarTipoTelefone();
//		gerenciarTipoEmpresa();
//		gerenciarTelefone();
//		gerenciarProduto();
//		gerenciarEstado();
//		gerenciarCidade();
//		gerenciarOrigemContato();
//		gerenciarTipoUsuario();
//		gerenciarUsuario();
//		gerenciarTipoContato();
//		gerenciarContato();		
//		gerenciarTipoComunicador();
//		gerenciarTipoAtividade();
//		gerenciarEmpresa();
//		gerenciarNegocio();
//		gerenciarItem();
//		gerenciarAtividade();
//		gerenciarLigacao();

	}
	public static void gerenciarTipoTelefone() throws Exception{
		TipoTelefoneBO ttBO = new TipoTelefoneBO();
		TipoTelefone tt = new TipoTelefone();
		/*cadastro de tipo de telefone*/
		tt.setNome("Teste fuking jpa");
		ttBO.salvar(tt);
//		System.out.println("Busca Tipos de Telefone:");
		tt = ttBO.getObjectById(1l);
//		System.out.println(tt.getId() +" - "+tt.getNome());
		tt.setNome("Movel");		
		ttBO.editar(tt);
		
//		ttBO.excluir(tt);

		System.out.println("Tipos de Telefone:");
		List<TipoTelefone> lista_tt =  ttBO.listar();
		for(TipoTelefone current_tt : lista_tt){
			System.out.println(current_tt.getId() +" - "+current_tt.getNome());
		}
		
		
	}
	public static void gerenciarTipoEmpresa() throws Exception{
		TipoEmpresaBO teBO = new TipoEmpresaBO();
		TipoEmpresa te = new TipoEmpresa();

		/*cadastro de tipo de empresas*/
		te.setNome("Tipo Empresa  Teste Salvar BO2");
		teBO.salvar(te);
		
		System.out.println("Busca Tipos de Empresa:");
		te = teBO.getObjectById(1l);
		System.out.println(te.getId() +" - "+te.getNome());
//		teBO.excluir(te);
//		te.setNome("Tipo Empresa Teste EditarBO");		
//		teBO.editar(te);
		System.out.println("Tipos de Empresa:");
		List<TipoEmpresa> lista_te =  teBO.listar();
		for(TipoEmpresa current_te : lista_te){
			System.out.println(current_te.getId() +" - "+current_te.getNome());
		}

	}
	public static void gerenciarTelefone() throws Exception{
		
		TelefoneBO telefoneBO = new TelefoneBO();
		Telefone telefone = new Telefone();

		TipoTelefoneBO tipotelefoneBO = new TipoTelefoneBO();
		TipoTelefone tipotelefone = new TipoTelefone();
		tipotelefone = tipotelefoneBO.getObjectById(1l);
		
		telefone.setTipotelefone(tipotelefone);
		telefone.setNumero(4188888888l);
		telefoneBO.salvar(telefone);
//		System.out.println("Busca Telefone:");
		telefone = telefoneBO.getObjectById(1l);
//		System.out.println(telefone.getId() +" - "+telefone.getNumero() + "- tipotelefone:" + telefone.getTipotelefone().getNome());
		
//		/*editar telefone*/
		telefone.setNumero(4191758834l);		
		telefoneBO.editar(telefone);
//		telefoneBO.excluir(telefone);

//		System.out.println("Telefone:");
		List<Telefone> lista_tf =  telefoneBO.listar();
		for(Telefone current_tf: lista_tf){
//			System.out.println(current_tf.getId() +" - "+current_tf.getNumero() + "- tipotelefone:" + current_tf.getTipotelefone().getNome());

		}
		
	}
	public static void gerenciarProduto() throws Exception{
		ProdutoBO produtoBO = new ProdutoBO();
		Produto produto = new Produto();
		
		/*cadastro de produtos*/
		produto.setNome("Iphone 7");
		produto.setPreco(649.99f);
		produtoBO.salvar(produto);
		

//		System.out.println("Busca Produtos:");
		produto = produtoBO.getObjectById(1l);
//		System.out.println( "id: "+produto.getId() +" Nome: "+produto.getNome()+" Preço: "+produto.getPreco());
		
		produto.setNome("Teste ProdutoBO Editar2");
		produto.setPreco(1.99f);
		produtoBO.editar(produto);
		
		
//		produtoBO.excluir(produto);

//		System.out.println("Produtos: ");
		List<Produto> lista_p =  produtoBO.listar();
		for(Produto current_p : lista_p){
//			System.out.println( "id: "+current_p.getId() +" Nome: "+current_p.getNome()+" Preço: "+current_p.getPreco());

		}	
		
	}
	public static void gerenciarEstado()throws Exception{
		EstadoBO eBO = new EstadoBO();
		Estado e = new Estado();

		/*cadastro de estado*/
		e.setNome("Pernambuco");
		eBO.salvar(e);
		
//		System.out.println("Busca Estado:");
		e = eBO.getObjectById(3l);
		System.out.println(e.getId() +" - "+e.getNome());
		
		e.setNome("Belo Horizonte");		
		eBO.editar(e);
		
		

		System.out.println("Estados: ");
		List<Estado> lista_e =  eBO.listar();
		for(Estado current_e : lista_e){
			System.out.println(current_e.getId() +" - "+current_e.getNome());
		}	
		
		//eDAO.excluir(e);
	
	}
	public static void gerenciarCidade()throws Exception{
		CidadeBO cBO= new CidadeBO();
		Cidade c = new Cidade();

		/*cadastro de estado*/
		EstadoBO eBO = new EstadoBO();
		Estado e = new Estado();
		e = eBO.getObjectById(1l);
		
		c.setNome("São José dos Campo");
		c.setEstado(e);
		cBO.salvar(c);
//		
		
		System.out.println("Busca Cidade:");
		c = cBO.getObjectById(1l);
		System.out.println(c.getId() +" - "+c.getNome());
		
		c.setNome("São José dos Campos");		
		cBO.editar(c);
		


		System.out.println("Cidades: ");
		List<Cidade> lista_c =  cBO.listar();
		for(Cidade current_c : lista_c){
			System.out.println(current_c.getId() +" - "+current_c.getNome()+" - "+current_c.getEstado().getNome());
		}	
		
		//cBO.excluir(c);
	
	}
	public static void gerenciarOrigemContato()throws Exception{
		OrigemContatoBO oBO= new OrigemContatoBO();
		OrigemContato o = new OrigemContato();

		/*cadastro de origem do contato*/
		o.setDescricao("Instagram");
		oBO.salvar(o);
		
		
//		System.out.println("Busca Origem de Contato:");
		o = oBO.getObjectById(1l);
//		System.out.println(o.getId() +" - "+o.getDescricao());
		
		o.setDescricao("Telegram");		
		oBO.editar(o);
		


//		System.out.println("Estados: ");
		List<OrigemContato> lista_o =  oBO.listar();
		for(OrigemContato current_o : lista_o){
//			System.out.println(current_o.getId() +" - "+current_o.getDescricao());
		}	
		
		//eDAO.excluir(e);
	}
	public static void gerenciarTipoUsuario()throws Exception{

		TipoUsuarioBO tuBO = new TipoUsuarioBO();
		TipoUsuario tu = new TipoUsuario();

		/*cadastro de Tipo de contato*/
		tu.setNome("Operador");
		tuBO.salvar(tu);
		
//		System.out.println("Busca Tipo TipoUsuario:");
		tu = tuBO.getObjectById(1l);
//		System.out.println(tu.getId() +" - "+tu.getNome());		
		
		tu.setId(1l);
		tu.setNome("Administrador");		
		tuBO.editar(tu);
		


//		System.out.println("Tipo Contato: ");
		List<TipoUsuario> lista_tu =  tuBO.listar();
		for(TipoUsuario current_tu : lista_tu){
//			System.out.println(current_tu.getId() +" - "+current_tu.getNome());
		}	
		
		//tuBO.excluir(tu);

	}
	private static void gerenciarUsuario()throws Exception{
		UsuarioBO usBO = new UsuarioBO();
		Usuario us = new Usuario();

		TipoUsuarioBO tuBO = new TipoUsuarioBO();
		TipoUsuario tu = new TipoUsuario();
		tu = tuBO.getObjectById(1l);
		us.setTipousuario(tu);
		CidadeBO cBO = new CidadeBO();
		Cidade c = new Cidade();
		c = cBO.getObjectById(1l);
		us.setCidade(c);
		us.setEmail("Teste@colorbit.com.br");
		us.setSenha("123");
		us.setNome("Teste teste");
		us.setCpf("080.779.555.55");
		us.setGenero(Genero.masculino);
		us.setCargo("cargo de teste");
		//date formating
		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy   HH:mm:ss");
		Calendar calendar = new GregorianCalendar(25,11,1993);
		us.setDatanascimento(calendar.getTime());
		us.setEndereco("Rua dos zef");
		us.setNumero(126l);
		us.setCep(81170680l);
		
		
		Telefone t = new Telefone();
		Telefone t2 = new Telefone();
		t = new TelefoneBO().getObjectById(1l);
		t2 = new TelefoneBO().getObjectById(2l);
		
		List<Telefone> telefones = new ArrayList<Telefone>();
		telefones.add(t);
		telefones.add(t2);
		us.setTelefones(telefones);
		usBO.salvar(us);


		
		
		System.out.println("Busca Usuario:");
		us = usBO.getObjectById(1l);
		System.out.println("id: "+	us.getId()+" nome: "+us.getNome() +" tipoUsuario: "+us.getTipousuario().getNome() +" Estado: "+us.getCidade().getEstado().getNome() +" Cidade: "+us.getCidade().getNome() 
		+" Email: "+us.getEmail()+" Senha: "+us.getSenha()+" cpf: "+us.getCpf()+" Genero: "+us.getGenero().toString()+" Cargo: "+us.getCargo() +" DataNascimento "+us.getDatanascimento().toString()
		+" Endereço: "+us.getEndereco()+" Numero: "+us.getNumero()+" Cep: "+us.getCep()	);
		us = usBO.getObjectById(1l);
		us.setCpf("111.000.000.00");
		usBO.editar(us);
		
		

		System.out.println("Lista de Usuarios: ");
		List<Usuario> lista_tc =  usBO.listar();
		for(Usuario current_tc : lista_tc){
			System.out.println("id: "+	current_tc.getId()+" nome: "+current_tc.getNome() +" tipoUsuario: "+current_tc.getTipousuario().getNome() +" Estado: "+current_tc.getCidade().getEstado().getNome() +" Cidade: "+current_tc.getCidade().getNome() 
					+" Email: "+current_tc.getEmail()+" Senha: "+current_tc.getSenha()+" cpf: "+current_tc.getCpf()+" Genero: "+current_tc.getGenero().toString()+" Cargo: "+current_tc.getCargo() +" DataNascimento "+current_tc.getDatanascimento().toString()
					+" Endereço: "+current_tc.getEndereco()+" Numero: "+current_tc.getNumero()+" Cep: "+current_tc.getCep()	);		}	
		
		
	}
	public static void gerenciarTipoContato()throws Exception{

		TipoContatoBO tcBO = new TipoContatoBO();
		TipoContato tc = new TipoContato();

		/*cadastro de Tipo de contato*/
		tc.setNome("teste");
		tcBO.salvar(tc);
		
		System.out.println("Busca Tipo Contato:");
		tc = tcBO.getObjectById(1l);
		System.out.println(tc.getId() +" - "+tc.getNome());		
		tc.setNome("Teste Editar");		
		tcBO.editar(tc);

		System.out.println("Tipo Contato: ");
		List<TipoContato> lista_tc =  tcBO.listar();
		for(TipoContato current_tc : lista_tc){
			System.out.println(current_tc.getId() +" - "+current_tc.getNome());
		}	
		
		//tcBO.excluir(tc);
	}
	public static void gerenciarContato()throws Exception{
		ContatoBO coBO = new ContatoBO();
		Contato co = new Contato();
		
		TipoContatoBO tcBO = new TipoContatoBO();
		TipoContato tc = new TipoContato();
		tc = tcBO.getObjectById(1l);
		co.setTipocontato(tc);
		
		TipoComunicadorBO tcoBO = new TipoComunicadorBO();
		TipoComunicador tco = new TipoComunicador();
		tco = tcoBO.getObjectById(1l);
		co.setTipocomunicador(tco);
		
		
		OrigemContatoBO oBO = new OrigemContatoBO();
		OrigemContato o = new OrigemContato();
		o = oBO.getObjectById(2l);
		co.setOrigemcontato(o);

		UsuarioBO uBO = new UsuarioBO();
		Usuario u = new Usuario();
		u = uBO.getObjectById(1l);
		co.setUsuarioresponsavel(u);
		
		CidadeBO cBO = new CidadeBO();
		Cidade c = new Cidade();
		c = cBO.getObjectById(1l);
		co.setCidade(c);
		co.setNome("Chappie");
		co.setEmail("emailteste@gmail.com.br");
		co.setCpf("111.111.111.11");
		co.setFoto("C://localhost/fake_path");
		co.setGenero(Genero.masculino);
		co.setCargo("iam CEO, bitch!");

		//date formating
		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy   HH:mm:ss");
		Calendar calendar = new GregorianCalendar(25,11,1993);
		co.setDatanascimento(calendar.getTime());

		
		co.setEndereco("rua dos bobos");
		co.setNumero(0l);
		co.setCep(00000000l);
		coBO.salvar(co);

//		co.setCpf("222.222.222.22");		
//		coBO.editar(co);
		
		System.out.println("Busca Contato:");
		co = coBO.getObjectById(1l);
		System.out.println("id: "+	co.getId()+" nome: "+co.getNome()+" usuarioResponsavel: "+co.getUsuarioresponsavel().getNome()  +" tipoContato: "+co.getTipocontato().getNome() +" Estado: "+co.getCidade().getEstado().getNome() +" Cidade: "
		+co.getCidade().getNome()+" cpf: "+co.getCpf()+" Genero: "+co.getGenero().toString()+" Cargo: "+co.getCargo() +" DataNascimento "+co.getDatanascimento().toString()
		+" Endereço: "+co.getEndereco()+" Numero: "+co.getNumero()+" Cep: "+co.getCep()	);


		System.out.println("Cidades: ");
		List<Contato> lista_c =  coBO.listar();
		for(Contato current_co : lista_c){
			System.out.println("id: "+	current_co.getId()+" nome: "+current_co.getNome()+" usuarioResponsavel: "+current_co.getUsuarioresponsavel().getNome()  +" tipoContato: "+current_co.getTipocontato().getNome() +" Estado: "+current_co.getCidade().getEstado().getNome() +" Cidade: "
					+current_co.getCidade().getNome()+" cpf: "+current_co.getCpf()+" Genero: "+current_co.getGenero().toString()+" Cargo: "+current_co.getCargo() +" DataNascimento "+current_co.getDatanascimento().toString()
					+" Endereço: "+current_co.getEndereco()+" Numero: "+current_co.getNumero()+" Cep: "+co.getCep()	);		}	
		
		//cDAO.excluir(c);
	
	}
	public static void gerenciarTipoComunicador()throws Exception{

		TipoComunicadorBO tcBO = new TipoComunicadorBO();
		TipoComunicador tc = new TipoComunicador();

		/*cadastro de Tipo de contato*/
		tc.setNome("Telefone Fixo");
		tcBO.salvar(tc);
		
		System.out.println("Busca TipoComunicador:");
		tc = tcBO.getObjectById(1l);
		System.out.println(tc.getId() +" - "+tc.getNome());		
		tc.setNome("Teste Editar");		
		tcBO.editar(tc);

		System.out.println("Tipo Contato: ");
		List<TipoComunicador> lista_tc =  tcBO.listar();
		for(TipoComunicador current_tc : lista_tc){
			System.out.println(current_tc.getId() +" - "+current_tc.getNome());
		}	
		
		//tcBO.excluir(tc);
	}
	public static void gerenciarTipoAtividade()throws Exception{

		TipoAtividadeBO taBO = new TipoAtividadeBO();
		TipoAtividade ta = new TipoAtividade();

		/*cadastro de Tipo de contato*/
		ta.setNome("Tarefa");
		taBO.salvar(ta);
		
		System.out.println("Busca TipoAtividade:");
		ta = taBO.getObjectById(1l);
		System.out.println(ta.getId() +" - "+ta.getNome());		
		ta.setNome("Teste Editar");		
		taBO.editar(ta);

		System.out.println("Tipo Contato: ");
		List<TipoAtividade> lista_ta =  taBO.listar();
		for(TipoAtividade current_ta : lista_ta){
			System.out.println(current_ta.getId() +" - "+current_ta.getNome());
		}	
		
		//taBO.excluir(ta);
	}
	private static void gerenciarEmpresa()throws Exception{
		EmpresaBO eBO = new EmpresaBO();
		Empresa e = new Empresa();

		TipoEmpresaBO teBO = new TipoEmpresaBO();
		TipoEmpresa te = new TipoEmpresa();
		te = teBO.getObjectById(1l);
		e.setTipoempresa(te);
		CidadeBO cBO = new CidadeBO();
		Cidade c = new Cidade();
		c = cBO.getObjectById(1l);
		e.setCidade(c);
		
		
		
		e.setNome("Boobox");
		e.setCnpj("000.000.00.000-41");
		e.setRazaosocial("Facebook LTDA");
		//date formating
		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy   HH:mm:ss");
		Calendar calendar = new GregorianCalendar(25,11,1993);
		e.setDatacadastro(calendar.getTime());
		e.setStatus(Status.ativo);
		e.setRamo("Tecnologia");
		e.setSite("https://www.boobox.com");
		e.setEndereco("Rua do vale do silicio");
		e.setNumero(123l);
		e.setCep(81170640l);

		Telefone t = new Telefone();
		Telefone t2 = new Telefone();
		t = new TelefoneBO().getObjectById(1l);
		t2 = new TelefoneBO().getObjectById(2l);
		
		List<Telefone> telefones = new ArrayList<Telefone>();
		telefones.add(t);
		telefones.add(t2);
		e.setTelefones(telefones);

		Contato co = new Contato();
		Contato co2 = new Contato();
		co  = new ContatoBO().getObjectById(1l);
		co2 = new ContatoBO().getObjectById(2l);

		List<Contato> contatos = new ArrayList<Contato>();
		contatos.add(co);
		contatos.add(co2);
		e.setContatos(contatos);
		eBO.salvar(e);		
			
		
//		System.out.println("Busca Usuario:");
//		us = usBO.getObjectById(1l);
//		System.out.println("id: "+	us.getId()+" nome: "+us.getNome() +" tipoUsuario: "+us.getTipousuario().getNome() +" Estado: "+us.getCidade().getEstado().getNome() +" Cidade: "+us.getCidade().getNome() 
//		+" Email: "+us.getEmail()+" Senha: "+us.getSenha()+" cpf: "+us.getCpf()+" Genero: "+us.getGenero().toString()+" Cargo: "+us.getCargo() +" DataNascimento "+us.getDatanascimento().toString()
//		+" Endereço: "+us.getEndereco()+" Numero: "+us.getNumero()+" Cep: "+us.getCep()	);
//		us = usBO.getObjectById(1l);
//		us.setCpf("111.000.000.00");
//		usBO.editar(us);
//		
//		
//
//		System.out.println("Lista de Usuarios: ");
//		List<Usuario> lista_tc =  usBO.listar();
//		for(Usuario current_tc : lista_tc){
//			System.out.println("id: "+	current_tc.getId()+" nome: "+current_tc.getNome() +" tipoUsuario: "+current_tc.getTipousuario().getNome() +" Estado: "+current_tc.getCidade().getEstado().getNome() +" Cidade: "+current_tc.getCidade().getNome() 
//					+" Email: "+current_tc.getEmail()+" Senha: "+current_tc.getSenha()+" cpf: "+current_tc.getCpf()+" Genero: "+current_tc.getGenero().toString()+" Cargo: "+current_tc.getCargo() +" DataNascimento "+current_tc.getDatanascimento().toString()
//					+" Endereço: "+current_tc.getEndereco()+" Numero: "+current_tc.getNumero()+" Cep: "+current_tc.getCep()	);		}	
//		
		
	}
	public static void gerenciarNegocio()throws Exception{

		NegocioBO nbo = new NegocioBO();
		Negocio n = new Negocio();

		/*cadastro de Tipo de contato*/
		Empresa e = new Empresa();
		e = new EmpresaDAO().getObjectById(1l);
		n.setEmpresa(e);
		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy   HH:mm:ss");
		Calendar calendar = new GregorianCalendar(25,11,2016);
		n.setData(calendar.getTime());
		
		nbo.salvar(n);
		
		System.out.println("Busca Negocio:");
		n = nbo.getObjectById(1l);
		System.out.println(" ID: "+n.getId() +" Empresa: "+n.getEmpresa().getNome()+"Data: "+n.getData());		
		calendar = new GregorianCalendar(25,11,2017);
		n.setData(calendar.getTime());		
		nbo.editar(n);

		System.out.println("Tipo Contato: ");
		List<Negocio> lista_ta =  nbo.listar();
		for(Negocio current_ta : lista_ta){
			System.out.println(" ID: "+current_ta.getId() +" Empresa: "+current_ta.getEmpresa().getNome()+"Data: "+current_ta.getData());		

		}	
		
		//taBO.excluir(ta);
	}
	public static void gerenciarItem()throws Exception{

		ItemBO ibo = new ItemBO();
		Item i = new Item();

		/*cadastro de Item*/
		NegocioBO nbo =  new NegocioBO();
		Negocio n = nbo.getObjectById(1l);
		i.setNegocio(n);
		Produto p = new ProdutoBO().getObjectById(1l);
		i.setProduto(p);
		i.setQuantidade(123l);
		
		ibo.salvar(i);
		
		System.out.println("Busca Itens:");
		i = ibo.getObjectById(1l);
		System.out.println(" id: "+i.getId() +" Produto:  "+i.getProduto().getNome()+" Quantidade: "+i.getQuantidade()+" Empresa: "+i.getNegocio().getEmpresa().getNome());		
		i.setQuantidade(321l);
		ibo.editar(i);

		System.out.println("Itens: ");
		List<Item> lista_ta =  ibo.listar();
		for(Item current_i : lista_ta){
			System.out.println(" id: "+current_i.getId() +" Produto:  "+current_i.getProduto().getNome()+" Quantidade: "+current_i.getQuantidade()+" Empresa: "+current_i.getNegocio().getEmpresa().getNome());		
		}	
		
		//taBO.excluir(ta);
	}
	public static void gerenciarAtividade() throws Exception{

		AtividadeBO abo = new AtividadeBO();
		Atividade a = new Atividade();

		Usuario u = new UsuarioBO().getObjectById(1l);
		a.setUsuario(u);
		
		Empresa e = new EmpresaBO().getObjectById(1l);
		a.setEmpresa(e);
		
		TipoAtividade ta = new TipoAtividadeBO().getObjectById(1l);
		a.setTipoatividade(ta);
		
		TipoComunicador tc = new TipoComunicadorBO().getObjectById(1l);
		a.setTipocomunicador(tc);
		
		Contato c = new ContatoBO().getObjectById(1l);
		a.setContato(c);
		
		a.setStatus(StatusAtividade.inativo);
		
		//date formating
		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy   HH:mm:ss");
		Calendar calendar = new GregorianCalendar(20,9,2016);
		a.setDatainicio(calendar.getTime());
		Calendar calendarfim = new GregorianCalendar(27,11,2016);
		a.setDatafim(calendarfim.getTime());
		a.setDescricao("Lorem ipsum");
		a.setNome("Cadastrar contato para empresa");

		
		abo.salvar(a);
		
		a = abo.getObjectById(1l);
		a.setDescricao("Ipsum Lorem");
		abo.editar(a);

		System.out.println("Atividades: ");
		List<Atividade> lista_a =  abo.listar();
		for(Atividade current_a : lista_a){
			System.out.println(" id: "+current_a.getId() +" Nome:  "+current_a.getNome() +" TipoAtividade:  "+current_a.getTipoatividade()+" Usuario:  "+current_a.getUsuario().getNome()+" Empresa: "+current_a.getEmpresa().getNome()
			+ " TipoComunicador: "+current_a.getTipocomunicador().getNome()  + " Contato: "+current_a.getContato().getNome() + " Status: "+current_a.getStatus()
			+ " DataInicio: "+current_a.getDatainicio() + " DataFim: "+current_a.getDatafim() + " Status: "+current_a.getDescricao()  );		
		}	
		
		//aBO.excluir(a);
	}
	public static void gerenciarLigacao() throws Exception{

		LigacaoBO lbo = new LigacaoBO();
		Ligacao l = new Ligacao();
		
		Contato c = new ContatoBO().getObjectById(1l);
		l.setContato(c);
		
		Atividade a = new AtividadeBO().getObjectById(1l);
		l.setAtividade(a);

		Usuario u = new UsuarioBO().getObjectById(1l);
		l.setUsuario(u);		
			
		Empresa e = new EmpresaBO().getObjectById(1l);
		l.setEmpresa(e);
		
		l.setDuracao("1 minuto e 20 segundos");

		//date formating
		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy   HH:mm:ss");
		Calendar calendar = new GregorianCalendar(20,9,2016);
		l.setData(calendar.getTime());
		
		
		l.setTipoligacao(TipoLigacao.efetuada);
		l.setResumo("falar sobre assuntos peculiares");

		
		
		
		lbo.salvar(l);
		
		l = lbo.getObjectById(1l);
		l.setDuracao("3 minutos e 44 segundos");
		lbo.editar(l);

		System.out.println("Ligacoes: ");
		List<Ligacao> lista_l =  lbo.listar();
		for(Ligacao current_l : lista_l){
			System.out.println(" id: "+current_l.getId() +" Contato:  "+current_l.getContato().getNome() 
			+" Atividade:  "+current_l.getAtividade().getNome() +" Usuario:  "+current_l.getUsuario().getNome()
			+" Empresa: "+current_l.getEmpresa().getNome() + " Duracao: "+current_l.getDuracao()
			+ " Data: "+current_l.getData() + " DataInicio: "+current_l.getDuracao()
			+ " Resumo: "+current_l.getResumo() 	);		
		}	
		
		//lBO.excluir(l);
	}	
	
}
