package it.crevu.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class PasswordEncoder {

	public static String encodePassword(String passw) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(passw.getBytes("UTF-8"));
		byte[] digest = md.digest();
		
		return Hex.encodeHexString(digest);
	}
	
	
	
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		System.out.println(PasswordEncoder.encodePassword("invisibme_kmanjnds"));
	}
}
