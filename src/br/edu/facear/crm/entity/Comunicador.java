package br.edu.facear.crm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private TipoComunicador id_tipocomunicador;

	// ATRIBUTO(S)
	private String nome;

	// GETTERS E SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoComunicador getId_tipocomunicador() {
		return id_tipocomunicador;
	}

	public void setId_tipocomunicador(TipoComunicador id_tipocomunicador) {
		this.id_tipocomunicador = id_tipocomunicador;
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
		result = prime * result + ((id_tipocomunicador == null) ? 0 : id_tipocomunicador.hashCode());
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
		Comunicador other = (Comunicador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_tipocomunicador == null) {
			if (other.id_tipocomunicador != null)
				return false;
		} else if (!id_tipocomunicador.equals(other.id_tipocomunicador))
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
		return "Comunicador [id=" + id + ", id_tipocomunicador=" + id_tipocomunicador + ", nome=" + nome + "]";
	}

	// CONSTRUCTOR USING FIELDS
	/**
	 * @param id
	 * @param id_tipocomunicador
	 * @param nome
	 */
	public Comunicador(Long id, TipoComunicador id_tipocomunicador, String nome) {
		super();
		this.id = id;
		this.id_tipocomunicador = id_tipocomunicador;
		this.nome = nome;
	}

	// CONSTRUCTORS FROM SUPERCLASS
	/**
	 * 
	 */
	public Comunicador() {
		super();
		// TODO Auto-generated constructor stub
	}
}