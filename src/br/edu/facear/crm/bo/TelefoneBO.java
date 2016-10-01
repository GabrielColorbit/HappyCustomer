package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.TelefoneDAO;
import br.edu.facear.crm.entity.Telefone;
import br.edu.facear.crm.entity.TipoEmpresa;

public class TelefoneBO implements InterfaceBO<Telefone>{
	TelefoneDAO tfDAO = new TelefoneDAO();
	@Override
	public void salvar(Telefone telefone) throws Exception {
		if(telefone.getNumero() == null){
			throw new Exception("N�mero de telefone � inv�lido");
		}
		else if(telefone.getTipotelefone() == null){
			throw new Exception("Tipo de telefone � inv�lido");
		}
		tfDAO.salvar(telefone);
	}

	@Override
	public List<Telefone> listar() throws Exception {
		List<Telefone> telefones= tfDAO.listar();
		if(telefones == null){
			throw new Exception("Nenhumm telefone cadastrado");
		}
		return telefones;
	}

	@Override
	public void editar(Telefone telefone) throws Exception {
		if(telefone.getNumero() == null) {
			throw new Exception("N�mero de telefone� Invalido");
		}
		if(telefone.getTipotelefone() == null) {
			throw new Exception("Tipo de Telefone � Invalido");
		}
		tfDAO.editar(telefone);					
	}

	@Override
	public Telefone getObjectById(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Telefone pesquisado � Inv�lido");
		}
		else if(id <= 0) {
			throw new Exception("Telefone Pesquisado � Inv�lido");
		}
		
		return tfDAO.getObjectById(id);
	}

	@Override
	public void excluir(Telefone telefone) throws Exception {
		if(telefone.getNumero() == null) {
			throw new Exception("Telefone selecionado � Inv�lido");
		}		
		tfDAO.excluir(telefone);			
	}

}
