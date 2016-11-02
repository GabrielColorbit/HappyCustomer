package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.facear.crm.entity.Genero;
import br.edu.facear.crm.entity.Status;

@Path("/restCollections")
public class EnumRestful {

	@GET
	@Path("/genders")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Genero> returnGenero() {

		ArrayList<Genero> genderList = new ArrayList<Genero>();
		for (Genero g : Genero.values()) {
			genderList.add(g);
		}
		return genderList;
	}

	@GET
	@Path("/status")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Status> returnStatus() {

		ArrayList<Status> statusList = new ArrayList<Status>();
		for (Status s : Status.values()) {
			statusList.add(s);
		}
		return statusList;
	}
}