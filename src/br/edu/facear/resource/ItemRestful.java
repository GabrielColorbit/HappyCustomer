package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.facear.crm.entity.Item;
import br.edu.facear.facade.FacadeHappyCustomer;

@Path("/restItem")
public class ItemRestful {

	@GET
	@Path("/listarTodos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Item> findAll() throws Exception {

		return (ArrayList<Item>) new FacadeHappyCustomer().ListarItem();
	}


//	@GET
//	@Path("/listarItemNegocio/{id}")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public ArrayList<Item> listarPorNegocio(@PathParam(value = "id")String NegocioCod) throws Exception {
//
//		
//		Long idnego = Long.parseLong(NegocioCod);
//		ArrayList<Item> itemlist = new ArrayList<Item>();
//		ArrayList<Item> itemlistall = new FacadeHappyCustomer().ListarItem();
//		for(Item i : itemlistall){
//			if(i.getNegocio().getId() == idnego ){
//				itemlist.add(i);
//			}
//		}
//		
//		return itemlist;
//	}

	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	@Produces("text/plain")
	@Path("/Salvar")
	public void cadastrarCliente(Item item) throws Exception {
		if (item.getId() == null)
			new FacadeHappyCustomer().CadastrarItem(item);
		else
			new FacadeHappyCustomer().AlterarItem(item);
	}

	@GET
	@Path("/Editar/{id}")
	@Produces("application/json")
	public Item editarItem(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Item i = new FacadeHappyCustomer().BuscarItemPorId(id);
		return i;
	}
	
	@POST
	@Path("/Excluir/{id}")
	@Produces("application/json")
	public void excluirItem(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Item i = new FacadeHappyCustomer().BuscarItemPorId(id);
		FacadeHappyCustomer fhc = new FacadeHappyCustomer();
		fhc.ExcluirItem(i);
	}
}