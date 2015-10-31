package mplanweb.music.web.member;

import org.springframework.security.access.prepost.PreAuthorize;

public interface MemberService {

	// 회원가입
	public void adduser(Member member);

	// 회원권한
	public void addgroup(String mp_userid, String authority);

	// 로그인
	public Member login(String mp_userid, String mp_pwd);

	// 정보수정
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	public int editAccount(Member member);

	// 비밀번호 변경
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	public int changepwd(String currentPasswd, String newPasswd, String mp_userid);

	// 탈퇴
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER') and #member.userid == principal.username")
	public void drop(Member member);

	// 회원 찾기
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public Member getUser(String mp_userid);
}
