package mplanweb.music.web.login;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class MainDaoImpl extends SqlSessionDaoSupport implements MainDAO{

	@Override
	public String getUserPwd(String userid) {
		// TODO Auto-generated method stub
		return (String)getSqlSession().selectOne("mplanweb.music.web.admin.getUserPwd", userid);
	}
	

}
