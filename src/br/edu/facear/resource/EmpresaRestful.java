package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.facear.crm.entity.Empresa;
import br.edu.facear.crm.entity.OrigemContato;
import br.edu.facear.facade.FacadeHappyCustomer;

@Path("/restEmpresa")
public class EmpresaRestful {

	@GET
	@Path("/listarTodos")
	@Produces({ MediaType.APPLICATION_JSON })
	public ArrayList<Empresa> findAll() throws Exception {

		return (ArrayList<Empresa>) new FacadeHappyCustomer().ListarEmpresa();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	@Produces("text/plain")
	@Path("/Salvar")
	public void cadastrarCliente(Empresa Empresa) throws Exception {
		if (Empresa.getId() == null)
			new FacadeHappyCustomer().CadastrarEmpresa(Empresa);
		else
			new FacadeHappyCustomer().AlterarEmpresa(Empresa);
	}

	@GET
	@Path("/Editar/{id}")
	@Produces("application/json")
	public Empresa editarEmpresa(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Empresa e = new FacadeHappyCustomer().BuscarEmpresaPorId(id);

		return e;
	}
	
	@POST
	@Path("/Excluir/{id}")
	@Produces("application/json")
	public void excluirEmpresa(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Empresa e = new FacadeHappyCustomer().BuscarEmpresaPorId(id);
		FacadeHappyCustomer fhc = new FacadeHappyCustomer();
		fhc.ExcluirEmpresa(e);
		
	}
}