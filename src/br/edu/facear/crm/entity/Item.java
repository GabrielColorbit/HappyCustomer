package br.edu.facear.crm.entity;

import javax.persistence.*;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="\"TB_ITEM\"")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	@ManyToOne
	@ForeignKey(name = "fk_produto")	
	private Produto produto;
	@ManyToOne
	@ForeignKey(name = "fk_negocio")		
	private Negocio negocio;
	private Long quantidade;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Negocio getNegocio() {
		return negocio;
	}
	public void setNegocio(Negocio negocio) {
		this.negocio = negocio;
	}
	public Long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", produto=" + produto + ", negocio=" + negocio + ", quantidade=" + quantidade + "]";
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
