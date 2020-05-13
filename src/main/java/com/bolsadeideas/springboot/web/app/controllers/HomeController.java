package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/tutorial")
	public String homeTutorial() {
		return "forward:/app/index";
	}
	
	@GetMapping("/")
	public String home() {
		return "forward:/recetas/home";
	}
}
