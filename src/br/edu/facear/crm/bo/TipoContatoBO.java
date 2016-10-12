package br.edu.facear.crm.bo;

import java.util.ArrayList;

import br.edu.facear.crm.dao.TipoContatoDAO;
import br.edu.facear.crm.entity.TipoContato;

public class TipoContatoBO implements InterfaceBO<TipoContato>{
	TipoContatoDAO tcdao = new TipoContatoDAO();
	@Override
	public void Cadastrar(TipoContato o) throws Exception {
		if(o.getNome() == null){
			throw new Exception("Nome do tipo de contato � inv�lido");
		}
		tcdao.Cadastrar(o);
	}

	@Override
	public ArrayList<TipoContato> Listar() throws Exception {
		ArrayList<TipoContato> tc = tcdao.Listar();
		if(tc == null){
			throw new Exception("Nenhuma tipo de contato cadastrado");
		}
		return tc;
	}

	@Override
	public void Alterar(TipoContato o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Nome do tipo de contato � inv�lido");
		}
		tcdao.Alterar(o);			
	}

	@Override
	public TipoContato BuscarID(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Tipo de contato pesquisado � Inv�lido");
		}
		else if(id <= 0) {
			throw new Exception("Tipo de contato Pesquisado � Inv�lido");
		}
		
		return tcdao.BuscarID(id);
	}

	@Override
	public void Excluir(TipoContato o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Tipo de contato selecionado � inv�lido.");
		}		
		tcdao.Excluir(o);		
	}
}