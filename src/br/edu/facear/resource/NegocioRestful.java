package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.facear.crm.dao.NegocioDAO;
import br.edu.facear.crm.entity.Item;
import br.edu.facear.crm.entity.Negocio;
import br.edu.facear.facade.FacadeHappyCustomer;

@Path("/restNegocio")
public class NegocioRestful {

	@GET
	@Path("/listarTodos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Negocio> findAll() throws Exception {

		return new FacadeHappyCustomer().ListarNegocio();
	}

	@GET
	@Path("/listarNegocioPendente")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Negocio> listarNegocioPendente() throws Exception {

		return new NegocioDAO().ListarEmAndamento();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	@Produces("application/json")
	@Path("/Salvar")
	public Negocio cadastrarCliente(Negocio negocio) throws Exception {
		// Cadastra se o negócio for novo
		if (negocio.getId() == null) {
			
			if(negocio.getItens_negocio() != null){
				ArrayList<Item> itemlist = new ArrayList<Item>();
				for (Item i : negocio.getItens_negocio()) {
					new FacadeHappyCustomer().CadastrarItem(i);
					itemlist.add(i);
				}
				negocio.setItens_negocio(itemlist);
			}

			new FacadeHappyCustomer().CadastrarNegocio(negocio);
		}
		// altera negócio já criado
		else {
			
			if(negocio.getItens_negocio() != null){
				ArrayList<Item> itemlist = new ArrayList<Item>();
				for (Item i : negocio.getItens_negocio()) {
					if (i.getId() == null) {
						new FacadeHappyCustomer().CadastrarItem(i);
					} else {
						new FacadeHappyCustomer().AlterarItem(i);
					}
					itemlist.add(i);
				}
				negocio.setItens_negocio(itemlist);
			}

			new FacadeHappyCustomer().AlterarNegocio(negocio);

		}
		return negocio;
	}

	@GET
	@Path("/Editar/{id}")
	@Produces("application/json")
	public Negocio editarNegocio(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Negocio n = new FacadeHappyCustomer().BuscarNegocioPorId(id);

		return n;
	}
	
	@POST
	@Path("/Excluir/{id}")
	@Produces("application/json")
	public void excluirNegocio(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Negocio n = new FacadeHappyCustomer().BuscarNegocioPorId(id);
		FacadeHappyCustomer fhc = new FacadeHappyCustomer();
		fhc.ExcluirNegocio(n);
	}
}