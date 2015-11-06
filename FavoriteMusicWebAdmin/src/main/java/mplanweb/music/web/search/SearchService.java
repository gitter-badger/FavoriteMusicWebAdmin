package mplanweb.music.web.search;

import java.util.List;

public interface SearchService {
	
	public List<SearchDTO> listall(String artist);
	
	public List<MsearchDTO> artistsearch(String result);
	
	public List<MsearchDTO> albumsearch(String result);
	
	public List<MsearchDTO> musicsearch(String result);

}
