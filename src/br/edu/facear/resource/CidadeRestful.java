package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.facear.crm.entity.Cidade;
import br.edu.facear.facade.FacadeHappyCustomer;

@Path("/restCidade")
public class CidadeRestful {

	@GET
	@Path("/listarTodos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Cidade> findAll() throws Exception {

		return (ArrayList<Cidade>) new FacadeHappyCustomer().ListarCidade();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	@Produces("text/plain")
	@Path("/Salvar")
	public void cadastrarCliente(Cidade cidade) throws Exception {
		if (cidade.getId() == null)
			new FacadeHappyCustomer().CadastrarCidade(cidade);
		else
			new FacadeHappyCustomer().AlterarCidade(cidade);
	}

	@GET
	@Path("/Editar/{id}")
	@Produces("application/json")
	public Cidade editarCidade(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Cidade c = new FacadeHappyCustomer().BuscarCidadePorId(id);
		return c;
	}
	
	@POST
	@Path("/Excluir/{id}")
	@Produces("application/json")
	public void excluirCidade(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Cidade c = new FacadeHappyCustomer().BuscarCidadePorId(id);
		FacadeHappyCustomer fhc = new FacadeHappyCustomer();
		fhc.ExcluirCidade(c);
	}
}