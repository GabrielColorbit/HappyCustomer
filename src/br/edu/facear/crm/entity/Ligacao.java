package br.edu.facear.crm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.ForeignKey;

@XmlRootElement
//CRIA TABELA
@Entity
@Table(name="\"TB_LIGACAO\"")

public class Ligacao {
	
	// CHAVE PRIMARIA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // CRIA O ID COMO AUTO-INCREMENT
	private Long id;
	
	// CHAVES ESTRANGEIRAS
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
	@ForeignKey(name="fk_telefone")
	private Telefone telefone;
	
	@ManyToOne
	@ForeignKey(name="fk_atividade")
	private Atividade atividade;
	
	// ATRIBUTOS
	private String data;
	private String duracao;
	private TipoLigacao tipoligacao;
	private String resumo;
	
	
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
	public Telefone getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	public Atividade getAtividade() {
		return atividade;
	}
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atividade == null) ? 0 : atividade.hashCode());
		result = prime * result + ((contato == null) ? 0 : contato.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((duracao == null) ? 0 : duracao.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((resumo == null) ? 0 : resumo.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result + ((tipoligacao == null) ? 0 : tipoligacao.hashCode());
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
		Ligacao other = (Ligacao) obj;
		if (atividade == null) {
			if (other.atividade != null)
				return false;
		} else if (!atividade.equals(other.atividade))
			return false;
		if (contato == null) {
			if (other.contato != null)
				return false;
		} else if (!contato.equals(other.contato))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (duracao == null) {
			if (other.duracao != null)
				return false;
		} else if (!duracao.equals(other.duracao))
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
		if (resumo == null) {
			if (other.resumo != null)
				return false;
		} else if (!resumo.equals(other.resumo))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (tipoligacao != other.tipoligacao)
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
		return "Ligacao [id=" + id + ", usuarioresponsavel=" + usuarioresponsavel + ", contato=" + contato
				+ ", empresa=" + empresa + ", telefone=" + telefone + ", atividade=" + atividade + ", data=" + data
				+ ", duracao=" + duracao + ", tipoligacao=" + tipoligacao + ", resumo=" + resumo + "]";
	}
	/**
	 * @param id
	 * @param usuarioresponsavel
	 * @param contato
	 * @param empresa
	 * @param telefone
	 * @param atividade
	 * @param data
	 * @param duracao
	 * @param tipoligacao
	 * @param resumo
	 */
	public Ligacao(Long id, Usuario usuarioresponsavel, Contato contato, Empresa empresa, Telefone telefone,
			Atividade atividade, String data, String duracao, TipoLigacao tipoligacao, String resumo) {
		super();
		this.id = id;
		this.usuarioresponsavel = usuarioresponsavel;
		this.contato = contato;
		this.empresa = empresa;
		this.telefone = telefone;
		this.atividade = atividade;
		this.data = data;
		this.duracao = duracao;
		this.tipoligacao = tipoligacao;
		this.resumo = resumo;
	}
	/**
	 * 
	 */
	public Ligacao() {
		super();
		// TODO Auto-generated constructor stub
	}
}