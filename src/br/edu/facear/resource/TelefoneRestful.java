package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.facear.crm.entity.Telefone;
import br.edu.facear.facade.FacadeHappyCustomer;

@Path("/restTelefone")
public class TelefoneRestful {
	@GET
	@Path("/listarTodos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Telefone> findAll() throws Exception {

		return new FacadeHappyCustomer().ListarTelefone();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	@Produces("text/plain")
	@Path("/Salvar")
	public void cadastrarTelefone(Telefone telefone) throws Exception {
		if (telefone.getId() == null)
			new FacadeHappyCustomer().CadastrarTelefone(telefone);
		else
			new FacadeHappyCustomer().AlterarTelefone(telefone);
	}

	@GET
	@Path("/Editar/{id}")
	@Produces("application/json")
	public Telefone editarTelefone(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Telefone u = new FacadeHappyCustomer().BuscarTelefonePorId(id);

		return u;
	}
}