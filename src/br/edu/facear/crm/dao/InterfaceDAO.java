package br.edu.facear.crm.dao;

import java.util.List;

public interface InterfaceDAO<CRM> {

	// INTERFACE CADASTRAR
	public void Cadastrar(CRM crm) throws CrmException;

	// INTERFACE ALTERAR
	public void Alterar(CRM crm);

	// INTERFACE EXCLUIR
	public void Excluir(CRM crm);

	// INTERFACE LISTAR
	public List<CRM> Listar();

	// INTERFACE BUSCAR PELO ID - "GetObjectById"
	public CRM BuscarID(Long id);

}