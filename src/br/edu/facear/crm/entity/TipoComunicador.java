package br.edu.facear.crm.entity;

import javax.persistence.*;

@Entity
@Table(name="\"TipoComunicador\"")
public class TipoComunicador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
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
	@Override
	public String toString() {
		return "TipoComunicador [id=" + id + ", nome=" + nome + "]";
	}
	public TipoComunicador() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
