package com.integral.cache.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.integral.cache.spring.client.RestClient;
import com.integral.cache.spring.model.Weather;

@Service
public class WeatherService {
	
	@Autowired
	private RestClient restClient;

	
	@Cacheable(value="weatherCache",key="#weatherId")
	public Weather callGetWeatherByCity(String weatherId) {
		System.out.println("cache not hit");
		String [] args = weatherId.split("_");
		
		String response = restClient.callGetWeatherByCity(args[0], args[1]);
		Weather weatherCache = new Weather();
		weatherCache.setWeatherId(weatherId);
		weatherCache.setData(response == null ? "no data found!" : response);
		return weatherCache;		
		
	}
	
	@Cacheable(value="weatherCache",key="#weatherId",unless="#result==null")
	public Weather getWeatherInfoBylatlon(String weatherId) {
		System.out.println("cache not hit");
		String [] args = weatherId.split("_");
		String response = restClient.callGetWeatherByLatLon(args[0], args[1]);
		Weather weatherCache = new Weather();
		weatherCache.setWeatherId(weatherId);
		weatherCache.setData(response == null ? "no data found!" : response);
		return weatherCache;		
		
	}
		
}
