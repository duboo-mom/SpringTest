package com.duboomom.spring.test.mybatis.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duboomom.spring.test.mybatis.dao.RealestateDAO;
import com.duboomom.spring.test.mybatis.model.Realestate;

@Service
public class RealestateBO {

	@Autowired
	private RealestateDAO realestateDAO;
	
	// 1. id로 데이터 조회
	public Realestate getRealestate() {
		Realestate realestate = realestateDAO.selectRealestate();
		return realestate;
	}
	
}
