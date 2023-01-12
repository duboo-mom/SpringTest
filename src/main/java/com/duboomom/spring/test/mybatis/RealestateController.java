package com.duboomom.spring.test.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duboomom.spring.test.mybatis.bo.RealestateBO;
import com.duboomom.spring.test.mybatis.model.Realestate;

@Controller
public class RealestateController {

	@Autowired
	private RealestateBO realestateBO;
	
	// id로 select 하기
	@RequestMapping("/mybatis/test01/1")
	public Realestate realestate() {
		Realestate realestate = realestateBO.getRealestate();
		
		return realestate;
		
	}
	
}
