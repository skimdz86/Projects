package it.mdz.todolist.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class CryptoUtil {

	public static String encodePassword(String passw) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(passw.getBytes("UTF-8"));
		byte[] digest = md.digest();

		return Hex.encodeHexString(digest);
	}
}
