package mplanweb.music.web.admin;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mplanweb.music.web.MainService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

	private static final Logger logger = LoggerFactory
			.getLogger(WebController.class);
	@Autowired
	MainService mainservice;
	@RequestMapping("/loginFail.do")
	public String loginFail(@RequestParam Map<String, Object> paramMap,
			ModelMap model) throws Throwable {
		logger.info("MainPage ==> loginFail.do : ", paramMap, model);
		return "/admin/loginFail";
	}

	@RequestMapping("/main.do")
	public String main(@RequestParam Map<String, Object> paramMap,
			ModelMap model, Principal principal) throws Throwable {
		logger.info("MainPage ==> main.do : ", paramMap, model);
		// 로그인 후 로그인 한 아이디를 가지고 온다.
		String name = principal.getName();

		model.addAttribute("username", name);
		return "/main/loginok";

	}

	@RequestMapping("/logout.do")
	public String logout(@RequestParam Map<String, Object> paramMap,
			ModelMap model) throws Throwable {
		logger.info("MainPage ==> logout.do : ", paramMap, model);
		int musictotal = mainservice.selectTotalCountMusic();
		logger.info("musictotal : " + musictotal);
		int todaymusictotal = mainservice.selectTotalCountToday();
		logger.info("todaymusictotal : " + todaymusictotal);
		int radiototal = mainservice.selectTotalCountRadio();
		logger.info("radiototal : " + radiototal);
		int membertotal = mainservice.selectTotalCountMember();
		logger.info("membertotal : " + membertotal);
		model.addAttribute("musictotal", musictotal);
		model.addAttribute("todaymusictotal", todaymusictotal);
		model.addAttribute("radiototal", radiototal);
		model.addAttribute("membertotal", membertotal);
		return "/main/index";
	}
	
	@RequestMapping("/join.do")
	public void getJoin(ModelMap model, HttpServletRequest request)  throws Throwable {
		String userid = request.getParameter("userid");
		ArrayList list = null;
		
	
		
	}
}
