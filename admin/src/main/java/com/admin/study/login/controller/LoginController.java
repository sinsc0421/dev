package com.admin.study.login.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.admin.study.login.dao.LoginSC;
import com.admin.study.login.dao.LoginVO;
import com.admin.study.login.service.LoginService;


@Controller
@RequestMapping(value = "/admin")
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private LoginService loginService;
	/**
     * Simply selects the home view to render by returning its name.
     */
	@RequestMapping(value = "/login" , method = {RequestMethod.GET,RequestMethod.POST})
    public String login(@RequestParam Map<String,Object> param , HttpSession session , Locale locale, ModelMap map) throws Exception{
        logger.info("Welcome login! {} , {} , {}", session.getId() , locale.getLanguage(), param.toString());

    	return "login";
    }

    @RequestMapping(value = "/loginProcess", method =RequestMethod.POST)
    public void loginProcess(@RequestParam Map<String,Object> param, HttpSession session, LoginSC sc, ModelMap map) throws Exception{
    	String id = StringUtils.defaultString((String)param.get("userId"), "");
    	String pass = StringUtils.defaultString((String)param.get("password"), "");
    	String redirectUrl = StringUtils.defaultString((String)param.get("redirectUrl"), "");

    	logger.debug("[SC] ID" +  sc.getUserId());
    	logger.debug("[SC] pw" +  sc.getPassword());
    	logger.info("seung        id   ======================  "+id);
    	logger.info("seung        pass   ======================  "+pass);

    	List<LoginVO> loginList = loginService.goLogin(sc);
    	if (loginList.size() > 0) {
			map.addAttribute("ResultCode", "S");
		} else {
			map.addAttribute("ResultCode", "F");
		}
    }
}
