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
import net.sf.json.JSONObject;

@Path("/restRelatorio")
public class RelatorioRestful {

	@GET
	@Path("/AtividadePorEmpresa/{id}")
	@Produces({ MediaType.TEXT_PLAIN})
	@Consumes({ MediaType.TEXT_PLAIN })
	public String findAll(@HeaderParam("hash") String md5hashusuario,
						  @PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		AuthenticationService ra = new AuthenticationService();
		ArrayList<AtividadePorEmpresa> apelist = new ArrayList<AtividadePorEmpresa>();
		//valida usuario logado
//		Usuario u = new AuthenticationService().RequestAuthentication(md5hashusuario);
//		if(u.getId() != null){
//			if(u.getTipousuario().getNome().equals("Administrador") ){
		 		apelist = new RelatorioDAO().SelectAtividade(id);
		 		Gson gson = new Gson();
				String json = gson.toJson(apelist);	
					 
				
				
//			}
//		}
		return json;
	}


}
