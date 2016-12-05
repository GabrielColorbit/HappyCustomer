package br.edu.facear.crm.entity;

public class AtividadesPorStatus {
	private Long atividade;
	private String situacao;
	private String cor;
	public Long getAtividade() {
		return atividade;
	}
	public void setAtividade(Long atividade) {
		this.atividade = atividade;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	@Override
	public String toString() {
		return "AtividadesPorStatus [atividade=" + atividade + ", situacao=" + situacao + ", cor=" + cor + "]";
	}
	
	
	
}
