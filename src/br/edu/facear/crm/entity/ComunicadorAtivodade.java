package br.edu.facear.crm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="\"ComunicadorAtividade\"")
public class ComunicadorAtivodade {

	@Id
	private Long id;
	@ManyToOne
	@ForeignKey(name = "fk_atividade")	
	private Atividade atividade;
	@ManyToOne
	@ForeignKey(name = "fk_produto")	
	private TipoComunicador tipocomunicador;
	private String descricao;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Atividade getAtividade() {
		return atividade;
	}
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
	public TipoComunicador getTipocomunicador() {
		return tipocomunicador;
	}
	public void setTipocomunicador(TipoComunicador tipocomunicador) {
		this.tipocomunicador = tipocomunicador;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public String toString() {
		return "ComunicadorAtivodade [id=" + id + ", atividade=" + atividade + ", tipocomunicador=" + tipocomunicador
				+ ", descricao=" + descricao + "]";
	}
	public ComunicadorAtivodade() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
