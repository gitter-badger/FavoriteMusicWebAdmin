package mplanweb.music.web.corp;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CorpLable implements Serializable {

	private int mp_lablenum;
	private String mp_lablename;
	private String mp_lablephone;
	private String mp_lableaddress;
	private String mp_lablebn;
	private String mp_lablecontents;
	private String mp_bizperson;
	private String mp_bizphone;
	private String mp_bizcontents;
	private String mp_useyn;
	private String mp_insertdate;
	private String mp_updatedate;
	private String mpssnumEncrypt;

	public int getMp_lablenum() {
		return mp_lablenum;
	}

	public void setMp_lablenum(int mp_lablenum) {
		setMpssnumEncrypt(CorpStringUtil
				.getStringTmsEncryptoAesForInt(mp_lablenum));
		this.mp_lablenum = mp_lablenum;
	}

	public String getMp_lablename() {
		return mp_lablename;
	}

	public void setMp_lablename(String mp_lablename) {
		this.mp_lablename = mp_lablename;
	}

	public String getMp_lablephone() {
		return mp_lablephone;
	}

	public void setMp_lablephone(String mp_lablephone) {
		this.mp_lablephone = mp_lablephone;
	}

	public String getMp_lableaddress() {
		return mp_lableaddress;
	}

	public void setMp_lableaddress(String mp_lableaddress) {
		this.mp_lableaddress = mp_lableaddress;
	}

	public String getMp_lablebn() {
		return mp_lablebn;
	}

	public void setMp_lablebn(String mp_lablebn) {
		this.mp_lablebn = mp_lablebn;
	}

	public String getMp_lablecontents() {
		return mp_lablecontents;
	}

	public void setMp_lablecontents(String mp_lablecontents) {
		this.mp_lablecontents = mp_lablecontents;
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

}
