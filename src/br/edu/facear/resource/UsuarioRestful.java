package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
<<<<<<< HEAD
import javax.ws.rs.core.Response;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
=======
>>>>>>> 7f1585005b8af0481226dab2231eee3987d7179c

import br.edu.facear.crm.entity.Comunicador;
import br.edu.facear.crm.entity.Telefone;
import br.edu.facear.crm.entity.Usuario;
import br.edu.facear.facade.FacadeHappyCustomer;

@Path("/restUsuario")
public class UsuarioRestful {
	
	@GET
	@Path("/listarTodos")
	@Produces({ MediaType.APPLICATION_JSON })
	public ArrayList<Usuario> findAll() throws Exception {

		return new FacadeHappyCustomer().ListarUsuario();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	@Produces("text/plain")
	@Path("/Salvar")
	public void cadastrarCliente(Usuario usuario) throws Exception {
		
		ArrayList<Telefone> telefonelist = new ArrayList<Telefone>();
		for(Telefone t : usuario.getTelefones_usuario()){
			new FacadeHappyCustomer().CadastrarTelefone(t);
			telefonelist.add(t);
		}
		
		/*ArrayList<Comunicador> comunicadorlist = new ArrayList<Comunicador>();
		for(Comunicador c : usuario.getComunicadores_usuario()){
			new FacadeHappyCustomer().CadastrarComunicador(c);
			comunicadorlist.add(c);
		}
		usuario.setComunicadores_usuario(comunicadorlist);
		*/
		
		usuario.setTelefones_usuario(telefonelist);
		
		
		if(usuario.getId() == null)
			new FacadeHappyCustomer().CadastrarUsuario(usuario);	

		else
			new FacadeHappyCustomer().AlterarUsuario(usuario);
		
		

	}

	@GET
	@Path("/Editar/{id}")
	@Produces("application/json")
	public Usuario editarUsuario(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Usuario u = new FacadeHappyCustomer().BuscarUsuarioPorId(id);

		return u;
	}
	
	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(
			@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail) {
			//transform to byte array
		String uploadedFileLocation = "d://uploaded/"
				+ fileDetail.getFileName();

		// save it
		writeToFile(uploadedInputStream, uploadedFileLocation);

		String output = "File uploaded to : " + uploadedFileLocation;

		return Response.status(200).entity(output).build();

	}

	// save uploaded file to new location
	private void writeToFile(InputStream uploadedInputStream,
			String uploadedFileLocation) {

		try {
			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	
	
}