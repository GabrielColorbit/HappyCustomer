package br.edu.facear.resource;

import java.security.MessageDigest;
import java.util.ArrayList;

import br.edu.facear.crm.entity.Usuario;
import br.edu.facear.facade.FacadeHappyCustomer;

public class AuthenticationService {
	
	
	public String getmd5(String hash) throws Exception{
		MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(hash.getBytes());

	    byte byteData[] = md.digest();

	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < byteData.length; i++)
	        sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		
		return sb.toString();
	}
	
	
	public Usuario RequestAuthentication( String md5hashusuario) throws Exception {
		if(md5hashusuario != null ){

			ArrayList<Usuario> usuarioslist = new FacadeHappyCustomer().ListarUsuario();
			for(Usuario u : usuarioslist){
					
				String uhash = u.getLogin()+u.getSenha();
				String md5u = new AuthenticationService().getmd5(uhash);
				
				if(md5hashusuario.equals(md5u)){
					return  u;	
				}

			}

		}
		
		return new Usuario();
	}
	
}	