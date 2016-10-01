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
			throw new Exception("Número de telefone é inválido");
		}
		else if(telefone.getTipotelefone() == null){
			throw new Exception("Tipo de telefone é inválido");
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
			throw new Exception("Número de telefoneé Invalido");
		}
		if(telefone.getTipotelefone() == null) {
			throw new Exception("Tipo de Telefone é Invalido");
		}
		tfDAO.editar(telefone);					
	}

	@Override
	public Telefone getObjectById(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Telefone pesquisado é Inválido");
		}
		else if(id <= 0) {
			throw new Exception("Telefone Pesquisado é Inválido");
		}
		
		return tfDAO.getObjectById(id);
	}

	@Override
	public void excluir(Telefone telefone) throws Exception {
		if(telefone.getNumero() == null) {
			throw new Exception("Telefone selecionado é Inválido");
		}		
		tfDAO.excluir(telefone);			
	}

}
