package com.duboomom.spring.test.jsp.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duboomom.spring.test.jsp.dao.SellerDAO;
import com.duboomom.spring.test.jsp.model.Seller;

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
	
	// if문을 포함하는 BO만들기
	public Seller getSeller(Integer id) {
		
		if(id == null) {
			return sellerDAO.selectLastSeller();
		} else {
			return sellerDAO.selectSellerById(id);
		}
		
	}
	
	public Seller getLastSeller() {
		return sellerDAO.selectLastSeller();
	}
	
	public Seller getSellerById(int id) {
		return sellerDAO.selectSellerById(id);
	}
	
}
