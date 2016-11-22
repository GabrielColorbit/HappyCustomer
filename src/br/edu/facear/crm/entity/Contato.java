package br.edu.facear.crm.entity;

import java.io.Serializable;
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

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.ForeignKey;

@XmlRootElement
@Entity
// CRIA TABELA
@Table(name = "\"TB_CONTATO\"")
public class Contato implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5781467587182894760L;

	// CHAVE PRIMARIA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// CHAVE(S) ESTRANGEIRA(S)
	@ManyToOne
	@ForeignKey(name = "fk_usuarioresponsavel")
	private Usuario usuarioresponsavel;

	@ManyToOne
	@ForeignKey(name = "fk_tipocontato")
	private TipoContato tipocontato;

	@ManyToOne
	@ForeignKey(name = "fk_origemcontato")
	private OrigemContato origemcontato;

	@ManyToOne
	@ForeignKey(name = "fk_cidade")
	private Cidade cidade;

	// RELACIONAMENTOS MUITOS PRA MUITOS

	// TELEFONES
	// @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OneToMany
	@JoinTable(name = "\"TB_TELEFONE_CONTATO\"", joinColumns = {
			@JoinColumn(name = "id_contato") }, inverseJoinColumns = { @JoinColumn(name = "id_telefone") })
	private List<Telefone> telefones_contato;

	// COMUNICADORES
	@OneToMany
	@JoinTable(name = "\"TB_COMUNICADOR_CONTATO\"", joinColumns = {
			@JoinColumn(name = "id_contato") }, inverseJoinColumns = { @JoinColumn(name = "id_comunicador") })
	private List<Comunicador> comunicadores_contato;

	// EMPRESAS
	@ManyToMany(mappedBy = "contatos", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonBackReference
	@JsonIgnore
	private List<Empresa> empresas;

	// ATRIBUTOS
	private String nome;
	private String cpf;
	private String datanascimento;
	private String endereco;
	private Long numero;
	private String complemento;
	private String cep;
	private String bairro;
	private Genero genero;
	private String cargo;
	private String foto;
	private String datacadastro;
	private Status status;
	private long idfoto;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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

	public TipoContato getTipocontato() {
		return tipocontato;
	}

	public void setTipocontato(TipoContato tipocontato) {
		this.tipocontato = tipocontato;
	}

	public OrigemContato getOrigemcontato() {
		return origemcontato;
	}

	public void setOrigemcontato(OrigemContato origemcontato) {
		this.origemcontato = origemcontato;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Telefone> getTelefones_contato() {
		return telefones_contato;
	}

	public void setTelefones_contato(List<Telefone> telefones_contato) {
		this.telefones_contato = telefones_contato;
	}

	public List<Comunicador> getComunicadores_contato() {
		return comunicadores_contato;
	}

	public void setComunicadores_contato(List<Comunicador> comunicadores_contato) {
		this.comunicadores_contato = comunicadores_contato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(String datanascimento) {
		this.datanascimento = datanascimento;
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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	// public List<Empresa> getEmpresas() {
	// return empresas;
	// }

	@ManyToMany(mappedBy = "contatos", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonBackReference
	@JsonIgnore
	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
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

	public long getIdfoto() {
		return idfoto;
	}

	public void setIdfoto(long idfoto) {
		this.idfoto = idfoto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((comunicadores_contato == null) ? 0 : comunicadores_contato.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((datacadastro == null) ? 0 : datacadastro.hashCode());
		result = prime * result + ((datanascimento == null) ? 0 : datanascimento.hashCode());
		result = prime * result + ((empresas == null) ? 0 : empresas.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((foto == null) ? 0 : foto.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((origemcontato == null) ? 0 : origemcontato.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((telefones_contato == null) ? 0 : telefones_contato.hashCode());
		result = prime * result + ((tipocontato == null) ? 0 : tipocontato.hashCode());
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
		Contato other = (Contato) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
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
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (comunicadores_contato == null) {
			if (other.comunicadores_contato != null)
				return false;
		} else if (!comunicadores_contato.equals(other.comunicadores_contato))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (datacadastro == null) {
			if (other.datacadastro != null)
				return false;
		} else if (!datacadastro.equals(other.datacadastro))
			return false;
		if (datanascimento == null) {
			if (other.datanascimento != null)
				return false;
		} else if (!datanascimento.equals(other.datanascimento))
			return false;
		if (empresas == null) {
			if (other.empresas != null)
				return false;
		} else if (!empresas.equals(other.empresas))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (foto == null) {
			if (other.foto != null)
				return false;
		} else if (!foto.equals(other.foto))
			return false;
		if (genero != other.genero)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (origemcontato == null) {
			if (other.origemcontato != null)
				return false;
		} else if (!origemcontato.equals(other.origemcontato))
			return false;
		if (status != other.status)
			return false;
		if (telefones_contato == null) {
			if (other.telefones_contato != null)
				return false;
		} else if (!telefones_contato.equals(other.telefones_contato))
			return false;
		if (tipocontato == null) {
			if (other.tipocontato != null)
				return false;
		} else if (!tipocontato.equals(other.tipocontato))
			return false;
		if (usuarioresponsavel == null) {
			if (other.usuarioresponsavel != null)
				return false;
		} else if (!usuarioresponsavel.equals(other.usuarioresponsavel))
			return false;
		return true;
	}

	public Contato(Long id, Usuario usuarioresponsavel, TipoContato tipocontato, OrigemContato origemcontato,
			Cidade cidade, List<Telefone> telefones_contato, List<Comunicador> comunicadores_contato,
			List<Empresa> empresas, String nome, String cpf, String datanascimento, String endereco, Long numero,
			String complemento, String cep, String bairro, Genero genero, String cargo, String foto,
			String datacadastro, Status status) {
		super();
		this.id = id;
		this.usuarioresponsavel = usuarioresponsavel;
		this.tipocontato = tipocontato;
		this.origemcontato = origemcontato;
		this.cidade = cidade;
		this.telefones_contato = telefones_contato;
		this.comunicadores_contato = comunicadores_contato;
		this.empresas = empresas;
		this.nome = nome;
		this.cpf = cpf;
		this.datanascimento = datanascimento;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.bairro = bairro;
		this.genero = genero;
		this.cargo = cargo;
		this.foto = foto;
		this.datacadastro = datacadastro;
		this.status = status;
	}

	/**
	 * 
	 */
	public Contato() {
		super();
		// TODO Auto-generated constructor stub
	}
}