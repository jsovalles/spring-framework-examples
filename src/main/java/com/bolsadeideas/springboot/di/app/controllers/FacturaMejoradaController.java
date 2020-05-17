package com.bolsadeideas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bolsadeideas.springboot.di.app.models.domain.Factura;
import com.bolsadeideas.springboot.di.app.models.service.IServicio;

@Controller
@RequestMapping("/facturaV2")
public class FacturaMejoradaController {
	
	@Autowired
	@Qualifier("miServicioSimpleV2")
	private IServicio srv;
	
	@GetMapping("/index")
	public String nuevafactura(Model model){
		
		Factura factura = new Factura();
		
		factura = srv.nuevaFactura();
		
		model.addAttribute("factura", factura);
		model.addAttribute("titulo", "Ejemplo Factura con Injeccion de metodos sin la utilizacion de beans");

		return "factura/ver";
		
	}

	@GetMapping("/json")
	@ResponseBody
	public Factura nuevafacturaJSON(Model model){
		
		Factura factura = new Factura();
		
		factura = srv.nuevaFactura();
	

		return factura;
		
	}
	
}
