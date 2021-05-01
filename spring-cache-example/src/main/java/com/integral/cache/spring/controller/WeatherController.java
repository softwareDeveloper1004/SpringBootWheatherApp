package com.integral.cache.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integral.cache.spring.model.Weather;
import com.integral.cache.spring.service.WeatherService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("/api")
@ApiOperation(value = "This API exposes to get weather information from 3rd party service."
		+ " URI to call for service http://localhost:8082/api/weatherBylatlon/{lat}/{lon}\r\n" + 
		"http://localhost:8082/api/weatherByCity/{countryIsoCode}/{city} ", authorizations = {@Authorization(value = "none")})
public class WeatherController {
		
	@Autowired
	private WeatherService weatherService;

    @GetMapping("/weatherByCity/{countryIsoCode}/{city}")
    @ApiOperation(value = "getWeatherInfoByCity", notes = "fetch weather info by city name and ISO country code", response = ResponseEntity.class)
    public ResponseEntity<String> getWeatherInfoByCity(@PathVariable String countryIsoCode,  @PathVariable String city) {
       
    	Weather response = weatherService.callGetWeatherByCity(city+"_"+countryIsoCode);
    	
        return new ResponseEntity<String>(response.getData(), HttpStatus.OK);
    }


    @GetMapping("/weatherBylatlon/{lat}/{lon}")
    @ApiOperation(value = "getWeatherInfoBylatlon", notes = "fetch weather info by lat  and lon cordinates", response = ResponseEntity.class)
    public ResponseEntity<String> getWeatherInfoBylatlon(@PathVariable String lat,  @PathVariable String lon) {
       
    	Weather response = weatherService.getWeatherInfoBylatlon(lat+"_"+lon);
    	
        return new ResponseEntity<String>(response.getData(), HttpStatus.OK);
    }

}
