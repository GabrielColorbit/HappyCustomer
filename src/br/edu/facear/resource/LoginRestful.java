package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import br.edu.facear.crm.entity.Usuario;
import br.edu.facear.facade.FacadeHappyCustomer;

@Path("/restLogin")
public class LoginRestful {

	@POST
	@Path("/AutenticacaoUsuario")
	@Consumes({ MediaType.APPLICATION_JSON})
	@Produces(MediaType.TEXT_PLAIN)
	public Response Logar(Usuario usuario) throws Exception {
			ResponseBuilder response = Response.ok(("Login ou senha incorreta.")); 
			String usuariohash = usuario.getLogin()+usuario.getSenha();
			String md5hashusuario = new AuthenticationService().getmd5(usuariohash);
			
			ArrayList<Usuario> usuarioslist = new FacadeHappyCustomer().ListarUsuario();

			for(Usuario u : usuarioslist){
				if(u.getLogin().equals(usuario.getLogin())){
					
					String uhash = u.getLogin()+u.getSenha();
					String md5u = new AuthenticationService().getmd5(uhash);
					
					if(md5hashusuario.equals(md5u)){
						response =  Response.ok((md5u));	
					}
					
				}
			}
		
		
		
		return response.build();
	}
	
	
	@GET
	@Path("/LoadUser/{md5user}")
	@Consumes({ MediaType.TEXT_PLAIN })
	@Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
	public Usuario LoadUser(@PathParam(value = "md5user") String md5user) throws Exception {
			
			Usuario usuarioLogado =  new Usuario();
			
			ArrayList<Usuario> usuarioslist = new FacadeHappyCustomer().ListarUsuario();

			for(Usuario u : usuarioslist){
					String uhash = u.getLogin()+u.getSenha();
					String md5u = new AuthenticationService().getmd5(uhash);
					
					if(md5user.equals(md5u)){
						usuarioLogado =  u;	
					}
			}
		
		
		
		return usuarioLogado;

	}

}