package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.ComunicadorDAO;
import br.edu.facear.crm.entity.Comunicador;

public class ComunicadorBO implements InterfaceBO<Comunicador> {
	ComunicadorDAO tcdao = new ComunicadorDAO();
	@Override
	public void Cadastrar(Comunicador o) throws Exception {
		if(o.getNome() == null){
			throw new Exception("Nome do comunicador � inv�lido");
		}
		tcdao.Cadastrar(o);		
	}

	@Override
	public List<Comunicador> Listar() throws Exception {
		List<Comunicador> tc= tcdao.Listar();
		if(tc == null){
			throw new Exception("Nenhum comunicador cadastrado");
		}
		return tc;
	}

	@Override
	public void Alterar(Comunicador o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Nome do comunicador � inv�lido");
		}
		tcdao.Alterar(o);			
	}

	@Override
	public Comunicador BuscarID(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Comunicador pesquisado � Inv�lido");
		}
		else if(id <= 0) {
			throw new Exception("Comunicador Pesquisado � Inv�lido");
		}
		
		return tcdao.BuscarID(id);
	}

	@Override
	public void Excluir(Comunicador o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Comunicador selecionado � inv�lido.");
		}		
		tcdao.Excluir(o);			
	}

}
