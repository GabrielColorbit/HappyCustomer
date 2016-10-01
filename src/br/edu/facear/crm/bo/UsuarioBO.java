package br.edu.facear.crm.bo;

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
	public void salvar(Usuario o) throws Exception {
		if(o.getNome() == null ||
		   o.getTipousuario() == null ||
   		   o.getCidade() == null ||
		   o.getEmail() == null ||
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
		udao.salvar(o);
	}

	@Override
	public List<Usuario> listar() throws Exception {
		List<Usuario> u= udao.listar();
		if(u == null){
			throw new Exception("Nenhuma usu�rio cadastrado");
		}
		return u;
	}

	@Override
	public void editar(Usuario o) throws Exception {
		if(o.getNome() == null ||
		   o.getTipousuario() == null ||
   		   o.getCidade() == null ||
		   o.getEmail() == null ||
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
		udao.editar(o);				
	}

	@Override
	public Usuario getObjectById(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Usu�rio pesquisado � Inv�lido");
		}
		else if(id <= 0) {
			throw new Exception("Usu�rio Pesquisado � Inv�lido");
		}
		
		return udao.getObjectById(id);
	}

	@Override
	public void excluir(Usuario o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Usuario Selecionada � inv�lido.");
		}		
		udao.excluir(o);			
	}
	

}
