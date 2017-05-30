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
		//����� ����Ʈ ����.
		List<LoginVO> list = null;
		//���� ����.
		SqlSession session = null;
		try{
			session = sqlSessionFactory.openSession();
			LoginDao dao = session.getMapper(LoginDao.class);
			list = dao.goLogin(sc);
		}finally{
			//���� ����.
			session.close();
		}
		return list;
	}
}
