package com.app.webflux;

import com.app.webflux.dao.IProductoDAO;
import com.app.webflux.dao.document.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;

import java.util.Date;

@SpringBootApplication
public class WebfluxApplication implements CommandLineRunner {

    @Autowired
    IProductoDAO dao;

    @Autowired
    private ReactiveMongoTemplate mongoTemplate;

    public static final Logger log = LoggerFactory.getLogger(WebfluxApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WebfluxApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Eliminar una colección
        mongoTemplate.dropCollection("productos").subscribe();
        //Creación de base de datos productos a partir de flatMap
        Flux.just(
                new Producto("TV Panasonic", 456.89),
                new Producto("Sony Camara", 177.89),
                new Producto("Apple iPod", 46.89),
                new Producto("Sony Notebook", 876.43)
        ).flatMap(producto -> {
            producto.setCreateDate(new Date());
            return dao.save(producto);
        })
                .subscribe(producto -> log.info(producto.getId() + producto.getNombre()));
    }
}
