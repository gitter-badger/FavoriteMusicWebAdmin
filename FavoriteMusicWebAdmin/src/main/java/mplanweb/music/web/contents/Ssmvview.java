package mplanweb.music.web.contents;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Ssmvview implements Serializable {
	private String mpssnumEncrypt;
	private int mp_anum;
	private int mp_alnum;
	private int mp_mpnum;
	private int mp_mvnum;

	private String mp_artist;
	private String mp_title; // : ?•„?‹°?Š¤?Š¸
	private String mp_album; // : ?•„?‹°?Š¤?Š¸
	private String mp_year; // : ?•„?‹°?Š¤?Š¸
	private String mp_corp; // : ?•„?‹°?Š¤?Š¸
	private String mp_label; // : ?•„?‹°?Š¤?Š¸

	private String mp_content; // : ?•„?‹°?Š¤?Š¸
	private String mp_genre1; // : ?•„?‹°?Š¤?Š¸
	private String mp_genre2; // : ?•„?‹°?Š¤?Š¸
	private String mp_age; // : ?•„?‹°?Š¤?Š¸
	private String mp_useyn; // : ?•„?‹°?Š¤?Š¸
	private String mp_insert_date;
	private String mp_img; // : ?•„?‹°?Š¤?Š¸
	private long mp_imgsize; // : ?•„?‹°?Š¤?Š¸
	private String mp_imgo; // : ?•„?‹°?Š¤?Š¸
	private String mp_mvk; // : ?•„?‹°?Š¤?Š¸
	private long mp_mvsize; // : ?•„?‹°?Š¤?Š¸
	private String mp_mvko; // : ?•„?‹°?Š¤?Š¸
	private String mp_release;
	public String getMp_release() {
		return mp_release;
	}

	public void setMp_release(String mp_release) {
		this.mp_release = mp_release;
	}

	public String getMpssnumEncrypt() {
		return mpssnumEncrypt;
	}

	public void setMpssnumEncrypt(String mpssnumEncrypt) {
		this.mpssnumEncrypt = mpssnumEncrypt;
	}

	public int getMp_anum() {
		return mp_anum;
	}

	public void setMp_anum(int mp_anum) {
		this.mp_anum = mp_anum;
	}

	public int getMp_alnum() {
		return mp_alnum;
	}

	public void setMp_alnum(int mp_alnum) {
		this.mp_alnum = mp_alnum;
	}

	public int getMp_mpnum() {
		return mp_mpnum;
	}

	public void setMp_mpnum(int mp_mpnum) {
		this.mp_mpnum = mp_mpnum;
	}

	public int getMp_mvnum() {
		return mp_mvnum;
	}

	public void setMp_mvnum(int mp_mvnum) {
		setMpssnumEncrypt(MusicStringUtil
				.getStringTmsEncryptoAesForInt(mp_mvnum));
		this.mp_mvnum = mp_mvnum;
	}

	public String getMp_artist() {
		return mp_artist;
	}

	public void setMp_artist(String mp_artist) {
		this.mp_artist = mp_artist;
	}

	public String getMp_title() {
		return mp_title;
	}

	public void setMp_title(String mp_title) {
		this.mp_title = mp_title;
	}

	public String getMp_album() {
		return mp_album;
	}

	public void setMp_album(String mp_album) {
		this.mp_album = mp_album;
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

	public String getMp_label() {
		return mp_label;
	}

	public void setMp_label(String mp_label) {
		this.mp_label = mp_label;
	}

	public String getMp_content() {
		return mp_content;
	}

	public void setMp_content(String mp_content) {
		this.mp_content = mp_content;
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

	public String getMp_age() {
		return mp_age;
	}

	public void setMp_age(String mp_age) {
		this.mp_age = mp_age;
	}

	public String getMp_useyn() {
		return mp_useyn;
	}

	public void setMp_useyn(String mp_useyn) {
		this.mp_useyn = mp_useyn;
	}


	public String getMp_insert_date() {
		return mp_insert_date;
	}

	public void setMp_insert_date(String mp_insert_date) {
		this.mp_insert_date = mp_insert_date;
	}

	public String getMp_img() {
		return mp_img;
	}

	public void setMp_img(String mp_img) {
		this.mp_img = mp_img;
	}

	public long getMp_imgsize() {
		return mp_imgsize;
	}

	public void setMp_imgsize(long mp_imgsize) {
		this.mp_imgsize = mp_imgsize;
	}

	public String getMp_imgo() {
		return mp_imgo;
	}

	public void setMp_imgo(String mp_imgo) {
		this.mp_imgo = mp_imgo;
	}

	public String getMp_mvk() {
		return mp_mvk;
	}

	public void setMp_mvk(String mp_mvk) {
		this.mp_mvk = mp_mvk;
	}

	public long getMp_mvsize() {
		return mp_mvsize;
	}

	public void setMp_mvsize(long mp_mvsize) {
		this.mp_mvsize = mp_mvsize;
	}

	public String getMp_mvko() {
		return mp_mvko;
	}

	public void setMp_mvko(String mp_mvko) {
		this.mp_mvko = mp_mvko;
	}

}
