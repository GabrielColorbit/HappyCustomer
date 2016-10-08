package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.TipoAtividadeDAO;
import br.edu.facear.crm.entity.TipoAtividade;
import br.edu.facear.crm.entity.TipoComunicador;

public class TipoAtividadeBO implements InterfaceBO<TipoAtividade>{
	TipoAtividadeDAO tadao = new TipoAtividadeDAO();

	@Override
	public void Cadastrar(TipoAtividade o) throws Exception {
		if(o.getNome() == null){
			throw new Exception("Nome do tipo de atividade é inválido");
		}
		tadao.Cadastrar(o);			
	}

	@Override
	public List<TipoAtividade> Listar() throws Exception {
		List<TipoAtividade> ta= tadao.Listar();
		if(ta == null){
			throw new Exception("Nenhuma tipo de atividade cadastrado");
		}
		return ta;
	}

	@Override
	public void Alterar(TipoAtividade o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Nome do tipo de atividade é inválido");
		}
		tadao.Alterar(o);			
	}

	@Override
	public TipoAtividade BuscarID(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Tipo de atividade pesquisado é inválido");
		}
		else if(id <= 0) {
			throw new Exception("Tipo de atividade Pesquisado é inválido");
		}
		
		return tadao.BuscarID(id);
	}

	@Override
	public void Excluir(TipoAtividade o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Tipo de atividade selecionado é inválido.");
		}		
		tadao.Excluir(o);			
	}

}
