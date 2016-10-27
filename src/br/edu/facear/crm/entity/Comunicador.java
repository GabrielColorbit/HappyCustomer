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
	private TipoComunicador tipocomunicador;

	// ATRIBUTO(S)
	private String nome;

	public Long getId() {
		return id;
	}

	// GETTERS E SETTERS
	public void setId(Long id) {
		this.id = id;
	}

	public TipoComunicador getTipocomunicador() {
		return tipocomunicador;
	}

	public void setTipocomunicador(TipoComunicador tipocomunicador) {
		this.tipocomunicador = tipocomunicador;
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
		result = prime * result + ((tipocomunicador == null) ? 0 : tipocomunicador.hashCode());
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
		return true;
	}

	// TO STRING
	@Override
	public String toString() {
		return "Comunicador [id=" + id + ", tipocomunicador=" + tipocomunicador + ", nome=" + nome + "]";
	}

	// CONSTRUCTOR USING FIELDS
	/**
	 * @param id
	 * @param tipocomunicador
	 * @param nome
	 */
	public Comunicador(Long id, TipoComunicador tipocomunicador, String nome) {
		super();
		this.id = id;
		this.tipocomunicador = tipocomunicador;
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