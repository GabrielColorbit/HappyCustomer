package br.edu.facear.crm.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

import br.edu.facear.crm.dao.UsuarioDAO;
import br.edu.facear.crm.entity.Cidade;
import br.edu.facear.crm.entity.Genero;
import br.edu.facear.crm.entity.TipoUsuario;
import br.edu.facear.crm.entity.Usuario;

public class UsuarioBO implements InterfaceBO<Usuario> {
	UsuarioDAO udao = new UsuarioDAO();
	
	
	@Override
	public void Cadastrar(Usuario o) throws Exception {
		if(o.getNome() == null ||
		   o.getTipousuario() == null ||
   		   o.getCidade() == null ||
		   o.getBairro() == null ||
		   o.getSenha() == null ||
		   o.getCpf() == null ||
		   o.getGenero() == null ||
		   o.getCargo() == null ||
		   o.getDatanascimento() == null ||
		   o.getEndereco() == null ||
		   o.getNumero() == null ||
		   o.getCep() == null    
				
		  ){
			throw new Exception("Preencher todos os campos do usu�rio");
		}
		udao.Cadastrar(o);
	}

	@Override
	public ArrayList<Usuario> Listar() throws Exception {
		ArrayList<Usuario> u= udao.Listar();
		if(u == null){
			throw new Exception("Nenhuma usu�rio cadastrado");
		}
		return u;
	}

	@Override
	public void Alterar(Usuario o) throws Exception {
		if(o.getNome() == null ||
		   o.getTipousuario() == null ||
   		   o.getCidade() == null ||
		   o.getBairro() == null ||
		   o.getSenha() == null ||
		   o.getCpf() == null ||
		   o.getGenero() == null ||
		   o.getCargo() == null ||
		   o.getDatanascimento() == null ||
		   o.getEndereco() == null ||
		   o.getNumero() == null ||
		   o.getCep() == null   
	     ) {
			throw new Exception("Nome do tipo de usu�rio � inv�lido");
		}
		udao.Alterar(o);				
	}

	@Override
	public Usuario BuscarID(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Usu�rio pesquisado � Inv�lido");
		}
		else if(id <= 0) {
			throw new Exception("Usu�rio Pesquisado � Inv�lido");
		}
		
		return udao.BuscarID(id);
	}

	@Override
	public void Excluir(Usuario o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Usuario Selecionada � inv�lido.");
		}		
		udao.Excluir(o);			
	}
	

}
