package com.duboomom.spring.test.jstl.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duboomom.spring.test.jstl.dao.WeatherHistoryDAO;
import com.duboomom.spring.test.jstl.model.Weather;

@Service
public class WeatherHistoryBO {

	@Autowired
	private WeatherHistoryDAO weatherHistoryDAO;
	
	public List<Weather> getWeathers() {
		return weatherHistoryDAO.selectWeather();
	}
	
	public int addWeather(Date date
			, String weather
			, String microDust
			, double temperatures
			, double precipitation
			, double windSpeed) {
		
		 return weatherHistoryDAO.insertWeather(date, weather, microDust, temperatures, precipitation, windSpeed);
	}
	
}
