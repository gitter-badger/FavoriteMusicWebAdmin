package mplanweb.music.web.search;

import java.util.List;

public interface SearchService {
	
	public List<SearchDTO> artistall(String result);
	public List<SearchDTO> albumall(String result);
	public List<SearchDTO> titleall(String result);
}
