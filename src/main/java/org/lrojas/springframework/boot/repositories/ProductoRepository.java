package org.lrojas.springframework.boot.repositories;

import org.lrojas.springframework.boot.models.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto,Integer> {


}