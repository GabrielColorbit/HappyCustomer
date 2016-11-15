package br.edu.facear.crm.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.ForeignKey;
@XmlRootElement
//CRIA TABELA
@Entity
@Table(name="\"TB_ATIVIDADE\"")
public class Atividade {

	// CHAVE PRIMARIA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // CRIA O ID COMO AUTO-INCREMENT
	private Long id;
	
	// CHAVE(S) ESTRANGEIRA(S)
	
	@ManyToOne
	@ForeignKey(name="fk_usuario")
	private Usuario usuarioresponsavel;
	
	@ManyToOne
	@ForeignKey(name="fk_contato")
	private Contato contato;
	
	@ManyToOne
	@ForeignKey(name="fk_empresa")
	private Empresa empresa;
	
	@ManyToOne
	@ForeignKey(name="fk_tipoatividade")
	private TipoAtividade tipoatividade;
	
	// RELACIONAMENTOS MUITOS PRA MUITOS
	
	// COMUNICADORES
	@OneToMany
	@JoinTable(name = "\"TB_COMUNICADOR_ATIVIDADE\"", joinColumns = {
	@JoinColumn(name = "id_atividade") }, inverseJoinColumns = {
	@JoinColumn(name = "id_comunicador") })
	private List<Comunicador> comunicadores_atividade;
	
	// ATRIBUTOS
	private String nome;
	private Date datacadastro;
	private Date datainicio;
	private Date datafim;
	private String descricao;
	private Situacao situacao;
	
	
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
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
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
	public List<Comunicador> getComunicadores_atividade() {
		return comunicadores_atividade;
	}
	public void setComunicadores_atividade(List<Comunicador> comunicadores_atividade) {
		this.comunicadores_atividade = comunicadores_atividade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDatacadastro() {
		return datacadastro;
	}
	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
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
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	@Override  
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comunicadores_atividade == null) ? 0 : comunicadores_atividade.hashCode());
		result = prime * result + ((contato == null) ? 0 : contato.hashCode());
		result = prime * result + ((datacadastro == null) ? 0 : datacadastro.hashCode());
		result = prime * result + ((datafim == null) ? 0 : datafim.hashCode());
		result = prime * result + ((datainicio == null) ? 0 : datainicio.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
		result = prime * result + ((tipoatividade == null) ? 0 : tipoatividade.hashCode());
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
		Atividade other = (Atividade) obj;
		if (comunicadores_atividade == null) {
			if (other.comunicadores_atividade != null)
				return false;
		} else if (!comunicadores_atividade.equals(other.comunicadores_atividade))
			return false;
		if (contato == null) {
			if (other.contato != null)
				return false;
		} else if (!contato.equals(other.contato))
			return false;
		if (datacadastro == null) {
			if (other.datacadastro != null)
				return false;
		} else if (!datacadastro.equals(other.datacadastro))
			return false;
		if (datafim == null) {
			if (other.datafim != null)
				return false;
		} else if (!datafim.equals(other.datafim))
			return false;
		if (datainicio == null) {
			if (other.datainicio != null)
				return false;
		} else if (!datainicio.equals(other.datainicio))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
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
		if (situacao != other.situacao)
			return false;
		if (tipoatividade == null) {
			if (other.tipoatividade != null)
				return false;
		} else if (!tipoatividade.equals(other.tipoatividade))
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
		final int maxLen = 10;
		return "Atividade [id=" + id + ", usuarioresponsavel=" + usuarioresponsavel + ", contato=" + contato
				+ ", empresa=" + empresa + ", tipoatividade=" + tipoatividade + ", comunicadores_atividade="
				+ (comunicadores_atividade != null
						? comunicadores_atividade.subList(0, Math.min(comunicadores_atividade.size(), maxLen)) : null)
				+ ", nome=" + nome + ", datacadastro=" + datacadastro + ", datainicio=" + datainicio + ", datafim="
				+ datafim + ", descricao=" + descricao + ", situacao=" + situacao + "]";
	}
	/**
	 * @param id
	 * @param usuarioresponsavel
	 * @param contato
	 * @param empresa
	 * @param tipoatividade
	 * @param comunicadores_atividade
	 * @param nome
	 * @param datacadastro
	 * @param datainicio
	 * @param datafim
	 * @param descricao
	 * @param situacao
	 */
	public Atividade(Long id, Usuario usuarioresponsavel, Contato contato, Empresa empresa, TipoAtividade tipoatividade,
			List<Comunicador> comunicadores_atividade, String nome, Date datacadastro, Date datainicio, Date datafim,
			String descricao, Situacao situacao) {
		super();
		this.id = id;
		this.usuarioresponsavel = usuarioresponsavel;
		this.contato = contato;
		this.empresa = empresa;
		this.tipoatividade = tipoatividade;
		this.comunicadores_atividade = comunicadores_atividade;
		this.nome = nome;
		this.datacadastro = datacadastro;
		this.datainicio = datainicio;
		this.datafim = datafim;
		this.descricao = descricao;
		this.situacao = situacao;
	}
	/**
	 * 
	 */
	public Atividade() {
		super();
		// TODO Auto-generated constructor stub
	}
}