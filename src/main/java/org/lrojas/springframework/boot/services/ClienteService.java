package org.lrojas.springframework.boot.services;

import org.lrojas.springframework.boot.models.Cliente;
import org.springframework.stereotype.Service;
import java.util.Optional;


public interface ClienteService {
    void guardar();
    Iterable<Cliente> listar();

    void eliminarPorId(Integer id);

    Optional<Cliente> buscarPorId(Integer id);

    Boolean actualizarCliente(Cliente cliente);

    void guardar(Cliente cliente);

}