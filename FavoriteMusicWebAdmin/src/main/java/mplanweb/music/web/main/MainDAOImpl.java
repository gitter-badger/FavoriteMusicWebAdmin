package mplanweb.music.web.main;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainDAOImpl implements MainDAO {
	@Autowired
	private SqlSession sqlSession;

	public int selectTotalCountMusic() {
		return sqlSession.selectOne("Query.selectTotalCountMusic" );

	}

	public int selectTotalCountRadio() {
		return sqlSession.selectOne("Query.selectTotalCountRadio");
	}

	public int selectTotalCountToday() {
		return sqlSession.selectOne("Query.selectTotalCountToday");
	}

	public int selectTotalCountMember() {
		return sqlSession.selectOne("Query.selectTotalCountMember");
	}
}
