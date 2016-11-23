package br.edu.facear.resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
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
import br.edu.facear.crm.entity.Comunicador;
import br.edu.facear.crm.entity.Contato;
import br.edu.facear.crm.entity.Empresa;
import br.edu.facear.crm.entity.Foto;
import br.edu.facear.crm.entity.Telefone;
import br.edu.facear.crm.entity.Usuario;
import br.edu.facear.facade.FacadeHappyCustomer;

@Path("/restUsuario")
public class UsuarioRestful {
	
	
	@GET
    @Path("/autenticacao")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getUserById(@HeaderParam("authorization") String authString){
        RestAuthenticationFilter raf = new RestAuthenticationFilter();
        if(!raf.isUserAuthenticated(authString)){
            return "{\"error\":\"User not authenticated\"}";
        }
        return "{\"success\":\"User authenticated!!\"}";
    }
	
	
	@GET
	@Path("/listarTodos")
	@Produces({ MediaType.APPLICATION_JSON , MediaType.TEXT_PLAIN})
	public ArrayList<Usuario> findAll() throws Exception {

		return new FacadeHappyCustomer().ListarUsuario();
		
	}

	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	@Produces("text/plain")
	@Path("/Salvar")
	public void cadastrarCliente(Usuario usuario) throws Exception {
		//Cadastra se o usuário for novo
		if (usuario.getId() == null){
				ArrayList<Telefone> telefonelist = new ArrayList<Telefone>();
				for(Telefone t : usuario.getTelefones_usuario()){
					new FacadeHappyCustomer().CadastrarTelefone(t);
					telefonelist.add(t);
				}
				usuario.setTelefones_usuario(telefonelist);

				ArrayList<Comunicador> comunicadorlist = new ArrayList<Comunicador>();
				for(Comunicador c : usuario.getComunicadores_usuario()){
					new FacadeHappyCustomer().CadastrarComunicador(c);
					comunicadorlist.add(c);
				}
				usuario.setComunicadores_usuario(comunicadorlist);

				new FacadeHappyCustomer().CadastrarUsuario(usuario);
		}
		//altera usuário já criado
		else{
			ArrayList<Telefone> telefonelist = new ArrayList<Telefone>();
			for(Telefone t : usuario.getTelefones_usuario()){
				if(t.getId() == null){
					new FacadeHappyCustomer().CadastrarTelefone(t);
				}else{
					new FacadeHappyCustomer().AlterarTelefone(t);
				}
				telefonelist.add(t);
			}
			usuario.setTelefones_usuario(telefonelist);

			ArrayList<Comunicador> comunicadorlist = new ArrayList<Comunicador>();
			for(Comunicador c : usuario.getComunicadores_usuario()){
				if(c.getId() == null){//cadastra novos comunicadores
					new FacadeHappyCustomer().CadastrarComunicador(c);
				}else{//salva alterações em comunicador'
					new FacadeHappyCustomer().AlterarComunicador(c);
				}
				comunicadorlist.add(c);
			}
			usuario.setComunicadores_usuario(comunicadorlist);

			new FacadeHappyCustomer().AlterarUsuario(usuario);


		}

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