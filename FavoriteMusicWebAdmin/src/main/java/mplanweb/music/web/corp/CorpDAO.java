package mplanweb.music.web.corp;

import java.util.List;
import java.util.Map;

public interface CorpDAO {

	//Corp View
	public int corptotalcount(CorpSearch corpsearch);

	public List<CorpCompany> selectcorpview(CorpSearch corpsearch);

	public CorpCompany viewcorpview(Map<String, Object> map);

	public int insertcorp(CorpCompany corpcompany);

	public void deletecorp(List<Map<String, Object>> mapList);

	public int updatecorp(CorpCompany corpcompany);
		
	//lable View
	public int labletotalcount(CorpSearch corpsearch);

	public List<CorpLable> selectlableview(CorpSearch corpsearch);

	public CorpLable viewlableview(Map<String, Object> map);

	public int insertlable(CorpLable corplable);

	public void deletelable(List<Map<String, Object>> mapList);

	public int updatelable(CorpLable corplable);
	
	//b2b View
	public int b2btotalcount(CorpSearch corpsearch);

	public List<CorpB2B> selectb2bview(CorpSearch corpsearch);

	public CorpB2B viewb2bview(Map<String, Object> map);

	public int insertb2b(CorpB2B corpb2b);

	public void deleteb2b(List<Map<String, Object>> mapList);

	public int updateb2b(CorpB2B corpb2b);


}
