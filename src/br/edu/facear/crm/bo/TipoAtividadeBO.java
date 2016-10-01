package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.TipoAtividadeDAO;
import br.edu.facear.crm.entity.TipoAtividade;
import br.edu.facear.crm.entity.TipoComunicador;

public class TipoAtividadeBO implements InterfaceBO<TipoAtividade>{
	TipoAtividadeDAO tadao = new TipoAtividadeDAO();

	@Override
	public void salvar(TipoAtividade o) throws Exception {
		if(o.getNome() == null){
			throw new Exception("Nome do tipo de atividade é inválido");
		}
		tadao.salvar(o);			
	}

	@Override
	public List<TipoAtividade> listar() throws Exception {
		List<TipoAtividade> ta= tadao.listar();
		if(ta == null){
			throw new Exception("Nenhuma tipo de atividade cadastrado");
		}
		return ta;
	}

	@Override
	public void editar(TipoAtividade o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Nome do tipo de atividade é inválido");
		}
		tadao.editar(o);			
	}

	@Override
	public TipoAtividade getObjectById(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Tipo de atividade pesquisado é inválido");
		}
		else if(id <= 0) {
			throw new Exception("Tipo de atividade Pesquisado é inválido");
		}
		
		return tadao.getObjectById(id);
	}

	@Override
	public void excluir(TipoAtividade o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Tipo de atividade selecionado é inválido.");
		}		
		tadao.excluir(o);			
	}

}
