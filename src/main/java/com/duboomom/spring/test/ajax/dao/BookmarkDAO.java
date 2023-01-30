package com.duboomom.spring.test.ajax.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.duboomom.spring.test.ajax.model.Bookmark;

@Repository
public interface BookmarkDAO {

	public List<Bookmark> selectBookmark();
	
	public int insertBookmark(
			@Param("name") String name
			, @Param("url") String url);
	
	public int selectCountUrl(@Param("url") String url);
	
	public int deleteBookmark(@Param("id") int id);
	
}
