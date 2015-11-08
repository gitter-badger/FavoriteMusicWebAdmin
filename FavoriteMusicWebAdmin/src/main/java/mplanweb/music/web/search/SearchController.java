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

	@RequestMapping(value = "/artistname", method = RequestMethod.POST)
	public void SearchartistValues(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response,
			SearchDTO searchdto) throws IOException {

		String result = request.getParameter("term");
		logger.info("Result : " + result);
		List<SearchDTO> list = searchdao.artistall(result);
		logger.info("list : " + list);
		JSONArray json = new JSONArray();
		logger.info("json : " + json);
		for (int i = 0; i < list.size(); i++) {
			json.add(list.get(i));
			logger.info("list.get(i) : " + list.get(i));
		}

		PrintWriter out = response.getWriter();
		out.print(json.toString());

	}
	
	@RequestMapping(value = "/albumname", method = RequestMethod.POST)
	public void SearchalbumValues(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response,
			SearchDTO searchdto) throws IOException {

		String result = request.getParameter("term");
		logger.info("Result : " + result);
		List<SearchDTO> list = searchdao.albumall(result);
		logger.info("list : " + list);
		JSONArray json = new JSONArray();
		logger.info("json : " + json);
		for (int i = 0; i < list.size(); i++) {
			json.add(list.get(i));
			logger.info("list.get(i) : " + list.get(i));
		}

		PrintWriter out = response.getWriter();
		out.print(json.toString());

	}
	@RequestMapping(value = "/titlename", method = RequestMethod.POST)
	public void SearchtitleValues(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response,
			SearchDTO searchdto) throws IOException {

		String result = request.getParameter("term");
		logger.info("Result : " + result);
		List<SearchDTO> list = searchdao.albumall(result);
		logger.info("list : " + list);
		JSONArray json = new JSONArray();
		logger.info("json : " + json);
		for (int i = 0; i < list.size(); i++) {
			json.add(list.get(i));
			logger.info("list.get(i) : " + list.get(i));
		}

		PrintWriter out = response.getWriter();
		out.print(json.toString());

	}
}
