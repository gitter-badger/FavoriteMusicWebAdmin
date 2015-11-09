package mplanweb.music.web.corp;

import java.util.List;
import java.util.Map;

public interface CorpDAO {

	// MV View
		public int corptotalcount(CorpSearch ssearch);

		public List<CorpLable> selectcorpview(CorpSearch ssearch);

		public CorpLable viewcorpview(Map<String, Object> map);

		public int insertcorp(CorpLable ssmvview);

		public void deletecorp(List<Map<String, Object>> mapList);

		public int updatecorp(CorpLable ssmvview);
		
		


}
