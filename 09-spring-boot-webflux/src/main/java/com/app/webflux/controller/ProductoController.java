package com.app.webflux.controller;

import com.app.webflux.dao.IProductoDAO;
import com.app.webflux.dao.document.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class ProductoController {

    @Autowired
    IProductoDAO dao;

    private static final Logger log = LoggerFactory.getLogger(ProductoController.class);

    @GetMapping({"/listar", ""})
    public Flux<Producto> listarProductos() {

        Flux<Producto> productos = dao.findAll().map(producto -> {
            producto.setNombre(producto.getNombre().toUpperCase());
            return producto;
        });

        productos.subscribe(producto -> log.info(producto.getNombre()));

        return productos;

    }

    @GetMapping("/listar-full")
    public Flux<Producto> listarFull() {

        Flux<Producto> productos = dao.findAll().map(producto -> {
            producto.setNombre(producto.getNombre().toUpperCase());
            return producto;
        }).repeat(5000);
        return productos;

    }

    @GetMapping("/listar-datadriver")
    public Flux<Producto> listarDataDriver() {

        Flux<Producto> productos = dao.findAll().map(producto -> {
            producto.setNombre(producto.getNombre().toUpperCase());
            return producto;
        }).delayElements(Duration.ofSeconds(1));

        productos.subscribe(producto -> log.info(producto.getNombre()));

        return productos;

    }

    @GetMapping("/{id}")
    public Mono<Producto> mostrarProducto(@PathVariable String id) {

        //Mono<Producto> producto = dao.findById(id);

        Flux<Producto> productos = dao.findAll().doOnNext(producto -> log.info(producto.toString()));

        Mono<Producto> producto = productos.filter(p -> p.getId().equals(id)).next();

        return producto;
    }

}
