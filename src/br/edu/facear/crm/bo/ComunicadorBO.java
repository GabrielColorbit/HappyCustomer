package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.ComunicadorDAO;
import br.edu.facear.crm.entity.Comunicador;

public class ComunicadorBO implements InterfaceBO<Comunicador> {
	ComunicadorDAO tcdao = new ComunicadorDAO();
	@Override
	public void Cadastrar(Comunicador o) throws Exception {
		if(o.getNome() == null){
			throw new Exception("Nome do comunicador é inválido");
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
			throw new Exception("Nome do comunicador é inválido");
		}
		tcdao.Alterar(o);			
	}

	@Override
	public Comunicador BuscarID(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Comunicador pesquisado é Inválido");
		}
		else if(id <= 0) {
			throw new Exception("Comunicador Pesquisado é Inválido");
		}
		
		return tcdao.BuscarID(id);
	}

	@Override
	public void Excluir(Comunicador o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Comunicador selecionado é inválido.");
		}		
		tcdao.Excluir(o);			
	}

}
