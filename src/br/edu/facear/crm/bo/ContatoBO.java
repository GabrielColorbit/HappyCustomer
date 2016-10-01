package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.ContatoDAO;
import br.edu.facear.crm.entity.Contato;
import br.edu.facear.crm.entity.Usuario;

public class ContatoBO implements InterfaceBO<Contato>{
	ContatoDAO cdao = new ContatoDAO();
	@Override
	public void salvar(Contato o) throws Exception {
		if(o.getTipocontato() == null ||
		   o.getOrigemcontato() == null ||
		   o.getUsuarioresponsavel() == null ||
   		   o.getCidade() == null ||
    	   o.getNome() == null ||
		   o.getEmail() == null ||
		   o.getCpf() == null ||
		   o.getFoto() == null ||
		   o.getGenero() == null ||
		   o.getCargo() == null ||
		   o.getDatanascimento() == null ||
		   o.getEndereco() == null ||
		   o.getNumero() == null ||
		   o.getCep() == null 	    ){
			throw new Exception("Preencher todos os campos do contato");
		}
		cdao.salvar(o);		
	}

	@Override
	public List<Contato> listar() throws Exception {
		List<Contato> c= cdao.listar();
		if(c == null){
			throw new Exception("Nenhum contato cadastrado");
		}
		return c;
	}

	@Override
	public void editar(Contato o) throws Exception {
		if(o.getTipocontato() == null ||
		   o.getOrigemcontato() == null ||
		   o.getUsuarioresponsavel() == null ||
   		   o.getCidade() == null ||
    	   o.getNome() == null ||
		   o.getEmail() == null ||
		   o.getCpf() == null ||
		   o.getFoto() == null ||
		   o.getGenero() == null ||
		   o.getCargo() == null ||
		   o.getDatanascimento() == null ||
		   o.getEndereco() == null ||
		   o.getNumero() == null ||
		   o.getCep() == null    
	    ){
			throw new Exception("Preencher todos os campos do contato");
		}
		cdao.salvar(o);		
	}

	@Override
	public Contato getObjectById(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Contato pesquisado � Inv�lido");
		}
		else if(id <= 0) {
			throw new Exception("Contato Pesquisado � Inv�lido");
		}
		return cdao.getObjectById(id);

	}

	@Override
	public void excluir(Contato o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Usuario Selecionada � inv�lido.");
		}		
		cdao.excluir(o);		
	}

		
}
