package mplanweb.music.web.corp;

import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/company")
public class CorpController {

	private static final Logger logger = LoggerFactory
			.getLogger(CorpController.class);

	@Autowired
	private CorpService corpservice;

	@RequestMapping(value = "/corpselect", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal corpselect(@RequestBody CorpSearch corpsearch) {

		Jsontotal jsontotal = new Jsontotal();
		int totalCount = corpservice.corptotalcount(corpsearch);
		List<CorpB2B> corplist = corpservice.selectcorpview(corpsearch); // nullpoint
		jsontotal.setTotal(totalCount);
		jsontotal.setItems(corplist);
		jsontotal.setSuccess(true);
		return jsontotal;
	}

	@RequestMapping(value = "/corpviewer/{mpssnumEncrypt}", method = RequestMethod.GET)
	@ResponseBody
	public Jsontotal corpviewer(@PathVariable String mpssnumEncrypt) {
		Jsontotal jsontotal = new Jsontotal();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mp_mpnum",
				CorpStringUtil.getTmsDecryptoAesForInt(mpssnumEncrypt));
		jsontotal.setData(musicService.viewSSview(map));
		jsontotal.setSuccess(true);
		return jsontotal;
	}

	@RequestMapping(value = "/corpinsert", produces = "application/json")
	@ResponseBody
	public Jsontotal corpinsert(MultipartHttpServletRequest request)
			throws Exception {

		String num_p = request.getParameter("num");
		int mp_num = Integer.parseInt(num_p);
		String anum = request.getParameter("artistnum");
		int mp_anum = Integer.parseInt(anum);
		String alnum = request.getParameter("albumnum");
		int mp_alnum = Integer.parseInt(alnum);
		String mp_titlemusic = request.getParameter("titleuse1");
		String mp_artist = request.getParameter("artist");
		String mp_title = request.getParameter("title");
		String mp_album = request.getParameter("album");
		String mp_lyric = request.getParameter("lyric");
		String mp_label = request.getParameter("label");
		String mp_corp = request.getParameter("corp");
		String mp_year = request.getParameter("year");
		String mp_genre1 = request.getParameter("genre1");
		String mp_genre2 = request.getParameter("genre2");
		String mp_etc = request.getParameter("etc");
		String mp_open_date = request.getParameter("copy");
		String mp_age = request.getParameter("age");
		String mp_useyn = request.getParameter("RadioGroup1");
		MultipartFile mimg = request.getFile("imgupload");
		MultipartFile m320k = request.getFile("m320kupload");
		MultipartFile m192k = request.getFile("m192kupload");
		logger.info("mp_num : " + mp_num);
		logger.info("mp_anum : " + mp_anum);
		logger.info("mp_alnum : " + mp_alnum);
		logger.info("mp_titlemusic : " + mp_titlemusic);
		logger.info("mp_artist : " + mp_artist);
		logger.info("mp_title : " + mp_title);
		logger.info("mp_album : " + mp_album);
		logger.info("mp_lyric : " + mp_lyric);
		logger.info("mp_label : " + mp_label);

		Jsontotal jsontotal = new Jsontotal();
		if (mimg != null && m192k != null && m192k != null) {

			String mp_img = mimg.getOriginalFilename();
			String mp_192k = m192k.getOriginalFilename();
			String mp_320k = m320k.getOriginalFilename();

			long mp_imgsize = mimg.getSize();
			long mp_192size = m192k.getSize();
			long mp_320size = m320k.getSize();

			String mp_imgo = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ mp_img.substring(mp_img.lastIndexOf("."));
			String mp_320ko = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ mp_320k.substring(mp_320k.lastIndexOf("."));
			String mp_192ko = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ mp_192k.substring(mp_192k.lastIndexOf("."));

			String uploadimgPath = "E://upload//img//";
			String upload320Path = "E://upload//music320k//";
			String upload192Path = "E://upload//music192k//";

			if (mimg.getSize() != 0) {
				mimg.transferTo(new File(uploadimgPath + "/" + mp_imgo));
			}
			if (m192k.getSize() != 0) {
				m192k.transferTo(new File(upload192Path + "/" + mp_192ko));
			}
			if (m320k.getSize() != 0) {
				m320k.transferTo(new File(upload320Path + "/" + mp_320ko));
			}

			CorpB2B ssview = new CorpB2B();
			ssview.setMp_num(mp_num);
			ssview.setMp_anum(mp_anum);
			ssview.setMp_alnum(mp_alnum);
			ssview.setMp_titlemusic(mp_titlemusic);

			ssview.setMp_img(mp_img);
			ssview.setMp_320k(mp_320k);
			ssview.setMp_192k(mp_192k);

			ssview.setMp_imgsize(mp_imgsize);
			ssview.setMp_320size(mp_320size);
			ssview.setMp_192size(mp_192size);

			ssview.setMp_imgo(mp_imgo);
			ssview.setMp_320ko(mp_320ko);
			ssview.setMp_192ko(mp_192ko);

			ssview.setMp_artist(mp_artist);
			ssview.setMp_title(mp_title);
			ssview.setMp_album(mp_album);
			ssview.setMp_lyric(mp_lyric);
			ssview.setMp_label(mp_label);
			ssview.setMp_corp(mp_corp);
			ssview.setMp_year(mp_year);
			ssview.setMp_genre1(mp_genre1);
			ssview.setMp_genre2(mp_genre2);
			ssview.setMp_etc(mp_etc);
			ssview.setMp_open_date(mp_open_date);
			ssview.setMp_age(mp_age);
			ssview.setMp_useyn(mp_useyn);

			musicService.insertssearch(ssview);

			jsontotal.setSuccess(true);

		}

		return jsontotal;
	}

	@RequestMapping(value = "/corpupdate", produces = "application/json")
	@ResponseBody
	public Jsontotal corpupdate(MultipartHttpServletRequest request)
			throws Exception {

		String num_pm = request.getParameter("mpssnumEncrypt");
		String num_p = request.getParameter("num");
		int mp_num = Integer.parseInt(num_p);
		String anum = request.getParameter("artistnum");
		int mp_anum = Integer.parseInt(anum);
		String alnum = request.getParameter("albumnum");
		int mp_alnum = Integer.parseInt(alnum);
		String mp_titlemusic = request.getParameter("titleuse1");
		String mp_artist = request.getParameter("artist");
		String mp_title = request.getParameter("title");
		String mp_album = request.getParameter("album");
		String mp_lyric = request.getParameter("lyric");
		String mp_label = request.getParameter("label");
		String mp_corp = request.getParameter("corp");
		String mp_year = request.getParameter("year");
		String mp_genre1 = request.getParameter("genre1");
		String mp_genre2 = request.getParameter("genre2");
		String mp_etc = request.getParameter("etc");
		String mp_open_date = request.getParameter("copy");
		String mp_age = request.getParameter("age");
		String mp_useyn = request.getParameter("RadioGroup1");
		MultipartFile mimg = request.getFile("imgupload");
		MultipartFile m320k = request.getFile("m320kupload");
		MultipartFile m192k = request.getFile("m192kupload");
		logger.info("num_pm : " + num_pm);
		logger.info("mp_num2 : " + mp_num);
		logger.info("mp_artist : " + mp_artist);
		logger.info("mp_title : " + mp_title);
		logger.info("mp_album : " + mp_album);
		logger.info("mp_lyric : " + mp_lyric);
		logger.info("mp_label : " + mp_label);

		Jsontotal jsontotal = new Jsontotal();
		if (mimg != null && m192k != null && m192k != null) {

			String mp_img = mimg.getOriginalFilename();
			String mp_192k = m192k.getOriginalFilename();
			String mp_320k = m320k.getOriginalFilename();
			long mp_imgsize = mimg.getSize();
			long mp_192size = m192k.getSize();
			long mp_320size = m320k.getSize();
			String mp_imgo = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ mp_img.substring(mp_img.lastIndexOf("."));
			String mp_320ko = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ mp_320k.substring(mp_320k.lastIndexOf("."));
			String mp_192ko = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ mp_192k.substring(mp_192k.lastIndexOf("."));
			String uploadimgPath = "E://upload//img//";
			String upload192Path = "E://upload//music192k//";
			String upload320Path = "E://upload//music320k//";
			if (mimg.getSize() != 0) {
				mimg.transferTo(new File(uploadimgPath + "/" + mp_imgo));
			}
			if (m192k.getSize() != 0) {
				m192k.transferTo(new File(upload192Path + "/" + mp_320ko));
			}
			if (m320k.getSize() != 0) {
				m320k.transferTo(new File(upload320Path + "/" + mp_192ko));
			}

			CorpB2B ssview = new CorpB2B();
			ssview.setMp_mpnum(CorpStringUtil.getTmsDecryptoAesForInt(num_pm));
			ssview.setMp_img(mp_img);
			ssview.setMp_320k(mp_320k);
			ssview.setMp_192k(mp_192k);
			ssview.setMp_imgsize(mp_imgsize);
			ssview.setMp_320size(mp_320size);
			ssview.setMp_192size(mp_192size);
			ssview.setMp_imgo(mp_imgo);
			ssview.setMp_320ko(mp_320ko);
			ssview.setMp_192ko(mp_192ko);
			ssview.setMp_num(mp_num);
			ssview.setMp_anum(mp_anum);
			ssview.setMp_alnum(mp_alnum);
			ssview.setMp_titlemusic(mp_titlemusic);
			ssview.setMp_artist(mp_artist);
			ssview.setMp_title(mp_title);
			ssview.setMp_album(mp_album);
			ssview.setMp_lyric(mp_lyric);
			ssview.setMp_label(mp_label);
			ssview.setMp_corp(mp_corp);
			ssview.setMp_year(mp_year);
			ssview.setMp_genre1(mp_genre1);
			ssview.setMp_genre2(mp_genre2);
			ssview.setMp_etc(mp_etc);
			ssview.setMp_open_date(mp_open_date);
			ssview.setMp_age(mp_age);
			ssview.setMp_useyn(mp_useyn);

			musicService.updatessearch(ssview);

			jsontotal.setSuccess(true);

		}

		return jsontotal;
	}

	@RequestMapping(value = "/corpdelete", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal corpdelete(@RequestBody Map<String, Object> param,
			String mp_imgo) {

		Jsontotal jsontotal = new Jsontotal();
		String mp_mpnum = String.valueOf(param.get("mp_mpnum"));
		System.out.println(mp_mpnum);

		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		String[] mpssnumEncrypts = mp_mpnum.split(",");

		for (String mpssnumEncrypt : mpssnumEncrypts) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("mp_mpnum",
					CorpStringUtil.getTmsDecryptoAesForInt(mpssnumEncrypt));
			mapList.add(map);
		}
		musicService.deletessearch(mapList);
		jsontotal.setSuccess(true);
		return jsontotal;
	}

	}