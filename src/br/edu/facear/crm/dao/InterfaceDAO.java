package br.edu.facear.crm.dao;

import java.util.List;

public interface InterfaceDAO<O> {
	public void salvar(O o) throws CrmException;
	public List<O> listar();
	public void editar(O o);
	public O getObjectById(Long id);
	public void excluir(O o);

}
