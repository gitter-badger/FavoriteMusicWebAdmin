package mplanweb.music.web.corp;

import java.io.Serializable;


@SuppressWarnings("serial")
public class CorpCompany implements Serializable {

	public void setMp_corpnum(int mp_corpnum) {
		setMpssnumEncrypt(MusicStringUtil
				.getStringTmsEncryptoAesForInt(mp_corpnum));
		this.mp_corpnum = mp_corpnum;
	}
}