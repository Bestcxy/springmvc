package com.bestcxx.stu.springmvc.service.base;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 所有Service的基类，用来注入sqlSession
 */
public class BaseService {
    /**
     * sqlSession
     */
	@Autowired
    protected SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
    
}
