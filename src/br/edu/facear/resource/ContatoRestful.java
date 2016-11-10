package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.facear.crm.entity.Contato;
import br.edu.facear.crm.entity.Telefone;
import br.edu.facear.facade.FacadeHappyCustomer;

@Path("/restContato")
public class ContatoRestful {
	
	@GET
	@Path("/listarTodos")
	@Produces({ MediaType.APPLICATION_JSON })
	public ArrayList<Contato> findAll() throws Exception {

		return new FacadeHappyCustomer().ListarContato();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	@Produces("text/plain")
	@Path("/Salvar")
	public void cadastrarCliente(Contato Contato) throws Exception {
		
		ArrayList<Telefone> telefonelist = new ArrayList<Telefone>();
		/*for(Telefone t : Contato.getTelefones_Contato()){
			new FacadeHappyCustomer().CadastrarTelefone(t);
			telefonelist.add(t);
		}
		Contato.setTelefones_Contato(telefonelist);
		if(Contato.getId() == null)
			new FacadeHappyCustomer().CadastrarContato(Contato);	

		else
			new FacadeHappyCustomer().AlterarContato(Contato);
		 */
	}

	@GET
	@Path("/Editar/{id}")
	@Produces("application/json")
	public Contato editarContato(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Contato u = new FacadeHappyCustomer().BuscarContatoPorId(id);

		return u;
	}
	

	
	
}