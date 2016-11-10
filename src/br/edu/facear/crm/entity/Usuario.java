package br.edu.facear.crm.entity;

import java.util.Date;
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
// CRIA TABELA
@Entity
@Table(name = "\"TB_USUARIO\"")

public class Usuario {

	// CHAVE PRIMARIA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // CRIA O ID COMO AUTO-INCREMENT
	private Long id;

	// CHAVES ESTRANGEIRAS
	@ManyToOne
	@ForeignKey(name = "fk_tipousuario")
	private TipoUsuario tipousuario;

	@ManyToOne
	@ForeignKey(name = "fk_cidade")
	private Cidade cidade;

	// RELACIONAMENTOS MUITOS PRA MUITOS

	// TELEFONES
	//@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OneToMany
	@JoinTable(name = "\"TB_TELEFONE_USUARIO\"", joinColumns = {
	@JoinColumn(name = "id_usuario") }, inverseJoinColumns = {
	@JoinColumn(name = "id_telefone") })
	private List<Telefone> telefones_usuario;

	// COMUNICADORES
	//@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OneToMany
	@JoinTable(name = "\"TB_COMUNICADOR_USUARIO\"", joinColumns = {
	@JoinColumn(name = "id_usuario") }, inverseJoinColumns = {
	@JoinColumn(name = "id_comunicador") })
	private List<Comunicador> comunicadores_usuario;

	// ATRIBUTOS
	private String nome;
	private String email;
	private String cpf;
	private Date datanascimento;
	private String endereco;
	private Long numero;
	private String complemento;
	private String cep;
	private String bairro;
	private String senha;
	private Genero genero;
	private String cargo;
	private String foto;
	private Date datacadastro;
	private Status status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TipoUsuario getTipousuario() {
		return tipousuario;
	}
	public void setTipousuario(TipoUsuario tipousuario) {
		this.tipousuario = tipousuario;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public List<Telefone> getTelefones_usuario() {
		return telefones_usuario;
	}
	public void setTelefones_usuario(List<Telefone> telefones_usuario) {
		this.telefones_usuario = telefones_usuario;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Date getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(Date datanascimento) {
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
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


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", tipousuario=" + tipousuario + ", cidade=" + cidade + ", telefones_usuario="
				+ telefones_usuario + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", datanascimento="
				+ datanascimento + ", endereco=" + endereco + ", numero=" + numero + ", complemento=" + complemento
				+ ", cep=" + cep + ", bairro=" + bairro + ", senha=" + senha + ", genero=" + genero + ", cargo=" + cargo
				+ ", foto=" + foto + ", datacadastro=" + datacadastro + ", status=" + status + "]";
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
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((datacadastro == null) ? 0 : datacadastro.hashCode());
		result = prime * result + ((datanascimento == null) ? 0 : datanascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((foto == null) ? 0 : foto.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((telefones_usuario == null) ? 0 : telefones_usuario.hashCode());
		result = prime * result + ((tipousuario == null) ? 0 : tipousuario.hashCode());
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
		Usuario other = (Usuario) obj;
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
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
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
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (status != other.status)
			return false;
		if (telefones_usuario == null) {
			if (other.telefones_usuario != null)
				return false;
		} else if (!telefones_usuario.equals(other.telefones_usuario))
			return false;
		if (tipousuario == null) {
			if (other.tipousuario != null)
				return false;
		} else if (!tipousuario.equals(other.tipousuario))
			return false;
		return true;
	}
	
	public Usuario(Long id, TipoUsuario tipousuario, Cidade cidade, List<Telefone> telefones_usuario, String nome,
			String email, String cpf, Date datanascimento, String endereco, Long numero, String complemento, String cep,
			String bairro, String senha, Genero genero, String cargo, String foto, Date datacadastro, Status status) {
		super();
		this.id = id;
		this.tipousuario = tipousuario;
		this.cidade = cidade;
		this.telefones_usuario = telefones_usuario;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.datanascimento = datanascimento;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.bairro = bairro;
		this.senha = senha;
		this.genero = genero;
		this.cargo = cargo;
		this.foto = foto;
		this.datacadastro = datacadastro;
		this.status = status;
	}
	/**
	 * 
	 */
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
}