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
	@GeneratedValue(strategy = GenerationType.IDENTITY) // CRIA O ID COMO
														// AUTO-INCREMENT
	private Long ComunicadorID;

	// CHAVE(S) ESTRANGEIRA(S)
	@ManyToOne
	@ForeignKey(name = "TipoComunicadorFK")
	private TipoComunicador TipoComunicadorID;

	// ATRIBUTO(S)
	private String Nome;

	public Long getComunicadorID() {
		return ComunicadorID;
	}

	public void setComunicadorID(Long comunicadorID) {
		ComunicadorID = comunicadorID;
	}

	public TipoComunicador getTipoComunicadorID() {
		return TipoComunicadorID;
	}

	public void setTipoComunicadorID(TipoComunicador tipoComunicadorID) {
		TipoComunicadorID = tipoComunicadorID;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}
}