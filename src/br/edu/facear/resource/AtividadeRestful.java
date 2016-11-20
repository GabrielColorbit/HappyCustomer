package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.facear.crm.entity.Atividade;
import br.edu.facear.facade.FacadeHappyCustomer;

@Path("/restAtividade")
public class AtividadeRestful {

	@GET
	@Path("/listarTodos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Atividade> findAll() throws Exception {

		return (ArrayList<Atividade>) new FacadeHappyCustomer().ListarAtividade();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	@Produces("text/plain")
	@Path("/Salvar")
	public void cadastrarCliente(Atividade atividade) throws Exception {
		if (atividade.getId() == null)
			new FacadeHappyCustomer().CadastrarAtividade(atividade);
		else
			new FacadeHappyCustomer().AlterarAtividade(atividade);
	}

	@GET
	@Path("/Editar/{id}")
	@Produces("application/json")
	public Atividade editarAtividade(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Atividade a = new FacadeHappyCustomer().BuscarAtividadePorId(id);
		return a;
	}

	@POST
	@Path("/Excluir/{id}")
	@Produces("application/json")
	public void excluirAtividade(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Atividade a = new FacadeHappyCustomer().BuscarAtividadePorId(id);
		FacadeHappyCustomer fhc = new FacadeHappyCustomer();
		fhc.ExcluirAtividade(a);
	}
}
