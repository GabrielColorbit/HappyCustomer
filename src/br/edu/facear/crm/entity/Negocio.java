package br.edu.facear.crm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
//CRIA TABELA
@Table(name="\"TB_NEGOCIO\"")

public class Negocio {
	
	// CHAVE PRIMARIA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // CRIA O ID COMO AUTO-INCREMENT
	private Long id;
	
	// CHAVE(S) ESTRANGEIRA(S)
	@ManyToOne
	@ForeignKey(name = "fk_usuarioresponsavel")
	private Usuario usuarioresponsavel;

	@ManyToOne
	@ForeignKey(name = "fk_empresa")
	private Empresa empresa;
	
	// ATRIBUTOS
	private String nome;
	private Date data;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Usuario getUsuarioresponsavel() {
		return usuarioresponsavel;
	}
	public void setUsuarioresponsavel(Usuario usuarioresponsavel) {
		this.usuarioresponsavel = usuarioresponsavel;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((usuarioresponsavel == null) ? 0 : usuarioresponsavel.hashCode());
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
		Negocio other = (Negocio) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
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
		if (usuarioresponsavel == null) {
			if (other.usuarioresponsavel != null)
				return false;
		} else if (!usuarioresponsavel.equals(other.usuarioresponsavel))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Negocio [id=" + id + ", usuarioresponsavel=" + usuarioresponsavel + ", empresa=" + empresa + ", nome="
				+ nome + ", data=" + data + "]";
	}
	/**
	 * @param id
	 * @param usuarioresponsavel
	 * @param empresa
	 * @param nome
	 * @param data
	 */
	public Negocio(Long id, Usuario usuarioresponsavel, Empresa empresa, String nome, Date data) {
		super();
		this.id = id;
		this.usuarioresponsavel = usuarioresponsavel;
		this.empresa = empresa;
		this.nome = nome;
		this.data = data;
	}
	/**
	 * 
	 */
	public Negocio() {
		super();
		// TODO Auto-generated constructor stub
	}
}