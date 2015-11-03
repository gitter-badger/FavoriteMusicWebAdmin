package mplanweb.music.web.contents;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * ?•”?˜¸?šŒ ì²˜ë¦¬ ?œ ?‹¸
 * 
 * @author ykkim
 * 
 */
public class MusicEncryptionUtil {
	
	private MusicEncryptionUtil() { }

	/**
	 * hex to byte[] : 16ì§„ìˆ˜ ë¬¸ì?—´?„ ë°”ì´?Š¸ ë°°ì—´ë¡? ë³??™˜?•œ?‹¤.
	 * 
	 * @param hex
	 *            hex string
	 * @return
	 */
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

	/**
	 * byte[] to hex : unsigned byte(ë°”ì´?Š¸) ë°°ì—´?„ 16ì§„ìˆ˜ ë¬¸ì?—´ë¡? ë°”ê¾¼?‹¤.
	 * 
	 * @param ba
	 *            byte[]
	 * @return
	 */
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

	/**
	 * AES ë°©ì‹?œ¼ë¡? ?–‘ë°©í–¥ ?•”?˜¸?™”(?‚¤?Š” 16byte ?•„?ˆ˜, ?˜ˆ : 00000000001234)
	 * 
	 * @param plaintext
	 * @param sKey
	 *            - 16byte ?•„?ˆ˜, ?˜ˆ : 00000000001234
	 * @return
	 */
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

	/**
	 * AES ë°©ì‹?œ¼ë¡? ë³µí˜¸?™”(?‚¤?Š” 16byte ?•„?ˆ˜, ?˜ˆ : 00000000001234)
	 * 
	 * @param encrypted
	 * @param sKey
	 *            - 16byte ?•„?ˆ˜, ?˜ˆ : 00000000001234
	 * @return
	 */
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

	/**
	 * MD5 -> Hexa?˜•?‹?œ¼ë¡? ?‹¨ë°©í–¥ ?•”?˜¸?™” (ë³µí˜¸?™” ë¶ˆê?)
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String getMD5Hexa(String str) throws Exception {
		MessageDigest md = null;
		md = MessageDigest.getInstance("MD5");
		return getHexa(md.digest(str.getBytes()));
	}

	/**
	 * Hexa?˜•?‹?œ¼ë¡? ë¦¬í„´
	 * 
	 * @param b
	 * @return
	 */
	private static String getHexa(byte[] b) {
		StringBuffer sb = new StringBuffer(b.length * 2);
		for (int i = 0; i < b.length; i++) {
			int v = b[i] < 0 ? (int) b[i] + 0x100 : (int) b[i]; // ?Œ?ˆ˜ë¥? ?–‘?ˆ˜ë¡? ë³??™˜ //
			// (int)b[i]+256??
			// ê°™ë‹¤.
			String s = Integer.toHexString(v); // 16ì§„ìˆ˜ë¡?
			if (s.length() == 1)
				sb.append('0'); // ?•œ?ë¦¬ë©´ ?•?— 0?„ ë¶™ì—¬ì¤??‹¤.
			sb.append(s);
		}
		return sb.toString();
	}

	//

	/**
	 * ë¬¸ì?—´?„ SHA-256 ë°©ì‹?œ¼ë¡? ?‹¨ë°©í–¥ ?•”?˜¸?™”
	 * 
	 * @param input
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
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

	/**
	 * ë¬¸ì?—´?„ SHA-512 ë°©ì‹?œ¼ë¡? ?‹¨ë°©í–¥ ?•”?˜¸?™”
	 * 
	 * @param input
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
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
