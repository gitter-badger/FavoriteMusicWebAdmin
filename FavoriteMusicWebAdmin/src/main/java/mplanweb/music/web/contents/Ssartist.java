package mplanweb.music.web.contents;

import java.io.Serializable;



@SuppressWarnings("serial")
public class Ssartist implements Serializable {
	private int mp_anum; // : ?ùå?õê?ÑòÎ≤?
	private String mp_artist; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_content; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_label; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_debut; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_artistimg; // : ?ïÑ?ã∞?ä§?ä∏
	private long mp_artistsize; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_artistorg; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_useyn; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_date;
	private String mpssnumEncrypt;

	public String getMp_date() {
		System.out.println("getMp_date : " + mp_date);
		return mp_date;
	}

	public void setMp_date(String mp_date) {
		System.out.println("setMp_date : " + mp_date);
		this.mp_date = mp_date;
	}

	public int getMp_anum() {
		System.out.println("getMp_anum : " + mp_anum);
		return mp_anum;
	}

	public void setMp_anum(int mp_anum) {

		System.out.println("setMp_anum : " + mp_anum);
		setMpssnumEncrypt(MusicStringUtil
				.getStringTmsEncryptoAesForInt(mp_anum));
		this.mp_anum = mp_anum;
	}

	public String getMp_artist() {

		System.out.println("getMp_artist : " + mp_artist);
		return mp_artist;
	}

	public void setMp_artist(String mp_artist) {

		System.out.println("setMp_artist : " + mp_artist);
		this.mp_artist = mp_artist;
	}

	public String getMp_content() {

		System.out.println("getMp_content : " + mp_content);
		return mp_content;
	}

	public void setMp_content(String mp_content) {

		System.out.println("setMp_content : " + mp_content);
		this.mp_content = mp_content;
	}

	public String getMp_label() {
		System.out.println("getMp_label : " + mp_label);
		return mp_label;
	}

	public void setMp_label(String mp_label) {
		System.out.println("setMp_label : " + mp_label);
		this.mp_label = mp_label;
	}

	public String getMp_debut() {
		System.out.println("getMp_debut : " + mp_debut);
		return mp_debut;
	}

	public void setMp_debut(String mp_debut) {
		System.out.println("setMp_debut : " + mp_debut);
		this.mp_debut = mp_debut;
	}

	public String getMp_artistimg() {
		System.out.println("getMp_artistimg : " + mp_artistimg);
		return mp_artistimg;
	}

	public void setMp_artistimg(String mp_artistimg) {
		System.out.println("setMp_artistimg : " + mp_artistimg);
		this.mp_artistimg = mp_artistimg;
	}

	public long getMp_artistsize() {
		System.out.println("getMp_artistsize : " + mp_artistsize);
		return mp_artistsize;
	}

	public void setMp_artistsize(long mp_artistsize) {
		System.out.println("setMp_artistsize : " + mp_artistsize);
		this.mp_artistsize = mp_artistsize;
	}

	public String getMp_artistorg() {
		System.out.println("getMp_artistorg : " + mp_artistorg);
		return mp_artistorg;
	}

	public void setMp_artistorg(String mp_artistorg) {
		System.out.println("setMp_artistorg : " + mp_artistorg);
		this.mp_artistorg = mp_artistorg;
	}

	public String getMp_useyn() {
		System.out.println("getMp_useyn : " + mp_useyn);
		return mp_useyn;
	}

	public void setMp_useyn(String mp_useyn) {
		System.out.println("setMp_useyn : " + mp_useyn);
		this.mp_useyn = mp_useyn;
	}

	public String getMpssnumEncrypt() {
		System.out.println("getMpssnumEncrypt : " + mpssnumEncrypt);
		return mpssnumEncrypt;
	}

	public void setMpssnumEncrypt(String mpssnumEncrypt) {
		System.out.println("setMpssnumEncrypt : " + mpssnumEncrypt);
		this.mpssnumEncrypt = mpssnumEncrypt;
	} // : Í≥†Ïú†?Ç§ ?ïî?ò∏?ôî
}
