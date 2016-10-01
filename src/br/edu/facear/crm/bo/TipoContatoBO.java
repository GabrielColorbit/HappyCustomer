package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.TipoContatoDAO;
import br.edu.facear.crm.entity.TipoContato;
import br.edu.facear.crm.entity.TipoUsuario;

public class TipoContatoBO implements InterfaceBO<TipoContato>{
	TipoContatoDAO tcdao = new TipoContatoDAO();
	@Override
	public void salvar(TipoContato o) throws Exception {
		if(o.getNome() == null){
			throw new Exception("Nome do tipo de contato é inválido");
		}
		tcdao.salvar(o);		
	}

	@Override
	public List<TipoContato> listar() throws Exception {
		List<TipoContato> tc = tcdao.listar();
		if(tc == null){
			throw new Exception("Nenhuma tipo de contato cadastrado");
		}
		return tc;
	}

	@Override
	public void editar(TipoContato o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Nome do tipo de contato é inválido");
		}
		tcdao.editar(o);			
	}

	@Override
	public TipoContato getObjectById(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Tipo de contato pesquisado é Inválido");
		}
		else if(id <= 0) {
			throw new Exception("Tipo de contato Pesquisado é Inválido");
		}
		
		return tcdao.getObjectById(id);
	}

	@Override
	public void excluir(TipoContato o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Tipo de contato selecionado é inválido.");
		}		
		tcdao.excluir(o);		
	}

}
