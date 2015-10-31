package mplanweb.music.web.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	//@Autowired
	private MemberMapper membermapper;

	// 회원가입
	public void adduser(Member member) {

		membermapper.insert(member);
	}

	// 회원권한
	public void addgroup(String mp_userid, String authority) {
		membermapper.insertAuthority(mp_userid, authority);
	}

	// 로그인
	
	public Member login(String mp_userid, String mp_pwd) {
		return membermapper.login(mp_userid, mp_pwd);

	}

	// 정보수정
	public int editAccount(Member member) {
		return membermapper.update(member);

	}

	// 비밀번호 변경
	public int changepwd(String currentPasswd, String newPasswd, String mp_userid) {
		return membermapper.updatePasswd(currentPasswd, newPasswd, mp_userid);

	}

	// 탈퇴
	public void drop(Member member) {
		membermapper.deleteAuthority(member.getMp_userid());
		membermapper.delete(member);
	}

	// 회원 찾기
	public Member getUser(String userid) {
		return membermapper.selectOne(userid);

	}

}
