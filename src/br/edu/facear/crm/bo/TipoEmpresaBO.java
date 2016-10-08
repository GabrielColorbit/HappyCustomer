package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.TipoEmpresaDAO;
import br.edu.facear.crm.entity.TipoEmpresa;

public class TipoEmpresaBO implements InterfaceBO<TipoEmpresa>{
	TipoEmpresaDAO tedao = new TipoEmpresaDAO();

	@Override
	public void Cadastrar(TipoEmpresa tipoempresa) throws Exception {
		if(tipoempresa.getNome() == null){
			throw new Exception("Nome do tipo de empresa � inv�lido");
		}
		tedao.Cadastrar(tipoempresa);
				
	}

	@Override
	public List<TipoEmpresa> Listar() throws Exception {
		List<TipoEmpresa> tipoempresa= tedao.Listar();
		if(tipoempresa == null){
			throw new Exception("Nenhumm tipo de empresa cadastrado");
		}
		return tipoempresa;
	}

	@Override
	public void Alterar(TipoEmpresa tipoempresa) throws Exception {
		if(tipoempresa.getNome() == null) {
			throw new Exception("Nome de tipo de empresa � Invalido");
		}
		tedao.Alterar(tipoempresa);				
	}

	@Override
	public TipoEmpresa BuscarID(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Tipo de Empresa pesquisado � Inv�lido");
		}
		else if(id <= 0) {
			throw new Exception("Tipo Telefone Pesquisado � Inv�lido");
		}
		
		return tedao.BuscarID(id);
	}

	@Override
	public void Excluir(TipoEmpresa tipoempresa) throws Exception {
		if(tipoempresa.getNome() == null) {
			throw new Exception("Tipo de Empresa Selecionada � inv�lido.");
		}		
		tedao.Excluir(tipoempresa);			
	}

}
