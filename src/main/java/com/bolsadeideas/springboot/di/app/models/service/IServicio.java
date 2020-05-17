package com.bolsadeideas.springboot.di.app.models.service;

import com.bolsadeideas.springboot.di.app.models.domain.Factura;

public interface IServicio {

	public String operacion();
	
	public Factura nuevaFactura();
}
