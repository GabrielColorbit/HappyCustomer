package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.AtividadeDAO;
import br.edu.facear.crm.entity.Atividade;
import br.edu.facear.crm.entity.Empresa;

public class AtividadeBO implements InterfaceBO<Atividade>{
	AtividadeDAO adao =  new AtividadeDAO();
	@Override
	public void Cadastrar(Atividade atividade) throws Exception {
		if(atividade.getUsuario() == null) {
			throw new Exception("Selecione um Usu�rio");
		}else if(atividade.getEmpresa() ==  null){
			throw new Exception("Selecione uma Empresa.");
		}
		else if(atividade.getTipoatividade() ==  null){
			throw new Exception("Selecione uma Atividade.");
		}
		else if(atividade.getTipocomunicador() ==  null){
			throw new Exception("Selecione um Comunicador.");
		}else if(atividade.getContato() ==  null){
			throw new Exception("Selecione uma Contato.");
		}
		else if(atividade.getStatus() ==  null){
			throw new Exception("Selecione um Status.");
		}
		else if(atividade.getNome() ==  null){
			throw new Exception("Nome da atividade Invalido.");
		}else if(atividade.getDatainicio() ==  null){
			throw new Exception("Data Invalida.");
		}
		else if(atividade.getDatafim() ==  null){
			throw new Exception("Data Invalida.");
		}else if(atividade.getDescricao() ==  null){
			throw new Exception("Nome da Descri��o Invalida.");
		}
		
		
			adao.Cadastrar(atividade);		
	}
	

	@Override
	public List<Atividade> Listar() throws Exception {
		List<Atividade> a = adao.Listar();
		if(a == null){
			throw new Exception("Nenhuma Atividade cadastrada");
		}
		return a;
	}

	@Override
	public void Alterar(Atividade atividade) throws Exception {
		
		if(atividade.getUsuario() == null) {
			throw new Exception("Selecione um Usu�rio");
		}else if(atividade.getEmpresa() ==  null){
			throw new Exception("Selecione uma Empresa.");
		}
		else if(atividade.getTipoatividade() ==  null){
			throw new Exception("Selecione uma Atividade.");
		}
		else if(atividade.getTipocomunicador() ==  null){
			throw new Exception("Selecione um Comunicador.");
		}else if(atividade.getContato() ==  null){
			throw new Exception("Selecione uma Contato.");
		}
		else if(atividade.getStatus() ==  null){
			throw new Exception("Selecione um Status.");
		}
		else if(atividade.getNome() ==  null){
			throw new Exception("Nome da atividade Invalido.");
		}else if(atividade.getDatainicio() ==  null){
			throw new Exception("Data Invalida.");
		}
		else if(atividade.getDatafim() ==  null){
			throw new Exception("Data Invalida.");
		}else if(atividade.getDescricao() ==  null){
			throw new Exception("Nome da Descri��o Invalida.");
		}
		
			adao.Alterar(atividade);	
	}

	@Override
	public Atividade BuscarID(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Atividade pesquisada � inv�lida");
		}
		else if(id <= 0) {
			throw new Exception("Atividade pesquisado � inv�lida");
		}
		return adao.BuscarID(id);
	}

	@Override
	public void Excluir(Atividade o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Atividade Selecionada � inv�lida.");
		}		
		adao.Excluir(o);			
	}

}
