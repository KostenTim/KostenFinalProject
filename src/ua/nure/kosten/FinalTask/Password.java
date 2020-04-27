package ua.nure.kosten.FinalTask;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is used for password processing.
 * 
 * @author t.Kosten
 * 
 */

public class Password {

	private static final String REGULAR_EXPRESSION = "[а-яА-ЯёЁы]";

	/**
	 * This method encodes an MD5 encoded string.
	 * @param st
	 * 			String
	 * @return encoded string
	 */
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
	
	/**
	 * The method checks if the string contains Cyrillic.
	 * @param st
	 * 			String
	 * @return "true" - contains
	 * 		   "false" - does not contain
	 */
	public static boolean haveCyrillic(String st) {
		Pattern p = Pattern.compile(REGULAR_EXPRESSION);
		Matcher m = p.matcher(st);
		while (m.find()) {
			return true;
		} 
		return false;
	}
	
	/**
	 * Method checks password validity.
	 * @param st
	 * 			Password
	 * @return "true" - valid
	 * 		   "false" - not contain
	 */
	public static boolean isValidPassword(String st) {
		if (st.length() <= 32 && st.length() >= 6 && !Password.haveCyrillic(st)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Method checks login validity.
	 * @param st
	 * 			Login
	 * @return "true" - valid
	 * 		   "false" - not contain
	 */
	public static boolean isValidLogin(String st) {
		if (st.length() <= 32 && st.length() >= 5 && !Password.haveCyrillic(st)) {
			return true;
		}
		return false;
	}
}
