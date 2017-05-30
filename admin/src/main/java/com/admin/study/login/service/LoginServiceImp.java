package com.admin.study.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.study.login.dao.LoginDao;
import com.admin.study.login.dao.LoginSC;
import com.admin.study.login.dao.LoginVO;

@Repository
public class LoginServiceImp implements LoginService{
	@Autowired
	private LoginDao loginDao;

	@Override
	public List<LoginVO> goLogin(LoginSC sc) throws Exception {
		List<LoginVO> loginList = loginDao.goLogin(sc);
		return loginList;
	}//end of list().
}
