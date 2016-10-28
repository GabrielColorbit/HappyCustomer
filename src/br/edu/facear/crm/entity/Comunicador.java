package br.edu.facear.crm.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

//CRIA TABELA
@Entity
@Table(name = "\"TB_COMUNICADOR\"")
public class Comunicador {

	// CHAVE PRIMARIA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // CRIA O ID COMO AUTO-INCREMENT
	private Long id;

	// CHAVE(S) ESTRANGEIRA(S)
	@ManyToOne
	@ForeignKey(name = "fk_tipocomunicador")
	private TipoComunicador tipocomunicador;

	// COMUNICADOR_USUARIOS
	@ManyToMany(mappedBy = "comunicadores_usuario")
	private List<Usuario> usuarios;

	// COMUNICADOR_EMPRESAS
	//@ManyToMany(mappedBy = "comunicadores_empresa")
	//private List<Empresa> empresas;

	// COMUNICADOR_CONTATOS
	//@ManyToMany(mappedBy = "comunicadores_contato")
	//private List<Contato> contatos;

	
	
	// ATRIBUTO(S)
	private String nome;

	public Long getId() {
		return id;
	}

	/**
	 * 
	 */
	public Comunicador() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param tipocomunicador
	 * @param usuarios
	 * @param nome
	 */
	public Comunicador(Long id, TipoComunicador tipocomunicador, List<Usuario> usuarios, String nome) {
		super();
		this.id = id;
		this.tipocomunicador = tipocomunicador;
		this.usuarios = usuarios;
		this.nome = nome;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "Comunicador [id=" + id + ", tipocomunicador=" + tipocomunicador + ", usuarios="
				+ (usuarios != null ? usuarios.subList(0, Math.min(usuarios.size(), maxLen)) : null) + ", nome=" + nome
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipocomunicador == null) ? 0 : tipocomunicador.hashCode());
		result = prime * result + ((usuarios == null) ? 0 : usuarios.hashCode());
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
		Comunicador other = (Comunicador) obj;
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
		if (tipocomunicador == null) {
			if (other.tipocomunicador != null)
				return false;
		} else if (!tipocomunicador.equals(other.tipocomunicador))
			return false;
		if (usuarios == null) {
			if (other.usuarios != null)
				return false;
		} else if (!usuarios.equals(other.usuarios))
			return false;
		return true;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoComunicador getTipocomunicador() {
		return tipocomunicador;
	}

	public void setTipocomunicador(TipoComunicador tipocomunicador) {
		this.tipocomunicador = tipocomunicador;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// GETTERS E SETTERS
	
	// HASHCODE
	

	// EQUALS
	
	// TO STRING
	
	// CONSTRUCTOR USING FIELDS
	
	// CONSTRUCTORS FROM SUPERCLASS
	
}