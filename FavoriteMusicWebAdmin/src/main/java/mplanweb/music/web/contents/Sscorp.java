package mplanweb.music.web.contents;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Sscorp implements Serializable {
	private int mp_corpnum; // : ?ùå?õê?ÑòÎ≤?
	private String mp_corpname; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_number; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_address; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_contents; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_person; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_phone; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_useyn; // : ?ïÑ?ã∞?ä§?ä∏
	private String mp_date;
	private String mpssnumEncrypt;
	public String getMp_date() {
		return mp_date;
	}

	public void setMp_date(String mp_date) {
		this.mp_date = mp_date;
	}



	public int getMp_corpnum() {
		return mp_corpnum;
	}

	public void setMp_corpnum(int mp_corpnum) {
		setMpssnumEncrypt(MusicStringUtil
				.getStringTmsEncryptoAesForInt(mp_corpnum));
		this.mp_corpnum = mp_corpnum;
	}

	public String getMp_corpname() {
		return mp_corpname;
	}

	public void setMp_corpname(String mp_corpname) {
		this.mp_corpname = mp_corpname;
	}

	public String getMp_number() {
		return mp_number;
	}

	public void setMp_number(String mp_number) {
		this.mp_number = mp_number;
	}

	public String getMp_address() {
		return mp_address;
	}

	public void setMp_address(String mp_address) {
		this.mp_address = mp_address;
	}

	public String getMp_contents() {
		return mp_contents;
	}

	public void setMp_contents(String mp_contents) {
		this.mp_contents = mp_contents;
	}

	public String getMp_person() {
		return mp_person;
	}

	public void setMp_person(String mp_person) {
		this.mp_person = mp_person;
	}

	public String getMp_phone() { 
		return mp_phone;
	}

	public void setMp_phone(String mp_phone) {
		this.mp_phone = mp_phone;
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