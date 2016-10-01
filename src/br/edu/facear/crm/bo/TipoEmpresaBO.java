package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.TipoEmpresaDAO;
import br.edu.facear.crm.entity.TipoEmpresa;

public class TipoEmpresaBO implements InterfaceBO<TipoEmpresa>{
	TipoEmpresaDAO tedao = new TipoEmpresaDAO();

	@Override
	public void salvar(TipoEmpresa tipoempresa) throws Exception {
		if(tipoempresa.getNome() == null){
			throw new Exception("Nome do tipo de empresa � inv�lido");
		}
		tedao.salvar(tipoempresa);
				
	}

	@Override
	public List<TipoEmpresa> listar() throws Exception {
		List<TipoEmpresa> tipoempresa= tedao.listar();
		if(tipoempresa == null){
			throw new Exception("Nenhumm tipo de empresa cadastrado");
		}
		return tipoempresa;
	}

	@Override
	public void editar(TipoEmpresa tipoempresa) throws Exception {
		if(tipoempresa.getNome() == null) {
			throw new Exception("Nome de tipo de empresa � Invalido");
		}
		tedao.editar(tipoempresa);				
	}

	@Override
	public TipoEmpresa getObjectById(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Tipo de Empresa pesquisado � Inv�lido");
		}
		else if(id <= 0) {
			throw new Exception("Tipo Telefone Pesquisado � Inv�lido");
		}
		
		return tedao.getObjectById(id);
	}

	@Override
	public void excluir(TipoEmpresa tipoempresa) throws Exception {
		if(tipoempresa.getNome() == null) {
			throw new Exception("Tipo de Empresa Selecionada � inv�lido.");
		}		
		tedao.excluir(tipoempresa);			
	}

}
