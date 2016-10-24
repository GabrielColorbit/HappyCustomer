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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.ForeignKey;

@XmlRootElement
@Entity
@Table(name="\"TB_USUARIO\"")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@ForeignKey(name="fk_tipousuario")
	private TipoUsuario tipousuario;
	@ManyToOne
	@ForeignKey(name="fk_cidade")
	private Cidade cidade;	
	   
    @ManyToMany
    @JoinTable(name="usuario_telefones", joinColumns={
    		@JoinColumn(name = "usuario_id") }, inverseJoinColumns = {
			@JoinColumn(name = "telefone_id") })
    private List<Telefone> telefones;
    
    
	private String email;
	private String senha;
	private String nome;
	private String cpf;
	private Genero genero;
	private String cargo;
	private Date datanascimento;
	private String endereco;
	private Long numero;
	private Long cep;
	public Long getId() {
		return id;
	}
	@XmlElement
	public void setId(Long id) {
		this.id = id;
	}
	public TipoUsuario getTipousuario() {
		return tipousuario;
	}
	@XmlElement
	public void setTipousuario(TipoUsuario tipousuario) {
		this.tipousuario = tipousuario;
	}
	public Cidade getCidade() {
		return cidade;
	}
	@XmlElement
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public String getEmail() {
		return email;
	}
	@XmlElement
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	@XmlElement
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	@XmlElement
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	@XmlElement
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Genero getGenero() {
		return genero;
	}
	@XmlElement
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public String getCargo() {
		return cargo;
	}
	@XmlElement
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Date getDatanascimento() {
		return datanascimento;
	}
	@XmlElement
	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}
	public String getEndereco() {
		return endereco;
	}
	@XmlElement
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Long getNumero() {
		return numero;
	}
	@XmlElement
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public Long getCep() {
		return cep;
	}
	@XmlElement
	public void setCep(Long cep) {
		this.cep = cep;
	}

 
	
	
	public List getTelefones() {
		return telefones;
	}
	@XmlElement
	public void setTelefones(List telefones) {
		this.telefones = telefones;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", tipousuario=" + tipousuario + ", cidade=" + cidade + ", telefones=" + telefones
				+ ", email=" + email + ", senha=" + senha + ", nome=" + nome + ", cpf=" + cpf + ", genero=" + genero
				+ ", cargo=" + cargo + ", datanascimento=" + datanascimento + ", endereco=" + endereco + ", numero="
				+ numero + ", cep=" + cep + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((datanascimento == null) ? 0 : datanascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((telefones == null) ? 0 : telefones.hashCode());
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
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
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
		if (telefones == null) {
			if (other.telefones != null)
				return false;
		} else if (!telefones.equals(other.telefones))
			return false;
		if (tipousuario == null) {
			if (other.tipousuario != null)
				return false;
		} else if (!tipousuario.equals(other.tipousuario))
			return false;
		return true;
	}
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Usuario(Long id, TipoUsuario tipousuario, Cidade cidade, List<Telefone> telefones, String email,
			String senha, String nome, String cpf, Genero genero, String cargo, Date datanascimento, String endereco,
			Long numero, Long cep) {
		super();
		this.id = id;
		this.tipousuario = tipousuario;
		this.cidade = cidade;
		this.telefones = telefones;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero;
		this.cargo = cargo;
		this.datanascimento = datanascimento;
		this.endereco = endereco;
		this.numero = numero;
		this.cep = cep;
	}
	
}
