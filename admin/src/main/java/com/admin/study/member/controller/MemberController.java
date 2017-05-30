package com.admin.study.member.controller;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/admin")
public class MemberController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/member" , method = {RequestMethod.GET,RequestMethod.POST})
    public String login(@RequestParam Map<String,Object> param , HttpSession session , Locale locale, ModelMap map) throws Exception{
        logger.info("member Page! {} , {} , {}", session.getId() , locale.getLanguage(), param.toString());
        
    	return "member/member_list";
    }
}
