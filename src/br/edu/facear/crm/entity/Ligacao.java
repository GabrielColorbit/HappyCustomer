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
@Table(name="\"Ligacao\"")
public class Ligacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	@ManyToOne
	@ForeignKey(name="fk_contato")
	private Contato contato;	
	@ManyToOne
	@ForeignKey(name="fk_atividade")
	private Atividade atividade;	
	@ManyToOne
	@ForeignKey(name="fk_usuario")
	private Usuario usuario;		
	@ManyToOne
	@ForeignKey(name="fk_empresa")
	private Empresa empresa;

	private String duracao;
	private Date data;
	private TipoLigacao tipoligacao;
	private String resumo;

	@Override
	public String toString() {
		return "Ligacao [id=" + id + ", contato=" + contato + ", atividade=" + atividade + ", usuario=" + usuario
				+ ", empresa=" + empresa + ", duracao=" + duracao + ", data=" + data + ", tipoligacao=" + tipoligacao
				+ ", resumo=" + resumo + "]";
	}

	public Long getId() {
		return id;
	}






	public void setId(Long id) {
		this.id = id;
	}






	public Contato getContato() {
		return contato;
	}






	public void setContato(Contato contato) {
		this.contato = contato;
	}






	public Atividade getAtividade() {
		return atividade;
	}






	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}






	public Usuario getUsuario() {
		return usuario;
	}






	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}






	public Empresa getEmpresa() {
		return empresa;
	}






	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}






	public String getDuracao() {
		return duracao;
	}






	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}






	public Date getData() {
		return data;
	}






	public void setData(Date data) {
		this.data = data;
	}






	public TipoLigacao getTipoligacao() {
		return tipoligacao;
	}






	public void setTipoligacao(TipoLigacao tipoligacao) {
		this.tipoligacao = tipoligacao;
	}






	public String getResumo() {
		return resumo;
	}






	public void setResumo(String resumo) {
		this.resumo = resumo;
	}






	public Ligacao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
