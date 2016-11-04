package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.facear.crm.entity.Produto;
import br.edu.facear.facade.FacadeHappyCustomer;

@Path("/restProduto")
public class ProdutoRestful {
	
	@GET
	@Path("/listarTodos")
	@Produces({ MediaType.APPLICATION_JSON })
	public ArrayList<Produto> findAll() throws Exception {

		return (ArrayList<Produto>) new FacadeHappyCustomer().ListarProduto();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	@Produces("text/plain")
	@Path("/Salvar")
	public void cadastrarCliente(Produto produto) throws Exception {
		if (produto.getId() == null)
			new FacadeHappyCustomer().CadastrarProduto(produto);
		else
			new FacadeHappyCustomer().AlterarProduto(produto);
	}

	@GET
	@Path("/Editar/{id}")
	@Produces("application/json")
	public Produto editarProduto(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Produto p = new FacadeHappyCustomer().BuscarProdutoPorId(id);

		return p;
	}
	
	@POST
	@Path("/Excluir/{id}")
	@Produces("application/json")
	public void excluirProduto(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Produto p = new FacadeHappyCustomer().BuscarProdutoPorId(id);
		FacadeHappyCustomer fhc = new FacadeHappyCustomer();
		fhc.ExcluirProduto(p);
	}
}