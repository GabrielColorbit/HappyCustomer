package br.edu.facear.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import br.edu.facear.crm.entity.Usuario;

@Path("/restLogin")
public class LoginRestful {

	@GET
	@Path("/Logar")
	public void Logar(Usuario usuario) throws Exception {
		if ((usuario.getLogin() == "aqui coloca o campo LOGIN da tela login") 
			&& (usuario.getSenha() == "aqui coloca o campo SENHA da tela login")){
			//ENTRA
		}
		else{
			//NÃOENTRA
		}
	}
}