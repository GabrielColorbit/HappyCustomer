package br.edu.facear.resource;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.IOUtils;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import br.edu.facear.crm.dao.CrmException;
import br.edu.facear.crm.dao.FotoDAO;
import br.edu.facear.crm.entity.Usuario;
import br.edu.facear.crm.entity.Foto;
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
		
//		ArrayList<Telefone> telefonelist = new ArrayList<Telefone>();
//		for(Telefone t : usuario.getTelefones_usuario()){
//			new FacadeHappyCustomer().CadastrarTelefone(t);
//			telefonelist.add(t);
//		}
//		
//		usuario.setTelefones_usuario(telefonelist);
		
		
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
//	@Produces(MediaType.TEXT_PLAIN)
//	@Produces("image/png")
	@Produces("application/json")
	public Foto  uploadFile(
			@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail) throws CrmException {
			//transform to byte array
		
		
	 
		 
		String uploadedFileLocation = "C://HappyCustomer/Usuarios/Imagens/" + fileDetail.getFileName();

		// save it
		Foto foto = writeToFile(uploadedInputStream, uploadedFileLocation);
		
		
		
		
	    return foto;

	}

	// save uploaded file to new location
	private Foto writeToFile(InputStream uploadedInputStream,
			String uploadedFileLocation) throws CrmException {
		Foto foto = new Foto();
		      
        
		try {
			byte[] ibytes = IOUtils.toByteArray(uploadedInputStream);
			System.out.println(ibytes);
			foto.setImagem(ibytes);
			FotoDAO fdao = new FotoDAO();
			fdao.Cadastrar(foto);
			

			
			
			//old saving
			OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
			
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
		return foto;

	}
	
	@POST
	@Path("/Excluir/{id}")
	@Produces("application/json")
	public void excluirUsuario(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Usuario u = new FacadeHappyCustomer().BuscarUsuarioPorId(id);
		FacadeHappyCustomer fhc = new FacadeHappyCustomer();
		fhc.ExcluirUsuario(u);
	}
	
}