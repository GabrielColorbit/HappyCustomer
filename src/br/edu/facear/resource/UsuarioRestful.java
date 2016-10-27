package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.facear.crm.entity.Usuario;
import br.edu.facear.facade.FacadeHappyCustomer;

@Path("/restUsuario")
public class UsuarioRestful {
	@GET
	@Path("/listarTodos")
	@Produces({ MediaType.APPLICATION_JSON })
	public ArrayList<Usuario>  findAll() throws Exception{
				
		return new FacadeHappyCustomer().ListarUsuario();
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED,
		MediaType.APPLICATION_JSON})
	@Produces("text/plain")
	@Path("/Salvar")
	public void cadastrarCliente(Usuario usuario) throws Exception {
		if(usuario.getId() == null)
			new FacadeHappyCustomer().CadastrarUsuario(usuario);	
		else
			new FacadeHappyCustomer().AlterarUsuario(usuario);	

	}

	@GET
	@Path("/Editar/{id}")
	@Produces("application/json")
	public Usuario editarUsuario(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Usuario u = new FacadeHappyCustomer().BuscarUsuarioPorId(id);

		return u;
	}
}
