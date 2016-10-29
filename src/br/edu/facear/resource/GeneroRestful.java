package br.edu.facear.resource;

import java.util.ArrayList;
import java.util.EnumSet;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.facear.crm.entity.Genero;

@Path("/restGenero")
public class GeneroRestful {

	
	@GET
	@Path("/listarTodos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
   public ArrayList<Genero> returnGenero(){
		
	
		ArrayList<Genero> genderList = new ArrayList<Genero>();
		for(Genero g : Genero.values()) {
			genderList.add(g);
		}		
		return genderList;
   }

}
