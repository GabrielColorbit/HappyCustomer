package br.edu.facear.crm.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NegocioPorContato {
	private String contato;
	private String foto;
	private Long negocios;
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Long getNegocios() {
		return negocios;
	}
	public void setNegocios(Long negocios) {
		this.negocios = negocios;
	}
	@Override
	public String toString() {
		return "NegocioPorContato [contato=" + contato + ", foto=" + foto + ", negocios=" + negocios + "]";
	}
	
	
	
	
		
}
