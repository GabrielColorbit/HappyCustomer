package br.edu.facear.resource;

import java.security.MessageDigest;

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
	
	
}	