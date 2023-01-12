package com.duboomom.spring.test.mybatis.dao;

import org.springframework.stereotype.Repository;

import com.duboomom.spring.test.mybatis.model.Realestate;

@Repository
public interface RealestateDAO {

	// 특정 id 데이터 조회
	public Realestate selectRealestate();
	
}
