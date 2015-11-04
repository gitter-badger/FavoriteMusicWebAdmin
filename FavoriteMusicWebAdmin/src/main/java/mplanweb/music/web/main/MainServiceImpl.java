package mplanweb.music.web.main;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	private MainDAO maindao;

	public int selectTotalCountMusic() {
		return maindao.selectTotalCountMusic();

	}

	public int selectTotalCountRadio() {
		return maindao.selectTotalCountRadio();
	}

	public int selectTotalCountToday() {
		return maindao.selectTotalCountToday();
	}

	public int selectTotalCountMember() {
		return maindao.selectTotalCountMember();
	}
}
