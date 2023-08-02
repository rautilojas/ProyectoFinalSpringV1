package org.lrojas.springframework.boot.services;

import org.lrojas.springframework.boot.models.Producto;
import org.springframework.stereotype.Service;

public interface ProductoService {
    void guardar();
    Iterable<Producto> listarProductos();
    void eliminarProductos(Integer id);
}