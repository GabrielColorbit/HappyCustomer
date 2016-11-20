package br.edu.facear.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.sun.jersey.core.util.Base64;

import br.edu.facear.crm.dao.FotoDAO;
import br.edu.facear.crm.entity.Foto;

@Path("/restFoto")
public class FotoRestful {

	
	@GET
	@Path("/Buscar/{id}")
	@Produces("application/json")
	public Foto buscarFoto(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Foto f = new FotoDAO().BuscarID(id);

		return f;
	}
	@GET 
	@Path("/RetornaImagemBase64/{id}")
	@Produces({MediaType.TEXT_PLAIN})
	public String retornaFotobase64(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Foto f = new FotoDAO().BuscarID(id);

		return new String(Base64.encode(f.getImagem()));
	}
	@GET 
	@Path("/RetornaImagem/{id}")
	@Produces("image/png")
	public Response retornaFoto(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Foto f = new FotoDAO().BuscarID(id);
		
		ResponseBuilder response = Response.ok((	f.getImagem()) );
	    
	    
		 return response.build();
	}	
}