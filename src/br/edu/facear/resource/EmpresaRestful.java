package br.edu.facear.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.facear.crm.entity.Comunicador;
import br.edu.facear.crm.entity.Contato;
import br.edu.facear.crm.entity.Empresa;
import br.edu.facear.crm.entity.Telefone;
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
	public void cadastrarCliente(Empresa empresa) throws Exception {
		
		
		ArrayList<Telefone> telefonelist = new ArrayList<Telefone>();
		for(Telefone t : empresa.getTelefones_empresa()){
			new FacadeHappyCustomer().CadastrarTelefone(t);
			telefonelist.add(t);
		}
		empresa.setTelefones_empresa(telefonelist);
		
		ArrayList<Comunicador> comunicadorlist = new ArrayList<Comunicador>();
		for(Comunicador c : empresa.getComunicadores_empresa()){
			new FacadeHappyCustomer().CadastrarComunicador(c);
			comunicadorlist.add(c);
		}
		empresa.setComunicadores_empresa(comunicadorlist);
		
//		List<Contato> contatos_empresa = new ArrayList<Contato>();
//		for(Contato c : empresa.getContatos_empresa() ){
//			contatos_empresa.add(c);
//		}
//		
//		empresa.setContatos_empresa(contatos_empresa);
//		
		
		if (empresa.getId() == null)
			new FacadeHappyCustomer().CadastrarEmpresa(empresa);
		else
			new FacadeHappyCustomer().AlterarEmpresa(empresa);
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