package com.example.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	
	
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		System.out.println("Index Page");		
		return "Index";
	}
	
}
