package com.duboomom.spring.test.jstl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.duboomom.spring.test.jstl.model.Weather;

@Repository
public interface WeatherHistoryDAO {

	public List<Weather> selectWeather();
	
}
