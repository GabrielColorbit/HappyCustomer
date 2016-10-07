package br.edu.facear.crm.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@Entity
@Table(name="\"TipoContato\"")
@XmlRootElement(name = "TipoContato")
public class TipoContato implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@XmlElement
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@XmlElement
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		TipoContato other = (TipoContato) obj;
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
	@Override
	public String toString() {
		return "TipoContato [id=" + id + ", nome=" + nome + "]";
	}

	public TipoContato() {
		super();
	}
	public TipoContato(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	
	
	
}
