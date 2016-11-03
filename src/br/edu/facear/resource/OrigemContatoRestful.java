package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.facear.crm.entity.OrigemContato;
import br.edu.facear.facade.FacadeHappyCustomer;

@Path("/restOrigemContato")
public class OrigemContatoRestful {
	
	@GET
	@Path("/listarTodos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<OrigemContato> findAll() throws Exception {

		return new FacadeHappyCustomer().ListarOrigemContato();
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	@Produces("text/plain")
	@Path("/Salvar")
	public void cadastrarOrigemContato(OrigemContato origemContato) throws Exception {
		if (origemContato.getId() == null)
			new FacadeHappyCustomer().CadastrarOrigemContato(origemContato);
		else
			new FacadeHappyCustomer().AlterarOrigemContato(origemContato);
	}
	
	@GET
	@Path("/Editar/{id}")
	@Produces("application/json")
	public OrigemContato editarOrigemContato(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		OrigemContato oc = new FacadeHappyCustomer().BuscarOrigemContatoPorId(id);

		return oc;
	}
	
	@POST
	@Path("/Excluir/{id}")
	@Produces("application/json")
	public void excluirOrigemContato(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		OrigemContato oc = new FacadeHappyCustomer().BuscarOrigemContatoPorId(id);
		FacadeHappyCustomer fhc = new FacadeHappyCustomer();
		fhc.ExcluirOrigemContato(oc);
		
	}
}