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
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.IOUtils;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import br.edu.facear.crm.dao.CrmException;
import br.edu.facear.crm.dao.FotoDAO;
import br.edu.facear.crm.entity.Comunicador;
import br.edu.facear.crm.entity.Contato;
import br.edu.facear.crm.entity.Foto;
import br.edu.facear.crm.entity.Telefone;
import br.edu.facear.facade.FacadeHappyCustomer;

@Path("/restContato")
public class ContatoRestful {

	@GET
	@Path("/listarTodos")
	@Produces({ MediaType.APPLICATION_JSON })
	public ArrayList<Contato> findAll() throws Exception {

		return (ArrayList<Contato>) new FacadeHappyCustomer().ListarContato();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	@Produces("text/plain")
	@Path("/Salvar")
	public void cadastrarCliente(Contato contato) throws Exception {
		// Cadastra se o contato for novo
		if (contato.getId() == null) {
			
			if(contato.getTelefones_contato() != null){
				ArrayList<Telefone> telefonelist = new ArrayList<Telefone>();
				for (Telefone t : contato.getTelefones_contato()) {
					new FacadeHappyCustomer().CadastrarTelefone(t);
					telefonelist.add(t);
				}
				contato.setTelefones_contato(telefonelist);
			}

			if(contato.getComunicadores_contato() != null){
				ArrayList<Comunicador> comunicadorlist = new ArrayList<Comunicador>();
				for (Comunicador c : contato.getComunicadores_contato()) {
					new FacadeHappyCustomer().CadastrarComunicador(c);
					comunicadorlist.add(c);
				}
				contato.setComunicadores_contato(comunicadorlist);
			}
//			ArrayList<Contato> contatos_empresa = new ArrayList<Contato>();
//			for (Contato c : empresa.getContatos()) {
//				contatos_empresa.add(c);
//			}
//			empresa.setContatos(contatos_empresa);

			new FacadeHappyCustomer().CadastrarContato(contato);
		}
		// altera contato já criado
		else {
			
			if(contato.getTelefones_contato() != null){
				ArrayList<Telefone> telefonelist = new ArrayList<Telefone>();
				for (Telefone t : contato.getTelefones_contato()) {
					if (t.getId() == null) {
						new FacadeHappyCustomer().CadastrarTelefone(t);
					} else {
						new FacadeHappyCustomer().AlterarTelefone(t);
					}
					telefonelist.add(t);
				}
				contato.setTelefones_contato(telefonelist);
			}

			if(contato.getComunicadores_contato() != null){
				ArrayList<Comunicador> comunicadorlist = new ArrayList<Comunicador>();
				for (Comunicador c : contato.getComunicadores_contato()) {
					if (c.getId() == null) {// cadastra novos comunicadores
						new FacadeHappyCustomer().CadastrarComunicador(c);
					} else {// salva alterações em comunicador'
						new FacadeHappyCustomer().AlterarComunicador(c);
					}
					comunicadorlist.add(c);
				}
				contato.setComunicadores_contato(comunicadorlist);
			}
//			ArrayList<Contato> contatos_empresa = new ArrayList<Contato>();
//			for (Contato c : empresa.getContatos()) {
//				contatos_empresa.add(c);
//			}
//			empresa.setContatos(contatos_empresa);

			new FacadeHappyCustomer().AlterarContato(contato);

		}

	}


	@GET
	@Path("/Editar/{id}")
	@Produces("application/json")
	public Contato editarContato(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Contato c = new FacadeHappyCustomer().BuscarContatoPorId(id);

		return c;
	}

	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	// @Produces(MediaType.TEXT_PLAIN)
	// @Produces("image/png")
	@Produces("application/json")
	public Foto uploadFile(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail) throws CrmException {
		// transform to byte array

		String uploadedFileLocation = "C://HappyCustomer/Contatos/Imagens/" + fileDetail.getFileName();

		// save it
		Foto foto = writeToFile(uploadedInputStream, uploadedFileLocation);

		return foto;

	}

	// save uploaded file to new location
	private Foto writeToFile(InputStream uploadedInputStream, String uploadedFileLocation) throws CrmException {
		Foto foto = new Foto();

		try {
			byte[] ibytes = IOUtils.toByteArray(uploadedInputStream);
			System.out.println(ibytes);
			foto.setImagem(ibytes);
			FotoDAO fdao = new FotoDAO();
			fdao.Cadastrar(foto);

			// old saving
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
	public void excluirContato(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Contato c = new FacadeHappyCustomer().BuscarContatoPorId(id);
		FacadeHappyCustomer fhc = new FacadeHappyCustomer();
		fhc.ExcluirContato(c);
	}
}