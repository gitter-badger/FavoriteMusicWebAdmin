package mplanweb.music.web;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mplanweb.music.web.contents.Ssearch;
import mplanweb.music.web.main.MainService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * Title : WebController.java
 * Author : M!Plan
 * Contents : Controller
 * 
 */


@Controller
public class WebController {

	
	// logger
	private static final Logger logger = LoggerFactory
			.getLogger(WebController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	MainService mainservice;
	// index Page
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Main(Locale locale, Model model) {
		logger.info("Site ==> IndexPage : ", locale);
		return "/admin/index";
	}

	// admin main page
	/*
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String action(Locale locale, Model model) {
		logger.info("IndexPage ==> MainPage : ", locale);
		int musictotal = mainservice.selectTotalCountMusic();
		int todaymusictotal = mainservice.selectTotalCountToday();
		int radiototal = mainservice.selectTotalCountRadio();
		int membertotal = mainservice.selectTotalCountMember();

		model.addAttribute("musictotal", musictotal);
		model.addAttribute("todaymusictotal", todaymusictotal);
		model.addAttribute("radiototal", radiototal);
		model.addAttribute("membertotal", membertotal);
		return "/admin/main/main";
	}
	*/
	// login
	@RequestMapping("/loginFail.do")
	public String loginFail(@RequestParam Map<String, Object> paramMap,
			ModelMap model) throws Throwable {
		logger.info("MainPage ==> loginFail.do : ", paramMap, model);
		return "/admin/login/loginFail";
	}

	@RequestMapping("/main.do")
	public String main(@RequestParam Map<String, Object> paramMap,
			ModelMap model, Principal principal) throws Throwable {
		logger.info("MainPage ==> main.do : ", paramMap, model);
		// 로그인 후 로그인 한 아이디를 가지고 온다.
		String name = principal.getName();
		model.addAttribute("username", name);
		
		
		int musictotal = mainservice.selectTotalCountMusic();
		int todaymusictotal = mainservice.selectTotalCountToday();
		int radiototal = mainservice.selectTotalCountRadio();
		int membertotal = mainservice.selectTotalCountMember();

		model.addAttribute("musictotal", musictotal);
		model.addAttribute("todaymusictotal", todaymusictotal);
		model.addAttribute("radiototal", radiototal);
		model.addAttribute("membertotal", membertotal);
		return "/admin/main/main";

	}

	@RequestMapping("/logout.do")
	public String logout(@RequestParam Map<String, Object> paramMap,
			ModelMap model) throws Throwable {
		logger.info("MainPage ==> logout.do : ", paramMap, model);
		return "/admin/index";
	}
	
	// Join 
	@RequestMapping("/join.do")
	public void getJoin(ModelMap model, HttpServletRequest request)  throws Throwable {
		String userid = request.getParameter("userid");
		ArrayList list = null;
		
	
		
	}

	
	// Company Page
	// Company main page
	@RequestMapping(value = "/company", method = RequestMethod.GET)
	public String Company(Locale locale, Model model) {
		logger.info("MainPage ==> companyPage : ", locale);

		return "/admin/company/company";
	}


	// Lable main page
	@RequestMapping(value = "/lable", method = RequestMethod.GET)
	public String Lable(Locale locale, Model model) {
		logger.info("MainPage ==> lablePage : ", locale);

		return "/admin/company/lable";
	}


	// B2B main page
	@RequestMapping(value = "/b2b", method = RequestMethod.GET)
	public String B2B(Locale locale, Model model) {
		logger.info("MainPage ==> b2bPage : ", locale);

		return "/admin/company/b2b";
	}

	
	// Admin Page
	// AD main page
	@RequestMapping(value = "/ad", method = RequestMethod.GET)
	public String Ad(Locale locale, Model model) {
		logger.info("MainPage ==> ADPage : ", locale);

		return "/admin/admin/ad";
	}

	// API main page
	@RequestMapping(value = "/api", method = RequestMethod.GET)
	public String Api(Locale locale, Model model) {
		logger.info("MainPage ==> APIPage : ", locale);

		return "/admin/admin/api";
	}

	// Board main page
	@RequestMapping(value = "/adminboard", method = RequestMethod.GET)
	public String Adminboard(Locale locale, Model model) {
		logger.info("MainPage ==> BoardPage : ", locale);

		return "/admin/admin/board";
	}

	// Event main page
	@RequestMapping(value = "/event", method = RequestMethod.GET)
	public String Event(Locale locale, Model model) {
		logger.info("MainPage ==> EventPage : ", locale);

		return "/admin/admin/event";
	}

	// Faq main page
	@RequestMapping(value = "/adminfaq", method = RequestMethod.GET)
	public String Adminfaq(Locale locale, Model model) {
		logger.info("MainPage ==> AdminfaqPage : ", locale);

		return "/admin/admin/faq";
	}

	// Notice main page
	@RequestMapping(value = "/adminnotice", method = RequestMethod.GET)
	public String Adminnotice(Locale locale, Model model) {
		logger.info("MainPage ==> AdminNoticePage : ", locale);

		return "/admin/admin/notice";
	}

	// Contents Page
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
