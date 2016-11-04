package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.CrmException;

public interface InterfaceBO<CRM> {

	// INTERFACE CADASTRAR
	public void Cadastrar(CRM crm) throws CrmException, Exception;

	// INTERFACE ALTERAR
	public void Alterar(CRM crm) throws Exception;

	// INTERFACE EXCLUIR
	public void Excluir(CRM crm) throws Exception;

	// INTERFACE LISTAR
	public List<CRM> Listar() throws Exception;

	// INTERFACE BUSCAR PELO ID - "GetObjectById"
	public CRM BuscarID(Long id) throws Exception;
	
}