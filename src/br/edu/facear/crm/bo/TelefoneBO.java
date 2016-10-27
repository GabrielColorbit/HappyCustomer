package br.edu.facear.crm.bo;

import java.util.ArrayList;

import br.edu.facear.crm.dao.TelefoneDAO;
import br.edu.facear.crm.entity.Telefone;
import br.edu.facear.crm.entity.Usuario;

public class TelefoneBO implements InterfaceBO<Telefone>{
	TelefoneDAO tfDAO = new TelefoneDAO();
	@Override
	public void Cadastrar(Telefone telefone) throws Exception {
		if(telefone.getNumero() == null){
			throw new Exception("Número de telefone é inválido");
		}
		else if(telefone.getTipotelefone() == null){
			throw new Exception("Tipo de telefone é inválido");
		}
		tfDAO.Cadastrar(telefone);
	}

	@Override
	public ArrayList<Telefone> Listar() throws Exception {
		ArrayList<Telefone> telefones= tfDAO.Listar();
		if(telefones == null){
			throw new Exception("Nenhumm telefone cadastrado");
		}
		return telefones;
	}

	@Override
	public void Alterar(Telefone telefone) throws Exception {
		if(telefone.getNumero() == null) {
			throw new Exception("Número de telefoneé Invalido");
		}
		if(telefone.getTipotelefone() == null) {
			throw new Exception("Tipo de Telefone é Invalido");
		}
		tfDAO.Alterar(telefone);					
	}

	@Override
	public Telefone BuscarID(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Telefone pesquisado é Inválido");
		}
		else if(id <= 0) {
			throw new Exception("Telefone Pesquisado é Inválido");
		}
		
		return tfDAO.BuscarID(id);
	}

	@Override
	public void Excluir(Telefone telefone) throws Exception {
		if(telefone.getNumero() == null) {
			throw new Exception("Telefone selecionado é Inválido");
		}		
		tfDAO.Excluir(telefone);			
	}

}
