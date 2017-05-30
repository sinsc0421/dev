package com.admin.study.login.service;

import java.util.List;

import com.admin.study.login.dao.LoginSC;
import com.admin.study.login.dao.LoginVO;

public interface LoginService {
	public List<LoginVO> goLogin(LoginSC sc) throws Exception;
}
