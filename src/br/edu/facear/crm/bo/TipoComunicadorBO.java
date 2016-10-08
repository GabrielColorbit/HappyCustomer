package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.TipoComunicadorDAO;
import br.edu.facear.crm.entity.TipoComunicador;
import br.edu.facear.crm.entity.TipoUsuario;

public class TipoComunicadorBO implements InterfaceBO<TipoComunicador> {
	TipoComunicadorDAO tcdao = new TipoComunicadorDAO();
	@Override
	public void Cadastrar(TipoComunicador o) throws Exception {
		if(o.getNome() == null){
			throw new Exception("Nome do tipo de comunicador � inv�lido");
		}
		tcdao.Cadastrar(o);		
	}

	@Override
	public List<TipoComunicador> Listar() throws Exception {
		List<TipoComunicador> tc= tcdao.Listar();
		if(tc == null){
			throw new Exception("Nenhuma tipo de comunicador cadastrado");
		}
		return tc;
	}

	@Override
	public void Alterar(TipoComunicador o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Nome do tipo de comunicador � inv�lido");
		}
		tcdao.Alterar(o);			
	}

	@Override
	public TipoComunicador BuscarID(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Tipo de comunicador pesquisado � Inv�lido");
		}
		else if(id <= 0) {
			throw new Exception("Tipo de comunicador Pesquisado � Inv�lido");
		}
		
		return tcdao.BuscarID(id);
	}

	@Override
	public void Excluir(TipoComunicador o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Tipo de comunicador selecionado � inv�lido.");
		}		
		tcdao.Excluir(o);			
	}

}
