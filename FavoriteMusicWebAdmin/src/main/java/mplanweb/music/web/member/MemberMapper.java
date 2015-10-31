package mplanweb.music.web.member;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.prepost.PreAuthorize;

public interface MemberMapper {

	public void insert(Member member);
	
	public void insertAuthority(@Param("mp_userid") String mp_userid, @Param("authority") String authority);
	
	public Member login(@Param("mp_userid") String mp_userid, @Param("mp_pwd") String mp_pwd);
	
	public int update(Member member);
	
	public int updatePasswd(@Param("currentPasswd") String currentPasswd, @Param("newPasswd") String newPasswd,
			@Param("mp_userid") String mp_userid);
	
	public void delete(Member member);
	
	public void deleteAuthority(@Param("mp_userid") String mp_userid);
	
	public Member selectOne(String mp_userid);
	
	
	





	

	

	

	
}
