package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.facear.crm.entity.TipoEmpresa;
import br.edu.facear.facade.FacadeHappyCustomer;

@Path("/restTipoEmpresa")
public class TipoEmpresaRestful {

	@GET
	@Path("/listarTodos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<TipoEmpresa> findAll() throws Exception {

		return new FacadeHappyCustomer().ListarTipoEmpresa();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	@Produces("text/plain")
	@Path("/Salvar")
	public void cadastrarCliente(TipoEmpresa tipoempresa) throws Exception {
		if (tipoempresa.getId() == null)
			new FacadeHappyCustomer().CadastrarTipoEmpresa(tipoempresa);
		else
			new FacadeHappyCustomer().AlterarTipoEmpresa(tipoempresa);
	}

	@GET
	@Path("/Editar/{id}")
	@Produces("application/json")
	public TipoEmpresa editarTipoEmpresa(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		TipoEmpresa te = new FacadeHappyCustomer().BuscarTipoEmpresaPorId(id);

		return te;
	}
	
	@POST
	@Path("/Excluir/{id}")
	@Produces("application/json")
	public void excluirTipoEmpresa(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		TipoEmpresa te = new FacadeHappyCustomer().BuscarTipoEmpresaPorId(id);
		FacadeHappyCustomer fhc = new FacadeHappyCustomer();
		fhc.ExcluirTipoEmpresa(te);
	}
}