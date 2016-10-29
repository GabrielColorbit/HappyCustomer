package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.ContatoDAO;
import br.edu.facear.crm.entity.Contato;
import br.edu.facear.crm.entity.Usuario;

public class ContatoBO implements InterfaceBO<Contato>{
	ContatoDAO cdao = new ContatoDAO();
	@Override
	public void Cadastrar(Contato o) throws Exception {
		if(o.getTipocontato() == null ||
		   o.getOrigemcontato() == null ||
		   o.getUsuarioresponsavel() == null ||
   		   o.getCidade() == null ||
    	   o.getNome() == null ||
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
		cdao.Cadastrar(o);		
	}

	@Override
	public List<Contato> Listar() throws Exception {
		List<Contato> c= cdao.Listar();
		if(c == null){
			throw new Exception("Nenhum contato cadastrado");
		}
		return c;
	}

	@Override
	public void Alterar(Contato o) throws Exception {
		if(o.getTipocontato() == null ||
		   o.getOrigemcontato() == null ||
		   o.getUsuarioresponsavel() == null ||
   		   o.getCidade() == null ||
    	   o.getNome() == null ||
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
		cdao.Cadastrar(o);		
	}

	@Override
	public Contato BuscarID(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Contato pesquisado é Inválido");
		}
		else if(id <= 0) {
			throw new Exception("Contato Pesquisado é Inválido");
		}
		return cdao.BuscarID(id);

	}

	@Override
	public void Excluir(Contato o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Usuario Selecionada é inválido.");
		}		
		cdao.Excluir(o);		
	}

		
}
