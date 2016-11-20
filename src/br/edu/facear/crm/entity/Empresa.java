package br.edu.facear.crm.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.ForeignKey;

@XmlRootElement
//CRIA TABELA
@Entity
@Table(name = "\"TB_EMPRESA\"")

public class Empresa implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 192130139182398123L;

	// CHAVE PRIMARIA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // CRIA O ID COMO AUTO-INCREMENT
	private Long id;
	
	// CHAVE(S) ESTRANGEIRA(S)
	@ManyToOne
	@ForeignKey(name = "fk_usuarioresponsavel")
	private Usuario usuarioresponsavel;

	@ManyToOne
	@ForeignKey(name = "fk_tipoempresa")
	private TipoEmpresa tipoempresa;
	
	@ManyToOne
	@ForeignKey(name = "fk_cidade")
	private Cidade cidade;
	
	// RELACIONAMENTOS MUITOS PRA MUITOS
	
	// TELEFONES
	// @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OneToMany
	@JoinTable(name = "\"TB_TELEFONE_EMPRESA\"", joinColumns = {
	@JoinColumn(name = "id_empresa") }, inverseJoinColumns = {
	@JoinColumn(name = "id_telefone") })
	private List<Telefone> telefones_empresa;
	
	// COMUNICADORES
	@OneToMany
	@JoinTable(name = "\"TB_COMUNICADOR_EMPRESA\"", joinColumns = {
	@JoinColumn(name = "id_empresa") }, inverseJoinColumns = { 
	@JoinColumn(name = "id_comunicador") })
	private List<Comunicador> comunicadores_empresa;
	
	// CONTATOS
	@ManyToMany
	@JoinTable(name = "\"TB_EMPRESA_CONTATO\"", joinColumns = {
	@JoinColumn(name = "id_empresa") }, inverseJoinColumns = { 
	@JoinColumn(name = "id_contato") })
	@JsonManagedReference
	private List<Contato> contatos;
	
	// ATRIBUTOS
	private String razaosocial;
	private String cnpj;
	private String inscricaoestadual;
	private String endereco;
	private Long numero;
	private String complemento;
	private String cep;
	private String bairro;
	private String ramo;
	private String site;
	private String logo;
	private String datacadastro;
	private Status status;
	
	
	
	
	
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





	public List<Telefone> getTelefones_empresa() {
		return telefones_empresa;
	}





	public void setTelefones_empresa(List<Telefone> telefones_empresa) {
		this.telefones_empresa = telefones_empresa;
	}





	public List<Comunicador> getComunicadores_empresa() {
		return comunicadores_empresa;
	}





	public void setComunicadores_empresa(List<Comunicador> comunicadores_empresa) {
		this.comunicadores_empresa = comunicadores_empresa;
	}





	public List<Contato> getContatos() {
		return contatos;
	}





	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}





	public String getRazaosocial() {
		return razaosocial;
	}





	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}





	public String getCnpj() {
		return cnpj;
	}





	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}





	public String getInscricaoestadual() {
		return inscricaoestadual;
	}





	public void setInscricaoestadual(String inscricaoestadual) {
		this.inscricaoestadual = inscricaoestadual;
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





	public String getComplemento() {
		return complemento;
	}





	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}





	public String getCep() {
		return cep;
	}





	public void setCep(String cep) {
		this.cep = cep;
	}





	public String getBairro() {
		return bairro;
	}





	public void setBairro(String bairro) {
		this.bairro = bairro;
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





	public String getLogo() {
		return logo;
	}





	public void setLogo(String logo) {
		this.logo = logo;
	}





	public String getDatacadastro() {
		return datacadastro;
	}





	public void setDatacadastro(String datacadastro) {
		this.datacadastro = datacadastro;
	}





	public Status getStatus() {
		return status;
	}





	public void setStatus(Status status) {
		this.status = status;
	}





	public static long getSerialversionuid() {
		return serialVersionUID;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((comunicadores_empresa == null) ? 0 : comunicadores_empresa.hashCode());
		result = prime * result + ((contatos == null) ? 0 : contatos.hashCode());
		result = prime * result + ((datacadastro == null) ? 0 : datacadastro.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inscricaoestadual == null) ? 0 : inscricaoestadual.hashCode());
		result = prime * result + ((logo == null) ? 0 : logo.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((ramo == null) ? 0 : ramo.hashCode());
		result = prime * result + ((razaosocial == null) ? 0 : razaosocial.hashCode());
		result = prime * result + ((site == null) ? 0 : site.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((telefones_empresa == null) ? 0 : telefones_empresa.hashCode());
		result = prime * result + ((tipoempresa == null) ? 0 : tipoempresa.hashCode());
		result = prime * result + ((usuarioresponsavel == null) ? 0 : usuarioresponsavel.hashCode());
		return result;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (comunicadores_empresa == null) {
			if (other.comunicadores_empresa != null)
				return false;
		} else if (!comunicadores_empresa.equals(other.comunicadores_empresa))
			return false;
		if (contatos == null) {
			if (other.contatos != null)
				return false;
		} else if (!contatos.equals(other.contatos))
			return false;
		if (datacadastro == null) {
			if (other.datacadastro != null)
				return false;
		} else if (!datacadastro.equals(other.datacadastro))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inscricaoestadual == null) {
			if (other.inscricaoestadual != null)
				return false;
		} else if (!inscricaoestadual.equals(other.inscricaoestadual))
			return false;
		if (logo == null) {
			if (other.logo != null)
				return false;
		} else if (!logo.equals(other.logo))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (ramo == null) {
			if (other.ramo != null)
				return false;
		} else if (!ramo.equals(other.ramo))
			return false;
		if (razaosocial == null) {
			if (other.razaosocial != null)
				return false;
		} else if (!razaosocial.equals(other.razaosocial))
			return false;
		if (site == null) {
			if (other.site != null)
				return false;
		} else if (!site.equals(other.site))
			return false;
		if (status != other.status)
			return false;
		if (telefones_empresa == null) {
			if (other.telefones_empresa != null)
				return false;
		} else if (!telefones_empresa.equals(other.telefones_empresa))
			return false;
		if (tipoempresa == null) {
			if (other.tipoempresa != null)
				return false;
		} else if (!tipoempresa.equals(other.tipoempresa))
			return false;
		if (usuarioresponsavel == null) {
			if (other.usuarioresponsavel != null)
				return false;
		} else if (!usuarioresponsavel.equals(other.usuarioresponsavel))
			return false;
		return true;
	}





	@Override
	public String toString() {
		return "Empresa [id=" + id + ", usuarioresponsavel=" + usuarioresponsavel + ", tipoempresa=" + tipoempresa
				+ ", cidade=" + cidade + ", telefones_empresa=" + telefones_empresa + ", comunicadores_empresa="
				+ comunicadores_empresa + ", contatos=" + contatos + ", razaosocial=" + razaosocial + ", cnpj=" + cnpj
				+ ", inscricaoestadual=" + inscricaoestadual + ", endereco=" + endereco + ", numero=" + numero
				+ ", complemento=" + complemento + ", cep=" + cep + ", bairro=" + bairro + ", ramo=" + ramo + ", site="
				+ site + ", logo=" + logo + ", datacadastro=" + datacadastro + ", status=" + status + "]";
	}





	public Empresa(Long id, Usuario usuarioresponsavel, TipoEmpresa tipoempresa, Cidade cidade,
			List<Telefone> telefones_empresa, List<Comunicador> comunicadores_empresa, ArrayList<Contato> contatos,
			String razaosocial, String cnpj, String inscricaoestadual, String endereco, Long numero, String complemento,
			String cep, String bairro, String ramo, String site, String logo, String datacadastro, Status status) {
		super();
		this.id = id;
		this.usuarioresponsavel = usuarioresponsavel;
		this.tipoempresa = tipoempresa;
		this.cidade = cidade;
		this.telefones_empresa = telefones_empresa;
		this.comunicadores_empresa = comunicadores_empresa;
		this.contatos = contatos;
		this.razaosocial = razaosocial;
		this.cnpj = cnpj;
		this.inscricaoestadual = inscricaoestadual;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.bairro = bairro;
		this.ramo = ramo;
		this.site = site;
		this.logo = logo;
		this.datacadastro = datacadastro;
		this.status = status;
	}





	public Empresa() {
		super();
		// TODO Auto-generated constructor stub
	}
}