package mplanweb.music.web.contents;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicServiceImpl implements MusicService {

	@Autowired
	private MusicDAO musicDAO;

	// SSView
	@Override
	public int selecttotalcount(Ssearch ssearch) {
		return musicDAO.selecttotalcount(ssearch);

	}

	@Override
	public List<Ssview> selectSsview(Ssearch ssearch) {

		return musicDAO.selectSsview(ssearch);
	}

	@Override
	public Ssview viewSSview(Map<String, Object> map) {
		return musicDAO.viewSSview(map);
	}

	@Override
	public int insertssearch(Ssview ssview) {
		// TODO Auto-generated method stub
		return musicDAO.insertssearch(ssview);
	}

	@Override
	public void deletessearch(List<Map<String, Object>> mapList) {
		// TODO Auto-generated method stub

		musicDAO.deletessearch(mapList);
	}

	@Override
	public int updatessearch(Ssview ssview) {
		// TODO Auto-generated method stub
		return musicDAO.updatessearch(ssview);
	}

	// Album View
	public int albumtotalcount(Ssearch ssearch) {
		return musicDAO.albumtotalcount(ssearch);

	}

	public List<SsAlbum> selectalbumview(Ssearch ssearch) {
		return musicDAO.selectalbumview(ssearch);
	}

	public SsAlbum viewalbumview(Map<String, Object> map) {
		return musicDAO.viewalbumview(map);
	}

	public int insertalbum(SsAlbum ssalbum) {
		return musicDAO.insertalbum(ssalbum);
	}

	public void deletealbum(List<Map<String, Object>> mapList) {
		musicDAO.deletealbum(mapList);
	}

	public int updatealbum(SsAlbum ssalbum) {
		return musicDAO.updatealbum(ssalbum);
	}

	// Artist View
	public int artisttotalcount(Ssearch ssearch) {
		return musicDAO.artisttotalcount(ssearch);
	}

	public List<Ssartist> selectartistview(Ssearch ssearch) {
		return musicDAO.selectartistview(ssearch);
	}

	public Ssartist viewartistview(Map<String, Object> map) {
		return musicDAO.viewartistview(map);
	}

	public int insertartist(Ssartist ssartist) {
		return musicDAO.insertartist(ssartist);
	}

	public void deleteartist(List<Map<String, Object>> mapList) {
		musicDAO.deleteartist(mapList);
	}

	public int updateartist(Ssartist ssartist) {
		return musicDAO.updateartist(ssartist);
	}

	
	// mv View
	@Override
	public int mvtotalcount(Ssearch ssearch) {
		// TODO Auto-generated method stub
		return musicDAO.mvtotalcount(ssearch);
	}

	@Override
	public List<Ssmvview> selectSsmvview(Ssearch ssearch) {
		// TODO Auto-generated method stub
		return musicDAO.selectSsmvview(ssearch);
	}

	@Override
	public Ssmvview viewmv(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return musicDAO.viewmv(map);
	}

	@Override
	public int insertmv(Ssmvview ssmvview) {
		// TODO Auto-generated method stub
		return musicDAO.insertmv(ssmvview);
	}

	@Override
	public void deletemv(List<Map<String, Object>> mapList) {
		// TODO Auto-generated method stub
		musicDAO.deletemv(mapList);
		
	}

	@Override
	public int updatemv(Ssmvview ssmvview) {
		// TODO Auto-generated method stub
		System.out.println("MusicService Update");
		return musicDAO.updatemv(ssmvview);
	}

}
