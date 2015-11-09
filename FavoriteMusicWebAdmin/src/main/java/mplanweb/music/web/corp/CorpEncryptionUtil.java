package mplanweb.music.web.corp;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CorpEncryptionUtil {
	
	private CorpEncryptionUtil() { }
	private static byte[] hexToByteArray(String hex) {
		if (hex == null || hex.length() == 0) {
			return null;
		}
		byte[] ba = new byte[hex.length() / 2];
		for (int i = 0; i < ba.length; i++) {
			ba[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
		}
		return ba;
	}

	private static String byteArrayToHex(byte[] ba) {
		if (ba == null || ba.length == 0) {
			return null;
		}
		StringBuffer sb = new StringBuffer(ba.length * 2);
		String hexNumber;
		for (int x = 0; x < ba.length; x++) {
			hexNumber = "0" + Integer.toHexString(0xff & ba[x]);

			sb.append(hexNumber.substring(hexNumber.length() - 2));
		}
		return sb.toString();
	}

	public static String encrypto(String plaintext, String sKey) throws Exception {
		if (sKey.length() != 16)
			return plaintext;
		String resultStr = "";
		SecretKeySpec skeySpec = new SecretKeySpec(sKey.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encrypted = cipher.doFinal(plaintext.getBytes());
		resultStr = byteArrayToHex(encrypted);
		return resultStr;

	}

	public static String decrypto(String encrypted, String sKey) throws Exception {
		if (sKey.length() != 16)
			return encrypted;
		String resultStr = "";
		SecretKeySpec skeySpec = new SecretKeySpec(sKey.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		byte[] original = cipher.doFinal(hexToByteArray(encrypted));
		resultStr = new String(original);
		return resultStr;
	}

	public static String getMD5Hexa(String str) throws Exception {
		MessageDigest md = null;
		md = MessageDigest.getInstance("MD5");
		return getHexa(md.digest(str.getBytes()));
	}

	private static String getHexa(byte[] b) {
		StringBuffer sb = new StringBuffer(b.length * 2);
		for (int i = 0; i < b.length; i++) {
			int v = b[i] < 0 ? (int) b[i] + 0x100 : (int) b[i]; // ?Œ?ˆ˜ë¥? ?–‘?ˆ˜ë¡? ë³??™˜ //
			// (int)b[i]+256??
			// ê°™ë‹¤.
			String s = Integer.toHexString(v); // 16ì§„ìˆ˜ë¡?
			if (s.length() == 1)
				sb.append('0'); // ?•œ?žë¦¬ë©´ ?•ž?— 0?„ ë¶™ì—¬ì¤??‹¤.
			sb.append(s);
		}
		return sb.toString();
	}
	public static String encryptSHA256(String input) throws NoSuchAlgorithmException {
		String output = "";
		StringBuffer sb = new StringBuffer();
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(input.getBytes());
		byte[] msgb = md.digest();
		for (int i = 0; i < msgb.length; i++) {
			byte temp = msgb[i];
			String str = Integer.toHexString(temp & 0xFF);
			while (str.length() < 2) {
				str = "0" + str;
			}
			str = str.substring(str.length() - 2);
			sb.append(str);
		}
		output = sb.toString();
		return output;
	}

	public static String encryptSHA512(String input) throws NoSuchAlgorithmException {
		String output = "";
		StringBuffer sb = new StringBuffer();
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(input.getBytes());
		byte[] msgb = md.digest();
		for (int i = 0; i < msgb.length; i++) {
			byte temp = msgb[i];
			String str = Integer.toHexString(temp & 0xFF);
			while (str.length() < 2) {
				str = "0" + str;
			}
			str = str.substring(str.length() - 2);
			sb.append(str);
		}
		output = sb.toString();
		return output;
	}
}
