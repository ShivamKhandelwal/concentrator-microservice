package com.mulesoft.demo.order;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.apache.el.stream.Optional;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ConcentratorService {

	public static void main(String[] args) {
		SpringApplication.run(ConcentratorService.class, args);
	}

	@RequestMapping (value = "/concentrator", method = RequestMethod.GET)
	@CrossOrigin
	public String concentrators (@RequestParam String city) {
		
	    final String uri = "http://api.covidtracking.com/v1/states/current.json";

	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);

	    System.out.println(result);
		
        return result;
	}
}
