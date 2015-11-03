package mplanweb.music.web.contents;

import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import mplanweb.music.web.admin.WebController;

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

/*
 * 
 * Title : ??κ΄?λ¦? μ»¨νΈλ‘€λ¬
 * Author : κΉ?? ? (2015.05.15)
 *
 * 
 * 
 * 
 */

@Controller
@RequestMapping("/source")
public class MusicController {

	/*
	 * 
	 * Logger
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(MusicController.class);

	@Autowired
	private MusicService musicService;


	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * View =========> ssviewselect =========> jsontotal ======> DB =====>
	 * Ssview ===> /music/ssviewselect.jsp ?? λ¦¬μ€?Έ (List)
	 * 
	 * @param ssearch
	 * 
	 * @return jsontotal
	 */
	@RequestMapping(value = "/ssviewselect", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal ssviewselect(@RequestBody Ssearch ssearch) {
		// Json ???Όλ‘? λ³??? ? €κ³? ??± parameter json => result json
		Jsontotal jsontotal = new Jsontotal();
		// μΉ΄μ΄?Έ κ³μ°
		int totalCount = musicService.selecttotalcount(ssearch);
		System.out.println("μ΄? κ°?? : " + totalCount);
		// λ¦¬μ€?Έ ??
		List<Ssview> musiclist = musicService.selectSsview(ssearch); // nullpoint
		jsontotal.setTotal(totalCount);
		jsontotal.setItems(musiclist);
		jsontotal.setSuccess(true);

		// λ¦¬ν΄
		return jsontotal;
	}

	/*
	 * View =========> ssviewselect =========> jsontotal ======> DB =====>
	 * Ssview ===> /music/ssviewselect.jsp ?? κ΄?λ¦? ? ? (List)
	 * 
	 * @param mpssnumEncrypt
	 * 
	 * @return jsontotal
	 */
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

		// Jsontotal
		// int mp_num = Integer.parseInt(request.getParameter("num")); // ??°?€?Έ
		// ?΄λ¦? Request
		String num_p = request.getParameter("num"); // ??°?€?Έ ?΄λ¦? Request
		int mp_num = Integer.parseInt(num_p);
		String mp_artist = request.getParameter("artist"); // ??? λͺ? Request
		String mp_title = request.getParameter("title"); // ?¨λ²λͺ Request
		String mp_album = request.getParameter("album"); // κ°??¬ Request
		String mp_lyric = request.getParameter("lyric"); // ??°?€?Έ ?΄λ¦? Request
		String mp_label = request.getParameter("label"); // ??? λͺ? Request
		String mp_corp = request.getParameter("corp"); // ?¨λ²λͺ Request
		String mp_year = request.getParameter("year"); // κ°??¬ Request
		String mp_genre1 = request.getParameter("genre1"); // ??°?€?Έ ?΄λ¦? Request
		String mp_genre2 = request.getParameter("genre2"); // ??? λͺ? Request
		String mp_etc = request.getParameter("etc"); // ?¨λ²λͺ Request
		String mp_open_date = request.getParameter("copy"); // κ°??¬ Request
		String mp_age = request.getParameter("age"); // ??°?€?Έ ?΄λ¦? Request
		String mp_useyn = request.getParameter("RadioGroup1"); // ??? λͺ? Request
		MultipartFile mimg = request.getFile("imgupload");
		MultipartFile m320k = request.getFile("m320kupload");
		MultipartFile m192k = request.getFile("m192kupload");

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

			// ///////////////////////////////////////////////////////////////////////
			// Upload ??Όλͺ? UUIDλ³?κ²? (?? ??€ ??Ό?΄λ¦? λ³?κ²?)
			// ///////////////////////////////////////////////////////////////////////
			String mp_imgo = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ mp_img.substring(mp_img.lastIndexOf("."));
			String mp_320ko = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ mp_320k.substring(mp_320k.lastIndexOf("."));
			String mp_192ko = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ mp_192k.substring(mp_192k.lastIndexOf("."));

			// ///////////////////////////////////////////////////////////////////////
			// Upload ?΄??μΉ? ?€? 
			// ///////////////////////////////////////////////////////////////////////
			String uploadimgPath = "E://upload//img//";
			String upload320Path = "E://upload//music320k//";
			String upload192Path = "E://upload//music192k//";

			// ///////////////////////////////////////////////////////////////////////
			// Upload ??Ό?¬?΄μ¦? 0?΄ ???Όλ©?... ?λ‘λ
			// ///////////////////////////////////////////////////////////////////////
			if (mimg.getSize() != 0) {
				mimg.transferTo(new File(uploadimgPath + "/" + mp_imgo));
			}
			if (m192k.getSize() != 0) {
				m192k.transferTo(new File(upload192Path + "/" + mp_192ko));
			}
			if (m320k.getSize() != 0) {
				m320k.transferTo(new File(upload320Path + "/" + mp_320ko));
			}

			// ///////////////////////////////////////////////////////////////////////
			// Hashput ?? ₯
			// ///////////////////////////////////////////////////////////////////////
			Ssview ssview = new Ssview();
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
			System.out.println("Jsontotal : " + jsontotal);
			jsontotal.setSuccess(true);

		}

		return jsontotal;
	}

	/*
	 * View =========> ssviewupdate =========> jsontotal ======> DB =====>
	 * Ssview ===> /music/ssviewselect.jsp ?? κ΄?λ¦? ? ? (List)
	 * 
	 * @param ssviewupdate
	 * 
	 * @return jsontotal
	 */
	@RequestMapping(value = "/ssviewupdate", produces = "application/json")
	@ResponseBody
	public Jsontotal updatessview(MultipartHttpServletRequest request)
			throws Exception {
		// Jsontotal
		// int mp_num = Integer.parseInt(request.getParameter("num")); // ??°?€?Έ
		// ?΄λ¦? Request
		String num_pm = request.getParameter("mpssnumEncrypt"); // ??°?€?Έ ?΄λ¦?
																// Request
		String num_p = request.getParameter("num"); // ??°?€?Έ ?΄λ¦? Request
		int mp_num = Integer.parseInt(num_p);
		String mp_artist = request.getParameter("artist"); // ??? λͺ? Request
		String mp_title = request.getParameter("title"); // ?¨λ²λͺ Request
		String mp_album = request.getParameter("album"); // κ°??¬ Request
		String mp_lyric = request.getParameter("lyric"); // ??°?€?Έ ?΄λ¦? Request
		String mp_label = request.getParameter("label"); // ??? λͺ? Request
		String mp_corp = request.getParameter("corp"); // ?¨λ²λͺ Request
		String mp_year = request.getParameter("year"); // κ°??¬ Request
		String mp_genre1 = request.getParameter("genre1"); // ??°?€?Έ ?΄λ¦? Request
		String mp_genre2 = request.getParameter("genre2"); // ??? λͺ? Request
		String mp_etc = request.getParameter("etc"); // ?¨λ²λͺ Request
		String mp_open_date = request.getParameter("copy"); // κ°??¬ Request
		String mp_age = request.getParameter("age"); // ??°?€?Έ ?΄λ¦? Request
		String mp_useyn = request.getParameter("RadioGroup1"); // ??? λͺ? Request
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

			// ///////////////////////////////////////////////////////////////////////
			// Upload ??Όλͺ? UUIDλ³?κ²? (?? ??€ ??Ό?΄λ¦? λ³?κ²?)
			// ///////////////////////////////////////////////////////////////////////
			String mp_imgo = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ mp_img.substring(mp_img.lastIndexOf("."));
			String mp_320ko = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ mp_320k.substring(mp_320k.lastIndexOf("."));
			String mp_192ko = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ mp_192k.substring(mp_192k.lastIndexOf("."));

			// ///////////////////////////////////////////////////////////////////////
			// Upload ?΄??μΉ? ?€? 
			// ///////////////////////////////////////////////////////////////////////
			String uploadimgPath = "E://upload//img//";
			String upload192Path = "E://upload//music192k//";
			String upload320Path = "E://upload//music320k//";

			// ///////////////////////////////////////////////////////////////////////
			// Upload ??Ό?¬?΄μ¦? 0?΄ ???Όλ©?... ?λ‘λ
			// ///////////////////////////////////////////////////////////////////////
			if (mimg.getSize() != 0) {
				mimg.transferTo(new File(uploadimgPath + "/" + mp_imgo));
			}
			if (m192k.getSize() != 0) {
				m192k.transferTo(new File(upload192Path + "/" + mp_320ko));
			}
			if (m320k.getSize() != 0) {
				m320k.transferTo(new File(upload320Path + "/" + mp_192ko));
			}

			// ///////////////////////////////////////////////////////////////////////
			// Hashput ?? ₯
			// ///////////////////////////////////////////////////////////////////////
			Ssview ssview = new Ssview();
			// yboard.setBoardID(YKStringUtil.getTmsDecryptoAesForInt(yboard.getBoardIDEncrypt()));
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
			System.out.println("Jsontotal : " + jsontotal);
			jsontotal.setSuccess(true);

		}

		return jsontotal;
	}

	/*
	 * View =========> ssviewdelete =========> jsontotal ======> DB =====>
	 * Ssview ===> /music/ssviewselect.jsp ?? κ΄?λ¦? ? ? (List)
	 * 
	 * @param ssviewdelete
	 * 
	 * @return jsontotal
	 */
	@RequestMapping(value = "/ssviewdelete", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal deletessview(@RequestBody Map<String, Object> param, String mp_imgo) {
		Jsontotal jsontotal = new Jsontotal();
		String mp_mpnum = String.valueOf(param.get("mp_mpnum"));
		//String mp_imgo = String.valueOf(param.get("mp_imgo"));
		System.out.println("mp_mpnum : " + mp_mpnum);
		System.out.println("mp_imgo : " + mp_imgo);
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		String[] mpssnumEncrypts = mp_mpnum.split(",");

		for (String mpssnumEncrypt : mpssnumEncrypts) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("mp_mpnum",
					MusicStringUtil.getTmsDecryptoAesForInt(mpssnumEncrypt));
			mapList.add(map);
		}
		//musicService.deletessearch(mapList);
		jsontotal.setSuccess(true);
		return jsontotal;
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * View =========> abviewselect =========> jsontotal ======> DB =====>
	 * Ssview ===> /music/ssviewselect.jsp ?? κ΄?λ¦? ? ? (List)
	 * 
	 * @param abviewselect
	 * 
	 * @return jsontotal
	 */
	// Album
	@RequestMapping(value = "/abviewselect", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal albumviewselect(@RequestBody Ssearch ssearch) {
		// Json ???Όλ‘? λ³??? ? €κ³? ??± parameter json => result json
		Jsontotal jsontotal = new Jsontotal();
		// μΉ΄μ΄?Έ κ³μ°
		System.out.println("ssearch : " + ssearch);
		int totalCount = musicService.albumtotalcount(ssearch);
		System.out.println("totalCount : " + totalCount);
		// λ¦¬μ€?Έ ??
		List<SsAlbum> albumlist = musicService.selectalbumview(ssearch); // nullpoint
		jsontotal.setTotal(totalCount);
		jsontotal.setItems(albumlist);
		System.out.println("Jsontotal : " + jsontotal);
		System.out.println("musiclist : " + albumlist);
		jsontotal.setSuccess(true);
		System.out.println("musiclist : " + albumlist);
		System.out.println("Jsontotal : " + jsontotal);
		// λ¦¬ν΄
		return jsontotal;
	}

	/*
	 * View =========> abviewer =========> jsontotal ======> DB =====> Ssview
	 * ===> /music/ssviewselect.jsp ?? κ΄?λ¦? ? ? (List)
	 * 
	 * @param abviewer
	 * 
	 * @return jsontotal
	 */
	@RequestMapping(value = "/abviewer/{mpssnumEncrypt}", method = RequestMethod.GET)
	@ResponseBody
	public Jsontotal albumviewSelect(@PathVariable String mpssnumEncrypt) {
		System.out.println("mpssnumEncrypt : " + mpssnumEncrypt);
		Jsontotal jsontotal = new Jsontotal();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mp_alnum",
				MusicStringUtil.getTmsDecryptoAesForInt(mpssnumEncrypt));
		jsontotal.setData(musicService.viewalbumview(map));
		System.out.println("jsontotal : " + jsontotal);
		jsontotal.setSuccess(true);
		return jsontotal;
	}

	// jsontotal ???  ?€λ₯Έκ±Έλ‘? μΆμ§ ?΄?Ό?¨
	/*
	 * View =========> ssalbuminsert =========> jsontotal ======> DB =====>
	 * Ssview ===> /music/ssviewselect.jsp ?? κ΄?λ¦? ? ? (List)
	 * 
	 * @param ssalbuminsert
	 * 
	 * @return jsontotal
	 */
	@RequestMapping(value = "/ssalbuminsert", produces = "application/json")
	@ResponseBody
	public Jsontotal insertssalbum(MultipartHttpServletRequest request)
			throws Exception {

		// Jsontotal
		// int mp_num = Integer.parseInt(request.getParameter("num")); // ??°?€?Έ
		// ?΄λ¦? Request

		// String num_p = request.getParameter("mp_alnum"); // ??°?€?Έ ?΄λ¦? Request
		// int mp_alnum = Integer.parseInt(num_p);
		String mp_artist = request.getParameter("artist"); // ??? λͺ? Request
		String mp_album = request.getParameter("album"); // ?¨λ²λͺ Request
		String mp_content = request.getParameter("content"); // κ°??¬ Request
		String mp_year = request.getParameter("year"); // ??? λͺ? Request
		String mp_corp = request.getParameter("corp"); // ?¨λ²λͺ Request
		String mp_useyn = request.getParameter("RadioGroup1"); // ??? λͺ? Request
		MultipartFile mimg = request.getFile("imgupload");

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

			// ///////////////////////////////////////////////////////////////////////
			// Upload ??Όλͺ? UUIDλ³?κ²? (?? ??€ ??Ό?΄λ¦? λ³?κ²?)
			// ///////////////////////////////////////////////////////////////////////
			String mp_albumimgorg = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ mp_albumimg.substring(mp_albumimg.lastIndexOf("."));

			// ///////////////////////////////////////////////////////////////////////
			// Upload ?΄??μΉ? ?€? 
			// ///////////////////////////////////////////////////////////////////////
			String uploadimgPath = "E://upload//albumimg//";

			// ///////////////////////////////////////////////////////////////////////
			// Upload ??Ό?¬?΄μ¦? 0?΄ ???Όλ©?... ?λ‘λ
			// ///////////////////////////////////////////////////////////////////////
			if (mimg.getSize() != 0) {
				mimg.transferTo(new File(uploadimgPath + "/" + mp_albumimgorg));
			}

			// ///////////////////////////////////////////////////////////////////////
			// Hashput ?? ₯
			// ///////////////////////////////////////////////////////////////////////
			SsAlbum ssalbum = new SsAlbum();

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
			System.out.println("Jsontotal : " + jsontotal);
			jsontotal.setSuccess(true);

		}

		return jsontotal;
	}

	/*
	 * View =========> ssalbumupdate =========> jsontotal ======> DB =====>
	 * Ssview ===> /music/ssviewselect.jsp ?? κ΄?λ¦? ? ? (List)
	 * 
	 * @param ssalbumupdate
	 * 
	 * @return jsontotal
	 */
	@RequestMapping(value = "/ssalbumupdate", produces = "application/json")
	@ResponseBody
	public Jsontotal updatessalbum(MultipartHttpServletRequest request)
			throws Exception {

		String num_pm = request.getParameter("mpssnumEncrypt"); // ??°?€?Έ ?΄λ¦?
		String mp_artist = request.getParameter("artist"); // ??? λͺ? Request
		String mp_album = request.getParameter("album"); // ?¨λ²λͺ Request
		String mp_content = request.getParameter("content"); // κ°??¬ Request
		String mp_year = request.getParameter("year"); // ??? λͺ? Request
		String mp_corp = request.getParameter("corp"); // ?¨λ²λͺ Request
		String mp_useyn = request.getParameter("RadioGroup1"); // ??? λͺ? Request
		MultipartFile mimg = request.getFile("imgupload");

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

			// ///////////////////////////////////////////////////////////////////////
			// Upload ??Όλͺ? UUIDλ³?κ²? (?? ??€ ??Ό?΄λ¦? λ³?κ²?)
			// ///////////////////////////////////////////////////////////////////////
			String mp_albumimgorg = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ mp_albumimg.substring(mp_albumimg.lastIndexOf("."));

			// ///////////////////////////////////////////////////////////////////////
			// Upload ?΄??μΉ? ?€? 
			// ///////////////////////////////////////////////////////////////////////
			String uploadimgPath = "E://upload//albumimg//";

			// ///////////////////////////////////////////////////////////////////////
			// Upload ??Ό?¬?΄μ¦? 0?΄ ???Όλ©?... ?λ‘λ
			// ///////////////////////////////////////////////////////////////////////
			if (mimg.getSize() != 0) {
				mimg.transferTo(new File(uploadimgPath + "/" + mp_albumimgorg));
			}

			// ///////////////////////////////////////////////////////////////////////
			// Hashput ?? ₯
			// ///////////////////////////////////////////////////////////////////////
			SsAlbum ssalbum = new SsAlbum();

			ssalbum.setMp_alnum(MusicStringUtil.getTmsDecryptoAesForInt(num_pm));
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
			System.out.println("Jsontotal : " + jsontotal);
			jsontotal.setSuccess(true);

		}

		return jsontotal;
	}

	/*
	 * View =========> ssalbumdelete =========> jsontotal ======> DB =====>
	 * Ssview ===> /music/ssviewselect.jsp ?? κ΄?λ¦? ? ? (List)
	 * 
	 * @param ssalbumdelete
	 * 
	 * @return jsontotal
	 */
	@RequestMapping(value = "/ssalbumdelete", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal deletessalbum(@RequestBody Map<String, Object> param) {
		Jsontotal jsontotal = new Jsontotal();
		String mp_mpnum = String.valueOf(param.get("mp_alnum"));
		System.out.println("mp_alnum : " + mp_mpnum);
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

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * View =========> artviewselect =========> jsontotal ======> DB =====>
	 * Ssview ===> /music/ssviewselect.jsp ?? κ΄?λ¦? ? ? (List)
	 * 
	 * @param artviewselect
	 * 
	 * @return jsontotal
	 */

	@RequestMapping(value = "/artviewselect", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal artistviewselect(@RequestBody Ssearch ssearch) {
		// Json ???Όλ‘? λ³??? ? €κ³? ??± parameter json => result json
		Jsontotal jsontotal = new Jsontotal();
		// μΉ΄μ΄?Έ κ³μ°
		System.out.println("ssearch : " + ssearch);
		int totalCount = musicService.artisttotalcount(ssearch);
		System.out.println("totalCount : " + totalCount);
		// λ¦¬μ€?Έ ??
		List<Ssartist> artistlist = musicService.selectartistview(ssearch); // nullpoint
		jsontotal.setTotal(totalCount);
		jsontotal.setItems(artistlist);
		System.out.println("Jsontotal : " + jsontotal);
		System.out.println("musiclist : " + artistlist);
		jsontotal.setSuccess(true);
		System.out.println("musiclist : " + artistlist);
		System.out.println("Jsontotal : " + jsontotal);
		// λ¦¬ν΄
		return jsontotal;
	}

	/*
	 * View =========> artviewer =========> jsontotal ======> DB =====> Ssview
	 * ===> /music/ssviewselect.jsp ?? κ΄?λ¦? ? ? (List)
	 * 
	 * @param artviewer
	 * 
	 * @return jsontotal
	 */
	@RequestMapping(value = "/artviewer/{mpssnumEncrypt}", method = RequestMethod.GET)
	@ResponseBody
	public Jsontotal artistviewSelect(@PathVariable String mpssnumEncrypt) {
		System.out.println("mpssnumEncrypt : " + mpssnumEncrypt);
		Jsontotal jsontotal = new Jsontotal();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mp_anum",
				MusicStringUtil.getTmsDecryptoAesForInt(mpssnumEncrypt));
		jsontotal.setData(musicService.viewartistview(map));
		System.out.println("jsontotal : " + jsontotal);
		jsontotal.setSuccess(true);
		return jsontotal;
	}

	// jsontotal ???  ?€λ₯Έκ±Έλ‘? μΆμ§ ?΄?Ό?¨
	/*
	 * View =========> ssartistinsert =========> jsontotal ======> DB =====>
	 * Ssview ===> /music/ssviewselect.jsp ?? κ΄?λ¦? ? ? (List)
	 * 
	 * @param ssartistinsert
	 * 
	 * @return jsontotal
	 */
	@RequestMapping(value = "/ssartistinsert", produces = "application/json")
	@ResponseBody
	public Jsontotal insertartist(MultipartHttpServletRequest request)
			throws Exception {

		String mp_artist = request.getParameter("artist"); // ??? λͺ? Request
		String mp_content = request.getParameter("content"); // ?¨λ²λͺ Request
		String mp_label = request.getParameter("label"); // κ°??¬ Request
		String mp_debut = request.getParameter("debut"); // ??? λͺ? Request
		String mp_useyn = request.getParameter("RadioGroup1"); // ?¨λ²λͺ Request
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

			// ///////////////////////////////////////////////////////////////////////
			// Upload ??Όλͺ? UUIDλ³?κ²? (?? ??€ ??Ό?΄λ¦? λ³?κ²?)
			// ///////////////////////////////////////////////////////////////////////
			String mp_artistorg = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ mp_artistimg.substring(mp_artistimg.lastIndexOf("."));

			// ///////////////////////////////////////////////////////////////////////
			// Upload ?΄??μΉ? ?€? 
			// ///////////////////////////////////////////////////////////////////////
			String uploadimgPath = "E://upload//artistimg//";

			// ///////////////////////////////////////////////////////////////////////
			// Upload ??Ό?¬?΄μ¦? 0?΄ ???Όλ©?... ?λ‘λ
			// ///////////////////////////////////////////////////////////////////////
			if (mimg.getSize() != 0) {
				mimg.transferTo(new File(uploadimgPath + "/" + mp_artistorg));
			}

			// ///////////////////////////////////////////////////////////////////////
			// Hashput ?? ₯
			// ///////////////////////////////////////////////////////////////////////
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
			System.out.println("Jsontotal : " + jsontotal);
			jsontotal.setSuccess(true);

		}

		return jsontotal;
	}

	/*
	 * View =========> ssartistupdate =========> jsontotal ======> DB =====>
	 * Ssview ===> /music/ssviewselect.jsp ?? κ΄?λ¦? ? ? (List)
	 * 
	 * @param ssartistupdate
	 * 
	 * @return jsontotal
	 */
	@RequestMapping(value = "/ssartistupdate", produces = "application/json")
	@ResponseBody
	public Jsontotal updateartist(MultipartHttpServletRequest request)
			throws Exception {

		String num_pm = request.getParameter("mpssnumEncrypt"); // ??°?€?Έ ?΄λ¦?;
		String mp_artist = request.getParameter("artist"); // ??? λͺ? Request
		String mp_content = request.getParameter("content"); // ?¨λ²λͺ Request
		String mp_label = request.getParameter("label"); // κ°??¬ Request
		String mp_debut = request.getParameter("debut"); // ??? λͺ? Request
		String mp_useyn = request.getParameter("RadioGroup1"); // ?¨λ²λͺ Request
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

			// ///////////////////////////////////////////////////////////////////////
			// Upload ??Όλͺ? UUIDλ³?κ²? (?? ??€ ??Ό?΄λ¦? λ³?κ²?)
			// ///////////////////////////////////////////////////////////////////////
			String mp_artistorg = System.currentTimeMillis()
					+ UUID.randomUUID().toString()
					+ mp_artistimg.substring(mp_artistimg.lastIndexOf("."));

			// ///////////////////////////////////////////////////////////////////////
			// Upload ?΄??μΉ? ?€? 
			// ///////////////////////////////////////////////////////////////////////
			String uploadimgPath = "E://upload//albumimg//";

			// ///////////////////////////////////////////////////////////////////////
			// Upload ??Ό?¬?΄μ¦? 0?΄ ???Όλ©?... ?λ‘λ
			// ///////////////////////////////////////////////////////////////////////
			if (mimg.getSize() != 0) {
				mimg.transferTo(new File(uploadimgPath + "/" + mp_artistorg));
			}

			// ///////////////////////////////////////////////////////////////////////
			// Hashput ?? ₯
			// ///////////////////////////////////////////////////////////////////////
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
			System.out.println("Jsontotal : " + jsontotal);
			jsontotal.setSuccess(true);

		}

		return jsontotal;
	}

	/*
	 * View =========> ssartistdelete =========> jsontotal ======> DB =====>
	 * Ssview ===> /music/ssviewselect.jsp ?? κ΄?λ¦? ? ? (List)
	 * 
	 * @param ssartistdelete
	 * 
	 * @return jsontotal
	 */
	@RequestMapping(value = "/ssartistdelete", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal deleteartist(@RequestBody Map<String, Object> param) {
		Jsontotal jsontotal = new Jsontotal();
		String mp_mpnum = String.valueOf(param.get("mp_anum"));
		System.out.println("mp_anum : " + mp_mpnum);
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

	/*
	 * View =========> ssartistdelete =========> jsontotal ======> DB =====>
	 * Ssview ===> /music/ssviewselect.jsp ?? κ΄?λ¦? ? ? (List)
	 * 
	 * @param ssartistdelete
	 * 
	 * @return jsontotal
	 */
	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// artist
	@RequestMapping(value = "/corpviewselect", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal corpviewselect(@RequestBody Ssearch ssearch) {
		// Json ???Όλ‘? λ³??? ? €κ³? ??± parameter json => result json
		Jsontotal jsontotal = new Jsontotal();
		// μΉ΄μ΄?Έ κ³μ°
		System.out.println("ssearch : " + ssearch);
		int totalCount = musicService.corptotalcount(ssearch);
		System.out.println("totalCount : " + totalCount);
		// λ¦¬μ€?Έ ??
		List<Sscorp> corplist = musicService.selectcorpview(ssearch); // nullpoint
		jsontotal.setTotal(totalCount);
		jsontotal.setItems(corplist);
		System.out.println("Jsontotal : " + jsontotal);
		System.out.println("musiclist : " + corplist);
		jsontotal.setSuccess(true);
		System.out.println("musiclist : " + corplist);
		System.out.println("Jsontotal : " + jsontotal);
		// λ¦¬ν΄
		return jsontotal;
	}

	@RequestMapping(value = "/corpviewer/{mpssnumEncrypt}", method = RequestMethod.GET)
	@ResponseBody
	public Jsontotal corpviewSelect(@PathVariable String mpssnumEncrypt) {
		System.out.println("mpssnumEncrypt : " + mpssnumEncrypt);
		Jsontotal jsontotal = new Jsontotal();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mp_corpnum",
				MusicStringUtil.getTmsDecryptoAesForInt(mpssnumEncrypt));
		jsontotal.setData(musicService.viewcorpview(map));
		System.out.println("jsontotal : " + jsontotal);
		jsontotal.setSuccess(true);
		return jsontotal;
	}

	// jsontotal ???  ?€λ₯Έκ±Έλ‘? μΆμ§ ?΄?Ό?¨

	@RequestMapping(value = "/sscorpinsert", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal insertcorp(@RequestBody Sscorp sscorp) {
		System.out.println("sscorp : " + sscorp);
		Jsontotal jsontotal = new Jsontotal();
		musicService.insertcorp(sscorp);
		System.out.println("jsontotal : " + jsontotal);
		jsontotal.setSuccess(true);
		return jsontotal;
	}

	@RequestMapping(value = "/sscorpupdate", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal updatecorp(@RequestBody Sscorp sscorp) {
		Jsontotal jsontotal = new Jsontotal();
		System.out.println(sscorp.getMpssnumEncrypt());
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
		System.out.println("mp_corpnum : " + mp_corpnum);

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
}