package com.duboomom.spring.test.jsp.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duboomom.spring.test.jsp.dao.SellerDAO;

@Service
public class SellerBO {

	@Autowired
	private SellerDAO sellerDAO;
	
	public int addSeller(
			String name
			, String profile
			, double temperature ) {
		
		return sellerDAO.insertSeller(name, profile, temperature);
		
	}
	
}
