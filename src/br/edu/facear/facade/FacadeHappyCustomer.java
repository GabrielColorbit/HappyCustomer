package br.edu.facear.facade;

import java.util.ArrayList;

import br.edu.facear.crm.bo.AtividadeBO;
import br.edu.facear.crm.bo.CidadeBO;
import br.edu.facear.crm.bo.ComunicadorBO;
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
import br.edu.facear.crm.entity.Atividade;
import br.edu.facear.crm.entity.Cidade;
import br.edu.facear.crm.entity.Comunicador;
import br.edu.facear.crm.entity.Contato;
import br.edu.facear.crm.entity.Empresa;
import br.edu.facear.crm.entity.Estado;
import br.edu.facear.crm.entity.Item;
import br.edu.facear.crm.entity.Ligacao;
import br.edu.facear.crm.entity.Negocio;
import br.edu.facear.crm.entity.OrigemContato;
import br.edu.facear.crm.entity.Produto;
import br.edu.facear.crm.entity.Telefone;
import br.edu.facear.crm.entity.TipoAtividade;
import br.edu.facear.crm.entity.TipoComunicador;
import br.edu.facear.crm.entity.TipoContato;
import br.edu.facear.crm.entity.TipoEmpresa;
import br.edu.facear.crm.entity.TipoTelefone;
import br.edu.facear.crm.entity.TipoUsuario;
import br.edu.facear.crm.entity.Usuario;

public class FacadeHappyCustomer {

	/*
	 * -------------------
	 *      SUMÁRIO 
	 * ------------------- 
	 * TipoContato ok
	 * OrigemContato ok 
	 * TipoEmpresa ok 
	 * TipoUsuario ok 
	 * TipoTelefone ok
	 * TipoComunicador ok 
	 * TipoAtividade ok 
	 * Telefone ok 
	 * Comunicador ok 
	 * Produto ok
	 * Estado ok 
	 * Cidade ok 
	 * Negocio ok 
	 * Item ok 
	 * Atividade ok 
	 * Ligacao ok 
	 * Usuario ok
	 * Contato ok 
	 * Empresa ok 
	 * -------------------
	 */

	// ---------------------------------------------------------------------------------------//
	// TIPO CONTATO
	TipoContatoBO tipocontatoBO = new TipoContatoBO();

	// CADASTRAR
	public void CadastrarTipoContato(TipoContato tipocontato) throws Exception {
		tipocontatoBO.Cadastrar(tipocontato);
	}

	// ALTERAR
	public void AlterarTipoContato(TipoContato tipocontato) throws Exception {
		tipocontatoBO.Alterar(tipocontato);
	}

	// EXCLUIR
	public void ExcluirTipoContato(TipoContato tipocontato) throws Exception {
		tipocontatoBO.Excluir(tipocontato);
	}

	// LISTAR
	public ArrayList<TipoContato> ListarTipoContato() throws Exception {
		return tipocontatoBO.Listar();
	}

	// BUSCAR PELO ID
	public TipoContato BuscarTipoContatoPorId(Long tipocontato) throws Exception {
		return tipocontatoBO.BuscarID(tipocontato);
	}

	// ---------------------------------------------------------------------------------------//
	// ORIGEM CONTATO
	OrigemContatoBO origemcontatoBO = new OrigemContatoBO();

	// CADASTRAR
	public void CadastrarOrigemContato(OrigemContato origemcontato) throws Exception {
		origemcontatoBO.Cadastrar(origemcontato);
	}

	// ALTERAR
	public void AlterarOrigemContato(OrigemContato origemcontato) throws Exception {
		origemcontatoBO.Alterar(origemcontato);
	}

	// EXCLUIR
	public void ExcluirOrigemContato(OrigemContato origemcontato) throws Exception {
		origemcontatoBO.Excluir(origemcontato);
	}

	// LISTAR
	public ArrayList<OrigemContato> ListarOrigemContato() throws Exception {
		return origemcontatoBO.Listar();
	}

	// BUSCAR PELO ID
	public OrigemContato BuscarOrigemContatoPorId(Long origemcontato) throws Exception {
		return origemcontatoBO.BuscarID(origemcontato);
	}

	// ---------------------------------------------------------------------------------------//
	// TIPO EMPRESA
	TipoEmpresaBO tipoempresaBO = new TipoEmpresaBO();

	// CADASTRAR
	public void CadastrarTipoEmpresa(TipoEmpresa tipoempresa) throws Exception {
		tipoempresaBO.Cadastrar(tipoempresa);
	}

	// ALTERAR
	public void AlterarTipoEmpresa(TipoEmpresa tipoempresa) throws Exception {
		tipoempresaBO.Alterar(tipoempresa);
	}

	// EXCLUIR
	public void ExcluirTipoEmpresa(TipoEmpresa tipoempresa) throws Exception {
		tipoempresaBO.Excluir(tipoempresa);
	}

	// LISTAR
	public ArrayList<TipoEmpresa> ListarTipoEmpresa() throws Exception {
		return tipoempresaBO.Listar();
	}

	// BUSCAR PELO ID
	public TipoEmpresa BuscarTipoEmpresaPorId(Long tipoempresa) throws Exception {
		return tipoempresaBO.BuscarID(tipoempresa);
	}

	// ---------------------------------------------------------------------------------------//
	// TIPO USUÁRIO
	TipoUsuarioBO tipousuarioBO = new TipoUsuarioBO();

	// CADASTRAR
	public void CadastrarTipoUsuario(TipoUsuario tipousuario) throws Exception {
		tipousuarioBO.Cadastrar(tipousuario);
	}

	// ALTERAR
	public void AlterarTipoUsuario(TipoUsuario tipousuario) throws Exception {
		tipousuarioBO.Alterar(tipousuario);
	}

	// EXCLUIR
	public void ExcluirTipoUsuario(TipoUsuario tipousuario) throws Exception {
		tipousuarioBO.Excluir(tipousuario);
	}

	// LISTAR
	public ArrayList<TipoUsuario> ListarTipoUsuario() throws Exception {
		return tipousuarioBO.Listar();
	}

	// BUSCAR PELO ID
	public TipoUsuario BuscarTipoUsuarioPorId(Long tipousuario) throws Exception {
		return tipousuarioBO.BuscarID(tipousuario);
	}

	// ---------------------------------------------------------------------------------------//
	// TIPO TELEFONE
	TipoTelefoneBO tipotelefoneBO = new TipoTelefoneBO();

	// CADASTRAR
	public void CadastrarTipoTelefone(TipoTelefone tipotelefone) throws Exception {
		tipotelefoneBO.Cadastrar(tipotelefone);
	}

	// ALTERAR
	public void AlterarTipoTelefone(TipoTelefone tipotelefone) throws Exception {
		tipotelefoneBO.Alterar(tipotelefone);
	}

	// EXCLUIR
	public void ExcluirTipoTelefone(TipoTelefone tipotelefone) throws Exception {
		tipotelefoneBO.Excluir(tipotelefone);
	}

	// LISTAR
	public ArrayList<TipoTelefone> ListarTipoTelefone() throws Exception {
		return tipotelefoneBO.Listar();
	}

	// BUSCAR PELO ID
	public TipoTelefone BuscarTipoTelefonePorId(Long tipotelefone) throws Exception {
		return tipotelefoneBO.BuscarID(tipotelefone);
	}

	// ---------------------------------------------------------------------------------------//
	// TIPO COMUNICADOR
	TipoComunicadorBO tipocomunicadorBO = new TipoComunicadorBO();

	// CADASTRAR
	public void CadastrarTipoComunicador(TipoComunicador tipocomunicador) throws Exception {
		tipocomunicadorBO.Cadastrar(tipocomunicador);
	}

	// ALTERAR
	public void AlterarTipoComunicador(TipoComunicador tipocomunicador) throws Exception {
		tipocomunicadorBO.Alterar(tipocomunicador);
	}

	// EXCLUIR
	public void ExcluirTipoComunicador(TipoComunicador tipocomunicador) throws Exception {
		tipocomunicadorBO.Excluir(tipocomunicador);
	}

	// LISTAR
	public ArrayList<TipoComunicador> ListarTipoComunicador() throws Exception {
		return tipocomunicadorBO.Listar();
	}

	// BUSCAR PELO ID
	public TipoComunicador BuscarTipoComunicadorPorId(Long tipocomunicador) throws Exception {
		return tipocomunicadorBO.BuscarID(tipocomunicador);
	}

	// ---------------------------------------------------------------------------------------//
	// TIPO ATIVIDADE
	TipoAtividadeBO tipoatividadeBO = new TipoAtividadeBO();

	// CADASTRAR
	public void CadastrarTipoAtividade(TipoAtividade tipoatividade) throws Exception {
		tipoatividadeBO.Cadastrar(tipoatividade);
	}

	// ALTERAR
	public void AlterarTipoAtividade(TipoAtividade tipoatividade) throws Exception {
		tipoatividadeBO.Alterar(tipoatividade);
	}

	// EXCLUIR
	public void ExcluirTipoAtividade(TipoAtividade tipoatividade) throws Exception {
		tipoatividadeBO.Excluir(tipoatividade);
	}

	// LISTAR
	public ArrayList<TipoAtividade> ListarTipoAtividade() throws Exception {
		return tipoatividadeBO.Listar();
	}

	// BUSCAR PELO ID
	public TipoAtividade BuscarTipoAtividadePorId(Long tipoatividade) throws Exception {
		return tipoatividadeBO.BuscarID(tipoatividade);
	}

	// ---------------------------------------------------------------------------------------//
	// TELEFONE
	TelefoneBO telefoneBO = new TelefoneBO();

	// CADASTRAR
	public void CadastrarTelefone(Telefone telefone) throws Exception {
		telefoneBO.Cadastrar(telefone);
	}

	// ALTERAR
	public void AlterarTelefone(Telefone telefone) throws Exception {
		telefoneBO.Alterar(telefone);
	}

	// EXCLUIR
	public void ExcluirTelefone(Telefone telefone) throws Exception {
		telefoneBO.Excluir(telefone);
	}

	// LISTAR
	public ArrayList<Telefone> ListarTelefone() throws Exception {
		return telefoneBO.Listar();
	}

	// BUSCAR PELO ID
	public Telefone BuscarTelefonePorId(Long telefone) throws Exception {
		return telefoneBO.BuscarID(telefone);
	}

	// ---------------------------------------------------------------------------------------//
	// COMUNICADOR
	ComunicadorBO comunicadorBO = new ComunicadorBO();

	// CADASTRAR
	public void CadastrarComunicador(Comunicador comunicador) throws Exception {
		comunicadorBO.Cadastrar(comunicador);
	}

	// ALTERAR
	public void AlterarComunicador(Comunicador comunicador) throws Exception {
		comunicadorBO.Alterar(comunicador);
	}

	// EXCLUIR
	public void ExcluirComunicador(Comunicador comunicador) throws Exception {
		comunicadorBO.Excluir(comunicador);
	}

	// LISTAR
	public ArrayList<Comunicador> ListarComunicador() throws Exception {
		return comunicadorBO.Listar();
	}

	// BUSCAR PELO ID
	public Comunicador BuscarComunicadorPorId(Long comunicador) throws Exception {
		return comunicadorBO.BuscarID(comunicador);
	}

	// ---------------------------------------------------------------------------------------//
	// PRODUTO
	ProdutoBO produtoBO = new ProdutoBO();

	// CADASTRAR
	public void CadastrarProduto(Produto produto) throws Exception {
		produtoBO.Cadastrar(produto);
	}

	// ALTERAR
	public void AlterarProduto(Produto produto) throws Exception {
		produtoBO.Alterar(produto);
	}

	// EXCLUIR
	public void ExcluirProduto(Produto produto) throws Exception {
		produtoBO.Excluir(produto);
	}

	// LISTAR
	public ArrayList<Produto> ListarProduto() throws Exception {
		return produtoBO.Listar();
	}

	// BUSCAR PELO ID
	public Produto BuscarProdutoPorId(Long produto) throws Exception {
		return produtoBO.BuscarID(produto);
	}

	// ---------------------------------------------------------------------------------------//
	// ESTADO
	EstadoBO estadoBO = new EstadoBO();

	// CADASTRAR
	public void CadastrarEstado(Estado estado) throws Exception {
		estadoBO.Cadastrar(estado);
	}

	// ALTERAR
	public void AlterarEstado(Estado estado) throws Exception {
		estadoBO.Alterar(estado);
	}

	// EXCLUIR
	public void ExcluirEstado(Estado estado) throws Exception {
		estadoBO.Excluir(estado);
	}

	// LISTAR
	public ArrayList<Estado> ListarEstado() throws Exception {
		return estadoBO.Listar();
	}

	// BUSCAR PELO ID
	public Estado BuscarEstadoPorId(Long estado) throws Exception {
		return estadoBO.BuscarID(estado);
	}

	// ---------------------------------------------------------------------------------------//
	// CIDADE
	CidadeBO cidadeBO = new CidadeBO();

	// CADASTRAR
	public void CadastrarCidade(Cidade cidade) throws Exception {
		cidadeBO.Cadastrar(cidade);
	}

	// ALTERAR
	public void AlterarCidade(Cidade cidade) throws Exception {
		cidadeBO.Alterar(cidade);
	}

	// EXCLUIR
	public void ExcluirCidade(Cidade cidade) throws Exception {
		cidadeBO.Excluir(cidade);
	}

	// LISTAR
	public ArrayList<Cidade> ListarCidade() throws Exception {
		return cidadeBO.Listar();
	}

	// BUSCAR PELO ID
	public Cidade BuscarCidadePorId(Long cidade) throws Exception {
		return cidadeBO.BuscarID(cidade);
	}

	// ---------------------------------------------------------------------------------------//
	// NEGOCIO
	NegocioBO negocioBO = new NegocioBO();

	// CADASTRAR
	public void CadastrarNegocio(Negocio negocio) throws Exception {
		negocioBO.Cadastrar(negocio);
	}

	// ALTERAR
	public void AlterarNegocio(Negocio negocio) throws Exception {
		negocioBO.Alterar(negocio);
	}

	// EXCLUIR
	public void ExcluirNegocio(Negocio negocio) throws Exception {
		negocioBO.Excluir(negocio);
	}

	// LISTAR
	public ArrayList<Negocio> ListarNegocio() throws Exception {
		return negocioBO.Listar();
	}

	// BUSCAR PELO ID
	public Negocio BuscarNegocioPorId(Long negocio) throws Exception {
		return negocioBO.BuscarID(negocio);
	}

	// ---------------------------------------------------------------------------------------//
	// ITEM
	ItemBO itemBO = new ItemBO();

	// CADASTRAR
	public void CadastrarItem(Item item) throws Exception {
		itemBO.Cadastrar(item);
	}

	// ALTERAR
	public void AlterarItem(Item item) throws Exception {
		itemBO.Alterar(item);
	}

	// EXCLUIR
	public void ExcluirItem(Item item) throws Exception {
		itemBO.Excluir(item);
	}

	// LISTAR
	public ArrayList<Item> ListarItem() throws Exception {
		return itemBO.Listar();
	}

	// BUSCAR PELO ID
	public Item BuscarItemPorId(Long item) throws Exception {
		return itemBO.BuscarID(item);
	}

	// ---------------------------------------------------------------------------------------//
	// ATIVIDADE
	AtividadeBO atividadeBO = new AtividadeBO();

	// CADASTRAR
	public void CadastrarAtividade(Atividade atividade) throws Exception {
		atividadeBO.Cadastrar(atividade);
	}

	// ALTERAR
	public void AlterarAtividade(Atividade atividade) throws Exception {
		atividadeBO.Alterar(atividade);
	}

	// EXCLUIR
	public void ExcluirAtividade(Atividade atividade) throws Exception {
		atividadeBO.Excluir(atividade);
	}

	// LISTAR
	public ArrayList<Atividade> ListarAtividade() throws Exception {
		return atividadeBO.Listar();
	}
	
	// LISTAR ATIVOS
	public ArrayList<Atividade> ListarAtividadesAtivas() throws Exception {
		return atividadeBO.ListarAtividadesAtivas();
	}

	// BUSCAR PELO ID
	public Atividade BuscarAtividadePorId(Long atividade) throws Exception {
		return atividadeBO.BuscarID(atividade);
	}

	// ---------------------------------------------------------------------------------------//
	// LIGACAO
	LigacaoBO ligacaoBO = new LigacaoBO();

	// CADASTRAR
	public void CadastrarLigacao(Ligacao ligacao) throws Exception {
		ligacaoBO.Cadastrar(ligacao);
	}

	// ALTERAR
	public void AlterarLigacao(Ligacao ligacao) throws Exception {
		ligacaoBO.Alterar(ligacao);
	}

	// EXCLUIR
	public void ExcluirLigacao(Ligacao ligacao) throws Exception {
		ligacaoBO.Excluir(ligacao);
	}

	// LISTAR
	public ArrayList<Ligacao> ListarLigacao() throws Exception {
		return ligacaoBO.Listar();
	}

	// BUSCAR PELO ID
	public Ligacao BuscarLigacaoPorId(Long ligacao) throws Exception {
		return ligacaoBO.BuscarID(ligacao);
	}

	// ---------------------------------------------------------------------------------------//
	// USUARIO
	UsuarioBO usuarioBO = new UsuarioBO();

	// CADASTRAR
	public void CadastrarUsuario(Usuario usuario) throws Exception {
		usuarioBO.Cadastrar(usuario);
	}

	// ALTERAR
	public void AlterarUsuario(Usuario usuario) throws Exception {
		usuarioBO.Alterar(usuario);
	}

	// EXCLUIR
	public void ExcluirUsuario(Usuario usuario) throws Exception {
		usuarioBO.Excluir(usuario);
	}

	// LISTAR
	public ArrayList<Usuario> ListarUsuario() throws Exception {
		return usuarioBO.Listar();
	}

	// BUSCAR PELO ID
	public Usuario BuscarUsuarioPorId(Long usuario) throws Exception {
		return usuarioBO.BuscarID(usuario);
	}

	// ---------------------------------------------------------------------------------------//
	// CONTATO
	ContatoBO contatoBO = new ContatoBO();

	// CADASTRAR
	public void CadastrarContato(Contato contato) throws Exception {
		contatoBO.Cadastrar(contato);
	}

	// ALTERAR
	public void AlterarContato(Contato contato) throws Exception {
		contatoBO.Alterar(contato);
	}

	// EXCLUIR
	public void ExcluirContato(Contato contato) throws Exception {
		contatoBO.Excluir(contato);
	}

	// LISTAR
	public ArrayList<Contato> ListarContato() throws Exception {
		return contatoBO.Listar();
	}

	// BUSCAR PELO ID
	public Contato BuscarContatoPorId(Long contato) throws Exception {
		return contatoBO.BuscarID(contato);
	}

	// ---------------------------------------------------------------------------------------//
	// EMPRESA
	EmpresaBO empresaBO = new EmpresaBO();

	// CADASTRAR
	public void CadastrarEmpresa(Empresa empresa) throws Exception {
		empresaBO.Cadastrar(empresa);
	}

	// ALTERAR
	public void AlterarEmpresa(Empresa empresa) throws Exception {
		empresaBO.Alterar(empresa);
	}

	// EXCLUIR
	public void ExcluirEmpresa(Empresa empresa) throws Exception {
		empresaBO.Excluir(empresa);
	}

	// LISTAR
	public ArrayList<Empresa> ListarEmpresa() throws Exception {
		return empresaBO.Listar();
	}

	// BUSCAR PELO ID
	public Empresa BuscarEmpresaPorId(Long empresa) throws Exception {
		return empresaBO.BuscarID(empresa);
	}

	// ---------------------------------------------------------------------------------------//
}