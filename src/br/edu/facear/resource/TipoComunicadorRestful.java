package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.facear.crm.entity.TipoComunicador;
import br.edu.facear.facade.FacadeHappyCustomer;

@Path("/restTipoComunicador")
public class TipoComunicadorRestful {
	
	@GET
	@Path("/listarTodos")
	@Produces({ MediaType.APPLICATION_JSON })
	public ArrayList<TipoComunicador> findAll() throws Exception {

		return (ArrayList<TipoComunicador>) new FacadeHappyCustomer().ListarTipoComunicador();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	@Produces("text/plain")
	@Path("/Salvar")
	public void cadastrarCliente(TipoComunicador tipocomunicador) throws Exception {
		if (tipocomunicador.getId() == null)
			new FacadeHappyCustomer().CadastrarTipoComunicador(tipocomunicador);
		else
			new FacadeHappyCustomer().AlterarTipoComunicador(tipocomunicador);
	}

	@GET
	@Path("/Editar/{id}")
	@Produces("application/json")
	public TipoComunicador editarTipoComunicador(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		TipoComunicador tc = new FacadeHappyCustomer().BuscarTipoComunicadorPorId(id);

		return tc;
	}
	
	@POST
	@Path("/Excluir/{id}")
	@Produces("application/json")
	public void excluirTipoComunicador(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		TipoComunicador tc = new FacadeHappyCustomer().BuscarTipoComunicadorPorId(id);
		FacadeHappyCustomer fhc = new FacadeHappyCustomer();
		fhc.ExcluirTipoComunicador(tc);
	}
}