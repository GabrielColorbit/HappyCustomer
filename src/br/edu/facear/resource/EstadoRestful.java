package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.facear.crm.entity.Estado;
import br.edu.facear.facade.FacadeHappyCustomer;


@Path("/restEstado")
public class EstadoRestful {
	@GET
	@Path("/listarTodos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Estado> findAll() throws Exception{
				
		return (ArrayList<Estado>) new FacadeHappyCustomer().ListarEstado();
	}
}
