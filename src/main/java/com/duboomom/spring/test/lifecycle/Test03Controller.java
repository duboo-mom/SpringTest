package com.duboomom.spring.test.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// responseBody까지 넣으면 return string이 보여질거임~
@Controller
public class Test03Controller {

	@RequestMapping("/lifecycle/test03")
	public String test03View() {
		return "lifecycle/test03";
	}
	
}
