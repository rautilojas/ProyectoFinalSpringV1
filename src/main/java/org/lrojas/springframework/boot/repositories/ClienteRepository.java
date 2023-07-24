package org.lrojas.springframework.boot.repositories;

import org.lrojas.springframework.boot.models.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente,Integer> {


}