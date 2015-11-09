package mplanweb.music.web.corp;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class CorpDAOImpl implements CorpDAO {

	@Autowired
	private SqlSession sqlSession;

	// SSView

	@Override
	public int selecttotalcount(CorpSearch ssearch) {
		return sqlSession.selectOne("Test.selecttotalcount", ssearch);

	}

	@Override
	public List<CorpB2B> selectSsview(CorpSearch ssearch) {
		return sqlSession.selectList("Test.selectSsview", ssearch);

	}

	@Override
	public CorpB2B viewSSview(Map<String, Object> map) {
		return sqlSession.selectOne("Test.viewSSview", map);
	}

	@Override
	public int insertssearch(CorpB2B ssview) {
		// TODO Auto-generated method stub
		return sqlSession.insert("Test.insertssearch", ssview);
	}

	@Override
	public void deletessearch(List<Map<String, Object>> mapList) {
		for (Map<String, Object> map : mapList) {
			sqlSession.delete("Test.deletessearch", map);
		}
	}

	@Override
	public int updatessearch(CorpB2B ssview) {
		// TODO Auto-generated method stub
		return sqlSession.update("Test.updatessearch", ssview);
	}



}
