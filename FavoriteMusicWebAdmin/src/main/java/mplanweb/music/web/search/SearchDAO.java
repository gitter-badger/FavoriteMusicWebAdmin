package mplanweb.music.web.search;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SearchDAO implements SearchService {

	@Autowired
	private SqlSession sqlSession;

	public List<SearchDTO> listall(String artist) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Query.listall", artist);
	}

	public List<MsearchDTO> artistsearch(String result) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Query.artistsearch", result);
	}

	public List<MsearchDTO> albumsearch(String result) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Query.albumsearch", result);
	}

	public List<MsearchDTO> musicsearch(String result) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Query.musicsearch", result);
	}
}
