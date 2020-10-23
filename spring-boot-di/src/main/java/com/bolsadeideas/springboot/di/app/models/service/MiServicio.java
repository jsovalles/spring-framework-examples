package com.bolsadeideas.springboot.di.app.models.service;

import com.bolsadeideas.springboot.di.app.models.domain.Cliente;
import com.bolsadeideas.springboot.di.app.models.domain.Factura;
import com.bolsadeideas.springboot.di.app.models.domain.ItemFactura;
import com.bolsadeideas.springboot.di.app.models.domain.Producto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("miServicioSimpleV2")
public class MiServicio implements IServicio {

	@Override
	public String operacion() {
		return "ejecutando algún proceso importante simple ...";
	}

	@Override
	public Factura nuevaFactura() {

		Factura factura = new Factura();
		factura.setCliente(new Cliente());
		factura.getCliente().setNombre("Juan");
		factura.getCliente().setApellido("Ovalle");
		factura.setDescripcion("Factura 17/07/2020");

		List<ItemFactura> items = new ArrayList<>();

		items.add(new ItemFactura(new Producto("Monitor LG LCD 24", 250), 2));
		items.add(new ItemFactura(new Producto("Notebook Asus", 500), 1));
		items.add(new ItemFactura(new Producto("Impresora HP Multifuncional", 80), 1));
		items.add(new ItemFactura(new Producto("Escritorio Oficina", 300), 1));
		
		factura.setItems(items);

		return factura;
	}

}
