package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.facear.crm.entity.Empresa;
import br.edu.facear.facade.FacadeHappyCustomer;

@Path("/restEmpresa")
public class EmpresaRestful {
	
	@GET
	@Path("/listarTodos")
	@Produces({ MediaType.APPLICATION_JSON })
	public ArrayList<Empresa> findAll() throws Exception {

		return new FacadeHappyCustomer().ListarEmpresa();
	}
}