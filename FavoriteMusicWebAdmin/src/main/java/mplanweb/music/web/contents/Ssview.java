package mplanweb.music.web.contents;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Ssview implements Serializable {

	private String mpssnumEncrypt; // : Í≥†Ïú†?Ç§ ?ïî?ò∏?ôî
	private int mp_mpnum; // : ?ïÑ?ã∞?ä§?ä∏
	private int mp_num; // : ?ïÑ?ã∞?ä§?ä∏
	private int mp_anum; // : ?ùå?õê?ÑòÎ≤?
	private int mp_alnum; //æŸπ¸≥—πˆ
	private String mp_titlemusic; // ≈∏¿Ã∆≤∞Ó ¿Øπ´
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

	public String getMp_titlemusic() {
		return mp_titlemusic;
	}

	public void setMp_titlemusic(String mp_titlemusic) {
		this.mp_titlemusic = mp_titlemusic;
	}

	private String mp_artist; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_title; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_album; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_lyric; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_year; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_corp; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_label; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_genre1; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_genre2; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_etc; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_img; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_320k; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_192k; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_mvk; // : ?ïÑ?ã∞?ä§?ä∏
	private long mp_imgsize; // : ?ïÑ?ã∞?ä§?ä∏
	private long mp_320size; // : ?ïÑ?ã∞?ä§?ä∏
	private long mp_192size; // : ?ïÑ?ã∞?ä§?ä∏
	private long mp_mvsize; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_imgo; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_320ko; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_192ko; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_mvko; // : ?ïÑ?ã∞?ä§?ä∏

	private String mp_age; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_useyn; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_open_date; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_insert_date; // : ?ïÑ?ã∞?ä§?ä∏

	
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

	public long getMp_imgsize() {
	
		return mp_imgsize;
	}

	public void setMp_imgsize(long mp_imgsize) {

		this.mp_imgsize = mp_imgsize;
	}

	public long getMp_320size() {

		return mp_320size;
	}

	public void setMp_320size(long mp_320size) {
	
		this.mp_320size = mp_320size;
	}

	public long getMp_192size() {

		return mp_192size;
	}

	public void setMp_192size(long mp_192size) {
	
		this.mp_192size = mp_192size;
	}

	public String getMp_imgo() {

		return mp_imgo;
	}

	public void setMp_imgo(String mp_imgo) {
	
		this.mp_imgo = mp_imgo;
	}

	public String getMp_320ko() {
	
		return mp_320ko;
	}

	public void setMp_320ko(String mp_320ko) {
		
		this.mp_320ko = mp_320ko;
	}

	public String getMp_192ko() {
	
		return mp_192ko;
	}

	public void setMp_192ko(String mp_192ko) {
		
		this.mp_192ko = mp_192ko;
	}

	public int getMp_mpnum() {
	
		return mp_mpnum;
	}

	public void setMp_mpnum(int mp_mpnum) {

		setMpssnumEncrypt(MusicStringUtil
				.getStringTmsEncryptoAesForInt(mp_mpnum));
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

	public String getMpssnumEncrypt() {
	
		return mpssnumEncrypt;
	}

	public void setMpssnumEncrypt(String mpssnumEncrypt) {

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
