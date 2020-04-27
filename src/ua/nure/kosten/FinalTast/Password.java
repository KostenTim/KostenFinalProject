package ua.nure.kosten.FinalTast;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {

	public static String md5Coding(String st) {
		MessageDigest messageDigest = null;
		byte[] digest = new byte[0];

		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(st.getBytes());
			digest = messageDigest.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		BigInteger bigInt = new BigInteger(1, digest);
		String md5Hex = bigInt.toString(16);
		while( md5Hex.length() < 32 ){
			md5Hex = "0" + md5Hex;
		}
		return md5Hex;
	}

	public static boolean haveCyrillic(String st) {
		Pattern p = Pattern.compile("[а-яА-ЯёЁы]");
		Matcher m = p.matcher(st);
		while (m.find()) {
			return true;
		} 
		return false;
	}
	
	public static boolean isValidPassword(String st) {
		if (st.length() <=32 && st.length() >=6 && !Password.haveCyrillic(st)) {
			return true;
		}
		return false;
	}
	
	public static boolean isValidLogin(String st) {
		if (st.length() <=32 && st.length() >=5 && !Password.haveCyrillic(st)) {
			return true;
		}
		return false;
	}
}
