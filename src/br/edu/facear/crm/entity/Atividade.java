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
@Table(name="\"Atividade\"")
public class Atividade {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@ForeignKey(name="fk_usuario")
	private Usuario usuario;
	@ManyToOne
	@ForeignKey(name="fk_empresa")
	private Empresa empresa;
	@ManyToOne
	@ForeignKey(name="fk_tipoatividade")	
	private TipoAtividade tipoatividade;
	@ManyToOne
	@ForeignKey(name="fk_tipocomunicador")
	private TipoComunicador tipocomunicador;
	@ManyToOne
	@ForeignKey(name="fk_contato")
	private Contato contato;
	private StatusAtividade status;
	private String nome;
	private Date datainicio;
	private Date datafim;
	private String descricao;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public TipoAtividade getTipoatividade() {
		return tipoatividade;
	}
	public void setTipoatividade(TipoAtividade tipoatividade) {
		this.tipoatividade = tipoatividade;
	}
	public TipoComunicador getTipocomunicador() {
		return tipocomunicador;
	}
	public void setTipocomunicador(TipoComunicador tipocomunicador) {
		this.tipocomunicador = tipocomunicador;
	}
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	public StatusAtividade getStatus() {
		return status;
	}
	public void setStatus(StatusAtividade status) {
		this.status = status;
	}
	public Date getDatainicio() {
		return datainicio;
	}
	public void setDatainicio(Date datainicio) {
		this.datainicio = datainicio;
	}
	public Date getDatafim() {
		return datafim;
	}
	public void setDatafim(Date datafim) {
		this.datafim = datafim;
	}
	
	
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Atividade [id=" + id + ", usuario=" + usuario + ", empresa=" + empresa + ", tipoatividade="
				+ tipoatividade + ", tipocomunicador=" + tipocomunicador + ", contato=" + contato + ", status=" + status
				+ ", nome=" + nome + ", datainicio=" + datainicio + ", datafim=" + datafim + ", descricao=" + descricao
				+ "]";
	}
	public Atividade() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
