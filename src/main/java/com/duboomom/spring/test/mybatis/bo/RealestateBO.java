package com.duboomom.spring.test.mybatis.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duboomom.spring.test.mybatis.dao.RealestateDAO;
import com.duboomom.spring.test.mybatis.model.Realestate;

@Service
public class RealestateBO {

	@Autowired
	private RealestateDAO realestateDAO;
	
	// 1. id로 데이터 조회
	public Realestate getRealestate(int id) {
		Realestate realestate = realestateDAO.selectRealestate(id);
		return realestate;
	}
	
	public List<Realestate> getRealestateByRentPrice(int rentPrice) {
		
		List<Realestate> realestateList = realestateDAO.selectRealestateByRentprice(rentPrice);
				
		return realestateList;
	}
	
	public List<Realestate> getRealestateByAreaPrice(int area, int price) {
		
		return realestateDAO.selectRealestateByAreaPrice(area, price);
		
	}
	
	public int addRealestateByObject(Realestate realestate) {
		
		return realestateDAO.insertRealestateByObject(realestate);
				
	}
	
	public int addRealestate(int realtorId, String address, int area, String type, int price, int rentPrice) {
		
		return realestateDAO.insertRealestate(realtorId, address, area, type, price, rentPrice);
		
	}
	
	public int changeRealestateTypePrice(int id, String type, int price) {
		
		return realestateDAO.updateRealestateTypePrice(id, type, price);
	}
	
	public int deleteRealestate(int id) {
		return realestateDAO.deleteRealestate(id);
	}
	
	
}
