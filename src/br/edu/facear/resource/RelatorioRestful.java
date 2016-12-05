package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import br.edu.facear.crm.dao.RelatorioDAO;
import br.edu.facear.crm.entity.AtividadePorEmpresa;
import br.edu.facear.crm.entity.AtividadesPorStatus;
import br.edu.facear.crm.entity.NegocioPorContato;
import br.edu.facear.crm.entity.NegocioPorEmpresa;

@Path("/restRelatorio")
public class RelatorioRestful {

	@GET
	@Path("/AtividadePorEmpresa/{id}")
	@Produces({ MediaType.TEXT_PLAIN})
	@Consumes({ MediaType.TEXT_PLAIN })
	public String AtividadePorEmpresa(@HeaderParam("hash") String md5hashusuario,
						  @PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		AuthenticationService ra = new AuthenticationService();
		ArrayList<AtividadePorEmpresa> apelist = new ArrayList<AtividadePorEmpresa>();
		//valida usuario logado
		String json ="";
 		apelist = new RelatorioDAO().SelectAtividade(id);
 		Gson gson = new Gson();
		json = gson.toJson(apelist);	

		return json;
	}
	@GET
	@Path("/NegocioPorEmpresa")
	@Produces({ MediaType.TEXT_PLAIN})
	@Consumes({ MediaType.TEXT_PLAIN })
	public String NegocioPorEmpresa(@HeaderParam("hash") String md5hashusuario) throws Exception {
		AuthenticationService ra = new AuthenticationService();
		ArrayList<NegocioPorEmpresa> npelist = new ArrayList<NegocioPorEmpresa>();
		String json = "";
		npelist = new RelatorioDAO().ListNegocios();
 		Gson gson = new Gson();
		json = gson.toJson(npelist);		
		return json;
	}

	@GET
	@Path("/NegocioPorContato")
	@Produces({ MediaType.TEXT_PLAIN})
	@Consumes({ MediaType.TEXT_PLAIN })
	public String NegocioPorContato(@HeaderParam("hash") String md5hashusuario) throws Exception {
		AuthenticationService ra = new AuthenticationService();
		ArrayList<NegocioPorContato> npclist = new ArrayList<NegocioPorContato>();
		String json = "";
		npclist  = new RelatorioDAO().ListNegociosPorContato();
 		Gson gson = new Gson();
		json = gson.toJson(npclist );		
		return json;
	}

	@GET
	@Path("/AtividadesPorStatus")
	@Produces({ MediaType.TEXT_PLAIN})
	@Consumes({ MediaType.TEXT_PLAIN })
	public String AtividadesPorStatus(@HeaderParam("hash") String md5hashusuario) throws Exception {
		AuthenticationService ra = new AuthenticationService();
		ArrayList<AtividadesPorStatus> apslist = new ArrayList<AtividadesPorStatus>();
		String json = "";
		apslist  = new RelatorioDAO().AtividadesPorStatus();
 		Gson gson = new Gson();
		json = gson.toJson(apslist );		
		return json;
	}
	
	
	
}