package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	
	@POST
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED,
		MediaType.APPLICATION_JSON})
	@Produces("text/plain")
	@Path("/Salvar")
	public void cadastrarCliente(TipoContato tipoContato) throws Exception {
		if(tipoContato.getId() == null)
			new FacadeHappyCustomer().CadastrarTipoContato(tipoContato);	
		else
			new FacadeHappyCustomer().AlterarTipoContato(tipoContato);	

	}
}

