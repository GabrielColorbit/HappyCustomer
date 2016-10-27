package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.TelefoneDAO;
import br.edu.facear.crm.entity.Telefone;
import br.edu.facear.crm.entity.TipoEmpresa;

public class TelefoneBO implements InterfaceBO<Telefone>{
	TelefoneDAO tfDAO = new TelefoneDAO();
	@Override
	public void Cadastrar(Telefone telefone) throws Exception {
		if(telefone.getNumero() == null){
			throw new Exception("N�mero de telefone � inv�lido");
		}
		else if(telefone.getId_tipotelefone() == null){
			throw new Exception("Tipo de telefone � inv�lido");
		}
		tfDAO.Cadastrar(telefone);
	}

	@Override
	public List<Telefone> Listar() throws Exception {
		List<Telefone> telefones= tfDAO.Listar();
		if(telefones == null){
			throw new Exception("Nenhumm telefone cadastrado");
		}
		return telefones;
	}

	@Override
	public void Alterar(Telefone telefone) throws Exception {
		if(telefone.getNumero() == null) {
			throw new Exception("N�mero de telefone� Invalido");
		}
		if(telefone.getId_tipotelefone() == null) {
			throw new Exception("Tipo de Telefone � Invalido");
		}
		tfDAO.Alterar(telefone);					
	}

	@Override
	public Telefone BuscarID(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Telefone pesquisado � Inv�lido");
		}
		else if(id <= 0) {
			throw new Exception("Telefone Pesquisado � Inv�lido");
		}
		
		return tfDAO.BuscarID(id);
	}

	@Override
	public void Excluir(Telefone telefone) throws Exception {
		if(telefone.getNumero() == null) {
			throw new Exception("Telefone selecionado � Inv�lido");
		}		
		tfDAO.Excluir(telefone);			
	}

}
