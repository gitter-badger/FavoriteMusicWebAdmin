package mplanweb.music.web.contents;

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
@RequestMapping("/contents")
public class MusicController {

	private static final Logger logger = LoggerFactory
			.getLogger(MusicController.class);

	@Autowired
	private MusicService musicService;

	@RequestMapping(value = "/ssviewselect", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal ssviewselect(@RequestBody Ssearch ssearch) {

		Jsontotal jsontotal = new Jsontotal();
		int totalCount = musicService.selecttotalcount(ssearch);
		List<Ssview> musiclist = musicService.selectSsview(ssearch); // nullpoint
		jsontotal.setTotal(totalCount);
		jsontotal.setItems(musiclist);
		jsontotal.setSuccess(true);
		return jsontotal;
	}

	@RequestMapping(value = "/ssviewer/{mpssnumEncrypt}", method = RequestMethod.GET)
	@ResponseBody
	public Jsontotal ViewSelect(@PathVariable String mpssnumEncrypt) {
		Jsontotal jsontotal = new Jsontotal();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mp_mpnum",
				MusicStringUtil.getTmsDecryptoAesForInt(mpssnumEncrypt));
		jsontotal.setData(musicService.viewSSview(map));
		jsontotal.setSuccess(true);
		return jsontotal;
	}

	@RequestMapping(value = "/ssviewinsert", produces = "application/json")
	@ResponseBody
	public Jsontotal insertssview(MultipartHttpServletRequest request)
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

			Ssview ssview = new Ssview();
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

	@RequestMapping(value = "/ssviewupdate", produces = "application/json")
	@ResponseBody
	public Jsontotal updatessview(MultipartHttpServletRequest request)
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

			Ssview ssview = new Ssview();
			ssview.setMp_mpnum(MusicStringUtil.getTmsDecryptoAesForInt(num_pm));
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

	@RequestMapping(value = "/ssviewdelete", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal deletessview(@RequestBody Map<String, Object> param,
			String mp_imgo) {

		Jsontotal jsontotal = new Jsontotal();
		String mp_mpnum = String.valueOf(param.get("mp_mpnum"));
		System.out.println(mp_mpnum);

		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		String[] mpssnumEncrypts = mp_mpnum.split(",");

		for (String mpssnumEncrypt : mpssnumEncrypts) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("mp_mpnum",
					MusicStringUtil.getTmsDecryptoAesForInt(mpssnumEncrypt));
			mapList.add(map);
		}
		musicService.deletessearch(mapList);
		jsontotal.setSuccess(true);
		return jsontotal;
	}

	@RequestMapping(value = "/abviewselect", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal albumviewselect(@RequestBody Ssearch ssearch) {
		Jsontotal jsontotal = new Jsontotal();
		int totalCount = musicService.albumtotalcount(ssearch);
		List<SsAlbum> albumlist = musicService.selectalbumview(ssearch); // nullpoint
		jsontotal.setTotal(totalCount);
		jsontotal.setItems(albumlist);
		jsontotal.setSuccess(true);
		return jsontotal;
	}

	@RequestMapping(value = "/abviewer/{mpssnumEncrypt}", method = RequestMethod.GET)
	@ResponseBody
	public Jsontotal albumviewSelect(@PathVariable String mpssnumEncrypt) {

		Jsontotal jsontotal = new Jsontotal();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mp_alnum",
				MusicStringUtil.getTmsDecryptoAesForInt(mpssnumEncrypt));
		jsontotal.setData(musicService.viewalbumview(map));

		jsontotal.setSuccess(true);
		return jsontotal;
	}

	@RequestMapping(value = "/ssalbuminsert", produces = "application/json")
	@ResponseBody
	public Jsontotal insertssalbum(MultipartHttpServletRequest request)
			throws Exception {
		String artistnum = request.getParameter("artistnum");
		int mp_anum = Integer.parseInt(artistnum);
		String mp_albumtitle = request.getParameter("albumtitle");
		String mp_artist = request.getParameter("artist");
		String mp_album = request.getParameter("album");
		String mp_content = request.getParameter("content");
		String mp_year = request.getParameter("year");
		String mp_corp = request.getParameter("corp");
		String mp_useyn = request.getParameter("RadioGroup1");
		MultipartFile mimg = request.getFile("imgupload");
		logger.info("mp_artistnum : " + mp_anum);
		logger.info("mp_albumtitle : " + mp_albumtitle);
		logger.info("mp_artist : " + mp_artist);
		logger.info("mp_album : " + mp_album);
		logger.info("mp_content : " + mp_content);
		logger.info("mp_year : " + mp_year);
		logger.info("mp_corp : " + mp_corp);
		logger.info("mp_useyn : " + mp_useyn);
		Jsontotal jsontotal = new Jsontotal();
		if (mimg != null) {

			String mp_albumimg = mimg.getOriginalFilename();

			long mp_albumsize = mimg.getSize();
			String mp_albumimgorg = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ mp_albumimg.substring(mp_albumimg.lastIndexOf("."));
			String uploadimgPath = "E://upload//albumimg//";
			if (mimg.getSize() != 0) {
				mimg.transferTo(new File(uploadimgPath + "/" + mp_albumimgorg));
			}
			SsAlbum ssalbum = new SsAlbum();
			ssalbum.setMp_albumtitle(mp_albumtitle);
			ssalbum.setMp_anum(mp_anum);
			ssalbum.setMp_artist(mp_artist);
			ssalbum.setMp_album(mp_album);
			ssalbum.setMp_content(mp_content);
			ssalbum.setMp_corp(mp_corp);
			ssalbum.setMp_year(mp_year);
			ssalbum.setMp_useyn(mp_useyn);
			ssalbum.setMp_albumimg(mp_albumimg);
			ssalbum.setMp_albumsize(mp_albumsize);
			ssalbum.setMp_albumimgorg(mp_albumimgorg);

			musicService.insertalbum(ssalbum);

			jsontotal.setSuccess(true);

		}

		return jsontotal;
	}

	@RequestMapping(value = "/ssalbumupdate", produces = "application/json")
	@ResponseBody
	public Jsontotal updatessalbum(MultipartHttpServletRequest request)
			throws Exception {
		String artistnum = request.getParameter("artistnum");
		int mp_anum = Integer.parseInt(artistnum);
		String mp_albumtitle = request.getParameter("albumtitle");
		String num_pm = request.getParameter("mpssnumEncrypt");
		String mp_artist = request.getParameter("artist");
		String mp_album = request.getParameter("album");
		String mp_content = request.getParameter("content");
		String mp_year = request.getParameter("year");
		String mp_corp = request.getParameter("corp");
		String mp_useyn = request.getParameter("RadioGroup1");
		MultipartFile mimg = request.getFile("imgupload");
		logger.info("mp_artistnum : " + mp_anum);
		logger.info("mp_albumtitle : " + mp_albumtitle);
		logger.info("mp_artist : " + mp_artist);
		logger.info("mp_album : " + mp_album);
		logger.info("mp_content : " + mp_content);
		logger.info("mp_year : " + mp_year);
		logger.info("mp_corp : " + mp_corp);
		logger.info("mp_useyn : " + mp_useyn);

		Jsontotal jsontotal = new Jsontotal();
		if (mimg != null) {
			String mp_albumimg = mimg.getOriginalFilename();
			long mp_albumsize = mimg.getSize();
			String mp_albumimgorg = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ mp_albumimg.substring(mp_albumimg.lastIndexOf("."));
			String uploadimgPath = "E://upload//albumimg//";
			if (mimg.getSize() != 0) {
				mimg.transferTo(new File(uploadimgPath + "/" + mp_albumimgorg));
			}
			SsAlbum ssalbum = new SsAlbum();
			ssalbum.setMp_alnum(MusicStringUtil.getTmsDecryptoAesForInt(num_pm));
			ssalbum.setMp_albumtitle(mp_albumtitle);
			ssalbum.setMp_anum(mp_anum);
			ssalbum.setMp_artist(mp_artist);
			ssalbum.setMp_album(mp_album);
			ssalbum.setMp_content(mp_content);
			ssalbum.setMp_corp(mp_corp);
			ssalbum.setMp_year(mp_year);
			ssalbum.setMp_useyn(mp_useyn);
			ssalbum.setMp_albumimg(mp_albumimg);
			ssalbum.setMp_albumsize(mp_albumsize);
			ssalbum.setMp_albumimgorg(mp_albumimgorg);
			musicService.updatealbum(ssalbum);
			jsontotal.setSuccess(true);

		}

		return jsontotal;
	}

	@RequestMapping(value = "/ssalbumdelete", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal deletessalbum(@RequestBody Map<String, Object> param) {
		Jsontotal jsontotal = new Jsontotal();
		String mp_mpnum = String.valueOf(param.get("mp_alnum"));

		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		String[] mpssnumEncrypts = mp_mpnum.split(",");

		for (String mpssnumEncrypt : mpssnumEncrypts) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("mp_alnum",
					MusicStringUtil.getTmsDecryptoAesForInt(mpssnumEncrypt));
			mapList.add(map);
		}
		musicService.deletealbum(mapList);
		jsontotal.setSuccess(true);
		return jsontotal;
	}

	@RequestMapping(value = "/artviewselect", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal artistviewselect(@RequestBody Ssearch ssearch) {

		Jsontotal jsontotal = new Jsontotal();
		int totalCount = musicService.artisttotalcount(ssearch);
		List<Ssartist> artistlist = musicService.selectartistview(ssearch); // nullpoint
		jsontotal.setTotal(totalCount);
		jsontotal.setItems(artistlist);
		jsontotal.setSuccess(true);
		return jsontotal;
	}

	@RequestMapping(value = "/artviewer/{mpssnumEncrypt}", method = RequestMethod.GET)
	@ResponseBody
	public Jsontotal artistviewSelect(@PathVariable String mpssnumEncrypt) {
		Jsontotal jsontotal = new Jsontotal();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mp_anum",
				MusicStringUtil.getTmsDecryptoAesForInt(mpssnumEncrypt));
		jsontotal.setData(musicService.viewartistview(map));

		jsontotal.setSuccess(true);
		return jsontotal;
	}

	@RequestMapping(value = "/ssartistinsert", produces = "application/json")
	@ResponseBody
	public Jsontotal insertartist(MultipartHttpServletRequest request)
			throws Exception {
		String mp_artist = request.getParameter("artist");
		String mp_content = request.getParameter("content");
		String mp_label = request.getParameter("label");
		String mp_debut = request.getParameter("debut");
		String mp_useyn = request.getParameter("RadioGroup1");
		MultipartFile mimg = request.getFile("imgupload");
		logger.info("mp_artist : " + mp_artist);
		logger.info("mp_content : " + mp_content);
		logger.info("mp_label : " + mp_label);
		logger.info("mp_debut : " + mp_debut);
		logger.info("mp_useyn : " + mp_useyn);
		Jsontotal jsontotal = new Jsontotal();
		if (mimg != null) {
			String mp_artistimg = mimg.getOriginalFilename();
			long mp_artistsize = mimg.getSize();
			String mp_artistorg = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ mp_artistimg.substring(mp_artistimg.lastIndexOf("."));
			String uploadimgPath = "E://upload//artistimg//";
			if (mimg.getSize() != 0) {
				mimg.transferTo(new File(uploadimgPath + "/" + mp_artistorg));
			}
			Ssartist ssartist = new Ssartist();
			ssartist.setMp_artist(mp_artist);
			ssartist.setMp_content(mp_content);
			ssartist.setMp_label(mp_label);
			ssartist.setMp_debut(mp_debut);
			ssartist.setMp_useyn(mp_useyn);
			logger.info("mp_artistimg : " + mp_artistimg);
			ssartist.setMp_artistimg(mp_artistimg);
			logger.info("mp_artistsize : " + mp_artistsize);
			ssartist.setMp_artistsize(mp_artistsize);
			logger.info("mp_artistorg : " + mp_artistorg);
			ssartist.setMp_artistorg(mp_artistorg);
			musicService.insertartist(ssartist);
			jsontotal.setSuccess(true);
		}
		return jsontotal;
	}

	@RequestMapping(value = "/ssartistupdate", produces = "application/json")
	@ResponseBody
	public Jsontotal updateartist(MultipartHttpServletRequest request)
			throws Exception {

		String num_pm = request.getParameter("mpssnumEncrypt");
		String mp_artist = request.getParameter("artist");
		String mp_content = request.getParameter("content");
		String mp_label = request.getParameter("label");
		String mp_debut = request.getParameter("debut");
		String mp_useyn = request.getParameter("RadioGroup1");
		MultipartFile mimg = request.getFile("imgupload");
		logger.info("mp_artist : " + mp_artist);
		logger.info("mp_content : " + mp_content);
		logger.info("mp_label : " + mp_label);
		logger.info("mp_debut : " + mp_debut);
		logger.info("mp_useyn : " + mp_useyn);
		Jsontotal jsontotal = new Jsontotal();
		if (mimg != null) {
			String mp_artistimg = mimg.getOriginalFilename();
			long mp_artistsize = mimg.getSize();
			String mp_artistorg = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ mp_artistimg.substring(mp_artistimg.lastIndexOf("."));
			String uploadimgPath = "E://upload//albumimg//";
			if (mimg.getSize() != 0) {
				mimg.transferTo(new File(uploadimgPath + "/" + mp_artistorg));
			}
			Ssartist ssartist = new Ssartist();
			ssartist.setMp_anum(MusicStringUtil.getTmsDecryptoAesForInt(num_pm));
			ssartist.setMp_artist(mp_artist);
			ssartist.setMp_content(mp_content);
			ssartist.setMp_label(mp_label);
			ssartist.setMp_debut(mp_debut);
			ssartist.setMp_useyn(mp_useyn);
			ssartist.setMp_artistimg(mp_artistimg);
			ssartist.setMp_artistsize(mp_artistsize);
			ssartist.setMp_artistorg(mp_artistorg);
			musicService.updateartist(ssartist);
			jsontotal.setSuccess(true);
		}
		return jsontotal;
	}

	@RequestMapping(value = "/ssartistdelete", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal deleteartist(@RequestBody Map<String, Object> param) {
		Jsontotal jsontotal = new Jsontotal();
		String mp_mpnum = String.valueOf(param.get("mp_anum"));

		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		String[] mpssnumEncrypts = mp_mpnum.split(",");

		for (String mpssnumEncrypt : mpssnumEncrypts) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("mp_anum",
					MusicStringUtil.getTmsDecryptoAesForInt(mpssnumEncrypt));
			mapList.add(map);
		}
		musicService.deleteartist(mapList);
		jsontotal.setSuccess(true);
		return jsontotal;
	}

	@RequestMapping(value = "/corpviewselect", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal corpviewselect(@RequestBody Ssearch ssearch) {
		Jsontotal jsontotal = new Jsontotal();
		int totalCount = musicService.corptotalcount(ssearch);
		List<Sscorp> corplist = musicService.selectcorpview(ssearch);
		jsontotal.setTotal(totalCount);
		jsontotal.setItems(corplist);
		jsontotal.setSuccess(true);
		return jsontotal;
	}

	@RequestMapping(value = "/corpviewer/{mpssnumEncrypt}", method = RequestMethod.GET)
	@ResponseBody
	public Jsontotal corpviewSelect(@PathVariable String mpssnumEncrypt) {

		Jsontotal jsontotal = new Jsontotal();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mp_corpnum",
				MusicStringUtil.getTmsDecryptoAesForInt(mpssnumEncrypt));
		jsontotal.setData(musicService.viewcorpview(map));

		jsontotal.setSuccess(true);
		return jsontotal;
	}

	@RequestMapping(value = "/sscorpinsert", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal insertcorp(@RequestBody Sscorp sscorp) {
		Jsontotal jsontotal = new Jsontotal();
		musicService.insertcorp(sscorp);
		jsontotal.setSuccess(true);
		return jsontotal;
	}

	@RequestMapping(value = "/sscorpupdate", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal updatecorp(@RequestBody Sscorp sscorp) {
		Jsontotal jsontotal = new Jsontotal();
		sscorp.setMp_corpnum(MusicStringUtil.getTmsDecryptoAesForInt(sscorp
				.getMpssnumEncrypt()));
		musicService.updatecorp(sscorp);
		jsontotal.setSuccess(true);
		return jsontotal;
	}

	@RequestMapping(value = "/sscorpdelete", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal deletecorp(@RequestBody Map<String, Object> param) {
		Jsontotal jsontotal = new Jsontotal();
		String mp_corpnum = String.valueOf(param.get("mp_corpnum"));

		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		String[] mpssnumEncrypts = mp_corpnum.split(",");

		for (String mpssnumEncrypt : mpssnumEncrypts) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("mp_corpnum",
					MusicStringUtil.getTmsDecryptoAesForInt(mpssnumEncrypt));
			mapList.add(map);
		}
		musicService.deletecorp(mapList);
		jsontotal.setSuccess(true);
		return jsontotal;
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * View =========> ssviewselect =========> jsontotal ======> DB =====>
	 * Ssview ===> /music/ssviewselect.jsp ?ùå?õê Î¶¨Ïä§?ä∏ (List)
	 * 
	 * @param ssearch
	 * 
	 * @return jsontotal
	 */
	@RequestMapping(value = "/mvselect", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal mvselect(@RequestBody Ssearch ssearch) {
		// Json ?òï?ãù?úºÎ°? Î≥??ôò?ï†?†§Í≥? ?Éù?Ñ± parameter json => result json
		Jsontotal jsontotal = new Jsontotal();
		// Ïπ¥Ïö¥?ä∏ Í≥ÑÏÇ∞
		int totalCount = musicService.mvtotalcount(ssearch);

		// Î¶¨Ïä§?ä∏ ?òï?ãù
		List<Ssmvview> musiclist = musicService.selectSsmvview(ssearch); // nullpoint
		jsontotal.setTotal(totalCount);
		jsontotal.setItems(musiclist);
		jsontotal.setSuccess(true);

		// Î¶¨ÌÑ¥
		return jsontotal;
	}

	/*
	 * View =========> ssviewselect =========> jsontotal ======> DB =====>
	 * Ssview ===> /music/ssviewselect.jsp ?ùå?õê Í¥?Î¶? ?Ñ†?Éù (List)
	 * 
	 * @param mpssnumEncrypt
	 * 
	 * @return jsontotal
	 */
	@RequestMapping(value = "/mvviewer/{mpssnumEncrypt}", method = RequestMethod.GET)
	@ResponseBody
	public Jsontotal MVViewSelect(@PathVariable String mpssnumEncrypt) {
		Jsontotal jsontotal = new Jsontotal();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mp_mvnum",
				MusicStringUtil.getTmsDecryptoAesForInt(mpssnumEncrypt));
		jsontotal.setData(musicService.viewmv(map));
		jsontotal.setSuccess(true);
		return jsontotal;
	}

	@RequestMapping(value = "/mvinsert", produces = "application/json")
	@ResponseBody
	public Jsontotal insertmv(MultipartHttpServletRequest request)
			throws Exception {
		
		
		String anum = request.getParameter("artistnum");
		int mp_anum = Integer.parseInt(anum);
		String alnum = request.getParameter("titlenum");
		int mp_alnum = Integer.parseInt(alnum);
		String mpnum = request.getParameter("albumnum");
		int mp_mpnum = Integer.parseInt(mpnum);
		String mp_release = request.getParameter("titleuse1");
		String mp_artist = request.getParameter("artist");
		String mp_title = request.getParameter("title");
		String mp_album = request.getParameter("album");
		String mp_year = request.getParameter("year");
		String mp_corp = request.getParameter("corp");
		String mp_label = request.getParameter("label");
		String mp_content = request.getParameter("content");
		String mp_genre1 = request.getParameter("genre1");
		String mp_genre2 = request.getParameter("genre2");
		String mp_age = request.getParameter("age");
		String mp_useyn = request.getParameter("RadioGroup1");

		MultipartFile mimg = request.getFile("imgupload");
		MultipartFile mmvk = request.getFile("mmvkupload");
		logger.info("mp_release : " + mp_release);
		logger.info("mp_anum : " + mp_anum);
		logger.info("mp_alnum : " + mp_alnum);
		logger.info("mp_mpnum : " + mp_mpnum);
		logger.info("mp_artist : " + mp_artist);
		logger.info("mp_title : " + mp_title);
		logger.info("mp_album : " + mp_album);
		logger.info("mp_year : " + mp_year);
		logger.info("mp_corp : " + mp_corp);
		logger.info("mp_label : " + mp_label);
		logger.info("mp_content : " + mp_content);
		logger.info("mp_genre1 : " + mp_genre1);
		logger.info("mp_genre2 : " + mp_genre2);
		logger.info("mp_age : " + mp_age);
		logger.info("mp_useyn : " + mp_useyn);
	
		Jsontotal jsontotal = new Jsontotal();
		if (mimg != null && mmvk != null) {

			String mp_img = mimg.getOriginalFilename();
			String mp_mvk = mmvk.getOriginalFilename();

			long mp_imgsize = mimg.getSize();
			long mp_mvsize = mmvk.getSize();

			String mp_imgo = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ mp_img.substring(mp_img.lastIndexOf("."));
			String mp_mvko = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ mp_mvk.substring(mp_mvk.lastIndexOf("."));

			String uploadmvimgPath = "E://upload//videoimg//";
			String uploadmvPath = "E://upload//video//";

			if (mimg.getSize() != 0) {
				mimg.transferTo(new File(uploadmvimgPath + "/" + mp_imgo));
			}
			if (mmvk.getSize() != 0) {
				mmvk.transferTo(new File(uploadmvPath + "/" + mp_mvko));
			}

			Ssmvview ssmvview = new Ssmvview();

			ssmvview.setMp_anum(mp_anum);
			ssmvview.setMp_alnum(mp_alnum);
			ssmvview.setMp_mpnum(mp_mpnum);
			ssmvview.setMp_artist(mp_artist);
			ssmvview.setMp_title(mp_title);
			ssmvview.setMp_album(mp_album);
			ssmvview.setMp_year(mp_year);
			ssmvview.setMp_corp(mp_corp);
			ssmvview.setMp_label(mp_label);
			ssmvview.setMp_content(mp_content);
			ssmvview.setMp_genre1(mp_genre1);
			ssmvview.setMp_genre2(mp_genre2);
			ssmvview.setMp_age(mp_age);
			ssmvview.setMp_useyn(mp_useyn);
			ssmvview.setMp_img(mp_img);
			ssmvview.setMp_imgsize(mp_imgsize);
			ssmvview.setMp_imgo(mp_imgo);
			ssmvview.setMp_mvk(mp_mvk);
			ssmvview.setMp_mvsize(mp_mvsize);
			ssmvview.setMp_mvko(mp_mvko);
			ssmvview.setMp_release(mp_release);
			logger.info("mimg : " + mimg);
			logger.info("mp_img : " + mp_img);
			logger.info("mp_imgsize : " + mp_imgsize);
			logger.info("mp_imgo : " + mp_imgo);
			logger.info("mmvk : " + mmvk);
			logger.info("mp_mvk : " + mp_mvk);
			logger.info("mp_mvsize : " + mp_mvsize);
			logger.info("mp_mvko : " + mp_mvko);
			musicService.insertmv(ssmvview);
			jsontotal.setSuccess(true);

		}

		return jsontotal;
	}

	@RequestMapping(value = "/mvupdate", produces = "application/json")
	@ResponseBody
	public Jsontotal updatemv(MultipartHttpServletRequest request)
			throws Exception {

		String anum = request.getParameter("artistnum");
		int mp_anum = Integer.parseInt(anum);
		String alnum = request.getParameter("titlenum");
		int mp_alnum = Integer.parseInt(alnum);
		String mpnum = request.getParameter("albumnum");
		int mp_mpnum = Integer.parseInt(mpnum);
		String mp_mvnum = request.getParameter("mpssnumEncrypt");
		String mp_release = request.getParameter("titleuse1");
		String mp_artist = request.getParameter("artist");
		String mp_title = request.getParameter("title");
		String mp_album = request.getParameter("album");
		String mp_year = request.getParameter("year");
		String mp_corp = request.getParameter("corp");
		String mp_label = request.getParameter("label");
		String mp_content = request.getParameter("content");
		String mp_genre1 = request.getParameter("genre1");
		String mp_genre2 = request.getParameter("genre2");
		String mp_age = request.getParameter("age");
		String mp_useyn = request.getParameter("RadioGroup1");

		MultipartFile mimg = request.getFile("imgupload");
		MultipartFile mmvk = request.getFile("mmvkupload");

		logger.info("mvupdate mp_anum : " + mp_anum);
		logger.info("mvupdate mp_alnum : " + mp_alnum);
		logger.info("mvupdate mp_mpnum : " + mp_mpnum);
		logger.info("mp_artist : " + mp_artist);
		logger.info("mp_title : " + mp_title);
		logger.info("mp_album : " + mp_album);
		logger.info("mp_year : " + mp_year);
		logger.info("mp_corp : " + mp_corp);
		logger.info("mp_label : " + mp_label);
		logger.info("mp_content : " + mp_content);
		logger.info("mp_genre1 : " + mp_genre1);
		logger.info("mp_genre2 : " + mp_genre2);
		logger.info("mp_age : " + mp_age);
		logger.info("mp_useyn : " + mp_useyn);
		logger.info("mimg : " + mimg);
		logger.info("mmvk : " + mmvk);
	

		Jsontotal jsontotal = new Jsontotal();
		if (mimg != null && mmvk != null) {

			String mp_img = mimg.getOriginalFilename();
			String mp_mvk = mmvk.getOriginalFilename();

			long mp_imgsize = mimg.getSize();
			long mp_mvsize = mmvk.getSize();

			String mp_imgo = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ mp_img.substring(mp_img.lastIndexOf("."));
			String mp_mvko = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ mp_mvk.substring(mp_mvk.lastIndexOf("."));

			String uploadmvimgPath = "E://upload//videoimg//";
			String uploadmvPath = "E://upload//video//";

			if (mimg.getSize() != 0) {
				mimg.transferTo(new File(uploadmvimgPath + "/" + mp_imgo));
			}
			if (mmvk.getSize() != 0) {
				mmvk.transferTo(new File(uploadmvPath + "/" + mp_mvko));
			}
			Ssmvview ssmvview = new Ssmvview();
			ssmvview.setMp_mvnum(MusicStringUtil.getTmsDecryptoAesForInt(mp_mvnum));
			ssmvview.setMp_anum(mp_anum);
			ssmvview.setMp_alnum(mp_alnum);
			ssmvview.setMp_mpnum(mp_mpnum);
			ssmvview.setMp_artist(mp_artist);
			ssmvview.setMp_title(mp_title);
			ssmvview.setMp_album(mp_album);
			ssmvview.setMp_year(mp_year);
			ssmvview.setMp_corp(mp_corp);
			ssmvview.setMp_label(mp_label);
			ssmvview.setMp_content(mp_content);
			ssmvview.setMp_genre1(mp_genre1);
			ssmvview.setMp_genre2(mp_genre2);
			ssmvview.setMp_age(mp_age);
			ssmvview.setMp_useyn(mp_useyn);
			ssmvview.setMp_img(mp_img);
			ssmvview.setMp_imgsize(mp_imgsize);
			ssmvview.setMp_imgo(mp_imgo);
			ssmvview.setMp_mvk(mp_mvk);
			ssmvview.setMp_mvsize(mp_mvsize);
			ssmvview.setMp_mvko(mp_mvko);
			ssmvview.setMp_release(mp_release);
			logger.info("mimg : " + mimg);
			logger.info("mp_img : " + mp_img);
			logger.info("mp_imgsize : " + mp_imgsize);
			logger.info("mp_imgo : " + mp_imgo);
			logger.info("mmvk : " + mmvk);
			logger.info("mp_mvk : " + mp_mvk);
			logger.info("mp_mvsize : " + mp_mvsize);
			logger.info("mp_mvko : " + mp_mvko);
			musicService.updatemv(ssmvview);
			logger.info("test " + ssmvview);
			jsontotal.setSuccess(true);

		}

		return jsontotal;
	}

	@RequestMapping(value = "/mvdelete", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal deletemv(@RequestBody Map<String, Object> param,
			String mp_imgo) {

		Jsontotal jsontotal = new Jsontotal();
		String mp_mvnum = String.valueOf(param.get("mp_mvnum"));
		System.out.println(mp_mvnum);

		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		String[] mpssnumEncrypts = mp_mvnum.split(",");

		for (String mpssnumEncrypt : mpssnumEncrypts) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("mp_mvnum",
					MusicStringUtil.getTmsDecryptoAesForInt(mpssnumEncrypt));
			mapList.add(map);
		}
		musicService.deletemv(mapList);
		jsontotal.setSuccess(true);
		return jsontotal;
	}

}