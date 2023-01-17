package com.duboomom.spring.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duboomom.spring.test.jsp.bo.SellerBO;
import com.duboomom.spring.test.jsp.model.Seller;

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
	
	// 가장 최근에 추가된 seller 정보 출력 페이지
	// id입력 있으면 그 값으로?
	@GetMapping("/info")
	public String lastSeller(Model model
			, @RequestParam(value="id", required=false) Integer id) {
		
		// request에 의한 판단이니까 controller에서 해도 되고
//		Seller seller = null;
//		
//		if(id == null) {
//			seller = sellerBO.getLastSeller();		
//		} else {
//			seller = sellerBO.getSellerById(id);
//		}

		// 로직이라 판단해서 BO에서 해도 되고
		
		Seller seller = sellerBO.getSeller(id);
		
		model.addAttribute("seller", seller);
		
		return "jsp/sellerinfo";
		
	}
	
	
}
