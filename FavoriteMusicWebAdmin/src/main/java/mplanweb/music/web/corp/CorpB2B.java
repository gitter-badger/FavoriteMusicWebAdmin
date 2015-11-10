package mplanweb.music.web.corp;

import java.io.Serializable;


@SuppressWarnings("serial")
public class CorpB2B implements Serializable {

	private int mp_b2bnum;
	private String mp_b2bname;
	private String mp_b2bphone;
	private String mp_b2baddress;
	private String mp_b2bbn;
	private String mp_b2bcontents;
	private String mp_bizperson;
	private String mp_bizphone;
	private String mp_bizcontents;
	private String mp_useyn;
	private String mp_insertdate;
	private String mp_updatedate;
	private String mpssnumEncrypt;
	public int getMp_b2bnum() {
		return mp_b2bnum;
	}
	public void setMp_b2bnum(int mp_b2bnum) {
		setMpssnumEncrypt(CorpStringUtil
				.getStringTmsEncryptoAesForInt(mp_b2bnum));
		this.mp_b2bnum = mp_b2bnum;
	}
	public String getMp_b2bname() {
		return mp_b2bname;
	}
	public void setMp_b2bname(String mp_b2bname) {
		this.mp_b2bname = mp_b2bname;
	}
	public String getMp_b2bphone() {
		return mp_b2bphone;
	}
	public void setMp_b2bphone(String mp_b2bphone) {
		this.mp_b2bphone = mp_b2bphone;
	}
	public String getMp_b2baddress() {
		return mp_b2baddress;
	}
	public void setMp_b2baddress(String mp_b2baddress) {
		this.mp_b2baddress = mp_b2baddress;
	}
	public String getMp_b2bbn() {
		return mp_b2bbn;
	}
	public void setMp_b2bbn(String mp_b2bbn) {
		this.mp_b2bbn = mp_b2bbn;
	}
	public String getMp_b2bcontents() {
		return mp_b2bcontents;
	}
	public void setMp_b2bcontents(String mp_b2bcontents) {
		this.mp_b2bcontents = mp_b2bcontents;
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
