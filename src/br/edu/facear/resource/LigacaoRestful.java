package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.facear.crm.entity.Ligacao;
import br.edu.facear.facade.FacadeHappyCustomer;

@Path("/restLigacao")
public class LigacaoRestful {

	@GET
	@Path("/listarTodos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Ligacao> findAll() throws Exception {

		return (ArrayList<Ligacao>) new FacadeHappyCustomer().ListarLigacao();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	@Produces("text/plain")
	@Path("/Salvar")
	public void cadastrarCliente(Ligacao ligacao) throws Exception {
		if (ligacao.getId() == null)
			new FacadeHappyCustomer().CadastrarLigacao(ligacao);
		else
			new FacadeHappyCustomer().AlterarLigacao(ligacao);
	}

	@GET
	@Path("/Editar/{id}")
	@Produces("application/json")
	public Ligacao editarLigacao(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Ligacao l = new FacadeHappyCustomer().BuscarLigacaoPorId(id);
		return l;
	}
	
	@POST
	@Path("/Excluir/{id}")
	@Produces("application/json")
	public void excluirLigacao(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Ligacao l = new FacadeHappyCustomer().BuscarLigacaoPorId(id);
		FacadeHappyCustomer fhc = new FacadeHappyCustomer();
		fhc.ExcluirLigacao(l);
	}
}