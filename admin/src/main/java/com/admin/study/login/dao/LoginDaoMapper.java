package com.admin.study.login.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("loginDao")
public class LoginDaoMapper implements LoginDao {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	/**setter*/
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	/***************************************************/
	@Override
	public List<LoginVO> goLogin(LoginSC sc) throws Exception {
		//출력할 리스트 선언.
		List<LoginVO> list = null;
		//세션 선언.
		SqlSession session = null;
		try{
			session = sqlSessionFactory.openSession();
			LoginDao dao = session.getMapper(LoginDao.class);
			list = dao.goLogin(sc);
		}finally{
			//세션 종료.
			session.close();
		}
		return list;
	}
}
