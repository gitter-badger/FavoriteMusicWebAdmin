package mplanweb.music.web.corp;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorpServiceImpl implements CorpService {

	@Autowired
	private CorpDAO corpDAO;

	// SSView
	@Override
	public int corptotalcount(CorpSearch corpsearch) {
		return corpDAO.corptotalcount(corpsearch);

	}

	@Override
	public List<CorpCompany> selectcorpview(CorpSearch corpsearch) {

		return corpDAO.selectcorpview(corpsearch);
	}

	@Override
	public CorpCompany viewcorpview(Map<String, Object> map) {
		return corpDAO.viewcorpview(map);
	}

	@Override
	public int insertcorp(CorpCompany corpcompany) {
		// TODO Auto-generated method stub
		return corpDAO.insertcorp(corpcompany);
	}

	@Override
	public void deletecorp(List<Map<String, Object>> mapList) {
		// TODO Auto-generated method stub

		corpDAO.deletecorp(mapList);
	}

	@Override
	public int updatecorp(CorpCompany corpcompany) {
		// TODO Auto-generated method stub
		return corpDAO.updatecorp(corpcompany);
	}

	//lable
	@Override
	public int labletotalcount(CorpSearch corpsearch) {
		// TODO Auto-generated method stub
		return corpDAO.corptotalcount(corpsearch);
	}

	@Override
	public List<CorpLable> selectlableview(CorpSearch corpsearch) {
		// TODO Auto-generated method stub
		return corpDAO.selectlableview(corpsearch);
	}

	@Override
	public CorpLable viewlableview(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return corpDAO.viewlableview(map);
	}

	@Override
	public int insertlable(CorpLable corplable) {
		// TODO Auto-generated method stub
		return corpDAO.insertlable(corplable);
	}

	@Override
	public void deletelable(List<Map<String, Object>> mapList) {
		// TODO Auto-generated method stub

		corpDAO.deletelable(mapList);
	}

	@Override
	public int updatelable(CorpLable corplable) {
		// TODO Auto-generated method stub
		return corpDAO.updatelable(corplable);
	}

	
	//b2b
	@Override
	public int b2btotalcount(CorpSearch corpsearch) {
		// TODO Auto-generated method stub
		return corpDAO.corptotalcount(corpsearch);
	}

	@Override
	public List<CorpB2B> selectb2bview(CorpSearch corpsearch) {
		// TODO Auto-generated method stub
		return corpDAO.selectb2bview(corpsearch);
	}

	@Override
	public CorpB2B viewb2bview(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return corpDAO.viewb2bview(map);
	}

	@Override
	public int insertb2b(CorpB2B corpb2b) {
		// TODO Auto-generated method stub
		return corpDAO.insertb2b(corpb2b);
	}

	@Override
	public void deleteb2b(List<Map<String, Object>> mapList) {
		// TODO Auto-generated method stub
		corpDAO.deleteb2b(mapList);
	}

	@Override
	public int updateb2b(CorpB2B corpb2b) {
		// TODO Auto-generated method stub
		return corpDAO.updateb2b(corpb2b);
	}


}
