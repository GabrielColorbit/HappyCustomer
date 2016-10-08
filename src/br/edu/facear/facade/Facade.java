package br.edu.facear.facade;

import java.util.List;

import br.edu.facear.crm.bo.TipoContatoBO;
import br.edu.facear.crm.entity.Empresa;
import br.edu.facear.crm.entity.TipoContato;

public class Facade {
	TipoContatoBO tipocontatoBO = new TipoContatoBO();
	
	public void cadastrarTipoContato(TipoContato tc) throws Exception{
		tipocontatoBO.Cadastrar(tc);
	}
	public TipoContato buscarTipoContatoPorId(Long l) throws Exception{
		return tipocontatoBO.BuscarID(l);
	}
	public void alterarTipoContato(TipoContato t) throws Exception{
		tipocontatoBO.Alterar(t);
	}
	public List<TipoContato> listarTipoContato() throws Exception {
		return tipocontatoBO.Listar();
	}

}
