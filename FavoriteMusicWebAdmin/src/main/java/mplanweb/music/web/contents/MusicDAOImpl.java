package mplanweb.music.web.contents;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class MusicDAOImpl implements MusicDAO {

	@Autowired
	private SqlSession sqlSession;

	// SSView

	@Override
	public int selecttotalcount(Ssearch ssearch) {
		return sqlSession.selectOne("Test.selecttotalcount", ssearch);

	}

	@Override
	public List<Ssview> selectSsview(Ssearch ssearch) {
		return sqlSession.selectList("Test.selectSsview", ssearch);

	}

	@Override
	public Ssview viewSSview(Map<String, Object> map) {
		return sqlSession.selectOne("Test.viewSSview", map);
	}

	@Override
	public int insertssearch(Ssview ssview) {
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
	public int updatessearch(Ssview ssview) {
		// TODO Auto-generated method stub
		return sqlSession.update("Test.updatessearch", ssview);
	}

	// Album View
	public int albumtotalcount(Ssearch ssearch) {
		return sqlSession.selectOne("Test.albumtotalcount", ssearch);

	}

	public List<SsAlbum> selectalbumview(Ssearch ssearch) {
		return sqlSession.selectList("Test.selectalbumview", ssearch);
	}

	public SsAlbum viewalbumview(Map<String, Object> map) {
		return sqlSession.selectOne("Test.viewalbumview", map);
	}

	public int insertalbum(SsAlbum ssalbum) {
		return sqlSession.insert("Test.insertalbum", ssalbum);
	}

	public void deletealbum(List<Map<String, Object>> mapList) {
		for (Map<String, Object> map : mapList) {
			sqlSession.delete("Test.deletealbum", map);
		}
	}

	public int updatealbum(SsAlbum ssalbum) {
		return sqlSession.update("Test.updatealbum", ssalbum);
	}

	// Artist View

	public int artisttotalcount(Ssearch ssearch) {
		return sqlSession.selectOne("Test.artisttotalcount", ssearch);
	}

	public List<Ssartist> selectartistview(Ssearch ssearch) {
		return sqlSession.selectList("Test.selectartistview", ssearch);
	}

	public Ssartist viewartistview(Map<String, Object> map) {
		return sqlSession.selectOne("Test.viewartistview", map);
	}

	public int insertartist(Ssartist ssartist) {
		return sqlSession.insert("Test.insertartist", ssartist);
	}

	public void deleteartist(List<Map<String, Object>> mapList) {
		for (Map<String, Object> map : mapList) {
			sqlSession.delete("Test.deleteartist", map);
		}
	}

	public int updateartist(Ssartist ssartist) {
		return sqlSession.update("Test.updateartist", ssartist);
	}

	// corp View

	public int corptotalcount(Ssearch ssearch) {
		return sqlSession.selectOne("Test.corptotalcount", ssearch);
	}

	public List<Sscorp> selectcorpview(Ssearch ssearch) {
		return sqlSession.selectList("Test.selectcorpview", ssearch);
	}

	public Sscorp viewcorpview(Map<String, Object> map) {
		return sqlSession.selectOne("Test.viewcorpview", map);
	}

	public int insertcorp(Sscorp sscorp) {
		return sqlSession.insert("Test.insertcorp", sscorp);
	}

	public void deletecorp(List<Map<String, Object>> mapList) {
		for (Map<String, Object> map : mapList) {
			sqlSession.delete("Test.deletecorp", map);
		}
	}

	public int updatecorp(Sscorp sscorp) {
		return sqlSession.update("Test.updatecorp", sscorp);
	}

}
