package com.bolsadeideas.springboot.di.app.models.service;

import com.bolsadeideas.springboot.di.app.models.domain.Factura;

//import org.springframework.stereotype.Component;

//@Component("miServicioComplejo")
public class MiServicioComplejo implements IServicio{

	@Override
	public String operacion() {
		return "ejecutando algún proceso importante complicado...";
	}

	@Override
	public Factura nuevaFactura() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
