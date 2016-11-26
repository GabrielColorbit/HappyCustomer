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
	// @ManyToMany(mappedBy = "comunicadores_usuario")
	// private List<Usuario> usuarios;

	// COMUNICADOR_EMPRESAS
	// @ManyToMany(mappedBy = "comunicadores_empresa")
	// private List<Empresa> empresas;

	// COMUNICADOR_CONTATOS
	// @ManyToMany(mappedBy = "comunicadores_contato")
	// private List<Contato> contatos;
	
	// COMUNICADOR_ATIVIDADES
	// @ManyToMany(mappedBy = "comunicadores_atividade")
	//private List<Atividade> atividades;

	// ATRIBUTO(S)
	private String nome;
	private String resumo;
	public Long getId() {
		return id;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((resumo == null) ? 0 : resumo.hashCode());
		result = prime * result + ((tipocomunicador == null) ? 0 : tipocomunicador.hashCode());
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
		if (resumo == null) {
			if (other.resumo != null)
				return false;
		} else if (!resumo.equals(other.resumo))
			return false;
		if (tipocomunicador == null) {
			if (other.tipocomunicador != null)
				return false;
		} else if (!tipocomunicador.equals(other.tipocomunicador))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Comunicador [id=" + id + ", tipocomunicador=" + tipocomunicador + ", nome=" + nome + ", resumo="
				+ resumo + "]";
	}
	public Comunicador(Long id, TipoComunicador tipocomunicador, String nome, String resumo) {
		super();
		this.id = id;
		this.tipocomunicador = tipocomunicador;
		this.nome = nome;
		this.resumo = resumo;
	}
	public Comunicador() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	// GETTERS E SETTERS
	
	// HASHCODE
	

	// EQUALS
	
	// TO STRING
	
	// CONSTRUCTOR USING FIELDS
	
	// CONSTRUCTORS FROM SUPERCLASS
	
}