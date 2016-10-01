package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.OrigemContatoDAO;
import br.edu.facear.crm.entity.OrigemContato;

public class OrigemContatoBO implements InterfaceBO<OrigemContato>{
	OrigemContatoDAO ocdao = new OrigemContatoDAO();
	
	@Override
	public void salvar(OrigemContato origemcontato) throws Exception {
		if(origemcontato.getDescricao() == null){
			throw new Exception("Descri��o � inv�lida");
		}
		ocdao.salvar(origemcontato);		
	}

	@Override
	public List<OrigemContato> listar() throws Exception {
		List<OrigemContato> listaorigemcontato = ocdao.listar();
		if(listaorigemcontato == null){
			throw new Exception("Nenhuma origem de contato cadastrada");
		}
		return listaorigemcontato;
	}

	@Override
	public void editar(OrigemContato origemcontato) throws Exception {
		if(origemcontato.getDescricao() == null) {
			throw new Exception("Descri��o � Invalida");
		}
		ocdao.editar(origemcontato);			
	}

	@Override
	public OrigemContato getObjectById(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Origem de Contato pesquisado � Inv�lido");
		}
		else if(id <= 0) {
			throw new Exception("Origem de Contato Pesquisado � Inv�lido");
		}
		
		return ocdao.getObjectById(id);
	}

	@Override
	public void excluir(OrigemContato origemcontato) throws Exception {
		if(origemcontato.getDescricao() == null) {
			throw new Exception("Origem de Contato Selecionado � inv�lido.");
		}		
		ocdao.excluir(origemcontato);			
	}

}
