package com.duboomom.spring.test.database.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duboomom.spring.test.database.dao.StoreDAO;
import com.duboomom.spring.test.database.model.Store;

@Service
public class StoreBO {
	
	@Autowired
	private StoreDAO storeDAO;
		
	// controller가 원하는 store 테이블의 데이터 조회하고 리턴하는 메소드
	public List<Store> getStoreList() {
		List<Store> storeList = storeDAO.selectStoreList();
		return storeList;
	}
	
}
