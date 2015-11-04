package mplanweb.music.web.login;

import javax.validation.constraints.Size;

public class UserDAO {
	@Size(min=4, message="���̵� �ۼ��� 4���� �̻� �ۼ� ���մϴ�.")
	private String userid;
	@Size(min=6, message="�н����� �Է½� 6���� �̻� �ۼ� �ٶ��ϴ�.")
	private String passwd;
	@Size(min=2, message="�̸��� 2���� �̻� �ۼ� �ٶ��ϴ�.")
	private String name;
	private String nickname;
	private String phone;
	private String address;
	private int hint;
	private String answer;
	private String email;
	private String comment;
	
	public UserDAO(){
		
	}
	public UserDAO(String userid, String passwd, String name, String email){
		this.userid = userid;
		this.passwd = passwd;
		this.name = name;
		this.email = email;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwsswd() {
		return passwd;
	}
	public void setPwsswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getHint() {
		return hint;
	}
	public void setHint(int hint) {
		this.hint = hint;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	

}
