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
@RequestMapping(value="/company" , method = {RequestMethod.GET, RequestMethod.POST})
public class CorpController {

	private static final Logger logger = LoggerFactory
			.getLogger(CorpController.class);

	@Autowired
	private CorpService corpservice;

	/*
	 * 회사 등록 
	 */
	
	//회사 SELECT
	@RequestMapping(value = "/corpselect", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal corpselect(@RequestBody CorpSearch corpsearch) {

		Jsontotal jsontotal = new Jsontotal();
		logger.info("corpselect 연결");
		int totalCount = corpservice.corptotalcount(corpsearch);
		logger.info("totalCount : " + totalCount);
		List<CorpCompany> corplist = corpservice.selectcorpview(corpsearch); // nullpoint
		logger.info("corplist : " + corplist);
		jsontotal.setTotal(totalCount);
		jsontotal.setItems(corplist);
		jsontotal.setSuccess(true);
		return jsontotal;
	}


	//회사 Viewer
	@RequestMapping(value = "/corpviewer/{mpssnumEncrypt}", method = RequestMethod.GET)
	@ResponseBody
	public Jsontotal corpviewer(@PathVariable String mpssnumEncrypt) {
		Jsontotal jsontotal = new Jsontotal();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mp_corpnum",
				CorpStringUtil.getTmsDecryptoAesForInt(mpssnumEncrypt));
		jsontotal.setData(corpservice.viewcorpview(map));
		jsontotal.setSuccess(true);
		return jsontotal;
	}

	//회사 등록
	@RequestMapping(value = "/corpinsert", produces = "application/json")
	@ResponseBody
	public Jsontotal corpinsert(@RequestBody CorpCompany corpcompany) {
		Jsontotal jsontotal = new Jsontotal();
		corpservice.insertcorp(corpcompany);
		jsontotal.setSuccess(true);
		return jsontotal;
	}
	//회사 수정
	@RequestMapping(value = "/corpupdate", produces = "application/json")
	@ResponseBody
	public Jsontotal updatecorp(@RequestBody CorpCompany corpcompany) {
		Jsontotal jsontotal = new Jsontotal();
		corpcompany.setMp_corpnum(CorpStringUtil.getTmsDecryptoAesForInt(corpcompany
				.getMpssnumEncrypt()));
		corpservice.updatecorp(corpcompany);
		jsontotal.setSuccess(true);
		return jsontotal;
	}

	//회사 삭제
	@RequestMapping(value = "/corpdelete", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal deletecorp(@RequestBody Map<String, Object> param) {
		Jsontotal jsontotal = new Jsontotal();
		String mp_corpnum = String.valueOf(param.get("mp_corpnum"));

		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		String[] mpssnumEncrypts = mp_corpnum.split(",");

		for (String mpssnumEncrypt : mpssnumEncrypts) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("mp_corpnum",
					CorpStringUtil.getTmsDecryptoAesForInt(mpssnumEncrypt));
			mapList.add(map);
		}
		corpservice.deletecorp(mapList);
		jsontotal.setSuccess(true);
		return jsontotal;
	}

	
	/*
	 * 레이블 등록 
	 */
	
	//레이블 SELECT
	@RequestMapping(value = "/lableselect", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal lableselect(@RequestBody CorpSearch corpsearch) {

		Jsontotal jsontotal = new Jsontotal();
		logger.info("lableselect 연결");
		int totalCount = corpservice.labletotalcount(corpsearch);
		logger.info("totalCount : " + totalCount);
		List<CorpLable> corplist = corpservice.selectlableview(corpsearch); // nullpoint
		logger.info("corplist : " + corplist);
		jsontotal.setTotal(totalCount);
		jsontotal.setItems(corplist);
		jsontotal.setSuccess(true);
		return jsontotal;
	}


	//레이블 Viewer
	@RequestMapping(value = "/lableviewer/{mpssnumEncrypt}", method = RequestMethod.GET)
	@ResponseBody
	public Jsontotal lableviewer(@PathVariable String mpssnumEncrypt) {
		Jsontotal jsontotal = new Jsontotal();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mp_lablenum",
				CorpStringUtil.getTmsDecryptoAesForInt(mpssnumEncrypt));
		jsontotal.setData(corpservice.viewlableview(map));
		jsontotal.setSuccess(true);
		return jsontotal;
	}

	//레이블 등록
	@RequestMapping(value = "/lableinsert", produces = "application/json")
	@ResponseBody
	public Jsontotal lableinsert(@RequestBody CorpLable corplable) {
		Jsontotal jsontotal = new Jsontotal();
		corpservice.insertlable(corplable);
		jsontotal.setSuccess(true);
		return jsontotal;
	}
	//레이블 수정
	@RequestMapping(value = "/lableupdate", produces = "application/json")
	@ResponseBody
	public Jsontotal updatelable(@RequestBody CorpLable corplable) {
		Jsontotal jsontotal = new Jsontotal();
		corplable.setMp_lablenum(CorpStringUtil.getTmsDecryptoAesForInt(corplable
				.getMpssnumEncrypt()));
		corpservice.updatelable(corplable);
		jsontotal.setSuccess(true);
		return jsontotal;
	}

	//레이블 삭제
	@RequestMapping(value = "/labledelete", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal deletelable(@RequestBody Map<String, Object> param) {
		Jsontotal jsontotal = new Jsontotal();
		String mp_lablenum = String.valueOf(param.get("mp_lablenum"));

		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		String[] mpssnumEncrypts = mp_lablenum.split(",");

		for (String mpssnumEncrypt : mpssnumEncrypts) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("mp_lablenum",
					CorpStringUtil.getTmsDecryptoAesForInt(mpssnumEncrypt));
			mapList.add(map);
		}
		corpservice.deletelable(mapList);
		jsontotal.setSuccess(true);
		return jsontotal;
	}
	
	
	
	/*
	 * b2b 등록 
	 */
	
	//b2b SELECT
	@RequestMapping(value = "/b2bselect", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal b2bselect(@RequestBody CorpSearch corpsearch) {

		Jsontotal jsontotal = new Jsontotal();
		logger.info("lableselect 연결");
		int totalCount = corpservice.b2btotalcount(corpsearch);
		logger.info("totalCount : " + totalCount);
		List<CorpB2B> corplist = corpservice.selectb2bview(corpsearch); // nullpoint
		logger.info("corplist : " + corplist);
		jsontotal.setTotal(totalCount);
		jsontotal.setItems(corplist);
		jsontotal.setSuccess(true);
		return jsontotal;
	}


	//b2b Viewer
	@RequestMapping(value = "/b2bviewer/{mpssnumEncrypt}", method = RequestMethod.GET)
	@ResponseBody
	public Jsontotal b2bviewer(@PathVariable String mpssnumEncrypt) {
		Jsontotal jsontotal = new Jsontotal();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mp_b2bnum",
				CorpStringUtil.getTmsDecryptoAesForInt(mpssnumEncrypt));
		jsontotal.setData(corpservice.viewb2bview(map));
		jsontotal.setSuccess(true);
		return jsontotal;
	}

	//b2b 등록
	@RequestMapping(value = "/b2binsert", produces = "application/json")
	@ResponseBody
	public Jsontotal b2binsert(@RequestBody CorpB2B corpb2b) {
		Jsontotal jsontotal = new Jsontotal();
		corpservice.insertb2b(corpb2b);
		jsontotal.setSuccess(true);
		return jsontotal;
	}
	//b2b 수정
	@RequestMapping(value = "/b2bupdate", produces = "application/json")
	@ResponseBody
	public Jsontotal updateb2b(@RequestBody CorpB2B corpb2b) {
		Jsontotal jsontotal = new Jsontotal();
		corpb2b.setMp_b2bnum(CorpStringUtil.getTmsDecryptoAesForInt(corpb2b
				.getMpssnumEncrypt()));
		corpservice.updateb2b(corpb2b);
		jsontotal.setSuccess(true);
		return jsontotal;
	}

	//b2b 삭제
	@RequestMapping(value = "/b2bdelete", method = RequestMethod.POST)
	@ResponseBody
	public Jsontotal deleteb2b(@RequestBody Map<String, Object> param) {
		Jsontotal jsontotal = new Jsontotal();
		String mp_b2bnum = String.valueOf(param.get("mp_b2bnum"));

		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		String[] mpssnumEncrypts = mp_b2bnum.split(",");

		for (String mpssnumEncrypt : mpssnumEncrypts) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("mp_b2bnum",
					CorpStringUtil.getTmsDecryptoAesForInt(mpssnumEncrypt));
			mapList.add(map);
		}
		corpservice.deleteb2b(mapList);
		jsontotal.setSuccess(true);
		return jsontotal;
	}
	
}