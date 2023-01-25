package com.duboomom.spring.test.jstl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duboomom.spring.test.jstl.bo.WeatherHistoryBO;
import com.duboomom.spring.test.jstl.model.Weather;

@Controller
@RequestMapping("/jstl/weather")
public class WeatherHistoryController {

	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	@GetMapping("/list")
	public String weatherList(Model model) {
	
		List<Weather> weatherList = weatherHistoryBO.getWeathers();
		
		model.addAttribute("weatherList", weatherList);
		
		return "jstl/weather/list";
		
	}
	
	@GetMapping("/input")
	public String weatherInput() {
		return "jstl/weather/weatherInput";
	}
	
}
