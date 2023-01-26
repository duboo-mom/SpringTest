package com.duboomom.spring.test.jstl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@PostMapping("/add")
	public String weatherInput(@RequestParam("date") String dateString
			, @RequestParam("weather") String weather
			, @RequestParam("microDust") String microDust
			, @RequestParam("temperatures") double temperatures
			, @RequestParam("precipitation") double precipitation
			, @RequestParam("windSpeed") double windSpeed) throws ParseException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 M월 d일");
		Date date = formatter.parse(dateString);		
		
		weatherHistoryBO.addWeather(date, weather, microDust, temperatures, precipitation, windSpeed);
		
		return "redirect:list";
	}

	@GetMapping("/input")
	public String inputpage() {
		return "jstl/weather/weatherInput";
	}
	
}
