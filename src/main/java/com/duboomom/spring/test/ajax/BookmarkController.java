package com.duboomom.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duboomom.spring.test.ajax.bo.BookmarkBO;
import com.duboomom.spring.test.ajax.model.Bookmark;

@Controller
@RequestMapping("/ajax/bookmark")
public class BookmarkController {

	@Autowired
	private BookmarkBO bookmarkBO;
	
	@GetMapping("/list")
	public String bookmarkList(Model model) {
		
		List<Bookmark> bookmarkList = bookmarkBO.getBookmarkList();
		model.addAttribute("bookmarkList", bookmarkList);
		
		return "ajax/bookmark/list";
	}
	
	@GetMapping("/input")
	public String bookmarkInput() {
		return "ajax/bookmark/input";
	}
	
	// 즐겨찾기 추가 api
	@ResponseBody
	@PostMapping("/add")
	public Map<String, String> addBookmark(
			@RequestParam("name") String name
			, @RequestParam("url") String url) {
	
		int count = bookmarkBO.addBookmark(name, url);
		
		Map<String, String> map = new HashMap<>();
		
		if(count == 1) {
			map.put("result", "success");
		} else {
			map.put("result", "fail");
		}
		
		return map;
		
	}
	
	@ResponseBody
	@PostMapping("/is_duplicate")
	public Map<String, Boolean> isDuplicateUrl(@RequestParam("url") String url) {
		
		//{"is_duplicate":true}
		//{"is_duplicate":false}
		
		Map<String, Boolean> result = new HashMap<>();
		
//		if(bookmarkBO.isDuplicateUrl(url)) {
//			result.put("is_duplicate", true);
//		} else {
//			result.put("is_duplicate", false);
//		}
		
		result.put("is_duplicate", bookmarkBO.isDuplicateUrl(url));
		
		return result;
		
	}
	
	@GetMapping("/delete")
	public String deleteBookmark(@RequestParam("id") int id) {
		bookmarkBO.deleteBookmark(id);
		return "redirect:/ajax/bookmark/list";
	}
	
	// ajax용 delete api
	
}
