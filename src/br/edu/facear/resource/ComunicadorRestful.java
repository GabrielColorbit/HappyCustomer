package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.facear.crm.entity.Comunicador;
import br.edu.facear.facade.FacadeHappyCustomer;

@Path("/restComunicador")
public class ComunicadorRestful {
	@GET
	@Path("/listarTodos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Comunicador> findAll() throws Exception {

		return new FacadeHappyCustomer().ListarComunicador();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	@Produces("text/plain")
	@Path("/Salvar")
	public void cadastrarComunicador(Comunicador comunicador) throws Exception {
		if (comunicador.getId() == null)
			new FacadeHappyCustomer().CadastrarComunicador(comunicador);
		else
			new FacadeHappyCustomer().AlterarComunicador(comunicador);
	}

	@GET
	@Path("/Editar/{id}")
	@Produces("application/json")
	public Comunicador editarComunicador(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Comunicador c = new FacadeHappyCustomer().BuscarComunicadorPorId(id);

		return c;
	}
}