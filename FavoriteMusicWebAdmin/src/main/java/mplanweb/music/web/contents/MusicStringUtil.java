package mplanweb.music.web.contents;

public class MusicStringUtil {

	private MusicStringUtil() {
	}

	private static final String AES_KEY = "123456790ykb1234";

	public static String getTmsEncryptoAesForString(String str) {
		String result = "";
		try {
			if (str != null && !str.equals("")) {
				result = MusicEncryptionUtil.encrypto(str, AES_KEY);
			}
		} catch (Exception e) {
			result = null;
		}
		return result;
	}

	public static String getTmsDecryptoAesForString(String str) {
		String result = "";
		try {
			if (str != null && !str.equals("")) {
				result = MusicEncryptionUtil.decrypto(str, AES_KEY);
			}
		} catch (Exception e) {
			result = null;
		}
		return result;
	}

	public static String getStringTmsEncryptoAesForInt(int itr) {
		String result = "";
		try {
			String str = Integer.toString(itr);
			if (str != null && !str.equals("")) {
				result = MusicEncryptionUtil.encrypto(str, AES_KEY);
			}
		} catch (Exception e) {
			result = "-1";
		}
		return result;
	}

	public static int getTmsDecryptoAesForInt(String str) {
		String result = "";
		try {
			if (str != null && !str.equals("")) {
				result = MusicEncryptionUtil.decrypto(str, AES_KEY);
			}
		} catch (Exception e) {
			result = "-1";
		}
		int a = Integer.parseInt(result);
		System.out.println("Aes   : " + a);
		return Integer.parseInt(result);
	}

	public static String getEncrypto(String str) {
		String result = "";
		try {
			if (str != null && !str.equals("")) {
				result = MusicEncryptionUtil.encryptSHA256(str);
			}
		} catch (Exception e) {
			result = null;
		}
		return result;
	}

	public static String replace(String sourceStr, String findStr,
			String replaceStr) {
		if (sourceStr == null) {
			return "";
		}
		int i = 0;
		StringBuffer stringbuffer = new StringBuffer();
		for (int j = sourceStr.indexOf(findStr, i); j >= 0; j = sourceStr
				.indexOf(findStr, i)) {
			stringbuffer.append(sourceStr.substring(i, j));
			stringbuffer.append(replaceStr);
			i = j + findStr.length();
		}

		if (i <= sourceStr.length()) {
			stringbuffer.append(sourceStr.substring(i, sourceStr.length()));
		}
		return stringbuffer.toString();
	}

	public static boolean checkLogin(String sessionValue) {
		boolean resultVal = true;
		if (sessionValue == null || sessionValue.equals("")) {
			resultVal = false;
		}
		return resultVal;
	}
}
