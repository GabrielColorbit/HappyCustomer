package br.edu.facear.resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataParam;

import com.sun.jersey.core.header.FormDataContentDisposition;

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
    @Path("/file")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public Response uploadFile(
            @FormDataParam("file") InputStream fileInputStream,
            @FormDataParam("file") FormDataContentDisposition fileMetaData) throws Exception {
        try {
            int read = 0;
            byte[] bytes = new byte[1024];
            File file = new File(fileMetaData.getFileName());
            System.out.println("Upload File Path : "+file.getAbsolutePath());
            OutputStream out = new FileOutputStream(file);
            while ((read = fileInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            throw (e);
        }
        return Response.ok("Data uploaded successfully !!").build();
    }	
	
	
	
}