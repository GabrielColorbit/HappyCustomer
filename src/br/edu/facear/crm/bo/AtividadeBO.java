package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.AtividadeDAO;
import br.edu.facear.crm.entity.Atividade;
import br.edu.facear.crm.entity.Empresa;

public class AtividadeBO implements InterfaceBO<Atividade>{
	AtividadeDAO adao =  new AtividadeDAO();
	@Override
	public void salvar(Atividade o) throws Exception {
		if(o.getUsuario() == null ||
		   o.getEmpresa() == null ||
   		   o.getTipoatividade() == null ||
    	   o.getContato() == null ||
		   o.getNome() == null ||
		   o.getTipocomunicador() == null ||
		   o.getStatus() == null ||
		   o.getDatainicio() == null ||
		   o.getDatafim() == null ||
		   o.getDescricao() == null ){
				throw new Exception("Preencher todos os campos da atividade");
			}
		
			adao.salvar(o);		
	}

	@Override
	public List<Atividade> listar() throws Exception {
		List<Atividade> a = adao.listar();
		if(a == null){
			throw new Exception("Nenhuma Atividade cadastrada");
		}
		return a;
	}

	@Override
	public void editar(Atividade o) throws Exception {
		if(o.getUsuario() == null ||
		   o.getEmpresa() == null ||
		   o.getTipoatividade() == null ||
		   o.getContato() == null ||
		   o.getNome() == null ||
		   o.getTipocomunicador() == null ||
		   o.getStatus() == null ||
		   o.getDatainicio() == null ||
		   o.getDatafim() == null ||
		   o.getDescricao() == null ){
				throw new Exception("Preencher todos os campos da atividade");
			}
		
			adao.editar(o);	
	}

	@Override
	public Atividade getObjectById(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Atividade pesquisada é inválida");
		}
		else if(id <= 0) {
			throw new Exception("Atividade pesquisado é inválida");
		}
		return adao.getObjectById(id);
	}

	@Override
	public void excluir(Atividade o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Atividade Selecionada é inválida.");
		}		
		adao.excluir(o);			
	}

}
