package br.edu.facear.crm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
// CRIA TABELA
@Table(name = "\"TB_TIPO_COMUNICADOR\"")

public class TipoComunicador {

	// CHAVE PRIMARIA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // CRIA O ID COMO AUTO-INCREMENT
	private Long id;

	// ATRIBUTOS
	private String nome;

	// GETTERS E SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// HASHCODE
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	// EQUALS
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoComunicador other = (TipoComunicador) obj;
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
		return true;
	}

	// TO STRING
	@Override
	public String toString() {
		return "TipoComunicador [id=" + id + ", nome=" + nome + "]";
	}

	// CONSTRUCTOR USING FIELDS
	/**
	 * @param id
	 * @param nome
	 */
	public TipoComunicador(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	// CONSTRUCTORS FROM SUPERCLASS
	/**
	 * 
	 */
	public TipoComunicador() {
		super();
		// TODO Auto-generated constructor stub
	}
}