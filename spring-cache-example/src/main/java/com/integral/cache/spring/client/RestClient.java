package com.integral.cache.spring.client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {
		
	private static final String GET_WEATHER_INFO_BY_CITY = "http://api.openweathermap.org/data/2.5/weather?q={id}&appid=ffa6f13ea40a22452bba3be726315d3f";

	private static  final String GET_WEATHER_INFO_BY_LAT_LON = "http://api.openweathermap.org/data/2.5/weather?lat={id1}&lon={id2}&appid=ffa6f13ea40a22452bba3be726315d3f";

	public  RestTemplate restTemplate = new RestTemplate();
	
   	
	public  String callGetWeatherByCity(String city, String contryCodeIso) {
		
		String responseToReturn = null;
		
		try {
			
			HttpHeaders header = new HttpHeaders();
			header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<>("parameters", header);
			
			Map<String, String> uriVariables = new HashMap();
			uriVariables.put("id", city+","+contryCodeIso);
			
			ResponseEntity<String> response = restTemplate.exchange(GET_WEATHER_INFO_BY_CITY, HttpMethod.GET, entity, String.class, uriVariables);
			
			if(response.getStatusCode() == HttpStatus.OK) {
				responseToReturn= response.getBody();
			}
			System.out.println(responseToReturn);
			
		} catch (Exception ex) {
			responseToReturn = null;
			System.out.println(ex.getMessage());
		}
		
		
		return responseToReturn;
		
	}
	
	/*
	 * public static void main(String[] args) { callGetWeatherByLatLon("35","139");
	 * }
	 */
	public  String callGetWeatherByLatLon(String lat, String lon) {
	
		String responseToReturn = null;
		
		try {
			
			HttpHeaders header = new HttpHeaders();
			header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<>("parameters", header);
			
			Map<String, String> uriVariables = new HashMap();
			uriVariables.put("id1", lat);
			uriVariables.put("id2", lon);
			
			ResponseEntity<String> response = restTemplate.exchange(GET_WEATHER_INFO_BY_LAT_LON, HttpMethod.GET, entity, String.class, uriVariables);
			
			if(response.getStatusCode() == HttpStatus.OK) {
				responseToReturn= response.getBody();
			}
			System.out.println(responseToReturn);
			
		} catch (Exception ex) {
			responseToReturn = null;
			System.out.println(ex.getMessage());
		}
		
		
		return responseToReturn;
		
	}
	


}
