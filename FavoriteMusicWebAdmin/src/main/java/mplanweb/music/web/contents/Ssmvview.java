package mplanweb.music.web.contents;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Ssmvview implements Serializable {
	private String mpssnumEncrypt; 
	private int mp_anum;
	private int mp_alnum;
	private int mp_mpnum;
	private String mp_artist;
	private String mp_title; // : ?•„?‹°?Š¤?Š¸
	private String mp_album; // : ?•„?‹°?Š¤?Š¸
	private String mp_year; // : ?•„?‹°?Š¤?Š¸
	private String mp_corp; // : ?•„?‹°?Š¤?Š¸
	private String mp_label; // : ?•„?‹°?Š¤?Š¸
	private String mp_img; // : ?•„?‹°?Š¤?Š¸
	private long mp_imgsize; // : ?•„?‹°?Š¤?Š¸
	private String mp_imgo; // : ?•„?‹°?Š¤?Š¸
	private String mp_mvk; // : ?•„?‹°?Š¤?Š¸
	private long mp_mvsize; // : ?•„?‹°?Š¤?Š¸
	private String mp_mvko; // : ?•„?‹°?Š¤?Š¸
	
	private int mp_listen; // : ?•„?‹°?Š¤?Š¸
	private int mp_charthit; // : ?•„?‹°?Š¤?Š¸
	private int mp_chartorderhit; // : ?•„?‹°?Š¤?Š¸
	private int mp_genrehit; // : ?•„?‹°?Š¤?Š¸
	private int mp_genreorderhit; // : ?•„?‹°?Š¤?Š¸
	private int mp_age; // : ?•„?‹°?Š¤?Š¸
	private int mp_favorite; // : ?•„?‹°?Š¤?Š¸
	private String mp_useyn; // : ?•„?‹°?Š¤?Š¸
	private String mp_date; // : ?•„?‹°?Š¤?Š¸
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
		setMpssnumEncrypt(MusicStringUtil
				.getStringTmsEncryptoAesForInt(mp_alnum));
		this.mp_alnum = mp_alnum;
	}
	public int getMp_mpnum() {
		return mp_mpnum;
	}
	public void setMp_mpnum(int mp_mpnum) {
		this.mp_mpnum = mp_mpnum;
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
	public int getMp_listen() {
		return mp_listen;
	}
	public void setMp_listen(int mp_listen) {
		this.mp_listen = mp_listen;
	}
	public int getMp_charthit() {
		return mp_charthit;
	}
	public void setMp_charthit(int mp_charthit) {
		this.mp_charthit = mp_charthit;
	}
	public int getMp_chartorderhit() {
		return mp_chartorderhit;
	}
	public void setMp_chartorderhit(int mp_chartorderhit) {
		this.mp_chartorderhit = mp_chartorderhit;
	}
	public int getMp_genrehit() {
		return mp_genrehit;
	}
	public void setMp_genrehit(int mp_genrehit) {
		this.mp_genrehit = mp_genrehit;
	}
	public int getMp_genreorderhit() {
		return mp_genreorderhit;
	}
	public void setMp_genreorderhit(int mp_genreorderhit) {
		this.mp_genreorderhit = mp_genreorderhit;
	}
	public int getMp_age() {
		return mp_age;
	}
	public void setMp_age(int mp_age) {
		this.mp_age = mp_age;
	}
	public int getMp_favorite() {
		return mp_favorite;
	}
	public void setMp_favorite(int mp_favorite) {
		this.mp_favorite = mp_favorite;
	}
	public String getMp_useyn() {
		return mp_useyn;
	}
	public void setMp_useyn(String mp_useyn) {
		this.mp_useyn = mp_useyn;
	}
	public String getMp_date() {
		return mp_date;
	}
	public void setMp_date(String mp_date) {
		this.mp_date = mp_date;
	}

	
}
