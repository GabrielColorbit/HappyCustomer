package br.com.restful.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.edu.facear.crm.entity.TipoContato;

/**
 * Classe responsavel por conter os metodos rest de acesso ao webservice
 * @author Gabriel
 *
 */

@Path("/tipocontato")
public class ClienteResource {
	@GET
	@Path("/listarTodos")
	@Produces("application/json")
	public ArrayList<TipoContato> listarTodos(){
		ArrayList<TipoContato> result = new ArrayList<TipoContato>();
		
		result.add( new TipoContato(1l,"Name1"));
		result.add( new TipoContato(2l,"Name2"));
		result.add( new TipoContato(3l,"Name3"));

		
		return result;
	}
	
}

