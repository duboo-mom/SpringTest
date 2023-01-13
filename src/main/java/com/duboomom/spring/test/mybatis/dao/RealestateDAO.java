package com.duboomom.spring.test.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.duboomom.spring.test.mybatis.model.Realestate;

@Repository
public interface RealestateDAO {

	// 특정 id 데이터 조회
	public Realestate selectRealestate(@Param("id") int id);
	
	public List<Realestate> selectRealestateByRentprice(@Param("rentPrice") int rentPrice);
	
	public List<Realestate> selectRealestateByAreaPrice(
			@Param("area") int area
			, @Param("price") int price);
	
	public int insertRealestateByObject(Realestate realestate);
	
	public int insertRealestate(
			@Param("realtorId") int realtorId
			, @Param("address") String address
			, @Param("area") int area
			, @Param("type") String type
			, @Param("price") int price
			, @Param("rentPrice") int rentPrice			
			);
	
	public int updateRealestateTypePrice(
			@Param("id") int id
			, @Param("type") String type
			, @Param("price") int price
			);
	
	public int deleteRealestate(@Param("id") int id);
	
}
