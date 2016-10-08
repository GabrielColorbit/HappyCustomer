package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.EstadoDAO;
import br.edu.facear.crm.entity.Estado;
import br.edu.facear.crm.entity.TipoEmpresa;

public class EstadoBO implements InterfaceBO<Estado> {
	EstadoDAO estadoDAO = new EstadoDAO();
	@Override
	public void Cadastrar(Estado estado) throws Exception {
		if(estado.getNome() == null){
			throw new Exception("Nome do estado é inválido");
		}
		estadoDAO.Cadastrar(estado);
	}

	@Override
	public List<Estado> Listar() throws Exception {
		List<Estado> estadoslist= estadoDAO.Listar();
		if(estadoslist == null){
			throw new Exception("Nenhumm estado cadastrado");
		}
		return estadoslist;
	}

	@Override
	public void Alterar(Estado estado) throws Exception {
		if(estado.getNome() == null) {
			throw new Exception("Nome do estado é Invalido");
		}
		estadoDAO.Alterar(estado);		
	}

	@Override
	public Estado BuscarID(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Estado pesquisado é intálido.");
		}
		else if(id <= 0) {
			throw new Exception("Estado pesquisado é inválido.");
		}
		
		return estadoDAO.BuscarID(id);
	}

	@Override
	public void Excluir(Estado estado) throws Exception {
		if(estado.getNome() == null) {
			throw new Exception("Tipo de Empresa Selecionada é inválido.");
		}		
		estadoDAO.Excluir(estado);				
	}

}
