package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.facear.crm.entity.TipoAtividade;
import br.edu.facear.facade.FacadeHappyCustomer;

@Path("/restTipoAtividade")
public class TipoAtividadeRestful {
	
	@GET
	@Path("/listarTodos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<TipoAtividade> findAll() throws Exception {

		return new FacadeHappyCustomer().ListarTipoAtividade();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	@Produces("text/plain")
	@Path("/Salvar")
	public void cadastrarTipoAtividade(TipoAtividade tipoAtividade) throws Exception {
		if (tipoAtividade.getId() == null)
			new FacadeHappyCustomer().CadastrarTipoAtividade(tipoAtividade);
		else
			new FacadeHappyCustomer().AlterarTipoAtividade(tipoAtividade);
	}

	@GET
	@Path("/Editar/{id}")
	@Produces("application/json")
	public TipoAtividade editarTipoAtividade(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		TipoAtividade ta = new FacadeHappyCustomer().BuscarTipoAtividadePorId(id);

		return ta;
	}

	@POST
	@Path("/Excluir/{id}")
	@Produces("application/json")
	public void excluirTipoAtividade(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		TipoAtividade ta = new FacadeHappyCustomer().BuscarTipoAtividadePorId(id);
		FacadeHappyCustomer fhc = new FacadeHappyCustomer();
		fhc.ExcluirTipoAtividade(ta);
	}
}
