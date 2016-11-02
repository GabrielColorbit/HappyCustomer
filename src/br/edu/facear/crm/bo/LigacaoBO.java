package br.edu.facear.crm.bo;

import java.util.Date;
import java.util.List;

import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

import br.edu.facear.crm.dao.LigacaoDAO;
import br.edu.facear.crm.entity.Atividade;
import br.edu.facear.crm.entity.Contato;
import br.edu.facear.crm.entity.Empresa;
import br.edu.facear.crm.entity.Ligacao;
import br.edu.facear.crm.entity.TipoLigacao;
import br.edu.facear.crm.entity.Usuario;

public class LigacaoBO implements InterfaceBO<Ligacao>{
	LigacaoDAO ldao =  new LigacaoDAO();
	@Override
	public void Cadastrar(Ligacao ligacao) throws Exception {
	
		if(ligacao.getContato() == null) {
			throw new Exception("Selecione um Contato");
		}		
		else if(ligacao.getAtividade() ==  null){
			throw new Exception("Selecione uma Atividade.");
		}
		else if(ligacao.getUsuario() ==  null){
			throw new Exception("Selecione um Usuario.");
		}
		else if(ligacao.getEmpresa() ==  null){
			throw new Exception("Selecione uma Empresa.");
		}
		else if(ligacao.getDuracao() ==  null){
			throw new Exception("Duracao Informada Invalida");
		}
		else if(ligacao.getData() ==  null){
			throw new Exception("Data Informada Invalida");
		}
		else if(ligacao.getTipoligacao() ==  null){
			throw new Exception("Selecione um Tipo de Ligacao");
		}
		else if(ligacao.getResumo() ==  null){
			throw new Exception("Resumo Informado Invalido");
		}
		
		
		
			ldao.Cadastrar(ligacao);						
				}

	@Override
	public List<Ligacao> Listar() throws Exception {
		List<Ligacao> l = ldao.Listar();
		if(l == null){
			throw new Exception("Nenhuma ligacão cadastrada");
		}
		return l;
	}

	@Override
	public void Alterar(Ligacao ligacao) throws Exception {
	
		
		if(ligacao.getContato() == null) {
			throw new Exception("Selecione um Contato");
		}		
		else if(ligacao.getAtividade() ==  null){
			throw new Exception("Selecione uma Atividade.");
		}
		else if(ligacao.getUsuario() ==  null){
			throw new Exception("Selecione um Usuario.");
		}
		else if(ligacao.getEmpresa() ==  null){
			throw new Exception("Selecione uma Empresa.");
		}
		else if(ligacao.getDuracao() ==  null){
			throw new Exception("Duracao Informada Invalida");
		}
		else if(ligacao.getData() ==  null){
			throw new Exception("Data Informada Invalida");
		}
		else if(ligacao.getTipoligacao() ==  null){
			throw new Exception("Selecione um Tipo de Ligacao");
		}
		else if(ligacao.getResumo() ==  null){
			throw new Exception("Resumo Informado Invalido");
		}
		
			ldao.Alterar(ligacao);				
	}

	@Override
	public Ligacao BuscarID(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Ligacao pesquisada é inválida");
		}
		else if(id <= 0) {
			throw new Exception("Ligacao pesquisado é inválida");
		}
		return ldao.BuscarID(id);
	}

	@Override
	public void Excluir(Ligacao o) throws Exception {
		if(o == null) {
			throw new Exception("Ligacao Selecionada é inválida.");
		}		
		ldao.Excluir(o);		
	}

}
