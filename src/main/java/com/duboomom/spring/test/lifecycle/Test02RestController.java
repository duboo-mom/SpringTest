package com.duboomom.spring.test.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duboomom.spring.test.lifecycle.model.Post;

@RequestMapping("/lifecycle/test02")
@RestController
public class Test02RestController {
	
	@RequestMapping("/1")
	public List<Map<String, Object>> listResponse() {
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("rate", 15);
		map.put("director", "봉준호");
		map.put("time", 131);
		map.put("title", "기생충");		
		list.add(map);
		
		map = new HashMap<>();
		map.put("rate", 0);
		map.put("director", "로베르토 베니니");
		map.put("time", 116);
		map.put("title", "인생은 아름다워");		
		list.add(map);
		
		map = new HashMap<>();
		map.put("rate", 12);
		map.put("director", "크리스토퍼 놀란");
		map.put("time", 147);
		map.put("title", "인셉션");		
		list.add(map);
		
		map = new HashMap<>();
		map.put("rate", 19);
		map.put("director", "윤종빈");
		map.put("time", 133);
		map.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");		
		list.add(map);
		
		map = new HashMap<>();
		map.put("rate", 15);
		map.put("director", "프란시스 로렌스");
		map.put("time", 137);
		map.put("title", "헝거게임");		
		list.add(map);
		
		return list;
		
	}
	
	@RequestMapping("/2")
	public List<Post> postResponse() {
		
		List<Post> list = new ArrayList<>();
		
		Post post = new Post();
		post.setTitle("안녕하세요 가입인사 드립니다.");
		post.setUser("hagulu");
		post.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다.");
		list.add(post);
		
		post = new Post();
		post.setTitle("헐 대박");
		post.setUser("bada");
		post.setContent("오늘 목요일이었어... 금요일인줄");
		list.add(post);
		
		post = new Post();
		post.setTitle("오늘 데이트 한 이야기 해드릴게요.");
		post.setUser("dulumary");
		post.setContent("...");
		list.add(post);
				
		return list;
		
	}
	
}
