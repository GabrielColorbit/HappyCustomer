package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.facear.crm.entity.TipoTelefone;
import br.edu.facear.facade.FacadeHappyCustomer;

@Path("/restTipoTelefone")
public class TipoTelefoneRestful {
	
	@GET
	@Path("/listarTodos")
	@Produces({ MediaType.APPLICATION_JSON })
	public ArrayList<TipoTelefone> findAll() throws Exception {

		return (ArrayList<TipoTelefone>) new FacadeHappyCustomer().ListarTipoTelefone();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	@Produces("text/plain")
	@Path("/Salvar")
	public void cadastrarCliente(TipoTelefone tipotelefone) throws Exception {
		if (tipotelefone.getId() == null)
			new FacadeHappyCustomer().CadastrarTipoTelefone(tipotelefone);
		else
			new FacadeHappyCustomer().AlterarTipoTelefone(tipotelefone);
	}

	@GET
	@Path("/Editar/{id}")
	@Produces("application/json")
	public TipoTelefone editarTipoTelefone(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		TipoTelefone tt = new FacadeHappyCustomer().BuscarTipoTelefonePorId(id);

		return tt;
	}
	
	@POST
	@Path("/Excluir/{id}")
	@Produces("application/json")
	public void excluirTipoTelefone(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		TipoTelefone tt = new FacadeHappyCustomer().BuscarTipoTelefonePorId(id);
		FacadeHappyCustomer fhc = new FacadeHappyCustomer();
		fhc.ExcluirTipoTelefone(tt);
	}
}