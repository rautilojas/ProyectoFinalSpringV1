package org.lrojas.springframework.boot.services;

import org.lrojas.springframework.boot.models.Cliente;
import org.springframework.stereotype.Service;

public interface ClienteService {
    void guardar();
    Iterable<Cliente> listar();
}