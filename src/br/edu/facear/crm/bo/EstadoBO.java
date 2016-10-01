package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.EstadoDAO;
import br.edu.facear.crm.entity.Estado;
import br.edu.facear.crm.entity.TipoEmpresa;

public class EstadoBO implements InterfaceBO<Estado> {
	EstadoDAO estadoDAO = new EstadoDAO();
	@Override
	public void salvar(Estado estado) throws Exception {
		if(estado.getNome() == null){
			throw new Exception("Nome do estado � inv�lido");
		}
		estadoDAO.salvar(estado);
	}

	@Override
	public List<Estado> listar() throws Exception {
		List<Estado> estadoslist= estadoDAO.listar();
		if(estadoslist == null){
			throw new Exception("Nenhumm estado cadastrado");
		}
		return estadoslist;
	}

	@Override
	public void editar(Estado estado) throws Exception {
		if(estado.getNome() == null) {
			throw new Exception("Nome do estado � Invalido");
		}
		estadoDAO.editar(estado);		
	}

	@Override
	public Estado getObjectById(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Estado pesquisado � int�lido.");
		}
		else if(id <= 0) {
			throw new Exception("Estado pesquisado � inv�lido.");
		}
		
		return estadoDAO.getObjectById(id);
	}

	@Override
	public void excluir(Estado estado) throws Exception {
		if(estado.getNome() == null) {
			throw new Exception("Tipo de Empresa Selecionada � inv�lido.");
		}		
		estadoDAO.excluir(estado);				
	}

}
