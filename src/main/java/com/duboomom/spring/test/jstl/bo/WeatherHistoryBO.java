package com.duboomom.spring.test.jstl.bo;

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
	
}
