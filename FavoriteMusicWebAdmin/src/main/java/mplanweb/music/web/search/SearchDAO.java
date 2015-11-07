package mplanweb.music.web.search;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SearchDAO implements SearchService {

	@Autowired
	private SqlSession sqlSession;

	public List<SearchDTO> listall(String result) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Query.listall", result);
	}
	

}
