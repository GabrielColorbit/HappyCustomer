package br.edu.facear.crm.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.ForeignKey;

@XmlRootElement
// CRIA TABELA
@Entity
@Table(name = "\"TB_TELEFONE\"")

public class Telefone {

	// CHAVE PRIMARIA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // CRIA O ID COMO AUTO-INCREMENT
	private Long id;

	// CHAVES ESTRANGEIRAS
	@ManyToOne
	@ForeignKey(name = "fk_tipotelefone")
	private TipoTelefone id_tipotelefone;

	// ATRIBUTOS
	private String numero;

	// GETTERS E SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoTelefone getId_tipotelefone() {
		return id_tipotelefone;
	}

	public void setId_tipotelefone(TipoTelefone id_tipotelefone) {
		this.id_tipotelefone = id_tipotelefone;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}