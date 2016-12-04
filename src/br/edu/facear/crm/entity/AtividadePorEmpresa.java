package br.edu.facear.crm.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AtividadePorEmpresa {

	private Long numeroatividade;
	private String mes;
	private Double media;
	public Long getNumeroatividade() {
		return numeroatividade;
	}
	public void setNumeroatividade(Long numeroatividade) {
		this.numeroatividade = numeroatividade;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public Double getMedia() {
		return media;
	}
	public void setMedia(Double media) {
		this.media = media;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((media == null) ? 0 : media.hashCode());
		result = prime * result + ((mes == null) ? 0 : mes.hashCode());
		result = prime * result + ((numeroatividade == null) ? 0 : numeroatividade.hashCode());
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
		AtividadePorEmpresa other = (AtividadePorEmpresa) obj;
		if (media == null) {
			if (other.media != null)
				return false;
		} else if (!media.equals(other.media))
			return false;
		if (mes == null) {
			if (other.mes != null)
				return false;
		} else if (!mes.equals(other.mes))
			return false;
		if (numeroatividade == null) {
			if (other.numeroatividade != null)
				return false;
		} else if (!numeroatividade.equals(other.numeroatividade))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AtividadePorEmpresa [numeroatividade=" + numeroatividade + ", mes=" + mes + ", media=" + media + "]";
	}
	public AtividadePorEmpresa(Long numeroatividade, String mes, Double media) {
		super();
		this.numeroatividade = numeroatividade;
		this.mes = mes;
		this.media = media;
	}
	public AtividadePorEmpresa() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}