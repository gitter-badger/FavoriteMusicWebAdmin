package mplanweb.music.web.search;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SearchController {
	private static final Logger logger = LoggerFactory
			.getLogger(SearchController.class);
	@Autowired
	SearchDAO searchdao;

	@RequestMapping(value = "/editsearch", method = RequestMethod.POST)
	public void SearchValues(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response,
			SearchDTO searchdto) throws IOException {

		String result = request.getParameter("term");
		logger.info("Result : " + result);
		List<SearchDTO> list = searchdao.listall(result);
		logger.info("list : " + list);
		JSONArray json = new JSONArray();
		logger.info("json : " + json);
		// System.out.println(list.get(0).getEname());
		for (int i = 0; i < list.size(); i++) {
			json.add(list.get(i));
			logger.info("list.get(i) : " + list.get(i));

		}

		PrintWriter out = response.getWriter();
		out.print(json.toString());

	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String Searchtest(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response,
			MsearchDTO msearchdto) throws IOException {
		String result = request.getParameter("searchname");
		System.out.println("Test : " + result);
		List<MsearchDTO> object = searchdao.artistsearch(result);
		List<MsearchDTO> object2 = searchdao.albumsearch(result);
		List<MsearchDTO> object3 = searchdao.musicsearch(result);
		model.addAttribute("object", object);
		model.addAttribute("object2", object2);
		model.addAttribute("object3", object3);
		logger.info("count : " + object.size());
		logger.info("object : " + object.toString());
		
		logger.info("count : " + object2.size());
		logger.info("object : " + object2.toString());
		
		logger.info("count : " + object3.size());
		logger.info("object : " + object3.toString());
		//移댁슫�듃 怨꾩궛
		return "main/search";
		
		//泥섎━ 
		//List<SearchDTO> list = searchdao.searchall(result);
	}

}
