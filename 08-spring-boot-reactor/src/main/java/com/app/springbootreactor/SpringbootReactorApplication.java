package com.app.springbootreactor;

import com.app.springbootreactor.dto.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringbootReactorApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SpringbootReactorApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringbootReactorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Flux<String> nombres = Flux.just("Pedro Gonzales", "Juan Ramirez", "Jose Guevara", "Bruce lee", "Bruce Khan");
        Flux<Usuario> usuarios = nombres.map(nombre -> new Usuario(nombre.split(" ")[0].toUpperCase(), nombre.split(" ")[1].toUpperCase()))
                .filter(usuario -> usuario.getNombre().equalsIgnoreCase("bruce"))
                .doOnNext(System.out::println)
                .map(usuario -> {
                    String nombre = usuario.getNombre().toLowerCase();
                    usuario.setNombre(nombre);
                    return usuario;
                });
        usuarios.subscribe(e -> log.info(e.toString()));

        //Otra forma

        log.info("--------- Forma con un ArrayList ---------");

        List<String> usuariosList = new ArrayList<>();
        usuariosList.add("Pedro Gonzales");
        usuariosList.add("Juan Ramirez");
        usuariosList.add("Jose Guevara");
        usuariosList.add("Bruce lee");
        usuariosList.add("Bruce Khan");

        Flux<String> nombresList = Flux.fromIterable(usuariosList);
        Flux<Usuario> usuarios2 = nombresList.map(nombre -> new Usuario(nombre.split(" ")[0].toUpperCase(), nombre.split(" ")[1].toUpperCase()))
                .filter(usuario -> usuario.getNombre().equalsIgnoreCase("bruce"))
                .doOnNext(System.out::println)
                .map(usuario -> {
                    String nombre = usuario.getNombre().toLowerCase();
                    usuario.setNombre(nombre);
                    return usuario;
                });
        usuarios2.subscribe(e -> log.info(e.toString()));
    }
}
