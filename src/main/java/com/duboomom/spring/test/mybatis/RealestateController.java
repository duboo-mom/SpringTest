package com.duboomom.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duboomom.spring.test.mybatis.bo.RealestateBO;
import com.duboomom.spring.test.mybatis.model.Realestate;

@Controller
@RequestMapping("mybatis/test01")
public class RealestateController {

	@Autowired
	private RealestateBO realestateBO;
	
	// id로 select 하기
	@ResponseBody
	@RequestMapping("/1")
	public Realestate realestate(@RequestParam("id") int id) {
		
		Realestate realestate = realestateBO.getRealestate(id);
		
		return realestate;
		
	}
	
	@ResponseBody
	@RequestMapping("/2")
	public List<Realestate> realestateByRent(@RequestParam("rent") int rentPrice) {
		
		List<Realestate> realestateList = realestateBO.getRealestateByRentPrice(rentPrice);
		
		return realestateList;
	}
	
	@ResponseBody
	@RequestMapping("/3")
	public List<Realestate> realestateByAreaPrice(
			@RequestParam("area") int area
			, @RequestParam("price") int price) {
		
		return realestateBO.getRealestateByAreaPrice(area, price);
				
	}
	
	
	
}
