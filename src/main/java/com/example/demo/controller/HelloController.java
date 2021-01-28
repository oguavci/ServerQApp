package com.example.demo.controller;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/login")
	public String login(@RequestParam(name = "username", defaultValue = "user") String name,
						@RequestParam(name = "password", defaultValue = "psw") String password, HttpServletResponse response) {

		boolean yes = true;
		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoicHJvdmEiLCJ1c2VybmFtZSI6InByb3ZhIiwicGFzc3dvcmQiOiJwcm92YSIsImVtYWlsIjoiZW1haWxAZW1haWwuY29tIn0.zXdAvrAkS2fLUTL7hGGOJADmiNvrYkeXdT-JFVu8spM";
		String[] parts = token.split("\\.", 0);

		if(name.equals("prova") && password.equals("prova"))
			yes = true;
		else
			yes = false;
		System.out.println(name + password);
		
		if (yes)
		{
			
			ArrayList<City> cities = new ArrayList<City>();
            for (int i = 0; i < 10; i++) 
            {
            	City c = new City();
             	c.setName("CITTA_"+i);
                cities.add(c);
            }
            response.setHeader("Authorization", "Bearer "+ token);
			return "{cities : [{\"id\":null,\"name\":\"CITTA_0\",\"role\":null},{\"id\":null,\"name\":\"CITTA_1\",\"role\":null},{\"id\":null,\"name\":\"CITTA_2\",\"role\":null},{\"id\":null,\"name\":\"CITTA_3\",\"role\":null},{\"id\":null,\"name\":\"CITTA_4\",\"role\":null},{\"id\":null,\"name\":\"CITTA_5\",\"role\":null},{\"id\":null,\"name\":\"CITTA_6\",\"role\":null},{\"id\":null,\"name\":\"CITTA_7\",\"role\":null},{\"id\":null,\"name\":\"CITTA_8\",\"role\":null},{\"id\":null,\"name\":\"CITTA_9\",\"role\":null}]}";
		}
		else
		{
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return null;
		}
	}
	
	@GetMapping("/store")
	public String store(@RequestParam(name = "chain", defaultValue = "chain") String city, @RequestHeader(value="Authorization") String details, HttpServletResponse response) {

		boolean yes = true;
		String token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoicHJvdmEiLCJ1c2VybmFtZSI6InByb3ZhIiwicGFzc3dvcmQiOiJwcm92YSIsImVtYWlsIjoiZW1haWxAZW1haWwuY29tIn0.zXdAvrAkS2fLUTL7hGGOJADmiNvrYkeXdT-JFVu8spM";
		 System.out.println("City: " + city);
        System.out.println("auth_bear: "+details);
		if(token.equals(details))
			yes = true;
		else 
			yes = false;
		if (yes)
		{
			
			ArrayList<City> cities = new ArrayList<City>();
            for (int i = 0; i < 3; i++) 
            {
            	City c = new City();
             	c.setName("STORE_"+i+"_"+city);
                cities.add(c);
            }
			return "{stores : [{\"id\":0,\"name\":\"STORE_0\",\"role\":null},{\"id\":1,\"name\":\"STORE_1\",\"role\":null},{\"id\":2,\"name\":\"STORE_2\",\"role\":null}]}";
		}
		else
		{
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return null;
		}
	}
	
	@GetMapping("/chain")
	public String chain(@RequestParam(name = "city", defaultValue = "city") String city, @RequestHeader(value="Authorization") String details, HttpServletResponse response) {

		boolean yes = true;
		String token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoicHJvdmEiLCJ1c2VybmFtZSI6InByb3ZhIiwicGFzc3dvcmQiOiJwcm92YSIsImVtYWlsIjoiZW1haWxAZW1haWwuY29tIn0.zXdAvrAkS2fLUTL7hGGOJADmiNvrYkeXdT-JFVu8spM";
		 System.out.println("City: " + city);
        System.out.println("auth_bear: "+details);
		if(token.equals(details))
			yes = true;
		else 
			yes = false;
		if (yes)
		{
			
			ArrayList<City> cities = new ArrayList<City>();
            for (int i = 0; i < 3; i++) 
            {
            	City c = new City();
             	c.setName("STORE_"+i+"_"+city);
                cities.add(c);
            }
			return "{chains : [{\"id\":null,\"name\":\"CHAIN_0\",\"role\":null},{\"id\":null,\"name\":\"CHAIN_1\",\"role\":null},{\"id\":null,\"name\":\"CHAIN_2\",\"role\":null}]}";
		}
		else
		{
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return null;
		}
	}
	
	
	@PostMapping("/register")
	public String doPost(@RequestParam(name = "username", defaultValue = "user") String name,
			@RequestParam(name = "password", defaultValue = "psw") String password, HttpServletResponse response) {
		
		boolean yes = true;
		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoicHJvdmEiLCJ1c2VybmFtZSI6InByb3ZhIiwicGFzc3dvcmQiOiJwcm92YSIsImVtYWlsIjoiZW1haWxAZW1haWwuY29tIn0.zXdAvrAkS2fLUTL7hGGOJADmiNvrYkeXdT-JFVu8spM";
		if(name.equals("prova") && password.equals("prova"))
			yes = true;
		else
			yes = false;
		System.out.println(name + password);
		
		if (yes)
		{
			
			ArrayList<City> cities = new ArrayList<City>();
            for (int i = 0; i < 10; i++) 
            {
            	City c = new City();
             	c.setName("CITTA_"+i);
                cities.add(c);
            }
            response.setHeader("Authorization", "Bearer "+ token);
            return "{cities : [{\"id\":null,\"name\":\"CITTA_0\",\"role\":null},{\"id\":null,\"name\":\"CITTA_1\",\"role\":null},{\"id\":null,\"name\":\"CITTA_2\",\"role\":null},{\"id\":null,\"name\":\"CITTA_3\",\"role\":null},{\"id\":null,\"name\":\"CITTA_4\",\"role\":null},{\"id\":null,\"name\":\"CITTA_5\",\"role\":null},{\"id\":null,\"name\":\"CITTA_6\",\"role\":null},{\"id\":null,\"name\":\"CITTA_7\",\"role\":null},{\"id\":null,\"name\":\"CITTA_8\",\"role\":null},{\"id\":null,\"name\":\"CITTA_9\",\"role\":null}]}";
    		
		}
		else
		{
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return null;
		}
	}
	
	@PostMapping("/lineup")
	public String doPost(@RequestParam(name = "storeId", defaultValue = "id") String id,HttpServletResponse response) {
		
		boolean yes = true;
		String token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoicHJvdmEiLCJ1c2VybmFtZSI6InByb3ZhIiwicGFzc3dvcmQiOiJwcm92YSIsImVtYWlsIjoiZW1haWxAZW1haWwuY29tIn0.zXdAvrAkS2fLUTL7hGGOJADmiNvrYkeXdT-JFVu8spM";
		System.out.println(id);
		
		if (yes)
		{
			
			ArrayList<City> cities = new ArrayList<City>();
            for (int i = 0; i < 10; i++) 
            {
            	City c = new City();
             	c.setName("CITTA_"+i);
                cities.add(c);
            }
            response.setHeader("Authorization", "Bearer "+ token);
            return "{\"numPeople\":5,\"time\":0}";
    		
		}
		else
		{
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return null;
		}
	}
	/*
	 *     <androidx.appcompat.widget.AppCompatButton
        android:layout_width="50dp"
        android:layout_height="50dp"/>
	 */
	
	@PutMapping("/hello")
	public String update() {
		return "PUT";
	}
	
	@DeleteMapping("/lineup")
	public String delete() {
		return "DELETE";
	}
}
