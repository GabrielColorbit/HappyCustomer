package br.edu.facear.crm.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;



@Entity
@Table(name="\"Empresa\"")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@ForeignKey(name = "fk_tipoempresa")		
	private TipoEmpresa tipoempresa;
	@ManyToOne
	@ForeignKey(name = "fk_cidade")
	private Cidade cidade;
	@ManyToMany
	@JoinTable(name = "empresa_telefones", joinColumns={
		@JoinColumn(name = "EmpresaID")	},inverseJoinColumns={ 
		@JoinColumn(name = "TelefoneID")})
	private List<Telefone> telefones;
	
	@ManyToMany
	@JoinTable(name = "empresa_contatos", joinColumns={
			@JoinColumn(name = "EmpresaID")	},inverseJoinColumns={ 
			@JoinColumn(name = "ContatoID")})
	private List<Contato> contatos;
	
	
	private String nome;
	private String cnpj;
	private String	razaosocial;
	private Date datacadastro;
	private Status status;
	private String ramo;
	private String site;
	private String endereco;
	private Long numero;
	private Long cep;
	
	
	
	
	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public TipoEmpresa getTipoempresa() {
		return tipoempresa;
	}




	public void setTipoempresa(TipoEmpresa tipoempresa) {
		this.tipoempresa = tipoempresa;
	}




	public Cidade getCidade() {
		return cidade;
	}




	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}





	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public String getCnpj() {
		return cnpj;
	}




	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}




	public String getRazaosocial() {
		return razaosocial;
	}




	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}




	public Date getDatacadastro() {
		return datacadastro;
	}




	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}




	public Status getStatus() {
		return status;
	}




	public void setStatus(Status status) {
		this.status = status;
	}




	public String getRamo() {
		return ramo;
	}




	public void setRamo(String ramo) {
		this.ramo = ramo;
	}




	public String getSite() {
		return site;
	}




	public void setSite(String site) {
		this.site = site;
	}




	public String getEndereco() {
		return endereco;
	}




	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}




	public Long getNumero() {
		return numero;
	}




	public void setNumero(Long numero) {
		this.numero = numero;
	}


	public List<Telefone> getTelefones() {
		return telefones;
	}




	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	



	public List<Contato> getContatos() {
		return contatos;
	}




	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}






	public Long getCep() {
		return cep;
	}




	public void setCep(Long cep) {
		this.cep = cep;
	}




	@Override
	public String toString() {
		return "Empresa [id=" + id + ", tipoempresa=" + tipoempresa + ", cidade=" + cidade + ", telefones=" + telefones
				+ ", contatos=" + contatos + ", nome=" + nome + ", cnpj=" + cnpj + ", razaosocial=" + razaosocial
				+ ", datacadastro=" + datacadastro + ", status=" + status + ", ramo=" + ramo + ", site=" + site
				+ ", endereco=" + endereco + ", numero=" + numero + ", cep=" + cep + "]";
	}




	public Empresa() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
