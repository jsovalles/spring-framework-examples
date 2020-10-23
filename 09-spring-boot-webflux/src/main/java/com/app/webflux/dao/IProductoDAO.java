package com.app.webflux.dao;

import com.app.webflux.dao.document.Producto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IProductoDAO extends ReactiveMongoRepository<Producto, String> {
}
