package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.ContatoDAO;
import br.edu.facear.crm.entity.Contato;
import br.edu.facear.crm.entity.Usuario;

public class ContatoBO implements InterfaceBO<Contato>{
	ContatoDAO cdao = new ContatoDAO();
	@Override
	public void Cadastrar(Contato contato) throws Exception {
		
		if(contato.getTipocontato() == null) {
			throw new Exception("Selecione um Tipo de Contato");
		}		
		else if(contato.getOrigemcontato() ==  null){
			throw new Exception("Selecione uma Origem de Contato.");
		}
		else if(contato.getUsuarioresponsavel() ==  null){
			throw new Exception("Selecione um Usu�rio Responsavel.");
		}
		else if(contato.getCidade() ==  null){
			throw new Exception("Selecione uma Cidade.");
		}
		else if(contato.getTipocomunicador() ==  null){
			throw new Exception("Selecione um Tipo Comunicador.");
		}
		else if(contato.getTipocomunicador() ==  null){
			throw new Exception("Selecione um Tipo Comunicador.");
		}
		
		
		
		cdao.Cadastrar(contato);		
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
		cdao.Cadastrar(o);		
	}

	@Override
	public Contato BuscarID(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Contato pesquisado � Inv�lido");
		}
		else if(id <= 0) {
			throw new Exception("Contato Pesquisado � Inv�lido");
		}
		return cdao.BuscarID(id);

	}

	@Override
	public void Excluir(Contato o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Usuario Selecionada � inv�lido.");
		}		
		cdao.Excluir(o);		
	}

		
}
