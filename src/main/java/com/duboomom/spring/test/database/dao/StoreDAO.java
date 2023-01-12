package com.duboomom.spring.test.database.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.duboomom.spring.test.database.model.Store;

@Repository
public interface StoreDAO {

	// store 테이블 조회 기능
	// 여기부터는 MyBatis 연동
	public List<Store> selectStoreList();
	
}
