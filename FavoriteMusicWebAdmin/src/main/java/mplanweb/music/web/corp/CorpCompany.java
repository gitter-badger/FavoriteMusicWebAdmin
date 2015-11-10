package mplanweb.music.web.corp;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CorpCompany implements Serializable {
	private int mp_corpnum;
	private String mp_corpname;
	private String mp_corpphone;
	private String mp_corpaddress;
	private String mp_corpbn;
	private String mp_corpcontents;
	private String mp_bizperson;
	private String mp_bizphone;
	private String mp_bizcontents;
	private String mp_useyn;
	private String mp_insertdate;
	private String mp_updatedate;
	private String mpssnumEncrypt;

	public String getMp_corpname() {
		return mp_corpname;
	}

	public void setMp_corpname(String mp_corpname) {
		this.mp_corpname = mp_corpname;
	}

	public String getMp_corpphone() {
		return mp_corpphone;
	}

	public void setMp_corpphone(String mp_corpphone) {
		this.mp_corpphone = mp_corpphone;
	}

	public String getMp_corpaddress() {
		return mp_corpaddress;
	}

	public void setMp_corpaddress(String mp_corpaddress) {
		this.mp_corpaddress = mp_corpaddress;
	}

	public String getMp_corpbn() {
		return mp_corpbn;
	}

	public void setMp_corpbn(String mp_corpbn) {
		this.mp_corpbn = mp_corpbn;
	}

	public String getMp_corpcontents() {
		return mp_corpcontents;
	}

	public void setMp_corpcontents(String mp_corpcontents) {
		this.mp_corpcontents = mp_corpcontents;
	}

	public String getMp_bizperson() {
		return mp_bizperson;
	}

	public void setMp_bizperson(String mp_bizperson) {
		this.mp_bizperson = mp_bizperson;
	}

	public String getMp_bizphone() {
		return mp_bizphone;
	}

	public void setMp_bizphone(String mp_bizphone) {
		this.mp_bizphone = mp_bizphone;
	}

	public String getMp_bizcontents() {
		return mp_bizcontents;
	}

	public void setMp_bizcontents(String mp_bizcontents) {
		this.mp_bizcontents = mp_bizcontents;
	}

	public String getMp_useyn() {
		return mp_useyn;
	}

	public void setMp_useyn(String mp_useyn) {
		this.mp_useyn = mp_useyn;
	}

	public String getMp_insertdate() {
		return mp_insertdate;
	}

	public void setMp_insertdate(String mp_insertdate) {
		this.mp_insertdate = mp_insertdate;
	}

	public String getMp_updatedate() {
		return mp_updatedate;
	}

	public void setMp_updatedate(String mp_updatedate) {
		this.mp_updatedate = mp_updatedate;
	}

	public String getMpssnumEncrypt() {
		return mpssnumEncrypt;
	}

	public void setMpssnumEncrypt(String mpssnumEncrypt) {
		this.mpssnumEncrypt = mpssnumEncrypt;
	}

	public int getMp_corpnum() {
		return mp_corpnum;
	}

	public void setMp_corpnum(int mp_corpnum) {
		setMpssnumEncrypt(CorpStringUtil
				.getStringTmsEncryptoAesForInt(mp_corpnum));
		this.mp_corpnum = mp_corpnum;
	}
}