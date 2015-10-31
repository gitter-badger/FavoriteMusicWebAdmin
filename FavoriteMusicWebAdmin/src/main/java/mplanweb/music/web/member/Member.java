package mplanweb.music.web.member;

public class Member {
	private String mp_userid; // 아이디
	private String mp_pwd; // 패스워드
	private String mp_name; // 이름
	private String mp_nickname; // 닉네임
	private String mp_email; // 이메일
	private String mp_email_useyn; // 이메일 동의
	private String mp_mobile; // 모바일
	private String mp_mailaddress; // 우편주소
	private String mp_houseaddress; // 동이름
	private String mp_etcaddress; // 기타주소
	private String mp_img; // 이미지
	private long mp_imgsize; // 사이즈
	private String mp_imgo; // 오리지널
	private String mp_useyn;
	
	public Member() {

	}

	public Member(String mp_userid, String mp_pwd) {
		this.mp_userid = mp_userid;
		this.mp_pwd = mp_pwd;
	}

	public Member(String mp_userid, String mp_pwd, String mp_name, String mp_nickname,
			String mp_email, String mp_email_useyn, String mp_mobile,
			String mp_mailaddress, String mp_houseaddress, String mp_etcaddress,
			String mp_img, long mp_imgsize, String mp_imgo) {
		this.mp_userid = mp_userid;
		this.mp_pwd = mp_pwd;
		this.mp_name = mp_name;
		this.mp_nickname = mp_nickname;
		this.mp_email_useyn = mp_email_useyn;
		this.mp_mobile = mp_mobile;
		this.mp_mailaddress = mp_mailaddress;
		this.mp_houseaddress = mp_houseaddress;
		this.mp_etcaddress = mp_etcaddress;
		this.mp_img = mp_img;
		this.mp_imgsize = mp_imgsize;
		this.mp_imgo = mp_imgo;
	}

	public String getMp_userid() {
		return mp_userid;
	}

	public void setMp_userid(String mp_userid) {
		this.mp_userid = mp_userid;
	}

	public String getMp_pwd() {
		return mp_pwd;
	}

	public void setMp_pwd(String mp_pwd) {
		this.mp_pwd = mp_pwd;
	}

	public String getMp_name() {
		return mp_name;
	}

	public void setMp_name(String mp_name) {
		this.mp_name = mp_name;
	}

	public String getMp_nickname() {
		return mp_nickname;
	}

	public void setMp_nickname(String mp_nickname) {
		this.mp_nickname = mp_nickname;
	}

	public String getMp_email() {
		return mp_email;
	}

	public void setMp_email(String mp_email) {
		this.mp_email = mp_email;
	}

	public String getMp_email_useyn() {
		return mp_email_useyn;
	}

	public void setMp_email_useyn(String mp_email_useyn) {
		this.mp_email_useyn = mp_email_useyn;
	}

	public String getMp_mobile() {
		return mp_mobile;
	}

	public void setMp_mobile(String mp_mobile) {
		this.mp_mobile = mp_mobile;
	}

	public String getMp_mailaddress() {
		return mp_mailaddress;
	}

	public void setMp_mailaddress(String mp_mailaddress) {
		this.mp_mailaddress = mp_mailaddress;
	}

	public String getMp_houseaddress() {
		return mp_houseaddress;
	}

	public void setMp_houseaddress(String mp_houseaddress) {
		this.mp_houseaddress = mp_houseaddress;
	}

	public String getMp_etcaddress() {
		return mp_etcaddress;
	}

	public void setMp_etcaddress(String mp_etcaddress) {
		this.mp_etcaddress = mp_etcaddress;
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

	public String getMp_useyn() {
		return mp_useyn;
	}

	public void setMp_useyn(String mp_useyn) {
		this.mp_useyn = mp_useyn;
	}
}