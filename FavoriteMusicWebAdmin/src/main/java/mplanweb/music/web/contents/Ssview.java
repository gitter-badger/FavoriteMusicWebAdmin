package mplanweb.music.web.contents;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Ssview implements Serializable {

	private String mpssnumEncrypt; // : ê³ ìœ ?‚¤ ?•”?˜¸?™”
	private int mp_mpnum; // : ?•„?‹°?Š¤?Š¸
	private int mp_num; // : ?•„?‹°?Š¤?Š¸
	private String mp_artist; // : ?•„?‹°?Š¤?Š¸
	private String mp_title; // : ?•„?‹°?Š¤?Š¸
	private String mp_album; // : ?•„?‹°?Š¤?Š¸
	private String mp_lyric; // : ?•„?‹°?Š¤?Š¸
	private String mp_year; // : ?•„?‹°?Š¤?Š¸
	private String mp_corp; // : ?•„?‹°?Š¤?Š¸
	private String mp_label; // : ?•„?‹°?Š¤?Š¸
	private String mp_genre1; // : ?•„?‹°?Š¤?Š¸
	private String mp_genre2; // : ?•„?‹°?Š¤?Š¸
	private String mp_etc; // : ?•„?‹°?Š¤?Š¸
	private String mp_img; // : ?•„?‹°?Š¤?Š¸
	private String mp_320k; // : ?•„?‹°?Š¤?Š¸
	private String mp_192k; // : ?•„?‹°?Š¤?Š¸
	private long mp_imgsize; // : ?•„?‹°?Š¤?Š¸
	private long mp_320size; // : ?•„?‹°?Š¤?Š¸
	private long mp_192size; // : ?•„?‹°?Š¤?Š¸
	private String mp_imgo; // : ?•„?‹°?Š¤?Š¸
	private String mp_320ko; // : ?•„?‹°?Š¤?Š¸
	private String mp_192ko; // : ?•„?‹°?Š¤?Š¸
	private String mp_age; // : ?•„?‹°?Š¤?Š¸
	private String mp_useyn; // : ?•„?‹°?Š¤?Š¸
	private String mp_open_date; // : ?•„?‹°?Š¤?Š¸
	private String mp_insert_date; // : ?•„?‹°?Š¤?Š¸

	public long getMp_imgsize() {
		System.out.println("getMp_imgsize : " + mp_imgsize);
		return mp_imgsize;
	}

	public void setMp_imgsize(long mp_imgsize) {
		System.out.println("setMp_imgsize : " + mp_imgsize);
		this.mp_imgsize = mp_imgsize;
	}

	public long getMp_320size() {
		System.out.println("getMp_320size : " + mp_320size);
		return mp_320size;
	}

	public void setMp_320size(long mp_320size) {
		System.out.println("setMp_320size : " + mp_320size);
		this.mp_320size = mp_320size;
	}

	public long getMp_192size() {
		System.out.println("getMp_192size : " + mp_192size);
		return mp_192size;
	}

	public void setMp_192size(long mp_192size) {
		System.out.println("setMp_192size : " + mp_192size);
		this.mp_192size = mp_192size;
	}

	public String getMp_imgo() {
		System.out.println("getMp_imgo : " + mp_imgo);
		return mp_imgo;
	}

	public void setMp_imgo(String mp_imgo) {
		System.out.println("setMp_imgo : " + mp_imgo);
		this.mp_imgo = mp_imgo;
	}

	public String getMp_320ko() {
		System.out.println("getMp_320ko : " + mp_320ko);
		return mp_320ko;
	}

	public void setMp_320ko(String mp_320ko) {
		System.out.println("setMp_320ko : " + mp_320ko);
		this.mp_320ko = mp_320ko;
	}

	public String getMp_192ko() {
		System.out.println("getMp_192ko : " + mp_192ko);
		return mp_192ko;
	}

	public void setMp_192ko(String mp_192ko) {
		System.out.println("setMp_192ko : " + mp_192ko);
		this.mp_192ko = mp_192ko;
	}

	public int getMp_mpnum() {
		System.out.println("getMp_mpnum : " + mp_mpnum);
		return mp_mpnum;
	}

	public void setMp_mpnum(int mp_mpnum) {
		System.out.println("setMp_mpnum : " + mp_mpnum);
		setMpssnumEncrypt(MusicStringUtil
				.getStringTmsEncryptoAesForInt(mp_mpnum));
		this.mp_mpnum = mp_mpnum;
	}

	public String getMp_artist() {
		System.out.println("getMp_artist : " + mp_artist);
		return mp_artist;
	}

	public void setMp_artist(String mp_artist) {
		System.out.println("setMp_artist : " + mp_artist);
		this.mp_artist = mp_artist;
	}

	public String getMp_title() {
		System.out.println("getMp_title : " + mp_title);
		return mp_title;
	}

	public void setMp_title(String mp_title) {
		System.out.println("setMp_title : " + mp_title);
		this.mp_title = mp_title;
	}

	public String getMp_album() {
		System.out.println("getMp_album : " + mp_album);
		return mp_album;
	}

	public void setMp_album(String mp_album) {
		System.out.println("setMp_album : " + mp_album);
		this.mp_album = mp_album;
	}

	public String getMp_year() {
		System.out.println("getMp_year : " + mp_year);
		return mp_year;
	}

	public void setMp_year(String mp_year) {
		System.out.println("setMp_year : " + mp_year);
		this.mp_year = mp_year;
	}

	public String getMp_useyn() {
		System.out.println("getMp_useyn : " + mp_useyn);
		return mp_useyn;
	}

	public void setMp_useyn(String mp_useyn) {
		System.out.println("setMp_useyn : " + mp_useyn);
		this.mp_useyn = mp_useyn;
	}

	public String getMp_insert_date() {
		System.out.println("getMp_insert_date : " + mp_insert_date);
		return mp_insert_date;
	}

	public void setMp_insert_date(String mp_insert_date) {
		System.out.println("setMp_insert_date : " + mp_insert_date);
		this.mp_insert_date = mp_insert_date;
	}

	public String getMpssnumEncrypt() {
		System.out.println("getMpssnumEncrypt : " + mpssnumEncrypt);
		return mpssnumEncrypt;
	}

	public void setMpssnumEncrypt(String mpssnumEncrypt) {
		System.out.println("setMpssnumEncrypt : " + mpssnumEncrypt);
		this.mpssnumEncrypt = mpssnumEncrypt;
	}

	public int getMp_num() {
		return mp_num;
	}

	public void setMp_num(int mp_num) {
		this.mp_num = mp_num;
	}

	public String getMp_lyric() {
		return mp_lyric;
	}

	public void setMp_lyric(String mp_lyric) {
		this.mp_lyric = mp_lyric;
	}

	public String getMp_corp() {
		return mp_corp;
	}

	public void setMp_corp(String mp_corp) {
		this.mp_corp = mp_corp;
	}

	public String getMp_label() {
		return mp_label;
	}

	public void setMp_label(String mp_label) {
		this.mp_label = mp_label;
	}

	public String getMp_genre1() {
		return mp_genre1;
	}

	public void setMp_genre1(String mp_genre1) {
		this.mp_genre1 = mp_genre1;
	}

	public String getMp_genre2() {
		return mp_genre2;
	}

	public void setMp_genre2(String mp_genre2) {
		this.mp_genre2 = mp_genre2;
	}

	public String getMp_etc() {
		return mp_etc;
	}

	public void setMp_etc(String mp_etc) {
		this.mp_etc = mp_etc;
	}

	public String getMp_img() {
		return mp_img;
	}

	public void setMp_img(String mp_img) {
		this.mp_img = mp_img;
	}

	public String getMp_320k() {
		return mp_320k;
	}

	public void setMp_320k(String mp_320k) {
		this.mp_320k = mp_320k;
	}

	public String getMp_192k() {
		return mp_192k;
	}

	public void setMp_192k(String mp_192k) {
		this.mp_192k = mp_192k;
	}

	public String getMp_age() {
		return mp_age;
	}

	public void setMp_age(String mp_age) {
		this.mp_age = mp_age;
	}

	public String getMp_open_date() {
		return mp_open_date;
	}

	public void setMp_open_date(String mp_open_date) {
		this.mp_open_date = mp_open_date;
	}
}
