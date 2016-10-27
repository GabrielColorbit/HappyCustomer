package br.edu.facear.crm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.ForeignKey;

@XmlRootElement
// CRIA TABELA
@Entity
@Table(name = "\"TB_CIDADE\"")

public class Cidade {

	// CHAVE PRIMÁRIA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // CRIA O ID COMO AUTO-INCREMENT
	private Long id;

	// CHAVE(S) ESTRANGEIRA(S)
	@ManyToOne
	@ForeignKey(name = "fk_estado")
	private Estado id_estado;

	// ATRIBUTO(S)
	private String nome;

	// GETTER(S) E SETTER(S)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Estado getId_estado() {
		return id_estado;
	}

	public void setId_estado(Estado id_estado) {
		this.id_estado = id_estado;
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
		result = prime * result + ((id_estado == null) ? 0 : id_estado.hashCode());
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
		Cidade other = (Cidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_estado == null) {
			if (other.id_estado != null)
				return false;
		} else if (!id_estado.equals(other.id_estado))
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
		return "Cidade [id=" + id + ", id_estado=" + id_estado + ", nome=" + nome + "]";
	}

	// CONSTRUCTOR USING FIELDS
	/**
	 * @param id
	 * @param id_estado
	 * @param nome
	 */
	public Cidade(Long id, Estado id_estado, String nome) {
		super();
		this.id = id;
		this.id_estado = id_estado;
		this.nome = nome;
	}

	// CONSTRUCTORS FROM SUPERCLASS
	/**
	 * 
	 */
	public Cidade() {
		super();
		// TODO Auto-generated constructor stub
	}
}