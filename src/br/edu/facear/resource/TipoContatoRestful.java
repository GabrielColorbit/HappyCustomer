package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.edu.facear.crm.entity.TipoContato;
import br.edu.facear.facade.FacadeHappyCustomer;

@Path("/restTipoContato")
public class TipoContatoRestful {
	
	@GET
	@Path("/listarTodos")
	@Produces("application/json")
	public ArrayList<TipoContato> findAll() throws Exception{
				
		return new FacadeHappyCustomer().ListarTipoContato();
	}

}

