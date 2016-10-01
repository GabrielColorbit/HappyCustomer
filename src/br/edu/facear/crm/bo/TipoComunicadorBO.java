package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.TipoComunicadorDAO;
import br.edu.facear.crm.entity.TipoComunicador;
import br.edu.facear.crm.entity.TipoUsuario;

public class TipoComunicadorBO implements InterfaceBO<TipoComunicador> {
	TipoComunicadorDAO tcdao = new TipoComunicadorDAO();
	@Override
	public void salvar(TipoComunicador o) throws Exception {
		if(o.getNome() == null){
			throw new Exception("Nome do tipo de comunicador é inválido");
		}
		tcdao.salvar(o);		
	}

	@Override
	public List<TipoComunicador> listar() throws Exception {
		List<TipoComunicador> tc= tcdao.listar();
		if(tc == null){
			throw new Exception("Nenhuma tipo de comunicador cadastrado");
		}
		return tc;
	}

	@Override
	public void editar(TipoComunicador o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Nome do tipo de comunicador é inválido");
		}
		tcdao.editar(o);			
	}

	@Override
	public TipoComunicador getObjectById(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Tipo de comunicador pesquisado é Inválido");
		}
		else if(id <= 0) {
			throw new Exception("Tipo de comunicador Pesquisado é Inválido");
		}
		
		return tcdao.getObjectById(id);
	}

	@Override
	public void excluir(TipoComunicador o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Tipo de comunicador selecionado é inválido.");
		}		
		tcdao.excluir(o);			
	}

}
