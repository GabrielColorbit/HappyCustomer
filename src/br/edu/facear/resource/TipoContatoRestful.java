package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.facear.crm.entity.TipoContato;
import br.edu.facear.facade.FacadeHappyCustomer;

@Path("/restTipoContato")
public class TipoContatoRestful {

	@GET
	@Path("/listarTodos")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<TipoContato> findAll() throws Exception {
		ArrayList<TipoContato> tiposContatos = new FacadeHappyCustomer().ListarTipoContato();
		return tiposContatos;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	@Produces("text/plain")
	@Path("/Salvar")
	public void cadastrarCliente(TipoContato tipoContato) throws Exception {
		if (tipoContato.getId() == null)
			new FacadeHappyCustomer().CadastrarTipoContato(tipoContato);
		else
			new FacadeHappyCustomer().AlterarTipoContato(tipoContato);
	}

	@GET
	@Path("/Editar/{id}")
	@Produces("application/json")
	public TipoContato editarContato(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		TipoContato tc = new FacadeHappyCustomer().BuscarTipoContatoPorId(id);

		return tc;
	}
	
	@POST
	@Path("/Excluir/{id}")
	@Produces("application/json")
	public void excluirTipoContato(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		TipoContato tc = new FacadeHappyCustomer().BuscarTipoContatoPorId(id);
		FacadeHappyCustomer fhc = new FacadeHappyCustomer();
		fhc.ExcluirTipoContato(tc);
	}
}