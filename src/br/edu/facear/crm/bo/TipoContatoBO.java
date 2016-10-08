package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.TipoContatoDAO;
import br.edu.facear.crm.entity.TipoContato;
import br.edu.facear.crm.entity.TipoUsuario;

public class TipoContatoBO implements InterfaceBO<TipoContato>{
	TipoContatoDAO tcdao = new TipoContatoDAO();
	@Override
	public void Cadastrar(TipoContato o) throws Exception {
		if(o.getNome() == null){
			throw new Exception("Nome do tipo de contato é inválido");
		}
		tcdao.Cadastrar(o);		
	}

	@Override
	public List<TipoContato> Listar() throws Exception {
		List<TipoContato> tc = tcdao.Listar();
		if(tc == null){
			throw new Exception("Nenhuma tipo de contato cadastrado");
		}
		return tc;
	}

	@Override
	public void Alterar(TipoContato o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Nome do tipo de contato é inválido");
		}
		tcdao.Alterar(o);			
	}

	@Override
	public TipoContato BuscarID(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Tipo de contato pesquisado é Inválido");
		}
		else if(id <= 0) {
			throw new Exception("Tipo de contato Pesquisado é Inválido");
		}
		
		return tcdao.BuscarID(id);
	}

	@Override
	public void Excluir(TipoContato o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Tipo de contato selecionado é inválido.");
		}		
		tcdao.Excluir(o);		
	}

}
