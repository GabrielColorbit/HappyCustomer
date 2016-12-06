package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.facear.crm.dao.AtividadeDAO;
import br.edu.facear.crm.entity.Atividade;
import br.edu.facear.crm.entity.Comunicador;
import br.edu.facear.crm.entity.Ligacao;
import br.edu.facear.facade.FacadeHappyCustomer;

@Path("/restAtividade")
public class AtividadeRestful {

	@GET
	@Path("/listarTodos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Atividade> findAll() throws Exception {

		return (ArrayList<Atividade>) new FacadeHappyCustomer().ListarAtividade();
	}
	@GET
	@Path("/listarAtivos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Atividade> listarAtividadesAtivo() throws Exception {
		return (ArrayList<Atividade>) new FacadeHappyCustomer().ListarAtividadesAtivas();
	}
	@GET
	@Path("/listarAtividadeUsuario/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Atividade> ListarAtividadesUsuario(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		return (ArrayList<Atividade>) new AtividadeDAO().ListarAtividadesUsuario(id);
	}
	

	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	@Produces("application/json")
	@Path("/Salvar")
	public Atividade cadastrarCliente(Atividade atividade) throws Exception {
		// Cadastra se a atividade for nova
		if (atividade.getId() == null) {
			new FacadeHappyCustomer().CadastrarAtividade(atividade);
		}
		// altera atividade já criada
		else {
			ArrayList<Comunicador> comunicadorlist = new ArrayList<Comunicador>();
			
			if(atividade.getComunicadores_atividade() != null){
				for (Comunicador c : atividade.getComunicadores_atividade()) {
					if (c.getId() == null) {// cadastra novos comunicadores
						new FacadeHappyCustomer().CadastrarComunicador(c);
					} else {// salva alterações em comunicador'
						new FacadeHappyCustomer().AlterarComunicador(c);
					}
					comunicadorlist.add(c);
				}
				atividade.setComunicadores_atividade(comunicadorlist);
			}			

			if(atividade.getLigacoes_atividade() != null){
				ArrayList<Ligacao> ligacoes = new ArrayList<Ligacao>();
				for(Ligacao l : atividade.getLigacoes_atividade()){
					if(l.getId() == null){
						l.setContato(atividade.getContato());
						l.setUsuarioresponsavel(atividade.getUsuarioresponsavel());
						l.setEmpresa(atividade.getEmpresa());
						new FacadeHappyCustomer().CadastrarLigacao(l);
					}else{
						new FacadeHappyCustomer().AlterarLigacao(l);
					}
					ligacoes.add(l);
				}
				atividade.setLigacoes_atividade(ligacoes);
			}			
			
			
			new FacadeHappyCustomer().AlterarAtividade(atividade);

		}
		return atividade;

	}

	@GET
	@Path("/Editar/{id}")
	@Produces("application/json")
	public Atividade editarAtividade(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Atividade a = new FacadeHappyCustomer().BuscarAtividadePorId(id);
		return a;
	}

	@POST
	@Path("/Excluir/{id}")
	@Produces("application/json")
	public void excluirAtividade(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Atividade a = new FacadeHappyCustomer().BuscarAtividadePorId(id);
		FacadeHappyCustomer fhc = new FacadeHappyCustomer();
		fhc.ExcluirAtividade(a);
	}
}
