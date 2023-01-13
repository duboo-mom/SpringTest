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
@RequestMapping("mybatis")
public class RealestateController {

	@Autowired
	private RealestateBO realestateBO;
	
	// id로 select 하기
	@ResponseBody
	@RequestMapping("/test01/1")
	public Realestate realestate(@RequestParam("id") int id) {
		
		Realestate realestate = realestateBO.getRealestate(id);
		
		return realestate;
		
	}
	
	@ResponseBody
	@RequestMapping("/test01//2")
	public List<Realestate> realestateByRent(@RequestParam("rent") int rentPrice) {
		
		List<Realestate> realestateList = realestateBO.getRealestateByRentPrice(rentPrice);
		
		return realestateList;
	}
	
	@ResponseBody
	@RequestMapping("/test01//3")
	public List<Realestate> realestateByAreaPrice(
			@RequestParam("area") int area
			, @RequestParam("price") int price) {
		
		return realestateBO.getRealestateByAreaPrice(area, price);
				
	}
	
	@ResponseBody
	@RequestMapping("/test02/1")
	public String addRealestate() {
		
		Realestate newRealestate = new Realestate();
		
		newRealestate.setRealtorId(3);
		newRealestate.setAddress("푸르지용 리버 303동 1104호");
		newRealestate.setArea(89);
		newRealestate.setType("매매");
		newRealestate.setPrice(100000);
		
		int count = realestateBO.addRealestateByObject(newRealestate);
		
		return "입력 성공 : " + count;
	}
	
	@ResponseBody
	@RequestMapping("/test02/2")
	public String addRealestateByField(@RequestParam("realtorId") int realtorId) {
		
		int count = realestateBO.addRealestate(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		return "입력 성공 : " + count;
	}
	
	@ResponseBody
	@RequestMapping("/test03")
	public String changeRealesateTypePrice() {
		
		int count = realestateBO.changeRealestateTypePrice(22, "전세", 70000);
		
		return "수정 성공 : " + count;
	}
	
	@ResponseBody
	@RequestMapping("/test04")
	public String deleteRealestate(@RequestParam("id") int id) {
		int count = realestateBO.deleteRealestate(id);
		return "삭제 성공 : " + count;
	}
	
	
	
	
	
	
}
