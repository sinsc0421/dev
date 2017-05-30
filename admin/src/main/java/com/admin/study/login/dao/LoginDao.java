package com.admin.study.login.dao;

import java.util.List;

public interface LoginDao {
	public List<LoginVO> goLogin(LoginSC sc) throws Exception;
}
