package mplanweb.music.web.corp;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorpServiceImpl implements CorpService {

	@Autowired
	private CorpDAO musicDAO;

	// SSView
	@Override
	public int selecttotalcount(CorpSearch ssearch) {
		return musicDAO.selecttotalcount(ssearch);

	}

	@Override
	public List<CorpB2B> selectSsview(CorpSearch ssearch) {

		return musicDAO.selectSsview(ssearch);
	}

	@Override
	public CorpB2B viewSSview(Map<String, Object> map) {
		return musicDAO.viewSSview(map);
	}

	@Override
	public int insertssearch(CorpB2B ssview) {
		// TODO Auto-generated method stub
		return musicDAO.insertssearch(ssview);
	}

	@Override
	public void deletessearch(List<Map<String, Object>> mapList) {
		// TODO Auto-generated method stub

		musicDAO.deletessearch(mapList);
	}

	@Override
	public int updatessearch(CorpB2B ssview) {
		// TODO Auto-generated method stub
		return musicDAO.updatessearch(ssview);
	}


}
