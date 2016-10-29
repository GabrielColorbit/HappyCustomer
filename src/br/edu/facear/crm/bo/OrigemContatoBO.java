package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.OrigemContatoDAO;
import br.edu.facear.crm.entity.OrigemContato;

public class OrigemContatoBO implements InterfaceBO<OrigemContato>{
	OrigemContatoDAO ocdao = new OrigemContatoDAO();
	
	@Override
	public void Cadastrar(OrigemContato origemcontato) throws Exception {
		if(origemcontato.getNome() == null){
			throw new Exception("Nome � inv�lido");
		}
		ocdao.Cadastrar(origemcontato);		
	}

	@Override
	public List<OrigemContato> Listar() throws Exception {
		List<OrigemContato> listaorigemcontato = ocdao.Listar();
		if(listaorigemcontato == null){
			throw new Exception("Nenhuma origem de contato cadastrada");
		}
		return listaorigemcontato;
	}

	@Override
	public void Alterar(OrigemContato origemcontato) throws Exception {
		if(origemcontato.getNome() == null) {
			throw new Exception("Descri��o � Invalida");
		}
		ocdao.Alterar(origemcontato);			
	}

	@Override
	public OrigemContato BuscarID(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Origem de Contato pesquisado � Inv�lido");
		}
		else if(id <= 0) {
			throw new Exception("Origem de Contato Pesquisado � Inv�lido");
		}
		
		return ocdao.BuscarID(id);
	}

	@Override
	public void Excluir(OrigemContato origemcontato) throws Exception {
		if(origemcontato.getNome() == null) {
			throw new Exception("Origem de Contato Selecionado � inv�lido.");
		}		
		ocdao.Excluir(origemcontato);			
	}

}
