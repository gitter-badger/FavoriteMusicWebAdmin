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

	// corp
	@Override
	public int corptotalcount(CorpSearch corpsearch) {
		return sqlSession.selectOne("mplancorp.corptotalcount", corpsearch);

	}

	@Override
	public List<CorpCompany> selectcorpview(CorpSearch corpsearch) {
		return sqlSession.selectList("mplancorp.selectcorpview", corpsearch);

	}

	@Override
	public CorpCompany viewcorpview(Map<String, Object> map) {
		return sqlSession.selectOne("mplancorp.viewcorpview", map);
	}

	@Override
	public int insertcorp(CorpCompany corpcompany) {
		// TODO Auto-generated method stub
		return sqlSession.insert("mplancorp.insertcorp", corpcompany);
	}

	@Override
	public void deletecorp(List<Map<String, Object>> mapList) {
		for (Map<String, Object> map : mapList) {
			sqlSession.delete("mplancorp.deletecorp", map);
		}
	}

	@Override
	public int updatecorp(CorpCompany corpcompany) {
		// TODO Auto-generated method stub
		return sqlSession.update("mplancorp.updatecorp", corpcompany);
	}

	// lable
	@Override
	public int labletotalcount(CorpSearch corpsearch) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mplancorp.labletotalcount", corpsearch);
	}

	@Override
	public List<CorpLable> selectlableview(CorpSearch corpsearch) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mplancorp.selectlableview", corpsearch);
	}

	@Override
	public CorpLable viewlableview(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mplancorp.viewlableview", map);
	}

	@Override
	public int insertlable(CorpLable corplable) {
		// TODO Auto-generated method stub
		return sqlSession.insert("mplancorp.insertlable", corplable);
	}

	@Override
	public void deletelable(List<Map<String, Object>> mapList) {
		// TODO Auto-generated method stub
		for (Map<String, Object> map : mapList) {
			sqlSession.delete("mplancorp.deletelable", map);
		}
	}

	@Override
	public int updatelable(CorpLable corplable) {
		// TODO Auto-generated method stub
		return sqlSession.update("mplancorp.updatelable", corplable);
	}

	// b2b
	@Override
	public int b2btotalcount(CorpSearch corpsearch) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mplancorp.b2btotalcount", corpsearch);
	}

	@Override
	public List<CorpB2B> selectb2bview(CorpSearch corpsearch) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mplancorp.selectb2bview", corpsearch);
	}

	@Override
	public CorpB2B viewb2bview(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mplancorp.viewb2bview", map);
	}

	@Override
	public int insertb2b(CorpB2B corpb2b) {
		// TODO Auto-generated method stub
		return sqlSession.insert("mplancorp.insertb2b", corpb2b);
	}

	@Override
	public void deleteb2b(List<Map<String, Object>> mapList) {
		for (Map<String, Object> map : mapList) {
			sqlSession.delete("mplancorp.deleteb2b", map);
		}

	}

	@Override
	public int updateb2b(CorpB2B corpb2b) {
		// TODO Auto-generated method stub
		return sqlSession.update("mplancorp.updateb2b", corpb2b);
	}

}
