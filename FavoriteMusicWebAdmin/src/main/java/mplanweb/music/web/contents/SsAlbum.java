package mplanweb.music.web.contents;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SsAlbum implements Serializable {
	private int mp_alnum; // : ?��?��?���?
	private int mp_anum; // : ?��?��?���?
	private String mp_albumtitle;
	private String mp_artist; // : ?��?��?��?��


	public int getMp_anum() {
		return mp_anum;
	}

	public void setMp_anum(int mp_anum) {
		this.mp_anum = mp_anum;
	}
	private String mp_album; // : ?��?��?��?��
	private String mp_content; // : ?��?��?��?��
	private String mp_year; // : ?��?��?��?��
	private String mp_corp; // : ?��?��?��?��
	private String mp_albumimg; // : ?��?��?��?��
	private long mp_albumsize; // : ?��?��?��?��
	private String mp_albumimgorg; // : ?��?��?��?��
	private String mp_useyn; // : ?��?��?��?��
	private String mp_date; // : ?��?��?��?��
	private String mpssnumEncrypt; // : 고유?�� ?��?��?��

	public String getMp_date() {
		return mp_date;
	}

	public void setMp_date(String mp_date) {
		this.mp_date = mp_date;
	}

	public String getMp_albumtitle() {
		return mp_albumtitle;
	}

	public void setMp_albumtitle(String mp_albumtitle) {
		this.mp_albumtitle = mp_albumtitle;
	}

	public int getMp_alnum() {
		return mp_alnum;
	}

	public void setMp_alnum(int mp_alnum) {
		setMpssnumEncrypt(MusicStringUtil
				.getStringTmsEncryptoAesForInt(mp_alnum));
		this.mp_alnum = mp_alnum;
	}


	public String getMp_artist() {
		return mp_artist;
	}

	public void setMp_artist(String mp_artist) {
		this.mp_artist = mp_artist;
	}

	public String getMp_album() {
		return mp_album;
	}

	public void setMp_album(String mp_album) {
		this.mp_album = mp_album;
	}

	public String getMp_content() {
		return mp_content;
	}

	public void setMp_content(String mp_content) {
		this.mp_content = mp_content;
	}

	public String getMp_year() {
		return mp_year;
	}

	public void setMp_year(String mp_year) {
		this.mp_year = mp_year;
	}

	public String getMp_corp() {
		return mp_corp;
	}

	public void setMp_corp(String mp_corp) {
		this.mp_corp = mp_corp;
	}

	public String getMp_albumimg() {
		return mp_albumimg;
	}

	public void setMp_albumimg(String mp_albumimg) {
		this.mp_albumimg = mp_albumimg;
	}

	public long getMp_albumsize() {
		return mp_albumsize;
	}

	public void setMp_albumsize(long mp_albumsize) {
		this.mp_albumsize = mp_albumsize;
	}

	public String getMp_albumimgorg() {
		return mp_albumimgorg;
	}

	public void setMp_albumimgorg(String mp_albumimgorg) {
		this.mp_albumimgorg = mp_albumimgorg;
	}

	public String getMp_useyn() {
		return mp_useyn;
	}

	public void setMp_useyn(String mp_useyn) {
		this.mp_useyn = mp_useyn;
	}

	public String getMpssnumEncrypt() {
		return mpssnumEncrypt;
	}

	public void setMpssnumEncrypt(String mpssnumEncrypt) {
		this.mpssnumEncrypt = mpssnumEncrypt;
	}
}
