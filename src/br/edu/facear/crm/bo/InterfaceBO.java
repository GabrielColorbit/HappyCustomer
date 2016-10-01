package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.CrmException;

public interface InterfaceBO<O> {
	public void salvar(O o) throws Exception;
	public List<O> listar() throws Exception;
	public void editar(O o) throws Exception;
	public O getObjectById(Long id) throws Exception;
	public void excluir(O o) throws Exception;

}