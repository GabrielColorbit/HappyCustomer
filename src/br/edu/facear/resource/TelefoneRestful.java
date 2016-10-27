package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
	public ArrayList<Telefone> findAll() throws Exception{
				
		return new FacadeHappyCustomer().ListarTelefone();
	}
}
