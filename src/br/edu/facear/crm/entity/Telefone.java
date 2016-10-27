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
@Entity
@Table(name="\"TB_TELEFONE\"")
public class Telefone implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@ForeignKey(name="fk_tipo_telefone")
	private TipoTelefone tipotelefone;
	private Long numero;

	@JsonManagedReference
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@JsonManagedReference
	public TipoTelefone getTipotelefone() {
		return tipotelefone;
	}
	public void setTipotelefone(TipoTelefone tipotelefone) {
		this.tipotelefone = tipotelefone;
	}
	@JsonManagedReference
	public Long getNumero() {
		return numero;
	}
	
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((tipotelefone == null) ? 0 : tipotelefone.hashCode());
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
		Telefone other = (Telefone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (tipotelefone == null) {
			if (other.tipotelefone != null)
				return false;
		} else if (!tipotelefone.equals(other.tipotelefone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", tipotelefone=" + tipotelefone + ", numero=" + numero + "]";
	}

	public Telefone() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Telefone(Long id, TipoTelefone tipotelefone, Long numero) {
		super();
		this.id = id;
		this.tipotelefone = tipotelefone;
		this.numero = numero;
	}
	
	

	
	
	

}
