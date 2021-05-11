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

@SpringBootApplication
@RestController
public class ConcentratorService {

	public static void main(String[] args) {
		SpringApplication.run(ConcentratorService.class, args);
	}

	@RequestMapping (value = "/concentrator", method = RequestMethod.GET)
	@CrossOrigin
	public JSONArray concentrators (@RequestParam String city) {
		
	       //JSON parser object to parse read file
           
             JSONParser jsonParser = new JSONParser();
             JSONArray concentratorList = null;
             try (FileReader reader = new FileReader("concentrator.json"))
             {
             //Read JSON file
             Object obj = jsonParser.parse(reader);
             
              concentratorList = (JSONArray) obj;
 
             } catch (FileNotFoundException e) {
             e.printStackTrace();
             } catch (IOException e) {
             e.printStackTrace();
             } catch (ParseException e) {
             e.printStackTrace();
             }
            
		

		
        return concentratorList;
	}
}
