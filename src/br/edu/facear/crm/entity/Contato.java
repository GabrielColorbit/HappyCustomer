package br.edu.facear.crm.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "\"TB_CONTATO\"")
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@ForeignKey(name = "fk_tipocontato")
	private TipoContato tipocontato;
	@ManyToOne
	@ForeignKey(name = "fk_origemcontato")
	private OrigemContato origemcontato;
	@ManyToOne
	@ForeignKey(name = "fk_usuarioresponsavel")
	private Usuario usuarioresponsavel;
	@ManyToOne
	@ForeignKey(name = "fk_cidade")
	private Cidade cidade;
	@ManyToOne
	@ForeignKey(name = "fk_tipocomunicador")
	private TipoComunicador tipocomunicador;
	
	@ManyToMany(mappedBy = "contatos")
	
	private List<Empresa> empresas;
	
	private String nome;
	private String email;	
	private String cpf;
	private String foto;
	private Genero genero;
	private String cargo;
	private Date datanascimento;
	private String endereco;
	private Long numero;
	private Long cep;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TipoContato getTipocontato() {
		return tipocontato;
	}
	public void setTipocontato(TipoContato tipocontato) {
		this.tipocontato = tipocontato;
	}
	public OrigemContato getOrigemcontato() {
		return origemcontato;
	}
	public void setOrigemcontato(OrigemContato origemcontato) {
		this.origemcontato = origemcontato;
	}
	public Usuario getUsuarioresponsavel() {
		return usuarioresponsavel;
	}
	public void setUsuarioresponsavel(Usuario usuarioresponsavel) {
		this.usuarioresponsavel = usuarioresponsavel;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public TipoComunicador getTipocomunicador() {
		return tipocomunicador;
	}
	public void setTipocomunicador(TipoComunicador tipocomunicador) {
		this.tipocomunicador = tipocomunicador;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Date getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public Long getCep() {
		return cep;
	}
	public void setCep(Long cep) {
		this.cep = cep;
	}

	
	
	public List<Empresa> getEmpresas() {
		return empresas;
	}
	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}
	
	
	
	@Override
	public String toString() {
		return "Contato [id=" + id + ", tipocontato=" + tipocontato + ", origemcontato=" + origemcontato
				+ ", usuarioresponsavel=" + usuarioresponsavel + ", cidade=" + cidade + ", tipocomunicador="
				+ tipocomunicador + ", empresas=" + empresas + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf
				+ ", foto=" + foto + ", genero=" + genero + ", cargo=" + cargo + ", datanascimento=" + datanascimento
				+ ", endereco=" + endereco + ", numero=" + numero + ", cep=" + cep + "]";
	}
	public Contato() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
}
