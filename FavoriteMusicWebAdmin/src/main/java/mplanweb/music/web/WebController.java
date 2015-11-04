package mplanweb.music.web;

import java.util.Locale;

import mplanweb.music.web.contents.Ssearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class WebController {

	private static final Logger logger = LoggerFactory
			.getLogger(WebController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	// index Page
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Main(Locale locale, Model model) {
		logger.info("Site ==> IndexPage : ", locale);
		return "/admin/index";
	}
	
	// admin main page
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String action(Locale locale, Model model) {
		logger.info("IndexPage ==> MainPage : ", locale);

		return "/admin/main/main";
	}
	
	
	// Contents Page
	// Lable main page
	@RequestMapping(value = "/lable", method = RequestMethod.GET)
	public String Lable(Locale locale, Model model) {
		logger.info("MainPage ==> LablePage : ", locale);

		return "/admin/contents/lable";
	}
	// Artist main page
	@RequestMapping(value = "/artist", method = RequestMethod.GET)
	public String Artist(Locale locale, Model model) {
		logger.info("MainPage ==> ArtistPage : ", locale);

		return "/admin/contents/artist";
	}
	// Album main page
	@RequestMapping(value = "/album", method = RequestMethod.GET)
	public String Album(Locale locale, Model model) {
		logger.info("MainPage ==> AlbumPage : ", locale);

		return "/admin/contents/album";
	}
	// Music main page
	@RequestMapping(value = "/music", method = RequestMethod.GET)
	public String Music(Locale locale, Model model) {
		logger.info("MainPage ==> MusicPage : ", locale);

		return "/admin/contents/music";
	}
	// MusicVideo main page
	@RequestMapping(value = "/musicvideo", method = RequestMethod.GET)
	public String MusicVideo(Locale locale, Model model) {
		logger.info("MainPage ==> MusicVideoPage : ", locale);

		return "/admin/contents/musicvideo";
	}
	
}
