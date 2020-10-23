package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recetas")
public class RecetasController {
	
	@GetMapping("/home")
	public String index(Model model) {
		model.addAttribute("titulo", "Enviar parámetros de la ruta (@PathVariable)");
		return "recetas/index";
	}
	
	@GetMapping("/carne_al_horno")
    public String carneAlHorno(Model model) {
		model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable)");
		return "recetas/carne_al_horno";
	}

	@GetMapping("/brownies")
    public String brownies(Model model) {
		model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable)");
		return "recetas/brownies";
	}
	
}
