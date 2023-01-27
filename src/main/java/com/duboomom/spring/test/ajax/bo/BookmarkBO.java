package com.duboomom.spring.test.ajax.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duboomom.spring.test.ajax.dao.BookmarkDAO;
import com.duboomom.spring.test.ajax.model.Bookmark;

@Service
public class BookmarkBO {

	@Autowired
	private BookmarkDAO bookmarkDAO;
	
	public List<Bookmark> getBookmarkList(){
		return bookmarkDAO.selectBookmark();
	}
	
	public int addBookmark(String name, String url) {
		return bookmarkDAO.insertBookmark(name, url);
	}
}
