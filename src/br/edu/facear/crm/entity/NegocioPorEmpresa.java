package br.edu.facear.crm.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NegocioPorEmpresa {
	private String empresa;
	private String foto;
	private Long negocios;
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
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
		return "NegocioPorEmpresa [empresa=" + empresa + ", foto=" + foto + ", negocios=" + negocios + "]";
	}
	
	
	
	
		
}
