/**
 * 前台主页 2014-06-25 孙建国
 */
package com.ttgis.recruit.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ttgis.recruit.domain.Bmgl;
import com.ttgis.recruit.domain.Collect_position;
import com.ttgis.recruit.domain.Jtjlk;
import com.ttgis.recruit.domain.Kcgl;
import com.ttgis.recruit.domain.Ksxcgl;
import com.ttgis.recruit.domain.MyApplication;
import com.ttgis.recruit.domain.Position;
import com.ttgis.recruit.domain.PositionWithBLOBs;
import com.ttgis.recruit.domain.QueryKcgl;
import com.ttgis.recruit.domain.QueryXxtz;
import com.ttgis.recruit.domain.QueryZw;
import com.ttgis.recruit.domain.Resume;
import com.ttgis.recruit.domain.Resume_jyjl;
import com.ttgis.recruit.domain.Userinfo;
import com.ttgis.recruit.domain.Xcxx;
import com.ttgis.recruit.domain.Xxtz;
import com.ttgis.recruit.domain.Zpxw;
import com.ttgis.recruit.domain.Zpzy;
import com.ttgis.recruit.domain.Zylb;
import com.ttgis.recruit.domain.Zzjg;
import com.ttgis.recruit.domain.ZzjgCondition;
import com.ttgis.recruit.service.BmglService;
import com.ttgis.recruit.service.CollectionService;
import com.ttgis.recruit.service.JtjlkService;
import com.ttgis.recruit.service.KcglService;
import com.ttgis.recruit.service.KsxcglService;
import com.ttgis.recruit.service.KsxtkbglService;
import com.ttgis.recruit.service.MsjgService;
import com.ttgis.recruit.service.ResumeService;
import com.ttgis.recruit.service.Resume_jyjlService;
import com.ttgis.recruit.service.XcxxService;
import com.ttgis.recruit.service.XxtzService;
import com.ttgis.recruit.service.ZpxwService;
import com.ttgis.recruit.service.ZwglService;
import com.ttgis.recruit.service.ZzjgService;
import com.ttgis.recruit.utility.random.RandomGUIDUtil;

/**
 * 
 * @author SJG
 * 
 */
@Controller
public class MainController {
    @Resource
    ZpxwService zpxwService;
    @Resource
    XcxxService xcxxService;
    @Resource
    ZwglService zwglService;
    @Resource
    XxtzService xxtzService;
    @Resource
    ZzjgService zzjgService;
    @Resource
    ResumeService resumeService;
    @Resource
    JtjlkService jtjlkService;
    @Resource
    CollectionService collectionService;
    @Autowired
    KcglService kcglService;
    @Autowired
    BmglService bmglService;
    @Autowired
    MsjgService msjgService;
    @Autowired
    Resume_jyjlService resume_jyjlService;
    @Autowired
    private KsxcglService ksxcglService;

    static Logger log = Logger.getLogger(MainController.class);
    @Autowired
    private HttpServletRequest request;
    @Autowired
    HttpSession session;

    protected String getRemoteIp() {
	String remoteIp = null;
	remoteIp = request.getHeader("x-forwarded-for");
	if (remoteIp == null || remoteIp.isEmpty() || "unknown".equalsIgnoreCase(remoteIp)) {
	    remoteIp = request.getHeader("X-Real-IP");
	}
	if (remoteIp == null || remoteIp.isEmpty() || "unknown".equalsIgnoreCase(remoteIp)) {
	    remoteIp = request.getHeader("Proxy-Client-IP");
	}
	if (remoteIp == null || remoteIp.isEmpty() || "unknown".equalsIgnoreCase(remoteIp)) {
	    remoteIp = request.getHeader("WL-Proxy-Client-IP");
	}
	if (remoteIp == null || remoteIp.isEmpty() || "unknown".equalsIgnoreCase(remoteIp)) {
	    remoteIp = request.getHeader("HTTP_CLIENT_IP");
	}
	if (remoteIp == null || remoteIp.isEmpty() || "unknown".equalsIgnoreCase(remoteIp)) {
	    remoteIp = request.getHeader("HTTP_X_FORWARDED_FOR");
	}
	if (remoteIp == null || remoteIp.isEmpty() || "unknown".equalsIgnoreCase(remoteIp)) {
	    remoteIp = request.getRemoteAddr();
	}
	if (remoteIp == null || remoteIp.isEmpty() || "unknown".equalsIgnoreCase(remoteIp)) {
	    remoteIp = request.getRemoteHost();
	}
	return remoteIp;
    }

    public void logInfo(String _call, String _parameter) {
	StringBuilder stringBuilder = new StringBuilder();
	stringBuilder.append(" Ip:");
	stringBuilder.append("【");
	stringBuilder.append(getRemoteIp());
	stringBuilder.append("】");
	stringBuilder.append(" SessionUId:");
	stringBuilder.append("【");
	if (session.getAttribute("userId") != null)
	    stringBuilder.append(session.getAttribute("userId"));
	if (session.getAttribute("zzjgId") != null)
	    stringBuilder.append(session.getAttribute("zzjgId"));
	stringBuilder.append("】");
	stringBuilder.append(" Call:");
	stringBuilder.append("【");
	stringBuilder.append(_call);
	stringBuilder.append("】");
	stringBuilder.append(" Parameter:");
	stringBuilder.append("【");
	stringBuilder.append(_parameter);
	stringBuilder.append("】");
	log.info(stringBuilder);
    }

    @RequestMapping(value = "/Main", method = RequestMethod.GET)
    public ModelAndView Main() {
	logInfo("Main", "");
	// 招聘新闻
	List<Zpxw> zpxws = zpxwService.select();
	ModelAndView mv = new ModelAndView();
	mv.addObject("zpxw", zpxws);
	// 二级单位
	List<Zzjg> zzjgs = zzjgService.selectBySjdw("test001");
	mv.addObject("zzjg", zzjgs);
	// 三级单位
	List<Zzjg> zzjgs3 = zzjgService.selectSanjidw("");
	mv.addObject("zzjg3", zzjgs3);
	List<Zylb> zylbs = zwglService.LoadZylbMain();
	for (Zylb zylb : zylbs) {
	    List<Zpzy> zpzys = zwglService.LoadZpzy(zylb.getZylbName());
	    zylb.setZpzys(zpzys);
	}
	mv.addObject("zylb", zylbs);
	return new ModelAndView("Main/Main", "mv", mv);
    }

    // a页面
    @RequestMapping(value = "/ErospaceAndDefense", method = RequestMethod.GET)
    public ModelAndView ErospaceAndDefense() {
	return new ModelAndView("shouyesidanye/ErospaceAndDefense");
    }

    // o页面
    @RequestMapping(value = "/TheProperty", method = RequestMethod.GET)
    public ModelAndView TheProperty() {
	return new ModelAndView("shouyesidanye/TheProperty");
    }

    // i页面
    @RequestMapping(value = "/NformationTechnology", method = RequestMethod.GET)
    public ModelAndView NformationTechnology() {
	return new ModelAndView("shouyesidanye/NformationTechnology");
    }

    // e页面
    @RequestMapping(value = "/QuipmentManufaturing", method = RequestMethod.GET)
    public ModelAndView QuipmentManufaturing() {
	return new ModelAndView("shouyesidanye/QuipmentManufaturing");
    }

    @RequestMapping(value = "/LoginFrmFirst", method = RequestMethod.GET)
    public ModelAndView LoginFrmFirst(HttpSession session) {
	return new ModelAndView("Main/LoginFrmFirst", "", session.getAttribute("userLoginSession"));
    }

    @RequestMapping(value = "/LoginFrm", method = RequestMethod.GET)
    public ModelAndView LoginFrm(HttpSession session) {
	return new ModelAndView("Main/LoginFrm", "", session.getAttribute("userLoginSession"));
    }

    @RequestMapping(value = "/ViewNews", method = RequestMethod.GET)
    public ModelAndView ViewNews(@RequestParam(value = "id", required = false) String id) {
	logInfo("ViewNews", id);
	Zpxw zpxw = zpxwService.selectByPrimaryKey(id);
	return new ModelAndView("Main/ViewNews", "zpxw", zpxw);
    }

    @RequestMapping(value = "/Group", method = RequestMethod.GET)
    public ModelAndView Group(@RequestParam(value = "id", required = false) String id) {
	logInfo("Group", id);
	Xcxx xcxx = xcxxService.selectByPrimaryKey("09E57BF4-128B-6D1F-D988-269C158134C4");
	return new ModelAndView("Main/Group", "xcxx", xcxx);
    }

    @RequestMapping(value = "/SearchPosition", method = RequestMethod.GET)
    public ModelAndView SearchPosition() {
	return new ModelAndView("Main/SearchPosition");
    }

    @ResponseBody
    @RequestMapping(value = "/LoadPositionData", method = RequestMethod.POST)
    public ModelAndView LoadPositionData(QueryZw q, HttpSession session) {
	logInfo("LoadPositionData", JSONArray.fromObject(q).toString());
	List<PositionWithBLOBs> positions = zwglService.selectByWhere1(q);
	ModelAndView mv = new ModelAndView();
	mv.addObject("list", positions);
	if (session.getAttribute("userLoginSession") != null)
	    mv.addObject("isLogin", true);
	else
	    mv.addObject("isLogin", false);
	return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/LoadPositionDataCount", method = RequestMethod.POST)
    public int LoadPositionDataCount(QueryZw q) {
	logInfo("LoadPositionDataCount", JSONArray.fromObject(q).toString());
	int intCount = zwglService.selectCount1(q);
	return intCount;
    }

    @RequestMapping(value = "/PositionDetails", method = RequestMethod.GET)
    public ModelAndView PositionDetails(@RequestParam(value = "id", required = false) String id) {
	logInfo("PositionDetails", id);
	Position p = zwglService.selectByPrimaryKey(id);
	// 判断为优才职位，返回至优才职位详情界面
	if (p != null && p.getIsuniposition().equals("1")) {
	    return new ModelAndView("zpyc/UniPositionDetails", "position", p);
	} else {
	    return new ModelAndView("Main/PositionDetails", "position", p);
	}

    }

    @RequestMapping(value = "/SearchEnterprise", method = RequestMethod.GET)
    public ModelAndView SearchEnterprise(@RequestParam(value = "id", required = false) String id) {
	logInfo("SearchEnterprise", id);
	id = "test001";
	String con = "";
	if (id == null || id.trim() == "") {
	    con = "";
	} else {
	    Zpxw zpxw = zpxwService.selectZprc(id);
	    if (zpxw == null)
		con = "";
	    else
		con = zpxw.getZpxwContent();
	}
	return new ModelAndView("Main/SearchEnterprise", "mav", con);
    }

    @RequestMapping(value = "/MyRecruit", method = RequestMethod.GET)
    public ModelAndView MyRecruit() {
	return new ModelAndView("Main/MyRecruit");
    }

    @RequestMapping(value = "/Message", method = RequestMethod.GET)
    public ModelAndView Message(HttpSession session) {
	logInfo("Message", "");
	ModelAndView mv = new ModelAndView();
	List<Xxtz> xxtzs = new ArrayList<Xxtz>();
	if (session.getAttribute("userLoginSession") != null) {
	    mv.addObject("isLogin", true);
	    QueryXxtz q = new QueryXxtz();
	    q.setCurrentPageSize(1000000);
	    q.setPageSize(1000000);
	    q.setPageNum(1);
	    q.setUserId(((Userinfo) session.getAttribute("userLoginSession")).getUserId());
	    xxtzs = xxtzService.selectByWhere(q);
	} else {
	    mv.addObject("isLogin", false);
	}
	mv.addObject("xxtzs", xxtzs);
	return new ModelAndView("Main/Message", "mv", mv);
    }

    @RequestMapping(value = "/MessageDetails", method = RequestMethod.GET)
    public ModelAndView MessageDetails(@RequestParam(value = "id", required = false) String id) {
	logInfo("MessageDetails", id);
	ModelAndView mv = new ModelAndView();
	Xxtz xxtz = xxtzService.selectByPrimaryKey(id);
	xxtz.setXxtzIsread(0);
	Zzjg zzjg = zzjgService.selectByPrimaryKey(xxtz.getXxtzCuser());
	mv.addObject("zzjg", zzjg.getZzjgDwmc());
	mv.addObject("xxtz", xxtz);
	xxtzService.updateByPrimaryKeySelective(xxtz);
	return new ModelAndView("Main/MessageDetails", "mv", mv);
    }

    /** 
    * @Title ApplyPosition 
    * @Description 添加普通岗位和优才岗位 1.判断是否优才岗位  2.判断申请数量5+3 3.判断是否收藏  4.判断同单位是否存在优才或者普通申请 
    * @param session
    * @param id
    * @param page
    * @return
    * @throws UnsupportedEncodingException  
    * @return ModelAndView     
    */
    @RequestMapping(value = "/ApplyPosition", method = RequestMethod.GET)
    public ModelAndView ApplyPosition(HttpSession session, @RequestParam(value = "id", required = false) String id, String page)
	    throws UnsupportedEncodingException {
	logInfo("ApplyPosition", id + "," + page);
	Userinfo userinfo = (Userinfo) session.getAttribute("userLoginSession");
	if (userinfo == null) {
	    return new ModelAndView("Main/ShowAlert", "uri", "SessionLost");
	}

	Position position = zwglService.selectByPrimaryKey(id);
	Resume resume = resumeService.selectByPrimaryKeySelectiveById(userinfo.getUserId());
	// 没填写简历
	if (resume == null) {
	    return new ModelAndView("Main/ShowAlert", "uri", page + "NoResume");
	}
	List<Resume_jyjl> resume_Jyjls = resume_jyjlService.getlistResumeJyjlByResumeId(resume.getResumeId());
	Resume_jyjl resume_Jyjl = new Resume_jyjl();
	// 没填写教育经历
	if (resume_Jyjls.size() == 0) {
	    return new ModelAndView("Main/ShowAlert", "uri", page + "NoResume");
	} else {
	    resume_Jyjl = resume_Jyjls.get(resume_Jyjls.size() - 1); // 获取最新时间的毕业经历
	}

	// 收藏简历删除条件
	Map<String, String> params = new HashMap<String, String>();
	params.put("positionId", id);
	params.put("userId", userinfo.getUserId());
	// 如果在已收藏职位列表里,删除

	// 通过userid查找具体单位所有未淘汰的简历最多只有一个
	List<Jtjlk> existInJtjlk = jtjlkService.selectIsExist(params);

	// 普通、优才数目查询条件
	Map<String, String> paramsMore = new HashMap<String, String>();
	paramsMore.put("userId", userinfo.getUserId());

	Jtjlk jtjlk = new Jtjlk();

	// 判断是优才职位还是普通职位
	if (position.getIsuniposition().equals("1")) {
	    /*
	     * // 备选学校名单
	     * Map<String, Integer> shortlist = new HashMap<String, Integer>();
	     * shortlist.put("清华大学", 1);
	     * shortlist.put("北京大学", 2);
	     * shortlist.put("上海交通大学", 3);
	     * shortlist.put("复旦大学", 4);
	     * shortlist.put("浙江大学", 5);
	     * shortlist.put("南京大学", 6);
	     * shortlist.put("中国科学技术大学", 7);
	     * shortlist.put("哈尔滨工业大学", 8);
	     * shortlist.put("西安交通大学", 9);
	     * shortlist.put("北京航空航天大学", 10);
	     * shortlist.put("北京理工大学", 11);
	     * shortlist.put("西北工业大学", 12);
	     */

	    // 判断该学生是否在备选学校名单中，跳转到优才招聘简介UniPositionIntroduce
	    /*
	     * if (!shortlist.containsKey(resume_Jyjl.getResumeXxmc())) {
	     * return new ModelAndView("Main/ShowAlert", "uri", page + "OutOfList");
	     * }
	     */

	    // 不允许同时投递优才简历数量超过3家企业
	    paramsMore.put("jtjlkUniPositionId", "1");
	    if (jtjlkService.selectIsExist(paramsMore).size() >= 3) {
		return new ModelAndView("Main/ShowAlert", "uri", page + "UniMore");
	    }

	    // 已经在该单位已经报名了优才职位
	    if (existInJtjlk.size() > 0 && existInJtjlk.get(0).getJtjlkUniPositionId() != null
		    && !existInJtjlk.get(0).getJtjlkUniPositionId().isEmpty()) {
		return new ModelAndView("Main/ShowAlert", "uri", page + "UniExist");
	    }

	    // 已经在该单位报名了普通职位
	    if (existInJtjlk.size() > 0 && existInJtjlk.get(0).getJtjlkPositionId() != null && existInJtjlk.get(0).getJtjlkPositionId() != "") {
		Jtjlk exist = new Jtjlk();
		exist = existInJtjlk.get(0);
		exist.setJtjlkUniPositionId(id);

		// 更新时间
		exist.setJtjlkAddtime(new Date());

		jtjlkService.updateByPrimaryKeySelective(exist);

		// 删除收藏
		collectionService.deleteByPrimaryKey(params);
		return new ModelAndView("Main/ShowAlert", "uri", page + "UniSuccess");
	    }

	    // 在该单位未投递任何职位，且优才投递数量不大于3
	    jtjlk.setJtjlkUniPositionId(position.getPositionId());

	    jtjlk.setJtjlkAddtime(new Date());
	    jtjlk.setJtjlkByxx(resume_Jyjl.getResumeXxmc());
	    jtjlk.setJtjlkCpcj("未通知");
	    jtjlk.setJtjlkDelflag((long) 1);
	    jtjlk.setJtjlkGwlb(position.getPositionType());
	    jtjlk.setJtjlkId(RandomGUIDUtil.generateKey());
	    jtjlk.setJtjlkJlzt("未筛选");
	    jtjlk.setJtjlkCpjg("未测评");
	    jtjlk.setJtjlkMszt("未安排面试");
	    jtjlk.setJtjlkName(userinfo.getUserName());
	    jtjlk.setJtjlkSex(resume.getResumeSex());
	    jtjlk.setJtjlkUserid(userinfo.getUserId());
	    jtjlk.setJtjlkXl(resume_Jyjl.getResumeXl());
	    // 该字段为普通职位的职位名称
	    // jtjlk.setJtjlkZw(position.getPositionName());
	    jtjlk.setJtjlkZy(resume_Jyjl.getResumeZy());
	    jtjlk.setZzjgId(position.getZzjgId());
	    jtjlk.setJtjlkLy("应聘者");
	    jtjlk.setJtjlkHkd(resume.getResumeRxqhkszcsProvince() + "," + resume.getResumeRxqhkszcsCity());
	    jtjlk.setJtjlkYxpm(resume_Jyjl.getResumeYxpm());
	    jtjlk.setJtjlkBjpm(resume_Jyjl.getResumeBjpm());
	    jtjlk.setJtjlkCsrq(resume.getResumeBirthday());
	    jtjlk.setJtjlkSfzh(userinfo.getUserSfzh());
	    List<Jtjlk> seList = jtjlkService.selectStatusByUserId(userinfo.getUserId());
	    if (seList.size() == 0)
		jtjlk.setJtjlkJtjlkflag(2);
	    else
		jtjlk.setJtjlkJtjlkflag(1);
	    jtjlkService.insertSelective(jtjlk);

	    // 删除收藏
	    collectionService.deleteByPrimaryKey(params);
	    return new ModelAndView("Main/ShowAlert", "uri", page + "UniSuccess");

	} else {
	    logInfo("ApplyPosition", id + "," + page);

	    // 不允许同时投递简历数量超过5家企业
	    paramsMore.put("jtjlkPositionId", "1");
	    if (jtjlkService.selectIsExist(paramsMore).size() >= 5) {
		return new ModelAndView("Main/ShowAlert", "uri", page + "OrdMore");
	    }

	    // 已经在该单位报名了普通职位
	    if (existInJtjlk.size() > 0 && existInJtjlk.get(0).getJtjlkPositionId() != null && existInJtjlk.get(0).getJtjlkPositionId() != "") {
		return new ModelAndView("Main/ShowAlert", "uri", page + "IsExist");
	    }
	    // 已经在该单位报名了优才职位 修改普通职位字段 更新时间
	    if (existInJtjlk.size() > 0 && existInJtjlk.get(0).getJtjlkUniPositionId() != null && existInJtjlk.get(0).getJtjlkUniPositionId() != "") {
		existInJtjlk.get(0).setJtjlkPositionId(id);
		existInJtjlk.get(0).setJtjlkZw(position.getPositionName());
		existInJtjlk.get(0).setJtjlkAddtime(new Date());
		jtjlkService.updateByPrimaryKeySelective(existInJtjlk.get(0));

		// 删除收藏
		collectionService.deleteByPrimaryKey(params);
		return new ModelAndView("Main/ShowAlert", "uri", page + "ApplySuccess");
	    }

	    jtjlk.setJtjlkPositionId(position.getPositionId());

	    jtjlk.setJtjlkAddtime(new Date());
	    jtjlk.setJtjlkByxx(resume_Jyjl.getResumeXxmc());
	    jtjlk.setJtjlkCpcj("未通知");
	    jtjlk.setJtjlkDelflag((long) 1);
	    jtjlk.setJtjlkGwlb(position.getPositionType());
	    jtjlk.setJtjlkId(RandomGUIDUtil.generateKey());
	    jtjlk.setJtjlkJlzt("未筛选");
	    jtjlk.setJtjlkCpjg("未测评");
	    jtjlk.setJtjlkMszt("未安排面试");
	    jtjlk.setJtjlkName(userinfo.getUserName());
	    jtjlk.setJtjlkSex(resume.getResumeSex());
	    jtjlk.setJtjlkUserid(userinfo.getUserId());
	    jtjlk.setJtjlkXl(resume_Jyjl.getResumeXl());
	    jtjlk.setJtjlkZw(position.getPositionName());
	    jtjlk.setJtjlkZy(resume_Jyjl.getResumeZy());
	    jtjlk.setZzjgId(position.getZzjgId());
	    jtjlk.setJtjlkLy("应聘者");
	    jtjlk.setJtjlkHkd(resume.getResumeRxqhkszcsProvince() + "," + resume.getResumeRxqhkszcsCity());
	    jtjlk.setJtjlkYxpm(resume_Jyjl.getResumeYxpm());
	    jtjlk.setJtjlkBjpm(resume_Jyjl.getResumeBjpm());
	    jtjlk.setJtjlkCsrq(resume.getResumeBirthday());
	    jtjlk.setJtjlkSfzh(userinfo.getUserSfzh());
	    List<Jtjlk> seList = jtjlkService.selectStatusByUserId(userinfo.getUserId());
	    if (seList.size() == 0)
		jtjlk.setJtjlkJtjlkflag(2);
	    else
		jtjlk.setJtjlkJtjlkflag(1);
	    jtjlkService.insertSelective(jtjlk);

	    // 删除收藏
	    collectionService.deleteByPrimaryKey(params);
	    return new ModelAndView("Main/ShowAlert", "uri", page + "ApplySuccess");
	}

    }

    @RequestMapping(value = "/ApplyPositionOld", method = RequestMethod.GET)
    public ModelAndView ApplyPositionOld(HttpSession session, @RequestParam(value = "id", required = false) String id, String page)
	    throws UnsupportedEncodingException {
	logInfo("ApplyPosition", id + "," + page);
	Userinfo userinfo = (Userinfo) session.getAttribute("userLoginSession");
	if (userinfo == null) {
	    return new ModelAndView("Main/ShowAlert", "uri", "SessionLost");
	}
	Map<String, String> params = new HashMap<String, String>();
	params.put("positionId", id);
	params.put("userId", userinfo.getUserId());
	// 如果在已收藏职位列表里,删除
	collectionService.deleteByPrimaryKey(params);

	/*
	 * // 已经在该单位已经报名了
	 * 
	 * if (jtjlkService.selectIsExist(params).size() > 0) {
	 * return new ModelAndView("Main/ShowAlert", "uri", page + "IsExist");
	 * }
	 */

	// 已经在该单位已经报名了普通职位
	List<Jtjlk> existInJtjlk = jtjlkService.selectIsExist(params);
	if (existInJtjlk.size() > 0 && existInJtjlk.get(0).getJtjlkPositionId() != null && existInJtjlk.get(0).getJtjlkPositionId() != "") {
	    return new ModelAndView("Main/ShowAlert", "uri", page + "IsExist");
	}

	// 已经在该单位报名了优才职位 修改普通职位字段
	if (existInJtjlk.size() > 0 && existInJtjlk.get(0).getJtjlkUniPositionId() != null && existInJtjlk.get(0).getJtjlkUniPositionId() != "") {
	    existInJtjlk.get(0).setJtjlkPositionId(id);
	    jtjlkService.updateByPrimaryKeySelective(existInJtjlk.get(0));
	    return new ModelAndView("Main/ShowAlert", "uri", page + "ApplySuccess");
	}

	Map<String, String> paramsMore = new HashMap<String, String>();
	paramsMore.put("userId", userinfo.getUserId());
	paramsMore.put("jtjlkPositionId", "1");
	// 不允许同时投递简历数量超过5家企业
	if (jtjlkService.selectIsExist(paramsMore).size() >= 5) {
	    return new ModelAndView("Main/ShowAlert", "uri", page + "More");
	}
	Resume resume = resumeService.selectByPrimaryKeySelectiveById(userinfo.getUserId());
	// 没填写简历
	if (resume == null) {
	    return new ModelAndView("Main/ShowAlert", "uri", page + "NoResume");
	}
	List<Resume_jyjl> resume_Jyjls = resume_jyjlService.getlistResumeJyjlByResumeId(resume.getResumeId());
	Resume_jyjl resume_Jyjl = new Resume_jyjl();
	// 没填写教育经历
	if (resume_Jyjls.size() == 0) {
	    return new ModelAndView("Main/ShowAlert", "uri", page + "NoResume");
	} else {
	    resume_Jyjl = resume_Jyjls.get(resume_Jyjls.size() - 1);
	}

	Position position = zwglService.selectByPrimaryKey(id);
	Jtjlk jtjlk = new Jtjlk();
	jtjlk.setJtjlkAddtime(new Date());
	jtjlk.setJtjlkByxx(resume_Jyjl.getResumeXxmc());
	jtjlk.setJtjlkCpcj("未通知");
	jtjlk.setJtjlkDelflag((long) 1);
	jtjlk.setJtjlkGwlb(position.getPositionType());
	jtjlk.setJtjlkId(RandomGUIDUtil.generateKey());
	jtjlk.setJtjlkJlzt("未筛选");
	jtjlk.setJtjlkCpjg("未测评");
	jtjlk.setJtjlkMszt("未安排面试");
	jtjlk.setJtjlkName(userinfo.getUserName());
	jtjlk.setJtjlkPositionId(position.getPositionId());
	jtjlk.setJtjlkSex(resume.getResumeSex());
	jtjlk.setJtjlkUserid(userinfo.getUserId());
	jtjlk.setJtjlkXl(resume_Jyjl.getResumeXl());
	jtjlk.setJtjlkZw(position.getPositionName());
	jtjlk.setJtjlkZy(resume_Jyjl.getResumeZy());
	jtjlk.setZzjgId(position.getZzjgId());
	jtjlk.setJtjlkLy("应聘者");
	jtjlk.setJtjlkHkd(resume.getResumeRxqhkszcsProvince() + "," + resume.getResumeRxqhkszcsCity());
	jtjlk.setJtjlkYxpm(resume_Jyjl.getResumeYxpm());
	jtjlk.setJtjlkBjpm(resume_Jyjl.getResumeBjpm());
	jtjlk.setJtjlkCsrq(resume.getResumeBirthday());
	jtjlk.setJtjlkSfzh(userinfo.getUserSfzh());
	List<Jtjlk> seList = jtjlkService.selectStatusByUserId(userinfo.getUserId());
	if (seList.size() == 0)
	    jtjlk.setJtjlkJtjlkflag(2);
	else
	    jtjlk.setJtjlkJtjlkflag(1);
	jtjlkService.insertSelective(jtjlk);
	return new ModelAndView("Main/ShowAlert", "uri", page + "ApplySuccess");
    }

    @RequestMapping(value = "/MyApplication", method = RequestMethod.GET)
    public ModelAndView MyApplication(HttpSession session) {
	logInfo("MyApplication", "");
	Userinfo userinfo = (Userinfo) session.getAttribute("userLoginSession");
	if (userinfo == null) {
	    return new ModelAndView("Main/ShowAlert", "uri", "SessionLost");
	} else {
	    List<MyApplication> myApplications = jtjlkService.selectMyApplication(userinfo.getUserId());
	    return new ModelAndView("Main/MyApplication", "Applications", myApplications);
	}
    }

    @RequestMapping(value = "/Revoke", method = RequestMethod.GET)
    public ModelAndView Revoke(HttpSession session, @RequestParam(value = "id", required = false) String id) {
	logInfo("Revoke", id);
	Userinfo userinfo = (Userinfo) session.getAttribute("userLoginSession");
	if (userinfo == null) {
	    return new ModelAndView("Main/ShowAlert", "uri", "SessionLost");
	} else {
	    Jtjlk jtjlk = jtjlkService.selectByPrimaryKey(id);
	    if (jtjlk.getJtjlkUniPositionId() != null && !jtjlk.getJtjlkUniPositionId().isEmpty()) {
		jtjlk.setJtjlkPositionId(null);
		jtjlk.setJtjlkZw(null);
		jtjlkService.updateByPrimaryKey(jtjlk);
	    } else {
		bmglService.delByJtjlkId(id);
		msjgService.deleteByForeignKey(id);
		jtjlkService.deleteByPrimaryKey(id);
	    }
	    return new ModelAndView("Main/ShowAlert", "uri", "MyApplicationRevoke");
	}
    }

    @RequestMapping(value = "/Xzcc", method = RequestMethod.GET)
    public ModelAndView Xzcc() {
	return new ModelAndView("kcgl/xzcc");
    }

    @ResponseBody
    @RequestMapping(value = "/qtKcglData", method = RequestMethod.POST)
    public List<Kcgl> qtKcglData(QueryKcgl qk) {
	logInfo("qtKcglData", JSONArray.fromObject(qk).toString());
	qk.setKcglKczt("开放");
	List<Kcgl> listKcgl = kcglService.selectByWhere(qk);
	return listKcgl;
    }

    @ResponseBody
    @RequestMapping(value = "/qtKcglDataCount", method = RequestMethod.POST)
    public int qtKcglDataCount(QueryKcgl qk) {
	logInfo("qtKcglDataCount", JSONArray.fromObject(qk).toString());
	qk.setKcglKczt("开放");
	int intCount = kcglService.selectCount(qk);
	return intCount;
    }

    @RequestMapping(value = "/PrintTestCard", method = RequestMethod.GET)
    public ModelAndView PrintTestCard(@RequestParam(value = "id", required = false) String id) {
	logInfo("PrintTestCard", id);
	Bmgl bmgl = new Bmgl();
	bmgl = bmglService.queryBmglById(id);
	return new ModelAndView("Main/PrintTestCard", "bmgl", bmgl);
    }

    @ResponseBody
    @RequestMapping(value = "/DoPrintTestCard", method = RequestMethod.POST)
    public int DoPrintTestCard(@RequestParam(value = "id", required = false) String id) {
	logInfo("DoPrintTestCard", id);
	Bmgl bmgl = new Bmgl();
	bmgl = bmglService.queryBmglById(id);
	bmgl.setBmglPrintflag((long) 0);
	bmgl.setBmglSfqr("是");
	bmglService.updKscjById(bmgl);
	return 0;
    }

    /**
     * 咨询中心Count
     * 
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/InformationCenterCount", method = RequestMethod.POST)
    public int InformationCenterCount(ZzjgCondition p) {
	if (p == null) {
	    logInfo("InformationCenterCount", null);
	    return 0;
	}
	logInfo("InformationCenterCount", JSONArray.fromObject(p).toString());
	p.setZPXW_CONTENT(p.getZPXW_CONTENT().replaceAll("'", ""));
	int count = zpxwService.selectCountNoTop(p);
	return count;
    }

    /**
     * 查找上级单位和二级单位 当参数为空时查找的是所有上级单位 不为空时查找的是上级单位对应的二级单位
     * 
     * @param p
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectBySjdw", method = RequestMethod.POST)
    public List<Zzjg> selectBySjdw(String sjdw) {
	logInfo("selectBySjdw", sjdw);
	List<Zzjg> list = null;
	if (sjdw == null || sjdw == "")
	    list = zzjgService.selectBySjdw("");// 返回一级单位
	else
	    list = zzjgService.selectBySjdw(sjdw);// 返回下级单位
	return list;
    }

    /**
     * 资讯中心分页查询
     * 
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/InformationCenterData", method = RequestMethod.POST)
    public List<Zpxw> InformationCenterData(ZzjgCondition p) {
	logInfo("InformationCenterData", JSONArray.fromObject(p).toString());
	if (p == null)
	    return null;
	p.setZPXW_CONTENT(p.getZPXW_CONTENT().replaceAll("'", ""));
	List<Zpxw> zpxws = zpxwService.selectZpxwByWhereNoTop(p);
	List<Zpxw> tops = zpxwService.selectZpxwByWhereTop(p);
	for (Zpxw z : tops) {
	    z.setZpxwTop("top");
	    zpxws.add(z);
	}
	return zpxws;
    }

    /**
     * 资讯中心
     * 
     * @param session
     * @return
     */
    @RequestMapping(value = "/InformationCenter", method = RequestMethod.GET)
    public ModelAndView InformationCenter(HttpSession session, ZzjgCondition p) {
	logInfo("InformationCenter", JSONArray.fromObject(p).toString());
	return new ModelAndView("Main/InformationCenter");
    }

    @RequestMapping(value = "/GroupIntroduction", method = RequestMethod.GET)
    public ModelAndView GroupIntroduction(HttpSession session) {
	logInfo("GroupIntroduction", "");
	Map<String, String> map = new HashMap<String, String>();
	map.put("xcxxId", "");
	map.put("xcxxType", "集团简介");
	List<Xcxx> xcxxs = xcxxService.selectByType(map);
	return new ModelAndView("Main/GroupIntroduction", "xcxxs", xcxxs);
    }

    @RequestMapping(value = "/OfficialsAddress", method = RequestMethod.GET)
    public ModelAndView OfficialsAddress(HttpSession session) {
	logInfo("OfficialsAddress", "");
	Map<String, String> map = new HashMap<String, String>();
	map.put("xcxxId", "");
	map.put("xcxxType", "领导致辞");
	List<Xcxx> xcxxs = xcxxService.selectByType(map);
	return new ModelAndView("Main/OfficialsAddress", "xcxxs", xcxxs);
    }

    @RequestMapping(value = "/Organization", method = RequestMethod.GET)
    public ModelAndView Organization(HttpSession session) {
	logInfo("Organization", "");
	Map<String, String> map = new HashMap<String, String>();
	map.put("xcxxId", "");
	map.put("xcxxType", "组织机构");
	List<Xcxx> xcxxs = xcxxService.selectByType(map);
	return new ModelAndView("Main/Organization", "xcxxs", xcxxs);
    }

    @RequestMapping(value = "/DevelopmentProcess", method = RequestMethod.GET)
    public ModelAndView DevelopmentProcess(HttpSession session) {
	logInfo("DevelopmentProcess", "");
	Map<String, String> map = new HashMap<String, String>();
	map.put("xcxxId", "");
	map.put("xcxxType", "发展历程");
	List<Xcxx> xcxxs = xcxxService.selectByType(map);
	return new ModelAndView("Main/DevelopmentProcess", "xcxxs", xcxxs);
    }

    @RequestMapping(value = "/Corporateleadership", method = RequestMethod.GET)
    public ModelAndView Corporateleadership(HttpSession session) {
	logInfo("Corporateleadership", "");
	Map<String, String> map = new HashMap<String, String>();
	map.put("xcxxId", "");
	map.put("xcxxType", "企业领导");
	List<Xcxx> xcxxs = xcxxService.selectByType(map);
	return new ModelAndView("Main/Corporateleadership", "xcxxs", xcxxs);
    }

    @RequestMapping(value = "/CorporateCulture", method = RequestMethod.GET)
    public ModelAndView CorporateCulture(HttpSession session) {
	logInfo("CorporateCulture", "");
	Map<String, String> map = new HashMap<String, String>();
	map.put("xcxxId", "");
	map.put("xcxxType", "企业文化");
	List<Xcxx> xcxxs = xcxxService.selectByType(map);
	return new ModelAndView("Main/CorporateCulture", "xcxxs", xcxxs);
    }

    // 招聘指南

    @RequestMapping(value = "/AboutOnlineApplication", method = RequestMethod.GET)
    public ModelAndView AboutOnlineApplication(HttpSession session) {
	logInfo("AboutOnlineApplication", "");
	Map<String, String> map = new HashMap<String, String>();
	map.put("xcxxId", "");
	map.put("xcxxType", "关于网申");
	List<Xcxx> xcxxs = xcxxService.selectByType(map);
	return new ModelAndView("Main/AboutOnlineApplication", "xcxxs", xcxxs);
    }

    @RequestMapping(value = "/AboutTheTest", method = RequestMethod.GET)
    public ModelAndView AboutTheTest(HttpSession session) {
	logInfo("AboutTheTest", "");
	Map<String, String> map = new HashMap<String, String>();
	map.put("xcxxId", "");
	map.put("xcxxType", "关于约考");
	List<Xcxx> xcxxs = xcxxService.selectByType(map);
	return new ModelAndView("Main/AboutTheTest", "xcxxs", xcxxs);
    }

    @RequestMapping(value = "/AboutEvaluation", method = RequestMethod.GET)
    public ModelAndView AboutEvaluation(HttpSession session) {
	logInfo("AboutEvaluation", "");
	Map<String, String> map = new HashMap<String, String>();
	map.put("xcxxId", "");
	map.put("xcxxType", "关于测评");
	List<Xcxx> xcxxs = xcxxService.selectByType(map);
	return new ModelAndView("Main/AboutEvaluation", "xcxxs", xcxxs);
    }

    @RequestMapping(value = "/AboutMobile", method = RequestMethod.GET)
    public ModelAndView AboutMobile(HttpSession session) {
	logInfo("AboutMobile", "");
	Map<String, String> map = new HashMap<String, String>();
	map.put("xcxxId", "");
	map.put("xcxxType", "关于移动招聘");
	List<Xcxx> xcxxs = xcxxService.selectByType(map);
	return new ModelAndView("Main/AboutMobile", "xcxxs", xcxxs);
    }

    @RequestMapping(value = "/Recruitment", method = RequestMethod.GET)
    public ModelAndView Recruitment(HttpSession session) {
	logInfo("Recruitment", "");
	Map<String, String> map = new HashMap<String, String>();
	map.put("xcxxId", "");
	map.put("xcxxType", "招聘");
	List<Xcxx> xcxxs = xcxxService.selectByType(map);
	return new ModelAndView("Main/Recruitment", "xcxxs", xcxxs);
    }

    // 员工发展
    @RequestMapping(value = "/TalentStrategy", method = RequestMethod.GET)
    public ModelAndView TalentStrategy(HttpSession session) {
	logInfo("TalentStrategy", "");
	Map<String, String> map = new HashMap<String, String>();
	map.put("xcxxId", "");
	map.put("xcxxType", "人才战略");
	List<Xcxx> xcxxs = xcxxService.selectByType(map);
	return new ModelAndView("Main/TalentStrategy", "xcxxs", xcxxs);
    }

    @RequestMapping(value = "/Personnel", method = RequestMethod.GET)
    public ModelAndView Personnel(HttpSession session) {
	logInfo("Personnel", "");
	Map<String, String> map = new HashMap<String, String>();
	map.put("xcxxId", "");
	map.put("xcxxType", "人才队伍");
	List<Xcxx> xcxxs = xcxxService.selectByType(map);
	return new ModelAndView("Main/Personnel", "xcxxs", xcxxs);
    }

    @RequestMapping(value = "/AcademiciansAndExperts", method = RequestMethod.GET)
    public ModelAndView AcademiciansAndExperts(HttpSession session) {
	logInfo("AcademiciansAndExperts", "");
	Map<String, String> map = new HashMap<String, String>();
	map.put("xcxxId", "");
	map.put("xcxxType", "院士专家");
	List<Xcxx> xcxxs = xcxxService.selectByType(map);
	return new ModelAndView("Main/AcademiciansAndExperts", "xcxxs", xcxxs);
    }

    @RequestMapping(value = "/Career", method = RequestMethod.GET)
    public ModelAndView Career(HttpSession session) {
	logInfo("Career", "");
	Map<String, String> map = new HashMap<String, String>();
	map.put("xcxxId", "");
	map.put("xcxxType", "职业生涯");
	List<Xcxx> xcxxs = xcxxService.selectByType(map);
	return new ModelAndView("Main/Career", "xcxxs", xcxxs);
    }

    @RequestMapping(value = "/Employee", method = RequestMethod.GET)
    public ModelAndView Employee(HttpSession session) {
	logInfo("Employee", "");
	Map<String, String> map = new HashMap<String, String>();
	map.put("xcxxId", "");
	map.put("xcxxType", "员工风采");
	List<Xcxx> xcxxs = xcxxService.selectByType(map);
	return new ModelAndView("Main/Employee", "xcxxs", xcxxs);
    }

    @RequestMapping(value = "/StaffDevelopment", method = RequestMethod.GET)
    public ModelAndView StaffDevelopment(HttpSession session) {
	logInfo("StaffDevelopment", "");
	Map<String, String> map = new HashMap<String, String>();
	map.put("xcxxId", "");
	map.put("xcxxType", "员工成长");
	List<Xcxx> xcxxs = xcxxService.selectByType(map);
	return new ModelAndView("Main/StaffDevelopment", "xcxxs", xcxxs);
    }

    /**
     * 单位简介
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/InstituteOf", method = RequestMethod.GET)
    public ModelAndView InstituteOf(@RequestParam(value = "id", required = false) String id) {
	logInfo("InstituteOf", "");
	ModelAndView mv = new ModelAndView();
	Map<String, String> map = new HashMap<String, String>();
	map.put("xcxxId", "");
	map.put("xcxxAdduser", id);
	map.put("xcxxType", "单位简介");
	List<Xcxx> xcxxs = xcxxService.selectByType(map);
	mv.addObject("xcxxs", xcxxs);
	mv.addObject("zzjgs", GetSubZzjgs(id));
	return new ModelAndView("Main/InstituteOf", "mv", mv);
    }

    public List<Zzjg> GetSubZzjgs(String strZzjgId) {
	List<Zzjg> zzjgs = new ArrayList<Zzjg>();
	zzjgs = zzjgService.selectBySjdw(strZzjgId);
	Zzjg cZzjg = zzjgService.selectByPrimaryKey(strZzjgId);
	if (zzjgs.size() == 0 && !cZzjg.getZzjgSjdw().equals("test001")) {
	    zzjgs = zzjgService.selectBySjdw(cZzjg.getZzjgSjdw());
	    zzjgs.add(0, zzjgService.selectByPrimaryKey(cZzjg.getZzjgSjdw()));
	} else {
	    zzjgs.add(0, zzjgService.selectByPrimaryKey(strZzjgId));
	}
	return zzjgs;
    }

    /**
     * 二级单位招聘动态
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/RecruitmentDynamics", method = RequestMethod.GET)
    public ModelAndView RecruitmentDynamics(@RequestParam(value = "id", required = false) String id) {
	logInfo("RecruitmentDynamics", id);
	ModelAndView mv = new ModelAndView();
	mv.addObject("zzjgs", GetSubZzjgs(id));
	return new ModelAndView("Main/RecruitmentDynamics", "mv", mv);
    }

    /**
     * 二级单位招聘动态详情
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/RecruitmentDynamicsDetails", method = RequestMethod.GET)
    public ModelAndView RecruitmentDynamicsDetails(@RequestParam(value = "newsId", required = false) String newsId) {
	logInfo("RecruitmentDynamicsDetails", newsId);
	Zpxw zpxw = zpxwService.selectByPrimaryKey(newsId);
	return new ModelAndView("Main/RecruitmentDynamicsDetails", "zpxw", zpxw);
    }

    /***************************优才招聘模块***************************************/

    @RequestMapping(value = "/UniPositionIntroduce", method = RequestMethod.GET)
    public ModelAndView UniPositionIntroduce(HttpSession session) {
	logInfo("UniPositionIntroduce", "");
	return new ModelAndView("zpyc/UniPositionIntroduce");
    }

    @RequestMapping(value = "/SearchUniPosition", method = RequestMethod.GET)
    public ModelAndView SearchUniPosition(HttpSession session) {
	ModelAndView mv = new ModelAndView("zpyc/SearchUniPosition");
	return mv;
    }

    @RequestMapping(value = "/MyUniApplication", method = RequestMethod.GET)
    public ModelAndView MyUniApplication(HttpSession session) {
	logInfo("MyUniApplication", "");
	Userinfo userinfo = (Userinfo) session.getAttribute("userLoginSession");
	if (userinfo == null) {
	    return new ModelAndView("Main/ShowAlert", "uri", "SessionLost");
	} else {
	    List<MyApplication> myApplications = jtjlkService.selectMyUniApplication(userinfo.getUserId());
	    return new ModelAndView("zpyc/MyUniApplication", "Applications", myApplications);
	}
    }
    
    /** 
    * @Title MyAllApplication 
    * @Description 所有申请岗位，包括普通、优才 ，为了统一网上测评预约的入口 
    * @param session
    * @return  
    * @return ModelAndView     
    */
    @RequestMapping(value = "/MyAllApplication", method = RequestMethod.GET)
    public ModelAndView MyAllApplication(HttpSession session) {
	logInfo("MyUniApplication", "");
	Userinfo userinfo = (Userinfo) session.getAttribute("userLoginSession");
	if (userinfo == null) {
	    return new ModelAndView("Main/ShowAlert", "uri", "SessionLost");
	} else {
	    List<MyApplication> myUniApplications = jtjlkService.selectMyUniApplication(userinfo.getUserId());
	    List<MyApplication> myApplications = jtjlkService.selectMyApplication(userinfo.getUserId());
	    ModelAndView mv = new ModelAndView("zpyc/MyAllApplication");
	    mv.addObject( "Applications", myApplications);
	    mv.addObject( "UniApplications", myUniApplications);
	    return mv;
	}
    }

    @RequestMapping(value = "/MyUniCollection", method = RequestMethod.GET)
    public ModelAndView MyUniCollection(HttpSession session) {
	logInfo("MyUniCollection", "");
	Userinfo userinfo = (Userinfo) session.getAttribute("userLoginSession");
	if (userinfo == null) {
	    return new ModelAndView("Main/ShowAlert", "uri", "SessionLost");
	} else {
	    Collect_position collect_position = new Collect_position();
	    collect_position.setCollectPositionUserId(userinfo.getUserId());
	    List<Collect_position> collect_positions = collectionService.selectByWhere(collect_position);
	    List<PositionWithBLOBs> positions = new ArrayList<PositionWithBLOBs>();
	    List<String> lstPostionIds = new ArrayList<String>();
	    for (Collect_position c : collect_positions) {
		lstPostionIds.add(c.getPositionId());
	    }
	    if (lstPostionIds.size() > 0) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("lstPostionIds", lstPostionIds);
		positions = zwglService.selectByPrimaryKeys(params);
	    }
	    List<PositionWithBLOBs> uniPositions = new ArrayList<PositionWithBLOBs>();
	    for (PositionWithBLOBs c : positions) {

		if (c.getIsuniposition().equals("1")) {
		    uniPositions.add(c);
		}
	    }
	    return new ModelAndView("zpyc/MyUniCollection", "positions", uniPositions);
	}

    }

    /** 
    * @Title CancelUniPosition 
    * @Description  取消优才收藏 
    * @param id
    * @param session
    * @return ModelAndView     
    */
    @RequestMapping(value = "/CancelUniPosition", method = RequestMethod.GET)
    public ModelAndView CancelUniPosition(@RequestParam(value = "id", required = false) String id, HttpSession session) {
	logInfo("CancelUniPosition", id);
	Userinfo userinfo = (Userinfo) session.getAttribute("userLoginSession");
	if (userinfo == null) {
	    return new ModelAndView("Main/ShowAlert", "uri", "SessionLost");
	}
	Map<String, String> params = new HashMap<String, String>();
	params.put("positionId", id);
	params.put("userId", userinfo.getUserId());
	collectionService.deleteByPrimaryKey(params);
	return new ModelAndView("Main/ShowAlert", "uri", "MyUniCollection");
    }

    /** 
    * @Title UniRevoke 
    * @Description 取消优才申请，判断普通职位是否存在 
    * @param session
    * @param id
    * @return  
    * @return ModelAndView     
    */
    @RequestMapping(value = "/UniRevoke", method = RequestMethod.GET)
    public ModelAndView UniRevoke(HttpSession session, @RequestParam(value = "id", required = false) String id) {
	logInfo("Revoke", id);
	Userinfo userinfo = (Userinfo) session.getAttribute("userLoginSession");
	if (userinfo == null) {
	    return new ModelAndView("Main/ShowAlert", "uri", "SessionLost");
	} else {
	    Jtjlk jtjlk = jtjlkService.selectByPrimaryKey(id);
	    if (jtjlk.getJtjlkPositionId() != null && !jtjlk.getJtjlkPositionId().isEmpty()) {
		jtjlk.setJtjlkUniPositionId(null);
		jtjlkService.updateByPrimaryKey(jtjlk);
	    } else {
		bmglService.delByJtjlkId(id);
		msjgService.deleteByForeignKey(id);
		jtjlkService.deleteByPrimaryKey(id);
	    }
	    return new ModelAndView("Main/ShowAlert", "uri", "MyUniApplicationRevoke");
	}
    }

    // 报名申请
    @RequestMapping(value = "/UniXzcc", method = RequestMethod.GET)
    public ModelAndView UniXzcc() {
	return new ModelAndView("zpyc/xzcc");
    }

    // 考场管理
    @RequestMapping(value = "/UniRegistration", method = RequestMethod.GET)
    public ModelAndView UniRegistration(@RequestParam(value = "kcId", required = false) String kcId,
	    @RequestParam(value = "id", required = false) String id, HttpSession session) throws ParseException {
	logInfo("Registration", kcId + "," + id);
	Userinfo user = (Userinfo) session.getAttribute("userLoginSession");
	if (user == null) {
	    return new ModelAndView("Main/ShowAlert", "uri", "SessionLost");
	}
	Kcgl kcgl = kcglService.selectByPrimaryKey(kcId);
	if (kcgl.getKcglSyrl() <= 0) {
	    return new ModelAndView("Main/ShowAlert", "uri", "RegistrationUniFull");
	}
	Jtjlk jtjlk = jtjlkService.selectByPrimaryKey(id);
	Bmgl b = new Bmgl();
	b.setBmglBkgw(jtjlk.getJtjlkApcpgwlb());
	b.setBmglSfzh(user.getUserSfzh());
	b.setBmglJtjlkid(jtjlk.getJtjlkId());
	List<Bmgl> bmglSel = bmglService.selectIsExist(b);
	if (bmglSel.size() == 0) {
	    Bmgl bmgl = new Bmgl();
	    Resume resume = resumeService.selectByPrimaryKeySelectiveById(user.getUserId());
	    Zzjg zzjg = new Zzjg();
	    zzjg = zzjgService.selectByPrimaryKey(jtjlk.getZzjgId());

	    Map<String, String> p = new HashMap<String, String>();
	    p.put("jtjlkId", id);
	    bmglService.deleteByWhere(p);

	    bmgl.setBmglAddtime(new Date());
	    bmgl.setBmglBkdw(zzjg.getZzjgDwmc());
	    bmgl.setBmglBkdwdm(zzjg.getZzjgDwdm());
	    bmgl.setBmglBkgw(jtjlk.getJtjlkApcpgwlb());
	    bmgl.setBmglByxx(jtjlk.getJtjlkByxx());
	    bmgl.setBmglDelflag((long) 1);
	    bmgl.setBmglId(RandomGUIDUtil.generateKey());
	    bmgl.setBmglJtjlkid(id);
	    bmgl.setBmglKcglId(kcId);
	    bmgl.setBmglKscj("未测评");
	    bmgl.setBmglKssj(kcgl.getKcglKssjStart().trim() + " - " + kcgl.getKcglKssjEnd().trim());
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    bmgl.setBmglKsrq(format.parse(kcgl.getKcglKsrq()));
	    bmgl.setBmglKsxm(jtjlk.getJtjlkName());
	    bmgl.setBmglLxdh(user.getUserTelephone());
	    bmgl.setBmglKsxb(user.getUserSex());
	    bmgl.setBmglSfqr("否");
	    bmgl.setBmglSfzh(resume.getResumeSfzh());
	    bmgl.setBmglKsdd(kcgl.getKcglDz());
	    bmgl.setBmglTszg("");
	    bmgl.setBmglPrintflag((long) 1);
	    bmglService.insertSelective(bmgl);

	    // Bmgl bmgl = bmglService.queryBmglById(ksxcgl.getKsxmId());
	    // Kcgl k = kcglService.selectByPrimaryKey(ksxcgl.getKsxcglKc());

	    Map<String, String> map = new HashMap<String, String>();
	    map.put("ksxcglIdcard", bmgl.getBmglSfzh());
	    map.put("ksxcglKkslx", bmgl.getBmglBkgw());
	    ksxcglService.deleteByBmglInfo(map);

	    Ksxcgl ksxcgl = new Ksxcgl();
	    ksxcgl.setKsxcglDelflag((long) 1);
	    ksxcgl.setKsxcglAddtime(new Date());
	    ksxcgl.setKsxcglId(RandomGUIDUtil.generateKey());
	    ksxcgl.setKsxcglIdcard(bmgl.getBmglSfzh());
	    ksxcgl.setKsxcglBkdw(bmgl.getBmglBkdw());
	    ksxcgl.setKsxcglKkslx(bmgl.getBmglBkgw());
	    ksxcgl.setKsxcglName(bmgl.getBmglKsxm());
	    ksxcgl.setKcglId(kcId);
	    ksxcgl.setKsxcglBmglId(bmgl.getBmglId());
	    ksxcgl.setKsxcglKc(kcgl.getKcglName());
	    ksxcgl.setKsxcglTszg("否");
	    ksxcgl.setKsxcglWjqk("否");
	    ksxcgl.setKsxcglKc(kcgl.getKcglName());
	    ksxcglService.insertksxcgl(ksxcgl);

	    return new ModelAndView("Main/ShowAlert", "uri", "RegistrationUniSuccess");
	} else
	    return new ModelAndView("Main/ShowAlert", "uri", "RegistrationUniIsExist");
    }
}
