package com.duboomom.spring.test.jsp.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerDAO {

	public int insertSeller(
			@Param("nickname") String name
			, @Param("profileImage") String profileImage
			, @Param("temperature") double temperature);
	
}
