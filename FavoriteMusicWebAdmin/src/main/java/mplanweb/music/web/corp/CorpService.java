package mplanweb.music.web.corp;

import java.util.List;
import java.util.Map;

public interface CorpService {

	// MV View
	public int mvtotalcount(CorpSearch ssearch);

	public List<CorpLable> selectSsmvview(CorpSearch ssearch);

	public CorpLable viewmv(Map<String, Object> map);

	public int insertmv(CorpLable ssmvview);

	public void deletemv(List<Map<String, Object>> mapList);

	public int updatemv(CorpLable ssmvview);


}
