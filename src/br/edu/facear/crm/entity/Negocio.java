package br.edu.facear.crm.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.ForeignKey;

@XmlRootElement
@Entity
//CRIA TABELA
@Table(name="\"TB_NEGOCIO\"")

public class Negocio {
	
	// CHAVE PRIMARIA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // CRIA O ID COMO AUTO-INCREMENT
	private Long id;
	
	// CHAVE(S) ESTRANGEIRA(S)
	@ManyToOne
	@ForeignKey(name="fk_usuario")
	private Usuario usuarioresponsavel;
	
	@ManyToOne
	@ForeignKey(name = "fk_contato")
	private Contato contato;
	
	@ManyToOne
	@ForeignKey(name = "fk_empresa")
	private Empresa empresa;	
	
	@OneToMany
	@JoinTable(name = "\"TB_ITEM_NEGOCIO\"", joinColumns = {
	@JoinColumn(name = "id_negocio") }, inverseJoinColumns = { 
	@JoinColumn(name = "id_item") })
	private List<Item> itens_negocio;
	
	// ATRIBUTOS
	private String nome;
	private String data;
	private Float valor;
	private Situacao situacao;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Usuario getUsuarioresponsavel() {
		return usuarioresponsavel;
	}
	public void setUsuarioresponsavel(Usuario usuarioresponsavel) {
		this.usuarioresponsavel = usuarioresponsavel;
	}
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public List<Item> getItens_negocio() {
		return itens_negocio;
	}
	public void setItens_negocio(List<Item> itens_negocio) {
		this.itens_negocio = itens_negocio;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	@Override
	public String toString() {
		return "Negocio [id=" + id + ", usuarioresponsavel=" + usuarioresponsavel + ", contato=" + contato
				+ ", empresa=" + empresa + ", itens_negocio=" + itens_negocio + ", nome=" + nome + ", data=" + data
				+ ", valor=" + valor + ", situacao=" + situacao + "]";
	}
	public Negocio(Long id, Usuario usuarioresponsavel, Contato contato, Empresa empresa, List<Item> itens_negocio,
			String nome, String data, Float valor, Situacao situacao) {
		super();
		this.id = id;
		this.usuarioresponsavel = usuarioresponsavel;
		this.contato = contato;
		this.empresa = empresa;
		this.itens_negocio = itens_negocio;
		this.nome = nome;
		this.data = data;
		this.valor = valor;
		this.situacao = situacao;
	}
	public Negocio() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}