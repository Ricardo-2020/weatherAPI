package com.tts.weatherapp.service;

import com.tts.weatherapp.model.Response;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${api_key}")
    private String apiKey;

    // make a call to openweather api with dynamic zipcode and 
    // apikey
    public Response getForecast(String zipCode) {
        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + "&units=imperial&appid=" + apiKey;

        // make call to "URL"
        // shoves the response in a response "OBJECT"
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject(url, Response.class);
        } catch (HttpClientErrorException exception) {
            //TODO: handle exception
        }
    }

    

}