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
	// Main Page
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Main(Locale locale, Model model) {
		logger.info("LoginPage ==> MainPage : ", locale);
		return "/admin/index";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String action(Locale locale, Model model) {
		logger.info("MainPage ==> ??? : ", locale);

		return "/admin/music/musical";
	}
	

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * main =========> ssview =========> /music/ssview.jsp ?Œ?› ê´?ë¦? (View)
	 * 
	 * @param Model
	 * 
	 * @return /music/ssview
	 */
	@RequestMapping(value = "/ssview", method = RequestMethod.GET)
	public String SsView(Locale locale, Model model) {
		logger.info("MainPage ==> musicda : " + locale);
		model.addAttribute("ssearch", new Ssearch());
		return "/music/soundview";
	}

	/*
	 * main =========> corpview =========> /music/corpview.jsp ?šŒ?‚¬ ê´?ë¦? (View)
	 * 
	 * @param Model
	 * 
	 * @return /music/corpview
	 */
	@RequestMapping(value = "/corpview", method = RequestMethod.GET)
	public String CorpView(Locale locale, Model model) {
		logger.info("MainPage ==> musicda : " + locale);
		return "/music/corpview";
	}

	/*
	 * main =========> albumview =========> /music/albumview.jsp ?•¨ë²”ê?ë¦? (View)
	 * 
	 * @param Model
	 * 
	 * @return /music/albumview
	 */
	@RequestMapping(value = "/albumview", method = RequestMethod.GET)
	public String AlbumView(Locale locale, Model model) {
		logger.info("MainPage ==> musicda : " + locale);
		return "/music/albumview";
	}

	/*
	 * main =========> labelview =========> /music/labelview.jsp ? ˆ?´ë¸”ê?ë¦? (View)
	 * 
	 * @param Model
	 * 
	 * @return /music/labelview
	 */
	@RequestMapping(value = "/labelview", method = RequestMethod.GET)
	public String LabelView(Locale locale, Model model) {
		logger.info("MainPage ==> musicda : " + locale);
		return "/music/labelview";
	}

	/*
	 * main =========> artistview =========> /music/artistview.jsp ?•„?‹°?Š¤?Š¸ ê´?ë¦?
	 * (View)
	 * 
	 * @param Model
	 * 
	 * @return /music/artistview
	 */
	@RequestMapping(value = "/artistview", method = RequestMethod.GET)
	public String ArtistView(Locale locale, Model model) {
		logger.info("MainPage ==> musicda : " + locale);
		return "/music/artistview";
	}
	/*
	 * main =========> artistview =========> /music/artistview.jsp ?•„?‹°?Š¤?Š¸ ê´?ë¦?
	 * (View)
	 * 
	 * @param Model
	 * 
	 * @return /music/artistview
	 */
	@RequestMapping(value = "/radioview", method = RequestMethod.GET)
	public String RadioView(Locale locale, Model model) {
		logger.info("MainPage ==> radioview : " + locale);
		return "/music/radioview";
	}
	/*
	 * main =========> coin =========> /music/coin.jsp ? •?‚° ê´?ë¦? (View)
	 * 
	 * @param Model
	 * 
	 * @return /music/coin
	 */
	@RequestMapping(value = "/coinview", method = RequestMethod.GET)
	public String CoinView(Locale locale, Model model) {
		logger.info("MainPage ==> musicda : " + locale);
		return "/music/coin";
	}
}
