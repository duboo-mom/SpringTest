package com.duboomom.spring.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duboomom.spring.test.jsp.bo.SellerBO;

@Controller
@RequestMapping("/jsp/seller")
public class SellerController {

	@Autowired
	private SellerBO sellerBO;
	
	@ResponseBody
	@PostMapping("/addresult")
	public String addSeller(
			@RequestParam("name") String name
			, @RequestParam("profile") String profile
			, @RequestParam("temp") double temperature
			) {
		
		int count = sellerBO.addSeller(name, profile, temperature);
		
		return "등록 성공 : " + count;
	}
	
	// 입력화면
	@GetMapping("/input")
	public String sellerInput() {
		return "jsp/sellerinput";
	}
	
}
