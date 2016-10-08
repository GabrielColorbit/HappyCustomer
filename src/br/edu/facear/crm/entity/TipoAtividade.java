package br.edu.facear.crm.entity;

import javax.persistence.*;

@Entity
@Table(name="\"TB_TIPO_ATIVIDADE\"")
public class TipoAtividade {
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
		return "TipoAtividade [id=" + id + ", nome=" + nome + "]";
	}
	public TipoAtividade() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
