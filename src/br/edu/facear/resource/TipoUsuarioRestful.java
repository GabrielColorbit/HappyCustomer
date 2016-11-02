package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.facear.crm.entity.TipoUsuario;
import br.edu.facear.facade.FacadeHappyCustomer;

@Path("/restTipoUsuario")
public class TipoUsuarioRestful {
	
	@GET
	@Path("/listarTodos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<TipoUsuario> findAll() throws Exception {

		return new FacadeHappyCustomer().ListarTipoUsuario();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	@Produces("text/plain")
	@Path("/Salvar")
	public void cadastrarTipoUsuario(TipoUsuario tipoUsuario) throws Exception {
		if (tipoUsuario.getId() == null)
			new FacadeHappyCustomer().CadastrarTipoUsuario(tipoUsuario);
		else
			new FacadeHappyCustomer().AlterarTipoUsuario(tipoUsuario);
	}

	@GET
	@Path("/Editar/{id}")
	@Produces("application/json")
	public TipoUsuario editarTipoUsuario(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		TipoUsuario tu = new FacadeHappyCustomer().BuscarTipoUsuarioPorId(id);

		return tu;
	}

	@POST
	@Path("/Excluir/{id}")
	@Produces("application/json")
	public void excluirTipoUsuario(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		TipoUsuario tu = new FacadeHappyCustomer().BuscarTipoUsuarioPorId(id);
		FacadeHappyCustomer fhc = new FacadeHappyCustomer();
		fhc.ExcluirTipoUsuario(tu);
	}
}
