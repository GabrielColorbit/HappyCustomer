package br.edu.facear.crm.entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
// CRIA TABELA
@Entity
@Table(name = "\"TB_FOTO\"")
public class Foto {

	// CHAVE PRIMÁRIA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // CRIA O ID COMO AUTO-INCREMENT
	private Long id;
	private byte[] imagem;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public byte[] getImagem() {
		return imagem;
	}
	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Arrays.hashCode(imagem);
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
		Foto other = (Foto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (!Arrays.equals(imagem, other.imagem))
			return false;
		return true;
	}
	public Foto(Long id, byte[] imagem) {
		super();
		this.id = id;
		this.imagem = imagem;
	}
	public Foto() {
		super();
		// TODO Auto-generated constructor stub
	}
}