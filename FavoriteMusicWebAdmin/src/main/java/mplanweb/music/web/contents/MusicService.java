package mplanweb.music.web.contents;

import java.util.List;
import java.util.Map;

public interface MusicService {

	// MV View
	public int mvtotalcount(Ssearch ssearch);

	public List<Ssview> selectSsmvview(Ssearch ssearch);

	public Ssview viewmv(Map<String, Object> map);

	public int insertmv(Ssmvview ssmvview);

	public void deletemv(List<Map<String, Object>> mapList);

	public int updatemv(Ssmvview ssmvview);

	// SSView
	public int selecttotalcount(Ssearch ssearch);

	public List<Ssview> selectSsview(Ssearch ssearch);

	public Ssview viewSSview(Map<String, Object> map);

	public int insertssearch(Ssview ssview);

	public void deletessearch(List<Map<String, Object>> mapList);

	public int updatessearch(Ssview ssview);

	// Album View
	public int albumtotalcount(Ssearch ssearch);

	public List<SsAlbum> selectalbumview(Ssearch ssearch);

	public SsAlbum viewalbumview(Map<String, Object> map);

	public int insertalbum(SsAlbum ssalbum);

	public void deletealbum(List<Map<String, Object>> mapList);

	public int updatealbum(SsAlbum ssalbum);

	// Artist View

	public int artisttotalcount(Ssearch ssearch);

	public List<Ssartist> selectartistview(Ssearch ssearch);

	public Ssartist viewartistview(Map<String, Object> map);

	public int insertartist(Ssartist ssartist);

	public void deleteartist(List<Map<String, Object>> mapList);

	public int updateartist(Ssartist ssartist);

	// corp View

	public int corptotalcount(Ssearch ssearch);

	public List<Sscorp> selectcorpview(Ssearch ssearch);

	public Sscorp viewcorpview(Map<String, Object> map);

	public int insertcorp(Sscorp sscorp);

	public void deletecorp(List<Map<String, Object>> mapList);

	public int updatecorp(Sscorp sscorp);

}
