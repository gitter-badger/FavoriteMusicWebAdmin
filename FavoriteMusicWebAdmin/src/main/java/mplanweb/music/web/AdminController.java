package mplanweb.music.web;

import java.security.Principal;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminController {

	private static final Logger logger = LoggerFactory
			.getLogger(AdminController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// Main Page
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Main(Locale locale, Model model) {
		logger.info("LoginPage ==> MainPage : ", locale);
		return "/admin/index";
	}
}
